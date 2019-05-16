package com.jt.lawfirm.service.anjian.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.finance.Invoice;
import com.jt.lawfirm.mapper.anjian.WholeCaseMapper;
import com.jt.lawfirm.service.anjian.WholeCaseService;

@Service("WholeCaseServiceImpl")
public class WholeCaseServiceImpl implements WholeCaseService {
	
	@Resource
	private WholeCaseMapper wholeCaseMapper;
	
	@Override
	public boolean upWholeCaseCZ3(Integer id, String case_recycle) {

		return wholeCaseMapper.upWholeCaseCZ3(id,case_recycle);
	}

	@Override
	public boolean upWholeCaseCZ4(Integer id, String case_clash) {
		// TODO Auto-generated method stub
		return wholeCaseMapper.upWholeCaseCZ4(id,case_clash);
	}
	
	//开发票
	@Override
	public Integer addWholeCaseCZ2(Invoice invoice) {
		
		return wholeCaseMapper.addWholeCaseCZ2(invoice);
	}

		
}
