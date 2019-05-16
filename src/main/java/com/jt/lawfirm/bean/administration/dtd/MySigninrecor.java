package com.jt.lawfirm.bean.administration.dtd;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jt.lawfirm.bean.hr.HrEmp;

@TableName(value = "adm_signinrecor")
public class MySigninrecor {
	private int id;
	private int   hrEmpId;
	private String  classifyId;
	private String   signinrecordEtime;
	private String   signinrecordStime;
	private String   signinrecordSite;
	private String 	admSigninrecorStatis;
	private String ename;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	private HrEmp emp;
	public MySigninrecor() {}
	public MySigninrecor(int id, int hrEmpId, String classifyId, String signinrecordEtime, String signinrecordStime,
			String signinrecordSite, String admSigninrecorStatis, HrEmp emp) {
		super();
		this.id = id;
		this.hrEmpId = hrEmpId;
		this.classifyId = classifyId;
		this.signinrecordEtime = signinrecordEtime;
		this.signinrecordStime = signinrecordStime;
		this.signinrecordSite = signinrecordSite;
		this.admSigninrecorStatis = admSigninrecorStatis;
		this.emp = emp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHrEmpId() {
		return hrEmpId;
	}
	public void setHrEmpId(int hrEmpId) {
		this.hrEmpId = hrEmpId;
	}
	public String getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}
	public String getSigninrecordEtime() {
		return signinrecordEtime;
	}
	public void setSigninrecordEtime(String signinrecordEtime) {
		this.signinrecordEtime = signinrecordEtime;
	}
	public String getSigninrecordStime() {
		return signinrecordStime;
	}
	public void setSigninrecordStime(String signinrecordStime) {
		this.signinrecordStime = signinrecordStime;
	}
	public String getSigninrecordSite() {
		return signinrecordSite;
	}
	public void setSigninrecordSite(String signinrecordSite) {
		this.signinrecordSite = signinrecordSite;
	}
	public String getAdmSigninrecorStatis() {
		return admSigninrecorStatis;
	}
	public void setAdmSigninrecorStatis(String admSigninrecorStatis) {
		this.admSigninrecorStatis = admSigninrecorStatis.equals("Y") ? "√(签到)" : "×(签退)";

	}
	public HrEmp getEmp() {
		return emp;
	}
	public void setEmp(HrEmp emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "Signinrecor [id=" + id + ", hrEmpId=" + hrEmpId + ", classifyId=" + classifyId + ", signinrecordEtime="
				+ signinrecordEtime + ", signinrecordStime=" + signinrecordStime + ", signinrecordSite="
				+ signinrecordSite + ", admSigninrecorStatis=" + admSigninrecorStatis + ", emp=" + emp + "]";
	}
}
