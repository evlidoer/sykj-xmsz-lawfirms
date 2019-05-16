package com.jt.lawfirm.service.administration;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.jt.lawfirm.bean.administration.Notice;

public interface Noticeservice {
	List<Notice> findNoticeAll(Map<String, Object> map);

	Map<String, Object> findInfoById(int id);

	int updNotice(Notice notice);

	void removeById(int id);

	void addNotice(Notice notice);

	/**
	 * 2019年5月12日下午5:40:59
	 * @User 许威
	 * @Desc 
	 * @param string
	 * @return
	 */
	Integer selIdByUserName(String string);
}
