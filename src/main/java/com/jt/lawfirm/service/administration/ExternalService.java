package com.jt.lawfirm.service.administration;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.administration.External;

public interface ExternalService {
	List<External> findExternalAll(Map<String, Object> map);

	void removeExternalById(int id);

	External selInfoExternalById(Integer id);

	External selUpdExternalById(Integer id);

	void upd(External external);

	void add(External external);
}
