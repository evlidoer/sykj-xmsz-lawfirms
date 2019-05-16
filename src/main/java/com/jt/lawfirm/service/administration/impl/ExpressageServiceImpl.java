package com.jt.lawfirm.service.administration.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.mapper.administration.IExpressageMapper;
import com.jt.lawfirm.service.administration.ExpressageService;


@Service(value = "ExpressageService")
public class ExpressageServiceImpl implements ExpressageService {
	@Autowired
	private IExpressageMapper iExpressageMapper;
	@Override
	public List<Map<String, Object>> findEexpressageAll(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");
		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
		List<Map<String, Object>> selectList = new ArrayList<Map<String,Object>>();
		if (map.get("title") != null && !"".equals(map.get("title"))  ||
				map.get("stime") != null && !"".equals(map.get("stime")) || 
				map.get("stime") != null && !"".equals(map.get("stime")) ||
				map.get("status") != null && !"".equals(map.get("status")) ||
				map.get("company") != null && !"".equals(map.get("company")) ||
						map.get("id") != null && !"".equals(map.get("id"))
				) {
			selectList = iExpressageMapper.selExpressageAll(map);
		}else {
			selectList = iExpressageMapper.selExpressageAll(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */
		pageBean.setRows(selectList);
		System.err.println(pageBean.getRows().toString());
		return iExpressageMapper.selExpressageAll(map);
	}
	@Override
	public List<Map<String, Object>> findEexpressageFAll(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");
		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
		List<Map<String, Object>> selectList = new ArrayList<Map<String,Object>>();
		if (map.get("title") != null && !"".equals(map.get("title"))  ||
				map.get("stime") != null && !"".equals(map.get("stime")) || 
				map.get("stime") != null && !"".equals(map.get("stime")) ||
				map.get("status") != null && !"".equals(map.get("status")) ||
				map.get("company") != null && !"".equals(map.get("company")) ||
						map.get("id") != null && !"".equals(map.get("id"))
				) {
			selectList = iExpressageMapper.selExpressageFAll(map);
		}else {
			selectList = iExpressageMapper.selExpressageFAll(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */
		pageBean.setRows(selectList);
		return iExpressageMapper.selExpressageFAll(map);
	}
	
	
	
	
	
	
	
	
	@Override
	public List<Map<String, Object>> addRequest_selUser(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");
		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
		List<Map<String, Object>> selectList = new ArrayList<Map<String,Object>>();
		if (map.get("title") != null && !"".equals(map.get("title"))) {
			selectList = iExpressageMapper.selselUserAll(map);
		}else {
			selectList = iExpressageMapper.selselUserAll(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */
		pageBean.setRows(selectList);
		System.err.println(pageBean.getRows().toString());
		return iExpressageMapper.selselUserAll(map);
	}

	/**
	 * s删除
	 */
	@Override
	public void remove_ExpressageById(int id) {
		
		iExpressageMapper.deleteExpressageById(id);
	}


		@Override
		public List<Map<String, Object>> findlawAndEmp(Map<String, Object> map) {
			PageBean pageBean = (PageBean) map.get("pageBean");
			// 得到总页数，设置到 pb中
			@SuppressWarnings("rawtypes")
			Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
			List<Map<String, Object>> selectList = new ArrayList<Map<String,Object>>();
			if (map.get("title") != null && !"".equals(map.get("title"))) {
				selectList = iExpressageMapper.selLawAndEMp(map);
			}else {
				selectList = iExpressageMapper.selLawAndEMp(null);
			}
			// 将分页查询到的数据 放入到  pb中， 返回给前台
			pageBean.setTotal((int) pg.getTotal());
			/**
			 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
			 */
			pageBean.setRows(selectList);
			for (Object map2 : pageBean.getRows()) {
				System.err.println(map2);
			}
			return iExpressageMapper.selLawAndEMp(map);
		}

		@Override
		public Map<String, Object> findExpressageById(int id) {
			return iExpressageMapper.selExpressageById(id);
		}

		/***
		 * 	快递公司查询
		 */

		@Override
		public List<Map<String,Object>> findselkuaidi(Map<String, Object> map) {
			PageBean pageBean = (PageBean) map.get("pageBean");
			// 得到总页数，设置到 pb中
			@SuppressWarnings("rawtypes")
			Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
			List<Map<String, Object>> selectList = new ArrayList<Map<String,Object>>();
			if (map.get("title") != null && !"".equals(map.get("title"))) {
				selectList = iExpressageMapper.selkuaidi(map);
			}else {
				selectList = iExpressageMapper.selkuaidi(null);
			}
			// 将分页查询到的数据 放入到  pb中， 返回给前台
			pageBean.setTotal((int) pg.getTotal());
			/**
			 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
			 */
			pageBean.setRows(selectList);
			for (Object map2 : pageBean.getRows()) {
				System.err.println(map2);
			}
			return iExpressageMapper.selkuaidi(map);
		}
		
		
		
			/***
			 * 	查询派送
			 */
		@Override
		public List<Map<String, Object>> findselkuaidiType(Map<String, Object> map) {
			PageBean pageBean = (PageBean) map.get("pageBean");
			// 得到总页数，设置到 pb中
			@SuppressWarnings("rawtypes")
			Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
			List<Map<String, Object>> selectList = new ArrayList<Map<String,Object>>();
			if (map.get("title") != null && !"".equals(map.get("title"))) {
				selectList = iExpressageMapper.selkuaidiType(map);
			}else {
				selectList = iExpressageMapper.selkuaidiType(null);
			}
			// 将分页查询到的数据 放入到  pb中， 返回给前台
			pageBean.setTotal((int) pg.getTotal());
			/**
			 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
			 */
			pageBean.setRows(selectList);
			for (Object map2 : pageBean.getRows()) {
				System.err.println(map2);
			}
			return iExpressageMapper.selkuaidiType(map);
		}
		
		
		@Override
		public HashMap<String, Object> findEmpIDByUserId(Object object) {
			return iExpressageMapper.selEmpIDByUserId(object);
		}

		/**
		 * 		添加
		 */
		@Override
		public void addAll(HashMap <String,Object> conversionToMap) {
			iExpressageMapper.insertAll(conversionToMap);
		}
		/**
		 * @author 许威
		 * 2019年4月26日
		 */
		@Override
		public void updAll(HashMap<String, Object> isNotEmptyKeyMap) {
			iExpressageMapper.updateAll(isNotEmptyKeyMap);
		}

		/**
		 * @author 许威
		 * 2019年4月26日
		 */
		@Override
		public void removeExpressageByID(int id) {
			iExpressageMapper.delExpressageByID(id);
		}
		/**
		 * @author 许威
		 * 2019年4月26日
		 */
		@Override
		public void updExpressageCompany(HashMap<String, Object> isNotEmptyKeyMap) {
			iExpressageMapper.updExpressageCompany(isNotEmptyKeyMap);
		}

		/**
		 * @author 许威
		 * 2019年4月26日
		 */
		@Override
		public void updateExpressageCompanyType(HashMap<String, Object> isNotEmptyKeyMap) {
			iExpressageMapper.updateExpressageCompanyType(isNotEmptyKeyMap);
		}

		/**
		 * @author 许威
		 * 2019年4月27日
		 */
		@Override
		public void ExpressageCompanyTypeadd(HashMap<String, Object> isNotEmptyKeyMap) {
			iExpressageMapper.updateExpressageCompanyTypeadd(isNotEmptyKeyMap);
			
		}


		/**
		 * @author 许威
		 * 2019年4月27日
		 */
		@Override
		public void ExpressageCompanyadd(HashMap<String, Object> isNotEmptyKeyMap) {
			iExpressageMapper.updExpressageCompanyadd(isNotEmptyKeyMap);			
		}

		/**
		 * @author 许威
		 * 2019年4月27日
		 */
		@Override
		public boolean ExpressageCompanyTypedel(int id) {
			List<Map<String,Object>> ooMap = iExpressageMapper.selByKDTypeID(id);	
			System.err.println(ooMap.toString());
			if (ooMap.toString() == null || ooMap.toString() == "null" || ooMap.toString() == "[]") {
				return iExpressageMapper.delCompanyType(id);
			}
			return false;
		}

		/**
		 * @author 许威
		 * 2019年4月27日
		 */
		@Override
		public boolean ExpressageCompanydel(int id) {
			List<Map<String,Object>> ooMap = iExpressageMapper.selByKDID(id);
			System.err.println(ooMap.toString());
			if (ooMap.toString() == null || ooMap.toString() == "null" || ooMap.toString() == "[]") {
				return iExpressageMapper.delCompany(id);
			}
			return false;
		}

		/**
		 * @author 许威
		 * 2019年4月27日
		 */
		@Override
		public void addFAll(HashMap<String, Object> isNotEmptyKeyMap) {
			iExpressageMapper.addFAll(isNotEmptyKeyMap);
		}
		/**
		 * @author 许威
		 * 2019年4月27日
		 */
		@Override
		public boolean RemoveExpressageF(int id) {
			int i = iExpressageMapper.delExpressageF(id);
			if (i > 0) {
				return true;
			}
			return false;
		}
		/**
		 * @author 许威
		 * 2019年4月28日
		 */
		@Override
		public HashMap<String, Object> findFById(int id) {
			return iExpressageMapper.selFbyid(id);
		}
		/**
		 * @author 许威
		 * 2019年4月28日
		 */
		@Override
		public void updF(@SuppressWarnings("rawtypes") HashMap HashMap) {
			iExpressageMapper.updF(HashMap);
		}
		/**
		 * 2019年5月12日下午6:28:25
		 * @author 许威
		 * @Desc 
		 * @param username
		 * @return
		 */
		@Override
		public Integer selUserIdByName(String username) {
			return iExpressageMapper.selUserIdByName(username);
		}
		
}
