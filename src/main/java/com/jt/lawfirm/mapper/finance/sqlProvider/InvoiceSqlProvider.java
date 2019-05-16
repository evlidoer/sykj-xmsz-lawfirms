package com.jt.lawfirm.mapper.finance.sqlProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyInvoice;

public class InvoiceSqlProvider {
	
	public String selectInvoiceofSive(MyInvoice invoice) {
		return new SQL() {
			{
				SELECT("ci.case_law_id lawId, ci.id cId, ci.cw_invoice_title iTitle, cl.case_propernum propernum, "
						+ "ci.cw_invoice_money invoicemoney," + 
						"ci.cw_application_date appDate, ci.cw_invoice_date invoiceDate,ci.cw_invoice_status iStatus");
				FROM("cw_invoice ci");
				INNER_JOIN("case_law cl on cl.id = ci.case_law_id");
				INNER_JOIN("case_case_type cct on cct.id = cl.case_case_type_id");
				if(invoice.getCaseId() != null && !invoice.getCaseId().trim().equals("")) {
					if(invoice.getCaseIdNum().equals("0")) WHERE("cl.case_propernum like '%" + invoice.getCaseId() + "%'");
					if(invoice.getCaseIdNum().equals("1")) WHERE("ci.cw_invoice_title like '%" + invoice.getCaseId() + "%'");
				}
				if(!invoice.getcType().equals("-1")) WHERE("(cl.case_case_type_id = #{cType} or cct.type_pid = #{cType})");
				if(!invoice.getkProject().equals("-1")) WHERE("ci.cw_invoice_item = #{kProject}");
				if(!invoice.getkStatus().equals("-1")) WHERE("ci.cw_invoice_status  = #{kStatus}");
				if(!invoice.getkType().equals("-1")) WHERE("ci.cw_invoice_type  = #{kType}");
				if(!invoice.getStartTime().trim().equals("")) WHERE("ci.cw_application_date >= #{startTime}");
				if(!invoice.getEndTime().trim().equals("")) WHERE("ci.cw_application_date <= #{endTime}");
				WHERE("ci.hr_emp_id = #{id}");
			}
		}.toString();
	}
	
