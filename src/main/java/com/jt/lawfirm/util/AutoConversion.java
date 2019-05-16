package com.jt.lawfirm.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
  * 自动转换为你想要的类
 * @author theFlyingCat
 *
 */
public class AutoConversion {
	
	/**
	  * 自动转换为Map集合 key安装传参的顺序分别为 str0, str1, str2 .... 依次类推
	 * @param str
	 * @return
	 */
	public static Map<String, String> conversionToMap(String... str){
		Map<String, String> map = new HashMap<String, String>(str.length);
		for (int i = 0; i < str.length; i++) {
			if(str[i].trim().equals("")) str[i] = null;
			map.put("str"+i, str[i]);
		}
		return map;
	}
	
	/**
	  * 根据传入的request自动生成Map集合 名称不变
	 * @param str
	 * @return
	 */
	public static Map<String, String> conversionToMap(HttpServletRequest request){
		Enumeration<String> names = request.getParameterNames();
		if(!names.hasMoreElements()) return null;
		Map<String, String> map = new HashMap<String, String>();
		while(names.hasMoreElements()) {
			String key = names.nextElement().toString();
			if(request.getParameter(key).trim().equals("")) {
				map.put(key, null);
				continue;
			}
			map.put(key, request.getParameter(key));
		}
		return map;
	}
	
	
	
	public static HashMap<String, Object> IsNotEmptyKeyMap(HttpServletRequest request){
		Enumeration<String> names = request.getParameterNames();
		if(!names.hasMoreElements()) return null;
		HashMap<String,Object> map = new HashMap<String,Object>();
		while(names.hasMoreElements()) {
			String key = names.nextElement().toString();
			if (!"".equals(request.getParameter(key).trim())) {
				map.put(key, request.getParameter(key));
			}
		}
		return map;
	}
	
}
