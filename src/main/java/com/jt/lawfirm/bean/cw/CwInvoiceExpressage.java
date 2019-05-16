package com.jt.lawfirm.bean.cw;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 	原始设计的中间表
 * 
 * 	许威
 * 	cw_invoice_expressage
 */

@TableName(value = "cw_invoice_expressage")
public class CwInvoiceExpressage {
	private Integer id;
	private int cw_invoice_id;
	private int adm_expressage_id;
	
	private CwInvoice cwInvoice;
	private Exception exception;
	public CwInvoiceExpressage(Integer id, int cw_invoice_id, int adm_expressage_id, CwInvoice cwInvoice,
			Exception exception) {
		super();
		this.id = id;
		this.cw_invoice_id = cw_invoice_id;
		this.adm_expressage_id = adm_expressage_id;
		this.cwInvoice = cwInvoice;
		this.exception = exception;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getCw_invoice_id() {
		return cw_invoice_id;
	}
	public void setCw_invoice_id(int cw_invoice_id) {
		this.cw_invoice_id = cw_invoice_id;
	}
	public int getAdm_expressage_id() {
		return adm_expressage_id;
	}
	public void setAdm_expressage_id(int adm_expressage_id) {
		this.adm_expressage_id = adm_expressage_id;
	}
	public CwInvoice getCwInvoice() {
		return cwInvoice;
	}
	public void setCwInvoice(CwInvoice cwInvoice) {
		this.cwInvoice = cwInvoice;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	@Override
	public String toString() {
		return "CwInvoiceExpressage [id=" + id + ", cw_invoice_id=" + cw_invoice_id + ", adm_expressage_id="
				+ adm_expressage_id + ", cwInvoice=" + cwInvoice + ", exception=" + exception + "]";
	}
}
