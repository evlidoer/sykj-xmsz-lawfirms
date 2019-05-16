package com.jt.lawfirm.service.administration.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.administration.Signinrecor;
import com.jt.lawfirm.bean.administration.dtd.MySigninrecor;
import com.jt.lawfirm.mapper.administration.ISigninrecorMapper;
import com.jt.lawfirm.service.administration.SigninrecorService;


@Service(value = "SigninrecorService")
public class SigninrecorServiceService implements SigninrecorService {
	@Autowired
	private ISigninrecorMapper signinrecorMapper;
	
	
	@Override
	public List<Signinrecor> findSigninrecorAll(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");
		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
		List<Signinrecor> selectList  = new ArrayList<Signinrecor>();
		if (map.get("title") != null && !"".equals(map.get("title"))  ||
				map.get("stime") != null && !"".equals(map.get("stime")) || 
				map.get("stime") != null && !"".equals(map.get("stime")) 
					) {
			selectList = signinrecorMapper.selSigninrecorAll(map);
		}else {
			selectList = signinrecorMapper.selSigninrecorAll(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */
		pageBean.setRows(selectList);
		System.err.println(pageBean.getRows().toString());
		return signinrecorMapper.selSigninrecorAll(map);
	}


	@Override
	public List<MySigninrecor> findMySigninrecorAll() {
		return signinrecorMapper.selMySigninrecorAll();
	}

}
