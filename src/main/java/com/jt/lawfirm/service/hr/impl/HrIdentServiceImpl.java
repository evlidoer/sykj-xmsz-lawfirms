package com.jt.lawfirm.service.hr.impl;
/*
 * 
 * @author代国繁
 * */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.hr.HrIdent;
import com.jt.lawfirm.bean.hr.myhrbean.Myempident;
import com.jt.lawfirm.mapper.hr.IHrIdentMapper;
import com.jt.lawfirm.service.hr.IHrIdentService;

@Service("hrIdentServie")
public class HrIdentServiceImpl implements IHrIdentService {
	
	@Resource(name="IHrIdentMapper")
	private IHrIdentMapper hridentmapper;

	@Override
	public List<HrIdent> selectaident(PageBean pageBean, Myempident myempident) {
		Page<Object> page = PageHelper.offsetPage(pageBean.getOffset(), pageBean.getLimit());
		if (myempident.getMindate() != null && myempident.getMaxdate() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				long max = sdf.parse(myempident.getMaxdate()).getTime();
				long min = sdf.parse(myempident.getMindate()).getTime();
				if (min>max) {
					String zj = myempident.getMindate();
					myempident.setMindate(myempident.getMaxdate());
					myempident.setMaxdate(zj);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		List<HrIdent> list = hridentmapper.selectIdent(myempident);
		pageBean.setTotal(page.getTotal());
		pageBean.setRows(list);
		return list;
	}

	@Override
	public boolean insertident(HrIdent entity) {
		return hridentmapper.insert(entity)>0;
	}


	
	
}
