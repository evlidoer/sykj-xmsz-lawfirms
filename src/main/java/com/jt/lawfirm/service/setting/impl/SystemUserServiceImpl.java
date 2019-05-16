/**
 * 2019年5月5日下午8:06:28
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.service.setting.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.hr.HrEmp;
import com.jt.lawfirm.mapper.setting.SystemUsermapper;
import com.jt.lawfirm.service.setting.SystemUserService;

/**
 * 2019年5月5日下午8:06:28
 * @author 许威
 * @Desc 
 */
@Service(value = "SystemUserService")
public class SystemUserServiceImpl implements SystemUserService {
	//加密算法名称，有：Base64 , MD5 , SHA1等等
	static final String hashAlgorithmName = "MD5";
	static final int hashIterations = 1024; //加密叠加次数
	@Autowired
	private SystemUsermapper systemUsermapper;
	/**
	 * 2019年5月5日下午8:07:41
	 * @author 许威
	 * @Desc 
	 * @param map
	 */
	@Override
	public List<HashMap<String, Object>>  findSystemUserAll(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");

		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());

		List<HashMap<String, Object>> selectList  = new ArrayList<HashMap<String, Object>>();
		if (map.get("title") != null && !"".equals(map.get("title"))) {
			selectList = systemUsermapper.selSystemUserall(map);
		}else {
			selectList = systemUsermapper.selSystemUserall(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */

		pageBean.setRows(selectList);
		return systemUsermapper.selSystemUserall(map);
	}
	/**
	 * 2019年5月8日下午9:17:48
	 * @author 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Override
	public Map<String, Object> userManagerSelByID(int id) {
		return systemUsermapper.userManagerSelByID(id);
	}
	/**
	 * 2019年5月12日上午10:51:18
	 * @author 许威
	 * @Desc 
	 * @param map
	 */
	@Override
	public void findempAll(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");

		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());

		List<HrEmp> selectList  = new ArrayList<HrEmp>();
		if (map.get("title") != null && !"".equals(map.get("title"))) {
			selectList = systemUsermapper.selempAll(map);
		}else {
			selectList = systemUsermapper.selempAll(map);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */
		pageBean.setRows(selectList);
	}
	/**
	 * 2019年5月12日上午11:12:10
	 * @author 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 * @return
	 */
	@Override
	public String addUser(HashMap<String, Object> isNotEmptyKeyMap) {
		try {
			/**
			 * 1.0 	判断用户名是否存在
			 */
			int i = systemUsermapper.selUserByid(isNotEmptyKeyMap);
			if (i >0) {
				return "no";
			}
			/*
			 * 2.0  开始向用户表添加数据
			 */
			systemUsermapper.insertUser(isNotEmptyKeyMap);
			/**
			 * 		修改密码和添加创建时间
			 */
			//根据用户名获得盐值
			Object salt = ByteSource.Util.bytes(isNotEmptyKeyMap.get("user_name"));
			/* 得到加密后的结果 */
			Object result = new SimpleHash(hashAlgorithmName, isNotEmptyKeyMap.get("user_pwd"), salt, hashIterations);
			systemUsermapper.insertUserP(result.toString(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString(),Integer.parseInt(isNotEmptyKeyMap.get("id").toString()));
			/**
			 * 	拿到 id 开始授权 , 
			 */
			systemUsermapper.addRole(isNotEmptyKeyMap);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();//打印错误信息
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动回滚失误
		}
		return "no";
	}
	/**
	 * 2019年5月12日下午1:24:06
	 * @author 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 * @return
	 */
	@Override
	public Boolean upduser(HashMap<String, Object> isNotEmptyKeyMap) {
		try {
			//根据用户名获得盐值
			Object salt = ByteSource.Util.bytes(isNotEmptyKeyMap.get("user_name"));
			/* 得到加密后的结果 */
			Object result = new SimpleHash(hashAlgorithmName, isNotEmptyKeyMap.get("user_pwd"), salt, hashIterations);
			isNotEmptyKeyMap.put("user_pwd", result.toString());
			systemUsermapper.upduser(isNotEmptyKeyMap);
			return true;
		} catch (Exception e) {
			e.printStackTrace();//打印错误信息
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动回滚失误
		}
		return false ;
	}
}
