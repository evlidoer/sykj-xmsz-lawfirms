package com.jt.lawfirm.service.anjian;

import java.util.List;
import java.util.Map;

public interface FeiyongService {
	
	//显示案件费用减免记录  biao
	List<Map<String, Object>> feiyongShow(Map<String, Object> map);
	//删除
	boolean delfeiyong(Integer id);
	
	
}
