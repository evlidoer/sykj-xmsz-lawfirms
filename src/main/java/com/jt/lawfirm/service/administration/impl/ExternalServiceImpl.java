package com.jt.lawfirm.service.administration.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.administration.External;
import com.jt.lawfirm.mapper.administration.IExternalMapper;
import com.jt.lawfirm.service.administration.ExternalService;

@Service(value = "ExternalService")
public class ExternalServiceImpl implements ExternalService{
	@Autowired
	private IExternalMapper iExternaMapper;
	@Override
	public List<External> findExternalAll(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");
		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
		List<External> selectList  = new ArrayList<External>();
		if (map.get("title") != null && !"".equals(map.get("title"))) {
			selectList = iExternaMapper.selExternaAll(map);
		}else {
			selectList = iExternaMapper.selExternaAll(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */
		pageBean.setRows(selectList);
		System.err.println(pageBean.getRows().toString());
		return iExternaMapper.selExternaAll(map);
	}
	@Override
	public void removeExternalById(int id) {
		iExternaMapper.deleteExternalById(id);
	}
	
	
	@Override
	public External selInfoExternalById(Integer id) {
		/*
		 * 	这调用 mybatis-plus 自己封装的方法,并非自己手写
		 */
		return  iExternaMapper.selectById(id);
	}
	@Override
	public External selUpdExternalById(Integer id) {
		/*
		 * 	这调用 mybatis-plus 自己封装的方法,并非自己手写
		 */
		return iExternaMapper.selectById(id);
	}
	@Override
	public void upd(External external) {
		/*
		 * 	这调用 mybatis-plus 自己封装的方法,并非自己手写
		 */
		iExternaMapper.updateById(external);
	}
	@Override
	public void add(External external) {
		iExternaMapper.insert(external);
	}
}
