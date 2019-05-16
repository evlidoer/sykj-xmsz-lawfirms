package com.jt.lawfirm.bean.anjian;

import com.jt.lawfirm.bean.casea.Law;

/**
 * 		用印申请表
 * @author 李阳
 *
 */
public class YongYin {
//	id bigint unsigned primary key auto_increment,
//	case_law_id int unsigned ,-- 案件外键
//	applyfor_receive date,-- 领用日期
//	applyfor_approval_status varchar(50),-- 审批状态
//	applyfor_recipient varchar(20), -- 领用人
//	applyfor_using_the_item varchar(500) -- 用印事项律师函
	
	private Integer id ;
	private Integer caselawid; //-- 案件外键
	private String applyforreceive;//- 领用日期
	private String applyforapprovalstatus;// -- 审批状态
	private String applyforrecipient;// -- 领用人
	private String applyforusingtheitem; //-- 用印事项律师函
	
	private Law law;

	public YongYin() {
		super();
	}

	public YongYin(Integer id, Integer caselawid, String applyforreceive, String applyforapprovalstatus,
			String applyforrecipient, String applyforusingtheitem, Law law) {
		super();
		this.id = id;
		this.caselawid = caselawid;
		this.applyforreceive = applyforreceive;
		this.applyforapprovalstatus = applyforapprovalstatus;
		this.applyforrecipient = applyforrecipient;
		this.applyforusingtheitem = applyforusingtheitem;
		this.law = law;
	}

	@Override
	public String toString() {
		return "YongYin [id=" + id + ", caselawid=" + caselawid + ", applyforreceive=" + applyforreceive
				+ ", applyforapprovalstatus=" + applyforapprovalstatus + ", applyforrecipient=" + applyforrecipient
				+ ", applyforusingtheitem=" + applyforusingtheitem + ", law=" + law + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCaselawid() {
		return caselawid;
	}

	public void setCaselawid(Integer caselawid) {
		this.caselawid = caselawid;
	}

	public String getApplyforreceive() {
		return applyforreceive;
	}

	public void setApplyforreceive(String applyforreceive) {
		this.applyforreceive = applyforreceive;
	}

	public String getApplyforapprovalstatus() {
		return applyforapprovalstatus;
	}

	public void setApplyforapprovalstatus(String applyforapprovalstatus) {
		this.applyforapprovalstatus = applyforapprovalstatus;
	}

	public String getApplyforrecipient() {
		return applyforrecipient;
	}

	public void setApplyforrecipient(String applyforrecipient) {
		this.applyforrecipient = applyforrecipient;
	}

	public String getApplyforusingtheitem() {
		return applyforusingtheitem;
	}

	public void setApplyforusingtheitem(String applyforusingtheitem) {
		this.applyforusingtheitem = applyforusingtheitem;
	}

	public Law getLaw() {
		return law;
	}

	public void setLaw(Law law) {
		this.law = law;
	}
	
}
