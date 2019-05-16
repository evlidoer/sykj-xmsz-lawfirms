package com.jt.lawfirm.service.systemlog;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.system.Log;
import com.jt.lawfirm.bean.system.mysystembean.MySysTemSelect;

public interface ISystemlogService {
List<Log> selectlog(PageBean pageBean,MySysTemSelect sysTemSelect);
boolean insertlog(Log log);
Map<String, Object> selectuserid(String username);
}
