package com.jt.lawfirm.mapper.finance;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.finance.Invoice;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyInvoice;
import com.jt.lawfirm.mapper.finance.sqlProvider.InvoiceSqlProvider;

public interface IInvoiceMapper extends BaseMapper<Invoice> {
	
	@SelectProvider(type=InvoiceSqlProvider.class, method="selectInvoiceofSive")
	List<Map<String, String>> selectInvoiceofSive(MyInvoice invoice);
	
	@SelectProvider(type=InvoiceSqlProvider.class, method="selectInvoiceByIdOfNumber")
	List<Map<String, String>> selectInvoiceByIdOfNumber(Map<String, String> map);
	
	@InsertProvider(type=InvoiceSqlProvider.class, method="insertInvoiceAll")
	boolean insertInvoiceAll(Map<String, String> map);
	
	@SelectProvider(type=InvoiceSqlProvider.class, method="selectInvoiceOfSiveAll")
	List<Map<String, String>> selectInvoiceOfSiveAll(Map<String, String> map);
	
	@SelectProvider(type=InvoiceSqlProvider.class, method="selectInvoiceOfSiveAllExprot")
	List<Map<String, String>> selectInvoiceOfSiveAllExprot(Map<String, String> map);
	
}
