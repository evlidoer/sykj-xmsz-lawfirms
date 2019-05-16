package com.jt.lawfirm.bean.hr;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

//-- 律师身份-员工（中间表）
public class HrIdent {
	@TableId(type=IdType.AUTO)
	private Integer id;// bigint primary key auto_increment,	#中间表id
	private Integer lawyerIdentity_id;// bigint not null,		#外键，身份ID
	private Integer hrEmpId;// bigint not null				#外键，员工表id
	@TableField(exist=false)
	private  String identityName;
	@TableField(exist=false)
	private  String empName;
	@TableField(exist=false)
	private  String empPhone;
	@TableField(exist=false)
	private  String empEntrydate;
	@TableField(exist=false)
	private  String empContEnddate;
	@TableField(exist=false)
	private  String empWorkstatus;
	@TableField(exist=false)
	private  String empSocialNum;
	@TableField(exist=false)
	private  String empStatus;
	public HrIdent() {
		super();
	}
	public HrIdent(Integer id, Integer lawyerIdentity_id, Integer hrEmpId, String identityName, String empName,
			String empPhone, String empEntrydate, String empContEnddate, String empWorkstatus, String empSocialNum,
			String empStatus) {
		super();
		this.id = id;
		this.lawyerIdentity_id = lawyerIdentity_id;
		this.hrEmpId = hrEmpId;
		this.identityName = identityName;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empEntrydate = empEntrydate;
		this.empContEnddate = empContEnddate;
		this.empWorkstatus = empWorkstatus;
		this.empSocialNum = empSocialNum;
		this.empStatus = empStatus;
	}
	@Override
	public String toString() {
		return "HrIdent [id=" + id + ", lawyerIdentity_id=" + lawyerIdentity_id + ", hrEmpId=" + hrEmpId
				+ ", identityName=" + identityName + ", empName=" + empName + ", empPhone=" + empPhone
				+ ", empEntrydate=" + empEntrydate + ", empContEnddate=" + empContEnddate + ", empWorkstatus="
				+ empWorkstatus + ", empSocialNum=" + empSocialNum + ", empStatus=" + empStatus + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLawyerIdentity_id() {
		return lawyerIdentity_id;
	}
	public void setLawyerIdentity_id(Integer lawyerIdentity_id) {
		this.lawyerIdentity_id = lawyerIdentity_id;
	}
	public Integer getHrEmpId() {
		return hrEmpId;
	}
	public void setHrEmpId(Integer hrEmpId) {
		this.hrEmpId = hrEmpId;
	}
	public String getIdentityName() {
		return identityName;
	}
	public void setIdentityName(String identityName) {
		this.identityName = identityName;
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
	public String getEmpEntrydate() {
		return empEntrydate;
	}
	public void setEmpEntrydate(String empEntrydate) {
		this.empEntrydate = empEntrydate;
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
	
}
