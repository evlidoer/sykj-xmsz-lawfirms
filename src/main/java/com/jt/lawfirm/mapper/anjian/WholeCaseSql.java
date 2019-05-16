package com.jt.lawfirm.mapper.anjian;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.jt.lawfirm.bean.finance.Invoice;

public class WholeCaseSql {
	public String insertInvoiceAll(Invoice invoice) {
		return new SQL() {
			{	
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				INSERT_INTO("cw_invoice");
				if ("hr_emp_id" !=null && !"hr_emp_id".equals("")) VALUES("hr_emp_id", "#{hr_emp_id}");
				if ("case_law_id" !=null && !"case_law_id".equals("")) VALUES("case_law_id", "#{case_law_id}");
				if ("cw_invoice_title" !=null && !"cw_invoice_title".equals("")) VALUES("cw_invoice_title", "#{cw_invoice_title}");
				if ("cw_invoice_money" !=null && !"cw_invoice_money".equals("")) VALUES("cw_invoice_money", "#{cw_invoice_money}");
				VALUES("cw_application_date", "'" + sdf.format(new Date()) + "'");
				if ("cw_invoice_date" !=null && !"cw_invoice_date".equals("")) VALUES("cw_invoice_date", "#{cw_invoice_date}");
				VALUES("cw_invoice_status", "'N'");
				if ("cw_invoice_number" !=null && !"cw_invoice_number".equals("")) VALUES("cw_invoice_number", "#{cw_invoice_number}");
				if ("cw_remark" !=null && !"cw_remark".equals("")) VALUES("cw_remark", "#{cw_remark}");
				if ("cw_open_type" !=null && !"cw_open_type".equals("")) VALUES("cw_open_type", "#{cw_open_type}");
				if ("cw_invoice_type" !=null && !"cw_invoice_type".equals("")) VALUES("cw_invoice_type", "#{cw_invoice_type}");
				if ("cw_invoice_item" !=null && !"cw_invoice_item".equals("-1")) VALUES("cw_invoice_item", "#{cw_invoice_item}");
				if ("cw_taxpayer_identity_number" !=null && !"cw_taxpayer_identity_number".equals("")) VALUES("cw_taxpayer_identity_number", "#{cw_taxpayer_identity_number}");
				if ("cw_basic_bankofdeposit" !=null && !"cw_basic_bankofdeposit".equals("")) VALUES("cw_basic_bankofdeposit", "#{cw_basic_bankofdeposit}");
				if ("cw_registered_address" !=null && !"cw_registered_address".equals("")) VALUES("cw_registered_address", "#{cw_registered_address}");
				if ("cw_fixedline_telephone" !=null && !"cw_fixedline_telephone".equals("")) VALUES("cw_fixedline_telephone", "#{cw_fixedline_telephone}");
			}
		}.toString();
	}
}
