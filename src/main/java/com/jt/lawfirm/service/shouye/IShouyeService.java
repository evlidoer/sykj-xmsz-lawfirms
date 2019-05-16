package com.jt.lawfirm.service.shouye;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.shouye.Calendar;

public interface IShouyeService {

	int approvalnum();

	int officenum();

	int settlenum();

	List<Map<String, Object>> SelectLaw();

	List<Map<String, Object>> Selectnotice();

	int addcalendar(Calendar calendr);

}
