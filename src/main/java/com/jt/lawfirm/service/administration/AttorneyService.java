package com.jt.lawfirm.service.administration;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.administration.Attorney;

public interface AttorneyService {
	List<Attorney> findAttorneyAll(Map<String, Object> map);

	List<Attorney> findAttorneyByID(Integer id);
}
