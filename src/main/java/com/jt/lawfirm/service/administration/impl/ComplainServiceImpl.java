package com.jt.lawfirm.service.administration.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.mapper.administration.IComplainMapper;
import com.jt.lawfirm.service.administration.ComplainService;


@Service("ComplainService")
public class ComplainServiceImpl implements ComplainService {
	@Autowired
	private IComplainMapper iComplainMapper;
	@Override
	public List<Map<String, Object>> findComplainAll(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");
		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
		List<Map<String, Object>> selectList = new ArrayList<Map<String,Object>>();
		/* List<Map<String,Object>> selectList = ArrayList<HashMap<String,Object>>(); */
		if (map.get("title") != null && !"".equals(map.get("title"))  ||
				map.get("stime") != null && !"".equals(map.get("stime")) || 
				map.get("stime") != null && !"".equals(map.get("stime")) 
					) {
			selectList = iComplainMapper.selComplainAll(map);
		}else {
			selectList = iComplainMapper.selComplainAll(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */
		pageBean.setRows(selectList);
		System.err.println(pageBean.getRows().toString());
		return iComplainMapper.selComplainAll(map);
	}

}
