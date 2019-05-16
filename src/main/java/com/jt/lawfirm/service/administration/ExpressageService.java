package com.jt.lawfirm.service.administration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ExpressageService {

	List<Map<String, Object>> findEexpressageAll(Map<String, Object> map);

	List<Map<String, Object>> addRequest_selUser(Map<String, Object> map);

	void remove_ExpressageById(int id);


	 List<Map<String,Object>> findlawAndEmp(Map<String, Object> map);

	Map<String, Object> findExpressageById(int id);

	List<Map<String,Object>> findselkuaidi(Map<String, Object> map);
	
	List<Map<String,Object>> findselkuaidiType(Map<String, Object> map);

	void addAll(HashMap<String,Object> conversionToMap);

	HashMap<String, Object> findEmpIDByUserId(Object object);

	/**
	 * 2019年4月26日下午3:43:07
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	void updAll(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月26日下午7:20:27
	 * @User 许威
	 * @Desc 
	 * @param id
	 */
	void removeExpressageByID(int id);

	/**
	 * 2019年4月26日下午11:36:52
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	void updExpressageCompany(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月26日下午11:37:57
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	void updateExpressageCompanyType(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月27日上午12:30:04
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	void ExpressageCompanyTypeadd(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月27日上午12:30:10
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	void ExpressageCompanyadd(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月27日上午1:11:58
	 * @User 许威
	 * @Desc 
	 * @param id
	 */
	boolean ExpressageCompanyTypedel(int id);

	/**
	 * 2019年4月27日上午1:12:09
	 * @User 许威
	 * @Desc 
	 * @param id
	 */
	boolean ExpressageCompanydel(int id);

	/**
	 * 2019年4月27日下午4:57:33
	 * @User 许威
	 * @Desc 
	 * @param isNotEmptyKeyMap
	 */
	void addFAll(HashMap<String, Object> isNotEmptyKeyMap);

	/**
	 * 2019年4月27日下午8:38:22
	 * @User 许威
	 * @Desc 
	 * @param map
	 * @return 
	 */
	List<Map<String, Object>> findEexpressageFAll(Map<String, Object> map);

	/**
	 * 2019年4月27日下午11:16:13
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	boolean RemoveExpressageF(int id);

	/**
	 * 2019年4月28日上午12:12:41
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	HashMap<String, Object> findFById(int id);

	/**
	 * 2019年4月28日上午8:33:05
	 * @User 许威
	 * @Desc 
	 * @param bean
	 */
	void updF(@SuppressWarnings("rawtypes") HashMap bean);

	/**
	 * 2019年5月12日下午6:28:12
	 * @User 许威
	 * @Desc 
	 * @param username
	 * @return
	 */
	Integer selUserIdByName(String username);

}
