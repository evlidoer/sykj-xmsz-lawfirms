package com.jt.lawfirm.bean.hr;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

// 员工表
public class HrEmp {
		 @TableId(type=IdType.AUTO)
		 private Integer id;// bigint primary key auto_increment #员工id
		 private String	empName;//			varchar(40) not null	#姓名
		 private String	empPicture;//		varchar(40)			#照片
		 private String	empPhone;//				varchar(40)		#手机号码
		 private String	empSite;//	varchar(100) not null	#联系地址
		 private String	empEntrydate;//			datetime#入职时间
		 private String	empEmail;//		varchar(40)	#邮箱地址
		 private String	empPostcode ;// 		varchar(50)	#邮政编码
		 private String	empQq;//		varchar(40) unique	#QQ账号
		 private String	empWechat;//	varchar(40) unique	#微信账号
		 private String	empContStartdate;//	datetime	#合同开始时间
		 private String	empContEnddate;//	datetime		#合同结束时间
		 private String	empWorkstatus;//	enum('Y','N') DEFAULT 'N'#在职状态 Y(在职) (离职)
		 private String	empSocialNum;//		varchar(40)	#社保号码turnovertime Datetime,				#更新时间
		 private String	empStatus;//		varchar(10)			#状态
		 private String	empSex;//#性别	M(男) F(女)enum('M','F') DEFAULT 'M'
		 private String	empBirthdate;//	datetime		#出生日期
		 private String	empPaperstype;//	 varchar(20)		#证件类型
		 private String	empPapersnum;//	varchar(40)		#证件号
		 private String	empMaritalsta;//		varchar(10)	#婚姻状态
		 private String	empEntrancenum;//	varchar(30)	#门禁号
		 private String	empPracnum;//		varchar(40)	#执业号码
		 private String	empPracdate;//	datetime		#首次执业时间
		 private String	empPracsite;//		 varchar(40)	#首次执业地址
		 private String	empCertifynum;//		varchar(30)	#资格证号码
		 private String	empGainway;//  enum('check','exam','rests') DEFAULT 'exam' #资格证取得方式exam（考试） check（考核）'rests'（其他）
		 private String	empGainsite;//	varchar(40)		#资格证取得地址
		 private String	empIntroduce;//	varchar(100)		#个人介绍
		 private String hrCertifyId;//	varchar(30)		#资格证类别
		 private String hrPractiseId;//	varchar(30)		#执业类别
		 private String hrSpecialtyId;//	varchar(30)		#专业部
		 private String hrNationId;//	bigint not null		#外键,民族id (民族表)
		 private String hrPoliticalId;// 	varchar(30)		#政治面貌
		 private String hrInternalId;//内部身份
		 private String empEducation;//最高学历
		 private String empAcademic;//最高学位
		 private String empGoodfield;//擅长领域
		 public HrEmp() {
			super();
		 }
		 
		@Override
		public String toString() {
			return "HrEmp [id=" + id + ", empName=" + empName + ", empPicture=" + empPicture + ", empPhone=" + empPhone
					+ ", empSite=" + empSite + ", empEntrydate=" + empEntrydate + ", empEmail=" + empEmail
					+ ", empPostcode=" + empPostcode + ", empQq=" + empQq + ", empWechat=" + empWechat
					+ ", empContStartdate=" + empContStartdate + ", empContEnddate=" + empContEnddate
					+ ", empWorkstatus=" + empWorkstatus + ", empSocialNum=" + empSocialNum + ", empStatus=" + empStatus
					+ ", empSex=" + empSex + ", empBirthdate=" + empBirthdate + ", empPaperstype=" + empPaperstype
					+ ", empPapersnum=" + empPapersnum + ", empMaritalsta=" + empMaritalsta + ", empEntrancenum="
					+ empEntrancenum + ", empPracnum=" + empPracnum + ", empPracdate=" + empPracdate + ", empPracsite="
					+ empPracsite + ", empCertifynum=" + empCertifynum + ", empGainway=" + empGainway + ", empGainsite="
					+ empGainsite + ", empIntroduce=" + empIntroduce + ", hrCertifyId=" + hrCertifyId
					+ ", hrPractiseId=" + hrPractiseId + ", hrSpecialtyId=" + hrSpecialtyId + ", hrNationId="
					+ hrNationId + ", hrPoliticalId=" + hrPoliticalId + ", hrInternalId=" + hrInternalId
					+ ", empEducation=" + empEducation + ", empAcademic=" + empAcademic + ", empGoodfield="
					+ empGoodfield + "]";
		}

