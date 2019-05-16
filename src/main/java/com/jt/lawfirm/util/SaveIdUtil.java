package com.jt.lawfirm.util;

public class SaveIdUtil {
	
	private static Integer id;

	/**
	 * 	查看详情保存id
	 * 2019年4月18日上午11:14:14
	 * @User 许威
	 * @Desc 
	 * @param id
	 */
	public static void saveID(Integer id) {
		SaveIdUtil.id  = id;
		///asdasdas
	}
	
	/**
	 * 	页面加载完毕,ajax查询数据时调用getID
	 * 2019年4月18日上午11:14:34
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	public static Integer getID() {
		return SaveIdUtil.id;
	}
}
