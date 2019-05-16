package com.jt.lawfirm.service.shouye.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.shouye.Calendar;
import com.jt.lawfirm.mapper.shouye.IShouyeMapper;
import com.jt.lawfirm.service.shouye.IShouyeService;
@Service
public class ShouyeServiceImpl implements IShouyeService {
	@Autowired
	private IShouyeMapper shouyemapper;

	@Override
	public int approvalnum() {
		int number =  shouyemapper.approvalquantity();
		return number;
	}

	@Override
	public int officenum() {
		int number =  shouyemapper.officequantity();
		return number;
	}

	@Override
	public int settlenum() {
		int number =  shouyemapper.settlequantity();
		return number;
	}

	@Override
	public List<Map<String, Object>> SelectLaw() {
		List<Map<String, Object>> listmap =  shouyemapper.FindLaw();
		return listmap;
	}

	@Override
	public List<Map<String, Object>> Selectnotice() {
		List<Map<String, Object>> listmap =	shouyemapper.Findnotice();
		return listmap;
	}

	@Override
	public int addcalendar(Calendar calendr) {
		int number =  shouyemapper.insertcalendr(calendr);
		return number;
	}
}
