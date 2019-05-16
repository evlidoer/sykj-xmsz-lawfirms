package com.jt.lawfirm.bean.system.mysystembean;

public class MycyBean {
	private String id;
	private  String userName;
	private  String empName;
	private  String empPhone;
	public MycyBean() {
		super();
	}
	@Override
	public String toString() {
		return "MycyBean [id=" + id + ", userName=" + userName + ", empName=" + empName + ", empPhone=" + empPhone
				+ "]";
	}
	public MycyBean(String id, String userName, String empName, String empPhone) {
		super();
		this.id = id;
		this.userName = userName;
		this.empName = empName;
		this.empPhone = empPhone;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	
	
}
