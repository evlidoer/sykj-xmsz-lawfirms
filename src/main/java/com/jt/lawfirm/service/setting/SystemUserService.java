/**
 * 2019年5月5日下午8:05:39
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.service.setting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2019年5月5日下午8:05:39
 * @author 许威
 * @Desc 
 */
public interface SystemUserService {

	/**
	 * 
	 * 2019年5月5日下午8:08:34
	 * @User 许威
	 * @Desc 
	 * @param map
	 * @return List<HashMap<String, Object>> 
	 */
	List<HashMap<String, Object>>  findSystemUserAll(Map<String, Object> map);

	/**
	 * 2019年5月8日下午9:17:29
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	Map<String, Object> userManagerSelByID(int id);

	/**
	 * 2019年5月12日上午10:51:04
	 * @User 许威
	 * @Desc 
	 * @param map
	 */
	void findempAll(Map<String, Object> map);

	/**
	 * 2019年5月12日上午11:11:49
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 * @return
	 */
	String addUser(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年5月12日下午1:23:52
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 * @return
	 */
	Boolean upduser(HashMap<String, Object> isNotEmptyKeyMap);
}
