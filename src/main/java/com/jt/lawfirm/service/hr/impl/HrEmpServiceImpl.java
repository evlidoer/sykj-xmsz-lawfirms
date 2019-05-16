package com.jt.lawfirm.service.hr.impl;
/*
 * 
 * @author代国繁
 * */
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jt.lawfirm.bean.hr.HrEmp;
import com.jt.lawfirm.bean.hr.HrIdent;
import com.jt.lawfirm.bean.hr.HrInsured;
import com.jt.lawfirm.bean.hr.HrPunishment;
import com.jt.lawfirm.bean.hr.HrReward;
import com.jt.lawfirm.mapper.hr.IHrCaseTypeMapper;
import com.jt.lawfirm.mapper.hr.IHrDegreeMapper;
import com.jt.lawfirm.mapper.hr.IHrEmpmapper;
import com.jt.lawfirm.mapper.hr.IHrIdentMapper;
import com.jt.lawfirm.mapper.hr.IHrInsuredMapper;
import com.jt.lawfirm.mapper.hr.IHrPunishmentMapper;
import com.jt.lawfirm.mapper.hr.IHrRewardMapper;
import com.jt.lawfirm.mapper.hr.IHrWorkhistoryMapper;
import com.jt.lawfirm.service.hr.IHrEmpService;

@Service("hrempservice")
public class HrEmpServiceImpl implements IHrEmpService{
	
	@Resource(name="IHrEmpmapper")
	private IHrEmpmapper empmapper;
	@Resource(name="IHrCaseTypeMapper")
	private IHrCaseTypeMapper casetype;
	@Resource(name="IHrIdentMapper")
	private IHrIdentMapper IdentMapper;
	@Resource(name="IHrRewardMapper")
	private IHrRewardMapper Reward;
	@Resource(name="IHrPunishmentMapper")
	private IHrPunishmentMapper Punishment;
	@Resource(name="IHrDegreeMapper")
	private IHrDegreeMapper degreeMapper;
	@Resource(name="IHrWorkhistoryMapper")
	private IHrWorkhistoryMapper workhistoryMapper;
	@Resource(name="IHrInsuredMapper")
	private IHrInsuredMapper insuredMapper;
	
	@Override
	public List<HrEmp> selectbyid(Map<String, Object> map) {
		return empmapper.selectByMap(map);
	}

	@Override
	public boolean updatebyid(HrEmp hrEmp) {
		return empmapper.updateById(hrEmp)>0;
	}

	@Override
	public boolean deletebyid(int id,Map<String, Object> map) {
		Reward.deleteByMap(map);
		Punishment.deleteByMap(map);
		degreeMapper.deleteByMap(map);
		workhistoryMapper.deleteByMap(map);
		insuredMapper.deleteByMap(map);
		IdentMapper.deleteByMap(map);
		return empmapper.deleteById(id)>0;
	}

	@Override
	public List<String> selectcase(String casetypename) {
		return casetype.selectcase(casetypename);
	}

	@Override
	public boolean addemp(Map<String, String> map) {
		return  empmapper.insertemp(map);
	}

	@Override
	public List<String> selectempid() {
		return empmapper.selectempid();
	}

	@Override
	public boolean addident(HrIdent hrIdent,HrInsured hrInsured) {
		boolean b = true; 
		try {
			if (IdentMapper.insert(hrIdent)>0 && insuredMapper.insert(hrInsured)>0) {
				
			}else {
				b=false;
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			} 	
		} catch (Exception e) {
			
		}
			return b;
	}

	@Override
	public boolean addreward(HrReward hrReward) {
		return Reward.insert(hrReward)>0 ;
	}

	@Override
	public boolean addpun(HrPunishment punishment) {
		return Punishment.insert(punishment)>0;
	}

	@Override
	public List<HrReward> selectrew(Map<String, Object> map) {
		return Reward.selectByMap(map);
	}

	@Override
	public List<com.jt.lawfirm.bean.hr.HrPunishment> selectpun(Map<String, Object> map) {
		return Punishment.selectByMap(map);
	}


	@Override
	public boolean uprew(HrReward hrReward) {
		return Reward.updateById(hrReward)>0;
	}

	@Override
	public boolean uppun(HrPunishment hrPunishment) {
		return Punishment.updateById(hrPunishment)>0;
	}

	@Override
	public boolean deleterew(int id) {
		return Reward.deleteById(id)>0;
	}

	@Override
	public boolean deletepun(int id) {
		return Punishment.deleteById(id)>0;
	}

	@Override
	public boolean insert(Map<String, String> map, int id) {
		boolean b = empmapper.insertemp(map);
		if (b == false) {
			Reward.deleteById(id);
			Punishment.deleteById(id);
			degreeMapper.deleteById(id);
			workhistoryMapper.deleteById(id);
			IdentMapper.deleteById(id);
			insuredMapper.deleteById(id);
		}
		return b;
	}

	@Override
	public List<Map<String, String>> selectemp() {
		return empmapper.selectemp();
	}

	@Override
	public List<Map<String, String>> selectdegree() {
		return empmapper.selectdegree();
	}

	@Override
	public List<Map<String, String>> selectwork() {
		return empmapper.selectwork();
	}

	@Override
	public List<Map<String, String>> selectrew() {
		return empmapper.selectrew();
	}

	@Override
	public List<Map<String, String>> selectpun() {
		return empmapper.selectpun();
	}

	@Override
	public List<HrInsured> selectins(String id) {
		return empmapper.selectins(id);
	}

	@Override
	public boolean updatecb(Map<String, Object> map) {
		return empmapper.updatecb(map);
	}

	@Override
	public boolean insertcb(Map<String, Object> map) {
		return empmapper.insertcb(map);
	}

}
