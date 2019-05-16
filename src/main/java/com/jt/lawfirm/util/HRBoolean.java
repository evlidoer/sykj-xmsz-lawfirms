package com.jt.lawfirm.util;

import java.util.HashMap;
import java.util.Map;

public class HRBoolean {
	
	public static Map<String, String> yesOrNo(boolean b){
		Map<String, String> map = new HashMap<String, String>();
		if(!b) map.put("status", "no");
		if(b) map.put("status", "yes");
		return map;
	}
	
}
