package com.jt.lawfirm.bean.finance;

import java.math.BigDecimal;
import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 发票表
 * @author theFlyingCat
 *
 */
@TableName("cw_invoice")
public class Invoice {
	private Integer id;// 发票Id
	private Integer hr_emp_id;// 开票人Id
	private Integer case_law_id;// 案件Id
	private String cw_invoice_title; //'发票抬头',
	private BigDecimal cw_invoice_money; //'发票金额',
	private Date cw_application_date; //'申请日期',
	private Date cw_invoice_date; //'开票日期',
	private String cw_invoice_status; //'开票状态', # Y=已开   N=未开 
	private String  cw_invoice_number; //'发票号',
	private String cw_remark; //'开票备注',
	private int  cw_open_type; //'开具类型', # 1=个人  ，2=企业
	private int  cw_invoice_type; //'发票类型',		# 1=增值税专用发票  ，2=增值税普通发票 ，3=普通机打发票
	private int  cw_invoice_item; //'开票项目',		# 1=法律代理费 ，2=法律顾问费 ，3=咨询费 ，4=法务托管费 ，5=非诉 ，6=其他(备注中填写)
	private String  cw_taxpayer_identity_number; //'纳税人识别号',
	private String  cw_basic_bankofdeposit;// '基本开户银行',
	private String  cw_registered_address;// '注册地址',
	private String  cw_fixedline_telephone;// '固定电话',
	private int  record_file_id;// '税务登记证副本(文件id)'
	private int adm_expressage_id; //快递表Id 外键
	private String account_number;
	
	public Invoice() {
		// TODO Auto-generated constructor stub
	}

	public Invoice(Integer id, Integer hr_emp_id, Integer case_law_id, String cw_invoice_title,
			BigDecimal cw_invoice_money, Date cw_application_date, Date cw_invoice_date, String cw_invoice_status,
			String cw_invoice_number, String cw_remark, int cw_open_type, int cw_invoice_type, int cw_invoice_item,
			String cw_taxpayer_identity_number, String cw_basic_bankofdeposit, String cw_registered_address,
			String cw_fixedline_telephone, int record_file_id) {
		super();
		this.id = id;
		this.hr_emp_id = hr_emp_id;
		this.case_law_id = case_law_id;
		this.cw_invoice_title = cw_invoice_title;
		this.cw_invoice_money = cw_invoice_money;
		this.cw_application_date = cw_application_date;
		this.cw_invoice_date = cw_invoice_date;
		this.cw_invoice_status = cw_invoice_status;
		this.cw_invoice_number = cw_invoice_number;
		this.cw_remark = cw_remark;
		this.cw_open_type = cw_open_type;
		this.cw_invoice_type = cw_invoice_type;
		this.cw_invoice_item = cw_invoice_item;
		this.cw_taxpayer_identity_number = cw_taxpayer_identity_number;
		this.cw_basic_bankofdeposit = cw_basic_bankofdeposit;
		this.cw_registered_address = cw_registered_address;
		this.cw_fixedline_telephone = cw_fixedline_telephone;
		this.record_file_id = record_file_id;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", hr_emp_id=" + hr_emp_id + ", case_law_id=" + case_law_id + ", cw_invoice_title="
				+ cw_invoice_title + ", cw_invoice_money=" + cw_invoice_money + ", cw_application_date="
				+ cw_application_date + ", cw_invoice_date=" + cw_invoice_date + ", cw_invoice_status="
				+ cw_invoice_status + ", cw_invoice_number=" + cw_invoice_number + ", cw_remark=" + cw_remark
				+ ", cw_open_type=" + cw_open_type + ", cw_invoice_type=" + cw_invoice_type + ", cw_invoice_item="
				+ cw_invoice_item + ", cw_taxpayer_identity_number=" + cw_taxpayer_identity_number
				+ ", cw_basic_bankofdeposit=" + cw_basic_bankofdeposit + ", cw_registered_address="
				+ cw_registered_address + ", cw_fixedline_telephone=" + cw_fixedline_telephone + ", record_file_id="
				+ record_file_id + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHr_emp_id() {
		return hr_emp_id;
	}

	public void setHr_emp_id(Integer hr_emp_id) {
		this.hr_emp_id = hr_emp_id;
	}

	public Integer getCase_law_id() {
		return case_law_id;
	}

	public void setCase_law_id(Integer case_law_id) {
		this.case_law_id = case_law_id;
	}

	public String getCw_invoice_title() {
		return cw_invoice_title;
	}

	public void setCw_invoice_title(String cw_invoice_title) {
		this.cw_invoice_title = cw_invoice_title;
	}

	public BigDecimal getCw_invoice_money() {
		return cw_invoice_money;
	}

	public void setCw_invoice_money(BigDecimal cw_invoice_money) {
		this.cw_invoice_money = cw_invoice_money;
	}

	public Date getCw_application_date() {
		return cw_application_date;
	}

	public void setCw_application_date(Date cw_application_date) {
		this.cw_application_date = cw_application_date;
	}

	public Date getCw_invoice_date() {
		return cw_invoice_date;
	}

	public void setCw_invoice_date(Date cw_invoice_date) {
		this.cw_invoice_date = cw_invoice_date;
	}

	public String getCw_invoice_status() {
		return cw_invoice_status;
	}

	public void setCw_invoice_status(String cw_invoice_status) {
		this.cw_invoice_status = cw_invoice_status;
	}

	public String getCw_invoice_number() {
		return cw_invoice_number;
	}

	public void setCw_invoice_number(String cw_invoice_number) {
		this.cw_invoice_number = cw_invoice_number;
	}

	public String getCw_remark() {
		return cw_remark;
	}

	public void setCw_remark(String cw_remark) {
		this.cw_remark = cw_remark;
	}

	public int getCw_open_type() {
		return cw_open_type;
	}

	public void setCw_open_type(int cw_open_type) {
		this.cw_open_type = cw_open_type;
	}

	public int getCw_invoice_type() {
		return cw_invoice_type;
	}

	public void setCw_invoice_type(int cw_invoice_type) {
		this.cw_invoice_type = cw_invoice_type;
	}

	public int getCw_invoice_item() {
		return cw_invoice_item;
	}

	public void setCw_invoice_item(int cw_invoice_item) {
		this.cw_invoice_item = cw_invoice_item;
	}

	public String getCw_taxpayer_identity_number() {
		return cw_taxpayer_identity_number;
	}

	public void setCw_taxpayer_identity_number(String cw_taxpayer_identity_number) {
		this.cw_taxpayer_identity_number = cw_taxpayer_identity_number;
	}

	public String getCw_basic_bankofdeposit() {
		return cw_basic_bankofdeposit;
	}

	public void setCw_basic_bankofdeposit(String cw_basic_bankofdeposit) {
		this.cw_basic_bankofdeposit = cw_basic_bankofdeposit;
	}

	public String getCw_registered_address() {
		return cw_registered_address;
	}

	public void setCw_registered_address(String cw_registered_address) {
		this.cw_registered_address = cw_registered_address;
	}

	public String getCw_fixedline_telephone() {
		return cw_fixedline_telephone;
	}

	public void setCw_fixedline_telephone(String cw_fixedline_telephone) {
		this.cw_fixedline_telephone = cw_fixedline_telephone;
	}

	public int getRecord_file_id() {
		return record_file_id;
	}

	public void setRecord_file_id(int record_file_id) {
		this.record_file_id = record_file_id;
	}

	public int getAdm_expressage_id() {
		return adm_expressage_id;
	}

	public void setAdm_expressage_id(int adm_expressage_id) {
		this.adm_expressage_id = adm_expressage_id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	
}
