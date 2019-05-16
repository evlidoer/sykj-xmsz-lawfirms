package com.jt.lawfirm.bean.anjian;

import com.jt.lawfirm.bean.casea.Law;

/**
 *	案件费用减免记录  biao
 * @author 李阳
 *
 */
public class Feiyong {
	
//	id bigint unsigned primary key auto_increment,
//	case_law_id varchar(50),-- 案件id
//		relief_proposer varchar(50),-- 申请人
//		relief_credit_amount decimal(10,2),-- 减免金额
//			relief_application_date date,-- 申请日期
//			relief_for varchar(50),-- 减免事由
//			relief_application_for_exemption int unsigned,-- 减免申请单(文件id)
//			relief_approval_status varchar(50)
	
			private Integer id;
			private Integer case_law_id;//-- 案件id
			private String relief_proposer;//-- 申请人
			private Double relief_credit_amount;//-- 减免金额
			private String relief_application_date;//-- 申请日期
			private String relief_for;//-- 减免事由
			private String relief_application_for_exemption;//-- 减免申请单(文件id)
			private String relief_approval_status; //审核状态
			
			private Law law;

			public Feiyong() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Feiyong(Integer id, Integer case_law_id, String relief_proposer, Double relief_credit_amount,
					String relief_application_date, String relief_for, String relief_application_for_exemption,
					String relief_approval_status, Law law) {
				super();
				this.id = id;
				this.case_law_id = case_law_id;
				this.relief_proposer = relief_proposer;
				this.relief_credit_amount = relief_credit_amount;
				this.relief_application_date = relief_application_date;
				this.relief_for = relief_for;
				this.relief_application_for_exemption = relief_application_for_exemption;
				this.relief_approval_status = relief_approval_status;
				this.law = law;
			}

			@Override
			public String toString() {
				return "Feiyong [id=" + id + ", case_law_id=" + case_law_id + ", relief_proposer=" + relief_proposer
						+ ", relief_credit_amount=" + relief_credit_amount + ", relief_application_date="
						+ relief_application_date + ", relief_for=" + relief_for + ", relief_application_for_exemption="
						+ relief_application_for_exemption + ", relief_approval_status=" + relief_approval_status
						+ ", law=" + law + "]";
			}

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public Integer getCase_law_id() {
				return case_law_id;
			}

			public void setCase_law_id(Integer case_law_id) {
				this.case_law_id = case_law_id;
			}

			public String getRelief_proposer() {
				return relief_proposer;
			}

			public void setRelief_proposer(String relief_proposer) {
				this.relief_proposer = relief_proposer;
			}

			public Double getRelief_credit_amount() {
				return relief_credit_amount;
			}

			public void setRelief_credit_amount(Double relief_credit_amount) {
				this.relief_credit_amount = relief_credit_amount;
			}

			public String getRelief_application_date() {
				return relief_application_date;
			}

			public void setRelief_application_date(String relief_application_date) {
				this.relief_application_date = relief_application_date;
			}

			public String getRelief_for() {
				return relief_for;
			}

			public void setRelief_for(String relief_for) {
				this.relief_for = relief_for;
			}

			public String getRelief_application_for_exemption() {
				return relief_application_for_exemption;
			}

			public void setRelief_application_for_exemption(String relief_application_for_exemption) {
				this.relief_application_for_exemption = relief_application_for_exemption;
			}

			public String getRelief_approval_status() {
				return relief_approval_status;
			}

			public void setRelief_approval_status(String relief_approval_status) {
				this.relief_approval_status = relief_approval_status;
			}

			public Law getLaw() {
				return law;
			}

			public void setLaw(Law law) {
				this.law = law;
			}
			
			
}
