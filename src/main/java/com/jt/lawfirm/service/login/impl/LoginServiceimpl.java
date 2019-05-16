/**
 * 2019年5月2日上午11:10:17
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.service.login.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jt.lawfirm.bean.system.User;
import com.jt.lawfirm.mapper.login.LoginMapper;
import com.jt.lawfirm.service.login.LoginService;

/**
 * 2019年5月2日上午11:10:17
 * @author 许威
 * @Desc 
 */
@Service("LoginService")
public class LoginServiceimpl implements LoginService {
	@Resource
	private LoginMapper loginmapper;
	/**
	 * 2019年5月2日上午11:10:17
	 * @author 许威
	 * @Desc 
	 * @return
	 */
	@Override
	public User finUserByNamw(String user_name) {
		Map<String, Object> selUserByName = loginmapper.selUserByName(user_name);
		if (selUserByName == null)
			return null;
		User reltUser = new User();
		reltUser.setId(Integer.parseInt(selUserByName.get("id").toString()));
		reltUser.setUserName(selUserByName.get("user_name").toString());
		reltUser.setUserPwd(selUserByName.get("user_pwd").toString());
		reltUser.setHrEmpId(Integer.parseInt(selUserByName.get("hr_emp_id").toString()));
		return reltUser;
	}
	/**
	 * 2019年5月2日上午11:22:59
	 * @author 许威
	 * @Desc 
	 * @param userCode
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findRoles(String userCode) {
		return null;
	}
}
