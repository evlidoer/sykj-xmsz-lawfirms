package com.jt.lawfirm.service.finance;

import java.util.List;
import java.util.Map;

public interface IActingInvoiceService {
	
	List<Map<String, String>> findInvoiceByIdOfNumber(int id);
	
	boolean addCollectionAll(Map<String, String> map);
	
	List<Map<String, String>> findKdmanagerFAllByY();
	
	List<Map<String, String>> findKdmanagerKdAllByY();
	
}
