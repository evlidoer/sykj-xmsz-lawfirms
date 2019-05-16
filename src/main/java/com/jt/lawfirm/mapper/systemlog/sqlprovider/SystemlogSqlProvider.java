package com.jt.lawfirm.mapper.systemlog.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

import com.jt.lawfirm.bean.system.Log;
import com.jt.lawfirm.bean.system.mysystembean.MySysTemSelect;

/**
 * @author 代
 * */
public class SystemlogSqlProvider {

	public String selectsyslog(MySysTemSelect sys){
		return new SQL(){
			{
				SELECT("l.*,u.user_name");
				FROM("system_log l");
				INNER_JOIN("system_user u on u.id = l.user_id");
				if(sys.getUserid() != null) WHERE("l.user_id = #{userid}");
				if (sys.getChoice().equals("1")){if(sys.getNameorip()!= null) WHERE("u.user_name like" + "'%" +sys.getNameorip()+"%'");}
				if (sys.getChoice().equals("2")){if(sys.getNameorip()!= null) WHERE("l.systemlog_ip like" + "'%" +sys.getNameorip()+"%'");}
			}
		}.toString();
	}
	
	public String insertlog(Log log){
		return new SQL(){
			{	
				INSERT_INTO("system_log");
				if (log.getUserId()!= null) VALUES("user_id","'" + log.getUserId()+"'" );
				if (log.getSystemTypeId() != null) VALUES("system_type_id","'" + log.getSystemTypeId()+"'");
				if (log.getSystemLogLogexplain()!= null) VALUES("system_log_logexplain","'" + log.getSystemLogLogexplain()+"'" );
				if (log.getSystemLogIp()!= null) VALUES("system_log_ip","'" + log.getSystemLogIp()+"'" );
				if (log.getSystemLogRecordTime()!= null) VALUES("system_log_recordTime","'" + log.getSystemLogRecordTime()+"'" );
			}
		}.toString();
	}
}
