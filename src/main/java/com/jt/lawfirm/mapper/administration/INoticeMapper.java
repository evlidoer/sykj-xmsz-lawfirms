package com.jt.lawfirm.mapper.administration;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.administration.Notice;

public interface INoticeMapper extends BaseMapper<Notice>{

	List<Notice> selNoticeAll(Map<String, Object> map);

	Map<String, Object> selInfoById(int id);

	int updNoticeById(Notice notice);

	/**
	 * 2019年5月12日下午5:49:44
	 * @User 许威
	 * @Desc 
	 * @param string
	 */
	@Select("select id from system_user where user_name = #{string}")
	Integer selIdByUserName(String string);

}