	public String selectInvoiceByIdOfNumber(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("cw_taxpayer_identity_number identityNumber, cw_invoice_number invoiceNumber");
				FROM("cw_invoice");
				WHERE("case_law_id = #{str0}");
				ORDER_BY("id desc limit 1");
			}
		}.toString();
	}
	
	public String insertInvoiceAll(Map<String, String> map) {
		return new SQL() {
			{	
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				INSERT_INTO("cw_invoice");
				if (map.get("properId") !=null && !map.get("properId").equals("")) VALUES("hr_emp_id", "#{properId}");
				if (map.get("lawNameId") !=null && !map.get("lawNameId").equals("")) VALUES("case_law_id", "#{lawNameId}");
				if (map.get("cw_taitouPerson") !=null && !map.get("cw_taitouPerson").equals("")) VALUES("cw_invoice_title", "#{cw_taitouPerson}");
				if (map.get("kaipiaoMoney") !=null && !map.get("kaipiaoMoney").equals("")) VALUES("cw_invoice_money", "#{kaipiaoMoney}");
				VALUES("cw_application_date", "'" + sdf.format(new Date()) + "'");
				if (map.get("kaipiaoDate") !=null && !map.get("kaipiaoDate").equals("")) VALUES("cw_invoice_date", "#{kaipiaoDate}");
				if (map.get("sessionID") !=null && !map.get("sessionID").equals("")) VALUES("hr_emp_id", "#{sessionID}");
				VALUES("cw_invoice_status", "'Y'");
				if (map.get("invoiceNumber") !=null && !map.get("invoiceNumber").equals("")) VALUES("cw_invoice_number", "#{invoiceNumber}");
				if (map.get("kaipiaoDesc") !=null && !map.get("kaipiaoDesc").equals("")) VALUES("cw_remark", "#{kaipiaoDesc}");
				if (map.get("kaijvType") !=null && !map.get("kaijvType").equals("")) VALUES("cw_open_type", "#{kaijvType}");
				if (map.get("invoiceType") !=null && !map.get("invoiceType").equals("")) VALUES("cw_invoice_type", "#{invoiceType}");
				if (map.get("kaipiaoProject") !=null && !map.get("kaipiaoProject").equals("-1")) VALUES("cw_invoice_item", "#{kaipiaoProject}");
				if (map.get("identityNumber") !=null && !map.get("identityNumber").equals("")) VALUES("cw_taxpayer_identity_number", "#{identityNumber}");
				if (map.get("kaihuBank") !=null && !map.get("kaihuBank").equals("")) VALUES("cw_basic_bankofdeposit", "#{kaihuBank}");
				if (map.get("zhuceAddress") !=null && !map.get("zhuceAddress").equals("")) VALUES("cw_registered_address", "#{zhuceAddress}");
				if (map.get("zhuceTel") !=null && !map.get("zhuceTel").equals("")) VALUES("cw_fixedline_telephone", "#{zhuceTel}");
				if (map.get("kaihuNumber") !=null && !map.get("kaihuNumber").equals("")) VALUES("account_number", "#{kaihuNumber}");
				if (map.get("fileId") !=null && !map.get("fileId").equals("") ) VALUES("adm_expressage_id", "#{fileId}");
			}
		}.toString();
	}
	
	public String selectInvoiceOfSiveAll(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("ci.id, ci.cw_invoice_money, case when a.sumInout is null then 0 else a.sumInout end "
						+ "as sumInout, b.sumInvoice,he.emp_name shengqing,b.emp_name banan,ci.cw_invoice_title,"
						+ "b.caseId,b.case_agencyfee,ci.cw_invoice_date,ci.cw_invoice_status, b.case_propernum");
				FROM("cw_invoice ci ");
				LEFT_OUTER_JOIN("(select cl.id caseId, sum(ci.cw_inout_money) sumInout from cw_inout ci " + 
						" inner join case_law cl on cl.id = ci.case_law_id group by cl.id " + 
						" ) a on ci.case_law_id = a.caseId ");
				INNER_JOIN("(select cl.id caseId, sum(ci.cw_invoice_money) sumInvoice, he.emp_name, cl.case_propernum, cct.*, "
						+ "cl.case_agencyfee from cw_invoice ci " + 
						" inner join case_law cl on cl.id = ci.case_law_id "
						+ "inner join case_case_type cct on cct.id = cl.case_case_type_id" + 
						" inner join hr_emp he on he.id = cl.case_attorney_id group by cl.id " + 
						" ) b on ci.case_law_id = b.caseId");
				INNER_JOIN("hr_emp he on he.id = ci.hr_emp_id");
				if(map.get("caseId") != null && !map.get("caseId").trim().equals("")) {
					if(map.get("caseId").equals("1")) WHERE("b.case_propernum like '%" + map.get("caseId") + "%'");
					if(map.get("caseId").equals("2")) WHERE("ci.cw_invoice_title like '%" + map.get("caseId") + "%'");
					if(map.get("caseId").equals("3")) WHERE("b.emp_name like '%" + map.get("caseId") + "%'");
				}
				if(map.get("kpStatus") != null && !map.get("kpStatus").equals("-1"))
					WHERE("ci.cw_invoice_status = #{kpStatus}");
				if(map.get("fpType") != null && !map.get("fpType").equals("-1"))
					WHERE("cw_invoice_type = #{fpType}");
				if(map.get("kaipiaoProject") != null && !map.get("kaipiaoProject").equals("-1"))
					WHERE("cw_invoice_item = #{kaipiaoProject}");
				if(map.get("cType") != null && !map.get("cType").equals("-1"))
					WHERE("(b.id = #{cType} or b.type_pid = #{cType})");
				if(map.get("startTime") != null && !map.get("startTime").trim().equals(""))
					WHERE("ci.cw_invoice_date >= #{startTime}");
				if(map.get("endTime") != null && !map.get("endTime").trim().equals(""))
					WHERE("ci.cw_invoice_date <= #{endTime}");
				ORDER_BY("ci.id desc");
			}
		}.toString();
	}
	
	public String selectInvoiceOfSiveAllExprot(Map<String, String> map) {
		return new SQL() {
			{
				SELECT("ci.id, ci.cw_invoice_money, case when a.sumInout is null then 0 else a.sumInout end "
						+ "as sumInout, b.sumInvoice,he.emp_name shengqing,b.emp_name banan,ci.cw_invoice_title,"
						+ "b.caseId,b.case_agencyfee,ci.cw_invoice_date,"
						+ "case when ci.cw_invoice_status = 'Y' then '已开'  else '未开' end as cw_invoice_status, b.case_propernum");
				FROM("cw_invoice ci ");
				LEFT_OUTER_JOIN("(select cl.id caseId, sum(ci.cw_inout_money) sumInout from cw_inout ci " + 
						" inner join case_law cl on cl.id = ci.case_law_id group by cl.id " + 
						" ) a on ci.case_law_id = a.caseId ");
				INNER_JOIN("(select cl.id caseId, sum(ci.cw_invoice_money) sumInvoice, he.emp_name, cl.case_propernum, cct.*, "
						+ "cl.case_agencyfee from cw_invoice ci " + 
						" inner join case_law cl on cl.id = ci.case_law_id "
						+ "inner join case_case_type cct on cct.id = cl.case_case_type_id" + 
						" inner join hr_emp he on he.id = cl.case_attorney_id group by cl.id " + 
						" ) b on ci.case_law_id = b.caseId");
				INNER_JOIN("hr_emp he on he.id = ci.hr_emp_id");
				if(map.get("caseId") != null && !map.get("caseId").trim().equals("")) {
					if(map.get("caseId").equals("1")) WHERE("b.case_propernum like '%" + map.get("caseId") + "%'");
					if(map.get("caseId").equals("2")) WHERE("ci.cw_invoice_title like '%" + map.get("caseId") + "%'");
					if(map.get("caseId").equals("3")) WHERE("b.emp_name like '%" + map.get("caseId") + "%'");
				}
				if(map.get("kpStatus") != null && !map.get("kpStatus").equals("-1"))
					WHERE("ci.cw_invoice_status = #{kpStatus}");
				if(map.get("fpType") != null && !map.get("fpType").equals("-1"))
					WHERE("cw_invoice_type = #{fpType}");
				if(map.get("kaipiaoProject") != null && !map.get("kaipiaoProject").equals("-1"))
					WHERE("cw_invoice_item = #{kaipiaoProject}");
				if(map.get("cType") != null && !map.get("cType").equals("-1"))
					WHERE("(b.id = #{cType} or b.type_pid = #{cType})");
				if(map.get("startTime") != null && !map.get("startTime").trim().equals(""))
					WHERE("ci.cw_invoice_date >= #{startTime}");
				if(map.get("endTime") != null && !map.get("endTime").trim().equals(""))
					WHERE("ci.cw_invoice_date <= #{endTime}");
				ORDER_BY("ci.id desc");
			}
		}.toString();
	}
	
}
