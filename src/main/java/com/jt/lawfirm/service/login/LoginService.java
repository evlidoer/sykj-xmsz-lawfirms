/**
 * 2019年5月2日上午11:09:24
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.service.login;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.system.User;

/**
 * 2019年5月2日上午11:09:24
 * @author 许威
 * @Desc 
 */
public interface LoginService {
	/**
	 * 2019年5月2日上午11:09:34
	 * @User 许威
	 * @Desc 
	 */
	User finUserByNamw(String user_name);

	/**
	 * 2019年5月2日上午11:16:30
	 * @User 许威
	 * @Desc 
	 * @param userCode
	 * @return
	 */
	List<Map<String, Object>> findRoles(String userCode);
}
