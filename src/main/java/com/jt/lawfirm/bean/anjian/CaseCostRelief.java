package com.jt.lawfirm.bean.anjian;

import com.jt.lawfirm.bean.casea.Law;

/**
 * 			费用减免记录表  
 * @author 李阳
 */
public class CaseCostRelief {
		private	Integer id;
		private String caselawid; //-- 案件id
		private	String	reliefproposer;// -- 申请人
		private	Double	reliefcreditamount; //-- 减免金额
		private	String	reliefapplicationdate; //- 申请日期
		private	String	relieffor; //,-- 减免事由
		private	Integer	reliefapplication_forexemption; //-- 减免申请单(文件id)
		private	String	reliefapprovalstatus;
		
		private Law law;

		public CaseCostRelief() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CaseCostRelief(Integer id, String caselawid, String reliefproposer, Double reliefcreditamount,
				String reliefapplicationdate, String relieffor, Integer reliefapplication_forexemption,
				String reliefapprovalstatus, Law law) {
			super();
			this.id = id;
			this.caselawid = caselawid;
			this.reliefproposer = reliefproposer;
			this.reliefcreditamount = reliefcreditamount;
			this.reliefapplicationdate = reliefapplicationdate;
			this.relieffor = relieffor;
			this.reliefapplication_forexemption = reliefapplication_forexemption;
			this.reliefapprovalstatus = reliefapprovalstatus;
			this.law = law;
		}

		@Override
		public String toString() {
			return "CaseCostRelief [id=" + id + ", caselawid=" + caselawid + ", reliefproposer=" + reliefproposer
					+ ", reliefcreditamount=" + reliefcreditamount + ", reliefapplicationdate=" + reliefapplicationdate
					+ ", relieffor=" + relieffor + ", reliefapplication_forexemption=" + reliefapplication_forexemption
					+ ", reliefapprovalstatus=" + reliefapprovalstatus + ", law=" + law + "]";
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getCaselawid() {
			return caselawid;
		}

		public void setCaselawid(String caselawid) {
			this.caselawid = caselawid;
		}

		public String getReliefproposer() {
			return reliefproposer;
		}

		public void setReliefproposer(String reliefproposer) {
			this.reliefproposer = reliefproposer;
		}

		public Double getReliefcreditamount() {
			return reliefcreditamount;
		}

		public void setReliefcreditamount(Double reliefcreditamount) {
			this.reliefcreditamount = reliefcreditamount;
		}

		public String getReliefapplicationdate() {
			return reliefapplicationdate;
		}

		public void setReliefapplicationdate(String reliefapplicationdate) {
			this.reliefapplicationdate = reliefapplicationdate;
		}

		public String getRelieffor() {
			return relieffor;
		}

		public void setRelieffor(String relieffor) {
			this.relieffor = relieffor;
		}

		public Integer getReliefapplication_forexemption() {
			return reliefapplication_forexemption;
		}

		public void setReliefapplication_forexemption(Integer reliefapplication_forexemption) {
			this.reliefapplication_forexemption = reliefapplication_forexemption;
		}

		public String getReliefapprovalstatus() {
			return reliefapprovalstatus;
		}

		public void setReliefapprovalstatus(String reliefapprovalstatus) {
			this.reliefapprovalstatus = reliefapprovalstatus;
		}

		public Law getLaw() {
			return law;
		}

		public void setLaw(Law law) {
			this.law = law;
		}
		
}
