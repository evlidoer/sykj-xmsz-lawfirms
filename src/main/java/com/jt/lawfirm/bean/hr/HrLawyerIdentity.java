package com.jt.lawfirm.bean.hr;
//-- 律师身份表
public class HrLawyerIdentity {
	private Integer id;// bigint primary key auto_increment,	#身份ID
	private String identityName;// enum('律师','实习','辅助') DEFAULT '律师',	#身份名称
	private String identityType;// varchar(20),				#执业/实习类别
	private String identityStartdate;// date,				#执业/实习开始时间
	private String identityTutor;// varchar(20),				#辅助导师
	private String identityPracsite;// varchar(30),			#首次执业地
	private String identityEnddate;// date,					#执业/实习结束时间
	private String identityNum;// varchar(30)				#执业/实习证号
	public HrLawyerIdentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HrLawyerIdentity(Integer id, String identityName, String identityType, String identityStartdate,
			String identityTutor, String identityPracsite, String identityEnddate, String identityNum) {
		super();
		this.id = id;
		this.identityName = identityName;
		this.identityType = identityType;
		this.identityStartdate = identityStartdate;
		this.identityTutor = identityTutor;
		this.identityPracsite = identityPracsite;
		this.identityEnddate = identityEnddate;
		this.identityNum = identityNum;
	}
	@Override
	public String toString() {
		return "LawyerIdentity [id=" + id + ", identityName=" + identityName + ", identityType=" + identityType
				+ ", identityStartdate=" + identityStartdate + ", identityTutor=" + identityTutor
				+ ", identityPracsite=" + identityPracsite + ", identityEnddate=" + identityEnddate + ", identityNum="
				+ identityNum + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdentityName() {
		return identityName;
	}
	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}
	public String getIdentityType() {
		return identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getIdentityStartdate() {
		return identityStartdate;
	}
	public void setIdentityStartdate(String identityStartdate) {
		this.identityStartdate = identityStartdate;
	}
	public String getIdentityTutor() {
		return identityTutor;
	}
	public void setIdentityTutor(String identityTutor) {
		this.identityTutor = identityTutor;
	}
	public String getIdentityPracsite() {
		return identityPracsite;
	}
	public void setIdentityPracsite(String identityPracsite) {
		this.identityPracsite = identityPracsite;
	}
	public String getIdentityEnddate() {
		return identityEnddate;
	}
	public void setIdentityEnddate(String identityEnddate) {
		this.identityEnddate = identityEnddate;
	}
	public String getIdentityNum() {
		return identityNum;
	}
	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}
	
}
