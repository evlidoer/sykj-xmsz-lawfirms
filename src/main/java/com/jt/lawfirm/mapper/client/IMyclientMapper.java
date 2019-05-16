package com.jt.lawfirm.mapper.client;

import com.jt.lawfirm.bean.client.AddclientBean;
import com.jt.lawfirm.bean.client.Client;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface IMyclientMapper {
	List<Client> FindAll(Map<String,Object> map);
	int Addclient(AddclientBean client);
	void AddTetail(AddclientBean client);
	void Addmsg(AddclientBean client);
	int modifclient(AddclientBean client);
	List<AddclientBean> FindClient(Integer id);
	int lawnum(Integer id);
	int removeById(Integer id);
	
	@Select("select count(*) from client where client = #{client} and empid=#{empid}")
	int clientCount(@Param("client")String client,@Param("empid")Integer empid);

	
	//根据客户ID查询案件
	@Select("select * from case_law cl inner join case_case_type cct"
			+ " on cl.case_case_type_id = cct.id  inner join hr_emp he" 
			+ " on cl.case_attorney_id = he.id "
			+ "where client_id = #{id}")
	List<Map<String, Object>> FindclientlawByid(Integer id);
	
	//查询emp
	@Select("<script>"
			+ "select * from hr_emp he left join system_user su on he.id = su.hr_emp_id"
			+" left join system_user_role sur on sur.user_id = su.id"
			+" left join system_role sr on sur.role_id = sr.id "
			+ "<where> "
			+ "<if  test='empname!=null and empname!= &apos;&apos;'> "
			+ "emp_name like #{empname}"
			+ "</if>"
			+ "</where>"
			+ "</script>")
	List<Map<String, Object>> FindEmp(Map<String, Object> cmap);
	//客户转送
	@Update("update client set empid = #{empid} where id = #{clientid}")
	int updateclientEmpid(Map<String, Object> map);
	void modifclientdetail(AddclientBean client);
	void modifclientmsg(AddclientBean client);
	
	@Select("select * from client c left join client_detail cd on c.id = cd.client_id left join client_typemsg ct on c.id = ct.client_id left join client_type cty on ct.client_type_id = cty.id  ORDER BY c.id")
	List<Map<String, Object>> FindAllexport(Map<String, Object> cmap);
	
	@Select("select  * "+
			"  FROM log_job "+
			" left JOIN log_type on log_job.logtype_id = log_type.id "+
			" left JOIN client on log_job.client_id = client.id "+
			" left JOIN case_law on case_law.id = log_job.case_law_id"+
			" where client.id = #{id} ")
	List<Map<String, Object>> FindLogbyId(Integer id);
	//查询证件号数量
	@Select("<script>"
			+ "select count(*) from  client_typemsg where idnumber = #{idnumber}"
			+ "<if test='clientid!=null and clientid!= &apos;&apos;'>"
			+ " and client_id not in (#{clientid})"
			+ "</if>"
			+ "</script>")
	int foridnumber(Map<String,Object> map);
	//查询身份证数量
	@Select("<script>"
			+ "select count(*) from client_detail where client_idcard = #{clientIdcard}"
			+ "<if test='clientid!=null and clientid!= &apos;&apos;'>"
			+ " and client_id not in (#{clientid})"
			+ "</if>"
			+ "</script>")
	int forclientIdcardSel(Map<String,Object> map);
}
