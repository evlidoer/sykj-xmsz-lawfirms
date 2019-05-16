package com.jt.lawfirm.bean.anjian;
/**
 * 		开庭表
 * @author 李阳
 *
 */

import com.jt.lawfirm.bean.casea.Law;

public class CasecHoldAHearing {
/*		id bigint unsigned primary key auto_increment,
		case_law_id varchar(50),-- 案件id
		hearing_consignor varchar(50),-- 委托人
		hearing_approval_procedure varchar(50),-- 审批程序
		hearing_accreditation_time date,-- 立案日期
		hearing_hold_a_cout_time date,-- 开庭日期
		hearing_acquit_time date,-- 宣判日期
		hearing_appeal_time date,-- 上诉日期
		hearing_office varchar(50),-- 审批籍贯
		hearing_court varchar(50),-- 法庭
		hearing_hold_a_cout_status varchar(10) check (hold_a_cout_status in('已开庭','未开庭')),-- 开庭状态
		hearing_jude varchar(50),-- 主审法官
		hearing_judge_tel varchar(20),-- 主审法官联系电话
		hearing_court_clerk varchar(50),-- 书记员
		hearing_court_clerk_tel varchar(50),-- 书记员电话
		hearing_remark varchar(500) -- 备注*/
		private Integer id;// 
		private int caselawid;//-- 外键 案件id
		//private Integer client_id;//客户
		private String hearingconsignor; //-- 委托人
		private String hearingapprovalprocedure;//-- 审批程序
		private String hearingaccreditationtime; //-- 立案日期
		private String hearingholdacouttime; //-- 开庭日期
		private String hearingacquittime;// ,-- 宣判日期
		private String hearingappealtime;// ,-- 上诉日期
		private String hearingoffice;// -- 审判机关
		private String hearingcourt;// -- 法庭
		private String hearingholdacoutstatus;// varchar(10) check (holdacoutstatus in('已开庭','未开庭')),-- 开庭状态
		private String hearingjude;// -- 主审法官
		private String hearingjudgetel;// -- 主审法官联系电话
		private String hearingcourtclerk; //-- 书记员
		private String hearingcourtclerktel;//  书记员电话
		private String hearingremark;// -- 备注
		
		private Law law;

		public CasecHoldAHearing() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CasecHoldAHearing(Integer id, int caselawid, String hearingconsignor, String hearingapprovalprocedure,
				String hearingaccreditationtime, String hearingholdacouttime, String hearingacquittime,
				String hearingappealtime, String hearingoffice, String hearingcourt, String hearingholdacoutstatus,
				String hearingjude, String hearingjudgetel, String hearingcourtclerk, String hearingcourtclerktel,
				String hearingremark, Law law) {
			super();
			this.id = id;
			this.caselawid = caselawid;
			this.hearingconsignor = hearingconsignor;
			this.hearingapprovalprocedure = hearingapprovalprocedure;
			this.hearingaccreditationtime = hearingaccreditationtime;
			this.hearingholdacouttime = hearingholdacouttime;
			this.hearingacquittime = hearingacquittime;
			this.hearingappealtime = hearingappealtime;
			this.hearingoffice = hearingoffice;
			this.hearingcourt = hearingcourt;
			this.hearingholdacoutstatus = hearingholdacoutstatus;
			this.hearingjude = hearingjude;
			this.hearingjudgetel = hearingjudgetel;
			this.hearingcourtclerk = hearingcourtclerk;
			this.hearingcourtclerktel = hearingcourtclerktel;
			this.hearingremark = hearingremark;
			this.law = law;
		}

		@Override
		public String toString() {
			return "CasecHoldAHearing [id=" + id + ", caselawid=" + caselawid + ", hearingconsignor=" + hearingconsignor
					+ ", hearingapprovalprocedure=" + hearingapprovalprocedure + ", hearingaccreditationtime="
					+ hearingaccreditationtime + ", hearingholdacouttime=" + hearingholdacouttime
					+ ", hearingacquittime=" + hearingacquittime + ", hearingappealtime=" + hearingappealtime
					+ ", hearingoffice=" + hearingoffice + ", hearingcourt=" + hearingcourt
					+ ", hearingholdacoutstatus=" + hearingholdacoutstatus + ", hearingjude=" + hearingjude
					+ ", hearingjudgetel=" + hearingjudgetel + ", hearingcourtclerk=" + hearingcourtclerk
					+ ", hearingcourtclerktel=" + hearingcourtclerktel + ", hearingremark=" + hearingremark + ", law="
					+ law + "]";
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public int getCaselawid() {
			return caselawid;
		}

		public void setCaselawid(int caselawid) {
			this.caselawid = caselawid;
		}

		public String getHearingconsignor() {
			return hearingconsignor;
		}

		public void setHearingconsignor(String hearingconsignor) {
			this.hearingconsignor = hearingconsignor;
		}

		public String getHearingapprovalprocedure() {
			return hearingapprovalprocedure;
		}

		public void setHearingapprovalprocedure(String hearingapprovalprocedure) {
			this.hearingapprovalprocedure = hearingapprovalprocedure;
		}

		public String getHearingaccreditationtime() {
			return hearingaccreditationtime;
		}

		public void setHearingaccreditationtime(String hearingaccreditationtime) {
			this.hearingaccreditationtime = hearingaccreditationtime;
		}

		public String getHearingholdacouttime() {
			return hearingholdacouttime;
		}

		public void setHearingholdacouttime(String hearingholdacouttime) {
			this.hearingholdacouttime = hearingholdacouttime;
		}

		public String getHearingacquittime() {
			return hearingacquittime;
		}

		public void setHearingacquittime(String hearingacquittime) {
			this.hearingacquittime = hearingacquittime;
		}

		public String getHearingappealtime() {
			return hearingappealtime;
		}

		public void setHearingappealtime(String hearingappealtime) {
			this.hearingappealtime = hearingappealtime;
		}

		public String getHearingoffice() {
			return hearingoffice;
		}

		public void setHearingoffice(String hearingoffice) {
			this.hearingoffice = hearingoffice;
		}

		public String getHearingcourt() {
			return hearingcourt;
		}

		public void setHearingcourt(String hearingcourt) {
			this.hearingcourt = hearingcourt;
		}

		public String getHearingholdacoutstatus() {
			return hearingholdacoutstatus;
		}

		public void setHearingholdacoutstatus(String hearingholdacoutstatus) {
			this.hearingholdacoutstatus = hearingholdacoutstatus;
		}

		public String getHearingjude() {
			return hearingjude;
		}

		public void setHearingjude(String hearingjude) {
			this.hearingjude = hearingjude;
		}

		public String getHearingjudgetel() {
			return hearingjudgetel;
		}

		public void setHearingjudgetel(String hearingjudgetel) {
			this.hearingjudgetel = hearingjudgetel;
		}

		public String getHearingcourtclerk() {
			return hearingcourtclerk;
		}

		public void setHearingcourtclerk(String hearingcourtclerk) {
			this.hearingcourtclerk = hearingcourtclerk;
		}

		public String getHearingcourtclerktel() {
			return hearingcourtclerktel;
		}

		public void setHearingcourtclerktel(String hearingcourtclerktel) {
			this.hearingcourtclerktel = hearingcourtclerktel;
		}

		public String getHearingremark() {
			return hearingremark;
		}

		public void setHearingremark(String hearingremark) {
			this.hearingremark = hearingremark;
		}

		public Law getLaw() {
			return law;
		}

		public void setLaw(Law law) {
			this.law = law;
		}

}
