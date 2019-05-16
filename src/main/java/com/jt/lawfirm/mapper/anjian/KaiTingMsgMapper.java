package com.jt.lawfirm.mapper.anjian;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.jt.lawfirm.bean.anjian.CaseInvestigation;
import com.jt.lawfirm.bean.anjian.CaseProcuratorialWork;
import com.jt.lawfirm.bean.anjian.CasecHoldAHearing;

public interface KaiTingMsgMapper {
	
		                                                                          //***
																				//三个都要加模糊查询
	//显示 开庭  casecHoldAHearingShow
	List<Map<String, Object>> casecHoldAHearingShow(Map<String, Object> map);
	
	//显示侦查
	List<Map<String, Object>> zhenChaShow(Map<String, Object> map);
	//显示检查
	List<Map<String, Object>> JianChaShow(Map<String, Object> map);
	
	//开庭信息添加
	boolean CasecHoldAHearingFormAdd(CasecHoldAHearing ch);
	//侦察 添加信息
	boolean kaitingMsgZCAdd(CaseInvestigation ci);
	//捡察 添加信息
	boolean kaitingMsgJCAdd(CaseProcuratorialWork cp);
	
	@Delete("delete from case_hold_a_hearing where id=#{id}")
	boolean delKaiTing(Integer id);
	@Delete("delete from case_investigation where id=#{id}")
	boolean delZhenCha(Integer id);
	@Delete("delete from case_procuratorial_work where id=#{id}")
	boolean delJianCha(Integer id);
}
