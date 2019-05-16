package com.jt.lawfirm.bean.finance;

import java.math.BigDecimal;
import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 
 * @author theFlyingCat
 *
 */

//收支数据表
@TableName("cw_inout")
public class Inout {
	private Integer id; // 收支数据ID
	private Integer cwInoutTypeId; // '收支类别id',
	private Date cwInoutDate; // '发收日期',
	private String cwInoutPerson; // '收支人',
	private BigDecimal cwInoutMoney; // '收支金额',
	private String cwPayType; // '支付方式',
	private Integer caseLawId; // '案件id',
	private Date cwEnteringdate; // '录入日期',
	private String cwRemark; // '备注',
	private String cwInoutLevel; // '收支级别',
	private String cwPayer; // '付款人'
	
	@TableField(exist=false)
	private String cwInoutTypeName; //'收支类别名称'
	@TableField(exist=false)
	private String caseUmber; //案号
	@TableField(exist=false)
	private String caseParties; //委托人
	@TableField(exist=false)
	private String caseOppositeParties; //对方当事人
	@TableField(exist=false)
	private String caseLawyer; //负责律师
	@TableField(exist=false)
	private String casePlan; //案件状态

	public Inout() {
		// TODO Auto-generated constructor stub
	}
	
	public Inout(Integer cwInoutTypeId, Date cwInoutDate, String cwInoutPerson, BigDecimal cwInoutMoney,
			String cwPayType, Integer caseLawId, Date cwEnteringdate, String cwRemark, String cwInoutLevel,
			String cwPayer) {
		this.cwInoutTypeId = cwInoutTypeId;
		this.cwInoutDate = cwInoutDate;
		this.cwInoutPerson = cwInoutPerson;
		this.cwInoutMoney = cwInoutMoney;
		this.cwPayType = cwPayType;
		this.caseLawId = caseLawId;
		this.cwEnteringdate = cwEnteringdate;
		this.cwRemark = cwRemark;
		this.cwInoutLevel = cwInoutLevel;
		this.cwPayer = cwPayer;
	}

	public Inout(Integer id, Integer cwInoutTypeId, Date cwInoutDate, String cwInoutPerson, BigDecimal cwInoutMoney,
			String cwPayType, Integer caseLawId, Date cwEnteringdate, String cwRemark, String cwInoutLevel,
			String cwPayer) {
		this.id = id;
		this.cwInoutTypeId = cwInoutTypeId;
		this.cwInoutDate = cwInoutDate;
		this.cwInoutPerson = cwInoutPerson;
		this.cwInoutMoney = cwInoutMoney;
		this.cwPayType = cwPayType;
		this.caseLawId = caseLawId;
		this.cwEnteringdate = cwEnteringdate;
		this.cwRemark = cwRemark;
		this.cwInoutLevel = cwInoutLevel;
		this.cwPayer = cwPayer;
	}

	@Override
	public String toString() {
		return "Inout [id=" + id + ", cwInoutTypeId=" + cwInoutTypeId + ", cwInoutDate=" + cwInoutDate
				+ ", cwInoutPerson=" + cwInoutPerson + ", cwInoutMoney=" + cwInoutMoney + ", cwPayType=" + cwPayType
				+ ", caseLawId=" + caseLawId + ", cwEnteringdate=" + cwEnteringdate + ", cwRemark=" + cwRemark
				+ ", cwInoutLevel=" + cwInoutLevel + ", cwPayer=" + cwPayer + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCwInoutTypeId() {
		return cwInoutTypeId;
	}

	public void setCwInoutTypeId(Integer cwInoutTypeId) {
		this.cwInoutTypeId = cwInoutTypeId;
	}

	public Date getCwInoutDate() {
		return cwInoutDate;
	}

	public void setCwInoutDate(Date cwInoutDate) {
		this.cwInoutDate = cwInoutDate;
	}

	public String getCwInoutPerson() {
		return cwInoutPerson;
	}

	public void setCwInoutPerson(String cwInoutPerson) {
		this.cwInoutPerson = cwInoutPerson;
	}

	public BigDecimal getCwInoutMoney() {
		return cwInoutMoney;
	}

	public void setCwInoutMoney(BigDecimal cwInoutMoney) {
		this.cwInoutMoney = cwInoutMoney;
	}

	public String getCwPayType() {
		return cwPayType;
	}

	public void setCwPayType(String cwPayType) {
		this.cwPayType = cwPayType;
	}

	public Integer getCaseLawId() {
		return caseLawId;
	}

	public void setCaseLawId(Integer caseLawId) {
		this.caseLawId = caseLawId;
	}

	public Date getCwEnteringdate() {
		return cwEnteringdate;
	}

	public void setCwEnteringdate(Date cwEnteringdate) {
		this.cwEnteringdate = cwEnteringdate;
	}

	public String getCwRemark() {
		return cwRemark;
	}

	public void setCwRemark(String cwRemark) {
		this.cwRemark = cwRemark;
	}

	public String getCwInoutLevel() {
		return cwInoutLevel;
	}

	public void setCwInoutLevel(String cwInoutLevel) {
		this.cwInoutLevel = cwInoutLevel;
	}

	public String getCwPayer() {
		return cwPayer;
	}

	public void setCwPayer(String cwPayer) {
		this.cwPayer = cwPayer;
	}

	public String getCwInoutTypeName() {
		return cwInoutTypeName;
	}

	public void setCwInoutTypeName(String cwInoutTypeName) {
		this.cwInoutTypeName = cwInoutTypeName;
	}

	public String getCaseUmber() {
		return caseUmber;
	}

	public void setCaseUmber(String caseUmber) {
		this.caseUmber = caseUmber;
	}

	public String getCaseParties() {
		return caseParties;
	}

	public void setCaseParties(String caseParties) {
		this.caseParties = caseParties;
	}

	public String getCaseOppositeParties() {
		return caseOppositeParties;
	}

	public void setCaseOppositeParties(String caseOppositeParties) {
		this.caseOppositeParties = caseOppositeParties;
	}

	public String getCaseLawyer() {
		return caseLawyer;
	}

	public void setCaseLawyer(String caseLawyer) {
		this.caseLawyer = caseLawyer;
	}

	public String getCasePlan() {
		return casePlan;
	}

	public void setCasePlan(String casePlan) {
		this.casePlan = casePlan;
	}
	
}
