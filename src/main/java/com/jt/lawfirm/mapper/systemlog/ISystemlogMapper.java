package com.jt.lawfirm.mapper.systemlog;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import com.jt.lawfirm.bean.system.Log;
import com.jt.lawfirm.bean.system.mysystembean.MySysTemSelect;
import com.jt.lawfirm.mapper.systemlog.sqlprovider.SystemlogSqlProvider;

/**
 * @author 代
 * */
public interface ISystemlogMapper {

	@SelectProvider(type=SystemlogSqlProvider.class,method="selectsyslog")
	List<Log> selectsyslog(MySysTemSelect sysTemSelect);
	
	@InsertProvider(type=SystemlogSqlProvider.class,method="insertlog")
	boolean insertlog(Log log);
}