		public HrEmp(Integer id, String empName, String empPicture, String empPhone, String empSite,
				String empEntrydate, String empEmail, String empPostcode, String empQq, String empWechat,
				String empContStartdate, String empContEnddate, String empWorkstatus, String empSocialNum,
				String empStatus, String empSex, String empBirthdate, String empPaperstype, String empPapersnum,
				String empMaritalsta, String empEntrancenum, String empPracnum, String empPracdate, String empPracsite,
				String empCertifynum, String empGainway, String empGainsite, String empIntroduce, String hrCertifyId,
				String hrPractiseId, String hrSpecialtyId, String hrNationId, String hrPoliticalId, String hrInternalId,
				String empEducation, String empAcademic, String empGoodfield) {
			super();
			this.id = id;
			this.empName = empName;
			this.empPicture = empPicture;
			this.empPhone = empPhone;
			this.empSite = empSite;
			this.empEntrydate = empEntrydate;
			this.empEmail = empEmail;
			this.empPostcode = empPostcode;
			this.empQq = empQq;
			this.empWechat = empWechat;
			this.empContStartdate = empContStartdate;
			this.empContEnddate = empContEnddate;
			this.empWorkstatus = empWorkstatus;
			this.empSocialNum = empSocialNum;
			this.empStatus = empStatus;
			this.empSex = empSex;
			this.empBirthdate = empBirthdate;
			this.empPaperstype = empPaperstype;
			this.empPapersnum = empPapersnum;
			this.empMaritalsta = empMaritalsta;
			this.empEntrancenum = empEntrancenum;
			this.empPracnum = empPracnum;
			this.empPracdate = empPracdate;
			this.empPracsite = empPracsite;
			this.empCertifynum = empCertifynum;
			this.empGainway = empGainway;
			this.empGainsite = empGainsite;
			this.empIntroduce = empIntroduce;
			this.hrCertifyId = hrCertifyId;
			this.hrPractiseId = hrPractiseId;
			this.hrSpecialtyId = hrSpecialtyId;
			this.hrNationId = hrNationId;
			this.hrPoliticalId = hrPoliticalId;
			this.hrInternalId = hrInternalId;
			this.empEducation = empEducation;
			this.empAcademic = empAcademic;
			this.empGoodfield = empGoodfield;
		}

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public String getEmpPicture() {
			return empPicture;
		}
		public void setEmpPicture(String empPicture) {
			this.empPicture = empPicture;
		}
		public String getEmpPhone() {
			return empPhone;
		}
		public void setEmpPhone(String empPhone) {
			this.empPhone = empPhone;
		}
		public String getEmpSite() {
			return empSite;
		}
		public void setEmpSite(String empSite) {
			this.empSite = empSite;
		}
		public String getEmpEntrydate() {
			return empEntrydate;
		}
		public void setEmpEntrydate(String empEntrydate) {
			this.empEntrydate = empEntrydate;
		}
		public String getEmpEmail() {
			return empEmail;
		}
		public void setEmpEmail(String empEmail) {
			this.empEmail = empEmail;
		}
		public String getEmpPostcode() {
			return empPostcode;
		}
		public void setEmpPostcode(String empPostcode) {
			this.empPostcode = empPostcode;
		}
		public String getEmpQq() {
			return empQq;
		}
		public void setEmpQq(String empQq) {
			if (empQq.trim().equals("")) {
				empQq = null;
			}
			this.empQq = empQq;
		}
		public String getEmpWechat() {
			return empWechat;
		}
		public void setEmpWechat(String empWechat) {
			if (empWechat.trim().equals("")) {
				empWechat = null;
			}
			this.empWechat = empWechat;
		}
		public String getEmpContStartdate() {
			return empContStartdate;
		}
		public void setEmpContStartdate(String empContStartdate) {
			this.empContStartdate = empContStartdate;
		}
		public String getEmpContEnddate() {
			return empContEnddate;
		}
		public void setEmpContEnddate(String empContEnddate) {
			this.empContEnddate = empContEnddate;
		}
		public String getEmpWorkstatus() {
			return empWorkstatus;
		}
		public void setEmpWorkstatus(String empWorkstatus) {
			this.empWorkstatus = empWorkstatus;
		}
		public String getEmpSocialNum() {
			return empSocialNum;
		}
		public void setEmpSocialNum(String empSocialNum) {
			this.empSocialNum = empSocialNum;
		}
		public String getEmpStatus() {
			return empStatus;
		}
		public void setEmpStatus(String empStatus) {
			this.empStatus = empStatus;
		}
		public String getEmpSex() {
			return empSex;
		}
		public void setEmpSex(String empSex) {
			this.empSex = empSex;
		}
		public String getEmpBirthdate() {
			return empBirthdate;
		}
		public void setEmpBirthdate(String empBirthdate) {
			this.empBirthdate = empBirthdate;
		}
		public String getEmpPaperstype() {
			return empPaperstype;
		}
		public void setEmpPaperstype(String empPaperstype) {
			this.empPaperstype = empPaperstype;
		}
		public String getEmpPapersnum() {
			return empPapersnum;
		}
		public void setEmpPapersnum(String empPapersnum) {
			this.empPapersnum = empPapersnum;
		}
		public String getEmpMaritalsta() {
			return empMaritalsta;
		}
		public void setEmpMaritalsta(String empMaritalsta) {
			this.empMaritalsta = empMaritalsta;
		}
		public String getEmpEntrancenum() {
			return empEntrancenum;
		}
		public void setEmpEntrancenum(String empEntrancenum) {
			this.empEntrancenum = empEntrancenum;
		}
		public String getEmpPracnum() {
			return empPracnum;
		}
		public void setEmpPracnum(String empPracnum) {
			this.empPracnum = empPracnum;
		}
		public String getEmpPracdate() {
			return empPracdate;
		}
		public void setEmpPracdate(String empPracdate) {
			if (empPracdate.trim().equals("")) {
				empPracdate=null;
			}
			this.empPracdate = empPracdate;
		}
		public String getEmpPracsite() {
			return empPracsite;
		}
		public void setEmpPracsite(String empPracsite) {
			this.empPracsite = empPracsite;
		}
		public String getEmpCertifynum() {
			return empCertifynum;
		}
		public void setEmpCertifynum(String empCertifynum) {
			this.empCertifynum = empCertifynum;
		}
		public String getEmpGainway() {
			return empGainway;
		}
		public void setEmpGainway(String empGainway) {
			this.empGainway = empGainway;
		}
		public String getEmpGainsite() {
			return empGainsite;
		}
		public void setEmpGainsite(String empGainsite) {
			this.empGainsite = empGainsite;
		}
		public String getEmpIntroduce() {
			return empIntroduce;
		}
		public void setEmpIntroduce(String empIntroduce) {
			this.empIntroduce = empIntroduce;
		}
		public String getHrCertifyId() {
			return hrCertifyId;
		}
		public void setHrCertifyId(String hrCertifyId) {
			this.hrCertifyId = hrCertifyId;
		}
		public String getHrPractiseId() {
			return hrPractiseId;
		}
		public void setHrPractiseId(String hrPractiseId) {
			this.hrPractiseId = hrPractiseId;
		}
		public String getHrSpecialtyId() {
			return hrSpecialtyId;
		}
		public void setHrSpecialtyId(String hrSpecialtyId) {
			this.hrSpecialtyId = hrSpecialtyId;
		}
		
		public String getHrNationId() {
			return hrNationId;
		}

		public void setHrNationId(String hrNationId) {
			this.hrNationId = hrNationId;
		}

		public String getHrPoliticalId() {
			return hrPoliticalId;
		}
		public void setHrPoliticalId(String hrPoliticalId) {
			this.hrPoliticalId = hrPoliticalId;
		}
		public String getHrInternalId() {
			return hrInternalId;
		}
		public void setHrInternalId(String hrInternalId) {
			this.hrInternalId = hrInternalId;
		}
		public String getEmpEducation() {
			return empEducation;
		}
		public void setEmpEducation(String empEducation) {
			this.empEducation = empEducation;
		}
		public String getEmpAcademic() {
			return empAcademic;
		}
		public void setEmpAcademic(String empAcademic) {
			this.empAcademic = empAcademic;
		}
		public String getEmpGoodfield() {
			return empGoodfield;
		}
		public void setEmpGoodfield(String empGoodfield) {
			this.empGoodfield = empGoodfield;
		}
		 
		
}
