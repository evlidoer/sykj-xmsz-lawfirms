package com.jt.lawfirm.util;

import java.io.IOException;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
		
	public static String wirte(Object o) {
		ObjectMapper mapper = new ObjectMapper();
		String JOSN = null;
		try {
			JOSN = mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(JOSN);
		return JOSN;
	}
}
