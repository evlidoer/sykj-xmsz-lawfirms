package com.jt.lawfirm.service.administration.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.administration.Attorney;
import com.jt.lawfirm.mapper.administration.IAttorneyMapper;
import com.jt.lawfirm.service.administration.AttorneyService;

@Service(value = "AttorneyService")
public class AttorneyServiceImpl implements AttorneyService {
	@Autowired
	private IAttorneyMapper iAttorneyMapper;
	@Override
	public List<Attorney> findAttorneyAll(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");

		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());

		List<Attorney> selectList  = new ArrayList<Attorney>();
		if (map.get("title") != null && !"".equals(map.get("title"))) {
			selectList = iAttorneyMapper.selAttorneyAll(map);
		}else {
			selectList = iAttorneyMapper.selAttorneyAll(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */

		pageBean.setRows(selectList);
		System.err.println(pageBean.getRows().toString());
		return iAttorneyMapper.selAttorneyAll(map);
	}
	@Override
	public List<Attorney> findAttorneyByID(Integer id) {
		return iAttorneyMapper.selAttorneyByID(id) ;
	}

}
