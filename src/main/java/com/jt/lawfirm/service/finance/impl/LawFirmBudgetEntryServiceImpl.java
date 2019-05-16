package com.jt.lawfirm.service.finance.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.finance.InoutType;
import com.jt.lawfirm.mapper.finance.IFinanceEmpMapper;
import com.jt.lawfirm.mapper.finance.IInoutMapper;
import com.jt.lawfirm.mapper.finance.IInoutTypeMapper;
import com.jt.lawfirm.service.finance.ILawFirmBudgetEntryService;

@Service("LFBEService")
public class LawFirmBudgetEntryServiceImpl implements ILawFirmBudgetEntryService {
	
	@Resource(name="IFinanceEmpMapper")
	private IFinanceEmpMapper empMapper;
	@Resource(name="IInoutTypeMapper")
	private IInoutTypeMapper inoutTypeMapper;
	@Resource(name="IInoutMapper")
	private IInoutMapper inoutMapper;

	@Override
	public List<Map<String, String>> findEmpToIdAndName(String name) {
		return empMapper.selectEmpToIdAndName(name);
	}
	
	@Override
	public List<InoutType> findInoutTypeAll(){
		return inoutTypeMapper.selectList(null);
	}

	@Override
	public boolean addInoutOneRow(Map<String, String> map) {
		int[] arr = {1003, 1004,1005, 100301,100302, 100401,100402 ,100403 ,100404,100501};
		for (int i : arr) {
			if(i == Integer.parseInt(map.get("inType"))) {
				map.put("getmoney", "-" + map.get("getmoney"));
				break;
			}
		}
		return inoutMapper.insertInoutOneRow(map);
	};
	
}
