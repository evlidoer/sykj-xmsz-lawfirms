package com.jt.lawfirm.bean.hr;

//-- 参保-员工（中间表）
public class HrEmpInsured {
	private Integer id;// bigint primary key auto_increment,
	private Integer hrEmpId;// bigint not null,						#外键，员工id
	private Integer hrInsuredId;// bigint not null					#外键，参保id
	private HrEmp emp;
	private HrInsured insured;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHrEmpId() {
		return hrEmpId;
	}
	public void setHrEmpId(Integer hrEmpId) {
		this.hrEmpId = hrEmpId;
	}
	public Integer getHrInsuredId() {
		return hrInsuredId;
	}
	public void setHrInsuredId(Integer hrInsuredId) {
		this.hrInsuredId = hrInsuredId;
	}
	public HrEmp getEmp() {
		return emp;
	}
	public void setEmp(HrEmp emp) {
		this.emp = emp;
	}
	public HrInsured getInsured() {
		return insured;
	}
	public void setInsured(HrInsured insured) {
		this.insured = insured;
	}
	@Override
	public String toString() {
		return "EmpInsured [id=" + id + ", hrEmpId=" + hrEmpId + ", hrInsuredId=" + hrInsuredId + ", emp=" + emp
				+ ", insured=" + insured + "]";
	}
	public HrEmpInsured(Integer id, Integer hrEmpId, Integer hrInsuredId, HrEmp emp, HrInsured insured) {
		super();
		this.id = id;
		this.hrEmpId = hrEmpId;
		this.hrInsuredId = hrInsuredId;
		this.emp = emp;
		this.insured = insured;
	}
	public HrEmpInsured() {
		super();
		// TODO Auto-generated constructor stub
	}

}
