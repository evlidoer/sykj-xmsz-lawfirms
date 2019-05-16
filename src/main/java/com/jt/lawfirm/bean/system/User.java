package com.jt.lawfirm.bean.system;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jt.lawfirm.bean.hr.HrEmp;

/**
	 * system_user 表
	 */
@TableName("system_user")
public class User {
	  private Integer id; 
	  private String userName;
	  private String userPwd;
	  private String userRealname;
	  private String userPhone;
	  private String userEmail;
	  private String user_Createdate;
	  private String userPre_date;
	  private String userLogin_num;
	  private Integer hrEmpId;
	  private String userStatus;
	  
	  private HrEmp hrEmp;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String userName, String userPwd, String userRealname, String userPhone, String userEmail,
			String user_Createdate, String userPre_date, String userLogin_num, Integer hrEmpId, String userStatus,
			HrEmp hrEmp) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userRealname = userRealname;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.user_Createdate = user_Createdate;
		this.userPre_date = userPre_date;
		this.userLogin_num = userLogin_num;
		this.hrEmpId = hrEmpId;
		this.userStatus = userStatus;
		this.hrEmp = hrEmp;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", userRealname=" + userRealname
				+ ", userPhone=" + userPhone + ", userEmail=" + userEmail + ", user_Createdate=" + user_Createdate
				+ ", userPre_date=" + userPre_date + ", userLogin_num=" + userLogin_num + ", hrEmpId=" + hrEmpId
				+ ", userStatus=" + userStatus + ", hrEmp=" + hrEmp + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserRealname() {
		return userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUser_Createdate() {
		return user_Createdate;
	}

	public void setUser_Createdate(String user_Createdate) {
		this.user_Createdate = user_Createdate;
	}

	public String getUserPre_date() {
		return userPre_date;
	}

	public void setUserPre_date(String userPre_date) {
		this.userPre_date = userPre_date;
	}

	public String getUserLogin_num() {
		return userLogin_num;
	}

	public void setUserLogin_num(String userLogin_num) {
		this.userLogin_num = userLogin_num;
	}

	public Integer getHrEmpId() {
		return hrEmpId;
	}

	public void setHrEmpId(Integer hrEmpId) {
		this.hrEmpId = hrEmpId;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public HrEmp getHrEmp() {
		return hrEmp;
	}

	public void setHrEmp(HrEmp hrEmp) {
		this.hrEmp = hrEmp;
	}
}
