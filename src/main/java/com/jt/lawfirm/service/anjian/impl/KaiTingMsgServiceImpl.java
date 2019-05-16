package com.jt.lawfirm.service.anjian.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.anjian.CaseInvestigation;
import com.jt.lawfirm.bean.anjian.CaseProcuratorialWork;
import com.jt.lawfirm.bean.anjian.CasecHoldAHearing;
import com.jt.lawfirm.mapper.anjian.KaiTingMsgMapper;
import com.jt.lawfirm.service.anjian.KaiTingMsgService;

/**
 * 	开庭
 * @author 李阳
 */
@Service("kaiTingMsgService")
public class KaiTingMsgServiceImpl implements KaiTingMsgService {
	
		
	@Resource
	private KaiTingMsgMapper kaiTingMsgMapper;
	//显示开庭
	@Override
	public List<Map<String, Object>> casecHoldAHearingShow(Map<String, Object> map) {
		return kaiTingMsgMapper.casecHoldAHearingShow(map);
	}
	//显示侦查
	@Override
	public List<Map<String, Object>> zhenChaShow(Map<String, Object> map) {
		return kaiTingMsgMapper.zhenChaShow(map);
	}
	//显示检查
	@Override
	public List<Map<String, Object>> JianChaShow(Map<String, Object> map) {
		return kaiTingMsgMapper.JianChaShow(map);
	}
	
	//开庭  添加信息
	@Override
	public boolean CasecHoldAHearingFormAdd(CasecHoldAHearing ch) {
		return kaiTingMsgMapper.CasecHoldAHearingFormAdd(ch);
	}
	
	//侦察 添加信息
	@Override
	public boolean kaitingMsgZCAdd(CaseInvestigation ci) {
		return kaiTingMsgMapper.kaitingMsgZCAdd(ci);
	}
	//jian察 添加信息
	@Override
	public boolean kaitingMsgJCAdd(CaseProcuratorialWork cp) {
		return kaiTingMsgMapper.kaitingMsgJCAdd(cp);
	}
	
	
	//删除
	@Override
	public boolean delKaiTing(Integer id) {
		// TODO Auto-generated method stub
		return kaiTingMsgMapper.delKaiTing(id);
	}
	@Override
	public boolean delZhenCha(Integer id) {
		// TODO Auto-generated method stub
		return kaiTingMsgMapper.delZhenCha(id);
	}
	@Override
	public boolean delJianCha(Integer id) {
		// TODO Auto-generated method stub
		return kaiTingMsgMapper.delJianCha(id);
	}
}
