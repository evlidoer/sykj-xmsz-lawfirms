package com.jt.lawfirm.service.anjian;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jt.lawfirm.bean.anjian.CaseInvestigation;
import com.jt.lawfirm.bean.anjian.CaseProcuratorialWork;
import com.jt.lawfirm.bean.anjian.CasecHoldAHearing;
import com.jt.lawfirm.mapper.anjian.KaiTingMsgMapper;

public interface KaiTingMsgService {
	
	
	//显示开庭
	List<Map<String, Object>> casecHoldAHearingShow(Map<String, Object> map);
	//显示侦查
	List<Map<String, Object>> zhenChaShow(Map<String, Object> map);
	//显示检查
	List<Map<String, Object>> JianChaShow(Map<String, Object> map);
	
	//开庭 添加信息
	boolean CasecHoldAHearingFormAdd(CasecHoldAHearing ch);
	//侦察 添加信息
	boolean kaitingMsgZCAdd(CaseInvestigation ci);
	//jian察 添加信息
	boolean kaitingMsgJCAdd(CaseProcuratorialWork cp);
	
	boolean delKaiTing(Integer id);
	boolean delZhenCha(Integer id);    //===>删除
	boolean delJianCha(Integer id);
	
	
	
	
	
}
