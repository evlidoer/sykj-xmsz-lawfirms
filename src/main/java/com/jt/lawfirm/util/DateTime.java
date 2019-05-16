package com.jt.lawfirm.util;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * 处理时间工具类
 * @author theFlyingCat
 *
 */
public class DateTime {
	
	/**
	 * 如果开始时间比结束时间大时使用
	 * @param classname 要交换bean
	 * @param startTime bean内的开始时间字段名称
	 * @param endTime bean内的结束时间字段名称
	 * @return 返回修改后的bean
	 */
	public static<T> T exchangeDate(T classname, String startColnum, String endColnum){
		try {
			Class<? extends Object> myClass = classname.getClass();
			Method getStartColnum = myClass.getMethod("get" + startColnum.substring(0, 1).toUpperCase() + startColnum.substring(1));
			Method getEndColnum = myClass.getMethod("get" + endColnum.substring(0, 1).toUpperCase() + endColnum.substring(1));
			String start = (String) getStartColnum.invoke(classname);
			String end = (String) getEndColnum.invoke(classname);
			if(start == null || end == null || start.trim().equals("") || end.trim().equals("")) return classname;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(sdf.parse(start).getTime() > sdf.parse(end).getTime()) {
				String temp = start;
				Method setStartColnum = myClass.getMethod("set" + startColnum.substring(0, 1).toUpperCase() + startColnum.substring(1), String.class);
				Method setEndColnum = myClass.getMethod("set" + endColnum.substring(0, 1).toUpperCase() + endColnum.substring(1), String.class);
				setStartColnum.invoke(classname, end);
				setEndColnum.invoke(classname, temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classname;
	}
	
	public static Map<String, String> exchangeDate(Map<String, String> map, String startColnum, String endColnum){
		String start = map.get(startColnum);
		String end = map.get(endColnum);
		if(start == null || end == null) return map;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfplus = new SimpleDateFormat("yyyy-MM");
		try {
			if(sdf.parse(start).getTime() > sdf.parse(end).getTime()) {
				String temp = start;
				map.put(startColnum, end);
				map.put(endColnum, temp);
			}
		}catch (ParseException e) {
			try {
				if(sdfplus.parse(start).getTime() > sdfplus.parse(end).getTime()) {
					String temp = start;
					map.put(startColnum, end);
					map.put(endColnum, temp);
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		return map;
	}
	
}
