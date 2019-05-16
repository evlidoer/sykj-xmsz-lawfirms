package com.jt.lawfirm.bean.statistics;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 
 * @author theFlyingCat
 *
 */
@TableName("cw_history_statistic")
public class HistoryStatistic {
	@TableId(value="id", type=IdType.AUTO)
	private Integer id;
	private int hrEmpId; //关联员工表
	private String cwBeginDate; //#开始日期
	private String cwEndDate; //#截止日期
	private BigDecimal cwIncomeAll; //#总收入
	private BigDecimal cwExpendAll; //#总支出
	private BigDecimal cwActual; //#实际应提
	
	public HistoryStatistic() {
		// TODO Auto-generated constructor stub
	}

	public HistoryStatistic(Integer id, int hrEmpId, String cwBeginDate, String cwEndDate, BigDecimal cwIncomeAll,
			BigDecimal cwExpendAll, BigDecimal cwActual) {
		super();
		this.id = id;
		this.hrEmpId = hrEmpId;
		this.cwBeginDate = cwBeginDate;
		this.cwEndDate = cwEndDate;
		this.cwIncomeAll = cwIncomeAll;
		this.cwExpendAll = cwExpendAll;
		this.cwActual = cwActual;
	}

	@Override
	public String toString() {
		return "HistoryStatistic [id=" + id + ", hrEmpId=" + hrEmpId + ", cwBeginDate=" + cwBeginDate + ", cwEndDate="
				+ cwEndDate + ", cwIncomeAll=" + cwIncomeAll + ", cwExpendAll=" + cwExpendAll + ", cwActual=" + cwActual
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getHrEmpId() {
		return hrEmpId;
	}

	public void setHrEmpId(int hrEmpId) {
		this.hrEmpId = hrEmpId;
	}

	public String getCwBeginDate() {
		return cwBeginDate;
	}

	public void setCwBeginDate(String cwBeginDate) {
		this.cwBeginDate = cwBeginDate;
	}

	public String getCwEndDate() {
		return cwEndDate;
	}

	public void setCwEndDate(String cwEndDate) {
		this.cwEndDate = cwEndDate;
	}

	public BigDecimal getCwIncomeAll() {
		return cwIncomeAll;
	}

	public void setCwIncomeAll(BigDecimal cwIncomeAll) {
		this.cwIncomeAll = cwIncomeAll;
	}

	public BigDecimal getCwExpendAll() {
		return cwExpendAll;
	}

	public void setCwExpendAll(BigDecimal cwExpendAll) {
		this.cwExpendAll = cwExpendAll;
	}

	public BigDecimal getCwActual() {
		return cwActual;
	}

	public void setCwActual(BigDecimal cwActual) {
		this.cwActual = cwActual;
	}
	
}
