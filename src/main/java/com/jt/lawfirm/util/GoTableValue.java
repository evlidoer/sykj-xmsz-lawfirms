package com.jt.lawfirm.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoTableValue {
	
	public static<T> List<Map<String, String>> lamadaOfUp(List<T> list , String... colunmNames){
		List<Map<String, String>> arrayList = new ArrayList<Map<String,String>>();
		list.forEach(obj -> {
			try {
				arrayList.add(GoTableValue.lamadaOfUpEach(obj, colunmNames));
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		});
		return arrayList;
	}
	
	private static<T> Map<String, String> lamadaOfUpEach(T obj, String... colunmNames ) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if(colunmNames.length == 0) return null;
		Map<String, String> map = new HashMap<String,String>();
		Class<? extends Object> myClass = obj.getClass();
		for (String name : colunmNames) {
			Method method = myClass.getMethod("get" + name.substring(0,1).toUpperCase() + name.substring(1));
			map.put(name, method.invoke(obj).toString());
		}
		return map;
	}
	
}
