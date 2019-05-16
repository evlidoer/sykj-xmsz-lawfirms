package com.jt.lawfirm.mapper.log;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.jt.lawfirm.bean.log.Job;

@Mapper
public interface IAddLogMapper {

	public List<Job> queryAll();

	@Insert("insert into log_job values(null,#{whatisPerson},#{logtypeId},#{law_id},#{cliendId},#{joblogStartTime},#{joblogEnddTime},#{joblogReportedTime},#{joblogUpdatetime},#{addresslistState},#{joblogFile},#{joblogText},#{detail})")
	public int insert(Job job);
}
