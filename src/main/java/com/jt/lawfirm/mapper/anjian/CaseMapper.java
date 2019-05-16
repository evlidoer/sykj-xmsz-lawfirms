package com.jt.lawfirm.mapper.anjian;

import com.jt.lawfirm.bean.anjian.CaseCostRelief;
import com.jt.lawfirm.bean.anjian.CaseServiceLog;
import com.jt.lawfirm.bean.casea.CaseSealApplyfor;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.bean.finance.CaseType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface CaseMapper {
	
	/**
	 *	 审查
	 */
	////显示案件
	 					//模糊查询***
	List<Map<String, Object>> findCase(Map<String, Object> map);
	
	
	//查询emp  的  id
	@Select("	select DISTINCT he.id	from case_law cl \r\n" + 
			"		inner join case_case_type cct on cct.id = cl.case_case_type_id			\r\n" + 
			"		inner join hr_emp he on he.id=cl.system_approval_id\r\n" + 
			"		inner join system_user su on su.hr_emp_id =he.id where su.user_name = #{userName}")
	Integer  findEmpById(Map<String, Object> map);
	
	
	/**************************8
	 *	 新增案件
	 * @param cols
	 */
	// 1. 显示下面菜单
		//1原始数据
		@Select("select * from case_case_type where id = #{cols}")
		 List<CaseType> findAllCaseTypeById(Integer cols);
		//2.自关联查询
		//@Select("select * from case_case_type where type_pid= #{cols}")
		@Select("select c2.* from case_case_type  c1\r\n" + 
				"	inner join case_case_type  c2 on c1.id = c2.type_pid where c2.type_pid = #{cols}")
		List<CaseType> findCaseType(Integer cols);
		
		//addCase4  添加 law
		Integer addCaseLaw(Law law);
		
		//查询客户id
		@Select("select id from  client where client= #{clientname} and empid=#{empid}")
		Integer selClientByName(@Param("clientname")String clientname,@Param("empid")Integer empid);
		
		//查询文书addcase6
		 //根据案件号查
		List<Map<String, Object>> ajaxCaseSealApplyfor(Map<String, Object> map);
		
		//查询案号id
		@Select("select id from case_law where case_propernum = #{anjianHao}")
		Integer anjianHaoSel(String anjianHao);
		//添加文书
		boolean addCaseSealApplyfor(CaseSealApplyfor cs);
		/*******************************
		 * 	我的案件
		 */
		//我的案件修改查
		@Select("select * from case_law where id = #{id}")  
		List<Map<String, Object>> myCaseById(Integer id);
		
		 //案件表的修改语句***
		boolean myCaseUpdate(Law law);
		
		//显示信息
					//查询 根据上面的七个菜单查询***
		List<Map<String, Object>> myCasefindCase(Map<String, Object> map);

		//减免申请  显示数据
		@Select("select * from  case_law cl inner join case_case_type ct on ct.id = cl.case_case_type_id where  cl.id = #{id}")
		List<Map<String, Object>> myCaseEmpById(Integer id);

		//添加 案件费用减免记录 表case_cost_relief
		boolean addCaseCostRelief(CaseCostRelief ccr);



		//修改案件状态
		@Update("update case_law set case_settle_status = 'Y' where id = #{id}")
		boolean myCasejieanUpdate(Integer id);
		
		
		//3收费
		@Update("update  case_law set case_paidsal = #{payPrice} where id = #{id}")
		boolean myCaseOperate3Up(@Param("id")Integer id,@Param("payPrice") double payPrice);
		
		//4 结案 提交
		@Update("update  case_law set case_settle_way = #{case_settle_way},case_settle_date=#{case_settle_date},case_settle_status='Y' where id = #{id}")
		boolean myCaseOperate4Up(@Param("id")Integer id, @Param("case_settle_way")String case_settle_way, @Param("case_settle_date")String case_settle_date);
		
		//查询咨询与代书
		                               ///按时间范围查询***  
		List<Map<String, Object>> ConsultingGhostwritingShow(Map<String, Object> map);

		//咨询与代书添加   服务表添加   														***
		boolean CaseServiceLogAdd(CaseServiceLog cs);
		
		//判断案号
		//@Select("select count(*) from case_law where case_propernum = #{anjianHao}")
		Integer anjianHaoYN(String anjianHao);

		//审查
		List<Map<String, Object>> ConflictOfInterestReview(Map<String, Object> map);


		


	
		
	
		

		

		
		
		//@Select()
}
