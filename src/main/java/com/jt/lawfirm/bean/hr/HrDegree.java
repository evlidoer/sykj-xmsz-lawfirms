package com.jt.lawfirm.bean.hr;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

//-- 学历表
public class HrDegree {
	@TableId(type=IdType.AUTO)
	private Integer	id ;//bigint primary key auto_increment, 				#学历id 
	private String	degreeSchool;// varchar(30),							#毕业学校
	private String	degreeMajor;// varchar(30),							#主修专业
	private String	degreeDegrees;// varchar(30),							#获得学位
	private String	degreeCrednum;// varchar(30),							#证书编号
	private String	degreeFulltime;// enum('Y','N') default 'Y',	#全日制Y（是）N（否）
	private String	degreeSite;// varchar(30),							#所在地
	private Integer	hrEmpId;// bigint not null 							#外键，员工id
	@TableField(exist=false)
	private HrEmp emp;
	public HrDegree() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HrDegree(Integer id, String degreeSchool, String degreeMajor, String degreeDegrees, String degreeCrednum,
			String degreeFulltime, String degreeSite, Integer hrEmpId, HrEmp emp) {
		super();
		this.id = id;
		this.degreeSchool = degreeSchool;
		this.degreeMajor = degreeMajor;
		this.degreeDegrees = degreeDegrees;
		this.degreeCrednum = degreeCrednum;
		this.degreeFulltime = degreeFulltime;
		this.degreeSite = degreeSite;
		this.hrEmpId = hrEmpId;
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "HrDegree [id=" + id + ", degreeSchool=" + degreeSchool + ", degreeMajor=" + degreeMajor
				+ ", degreeDegrees=" + degreeDegrees + ", degreeCrednum=" + degreeCrednum + ", degreeFulltime="
				+ degreeFulltime + ", degreeSite=" + degreeSite + ", hrEmpId=" + hrEmpId + ", emp=" + emp + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDegreeSchool() {
		return degreeSchool;
	}
	public void setDegreeSchool(String degreeSchool) {
		this.degreeSchool = degreeSchool;
	}
	public String getDegreeMajor() {
		return degreeMajor;
	}
	public void setDegreeMajor(String degreeMajor) {
		this.degreeMajor = degreeMajor;
	}
	public String getDegreeDegrees() {
		return degreeDegrees;
	}
	public void setDegreeDegrees(String degreeDegrees) {
		this.degreeDegrees = degreeDegrees;
	}
	public String getDegreeCrednum() {
		return degreeCrednum;
	}
	public void setDegreeCrednum(String degreeCrednum) {
		this.degreeCrednum = degreeCrednum;
	}
	public String getDegreeFulltime() {
		return degreeFulltime;
	}
	public void setDegreeFulltime(String degreeFulltime) {
		this.degreeFulltime = degreeFulltime;
	}
	public String getDegreeSite() {
		return degreeSite;
	}
	public void setDegreeSite(String degreeSite) {
		this.degreeSite = degreeSite;
	}
	public Integer getHrEmpId() {
		return hrEmpId;
	}
	public void setHrEmpId(Integer hrEmpId) {
		this.hrEmpId = hrEmpId;
	}
	public HrEmp getEmp() {
		return emp;
	}
	public void setEmp(HrEmp emp) {
		this.emp = emp;
	}
	
}
