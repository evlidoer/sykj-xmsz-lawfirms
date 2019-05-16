package com.jt.lawfirm.service.anjian;

import com.jt.lawfirm.bean.finance.Invoice;

public interface WholeCaseService {

	boolean upWholeCaseCZ3(Integer id, String case_recycle);

	boolean upWholeCaseCZ4(Integer id, String case_clash);
	//开发票
	Integer addWholeCaseCZ2(Invoice invoice);

}
