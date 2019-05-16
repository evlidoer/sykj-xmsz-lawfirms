/**
 * 2019年5月2日上午11:11:14
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.mapper.login;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * 2019年5月2日上午11:11:14
 * @author 许威
 * @Desc 
 */
public interface LoginMapper {
	/**
	 * 2019年5月2日上午11:11:28
	 * @User 许威
	 * @Desc 
	 */
	@Select("select * from system_user where user_name = #{user_name}")
	Map<String,Object> selUserByName(String user_name);
}
