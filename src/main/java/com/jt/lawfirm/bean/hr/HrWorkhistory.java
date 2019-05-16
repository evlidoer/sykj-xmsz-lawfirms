package com.jt.lawfirm.bean.hr;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

//-- 工作经历表
public class HrWorkhistory {
	@TableId(type=IdType.AUTO)
	private Integer id;// bigint primary key auto_increment,	#工作经历id
	private String workhistoryStartdate;// date,				#开始日期
	private String workhistoryEnddate;//  date,				#结束日期
	private String workhistoryWorkunit;// varchar(30),		#工作单位
	private String workhistoryJobPosition;// varchar(30),	#工作职务
	private String workhistoryWorktype;// varchar(30),		#工作类别
	private String workhistoryWorknature;// varchar(30),		#工作性质
	private String workhistorySite;//	varchar(30),		#所在地
	private Integer hrEmpId;// bigint not null				#外键，员工id
	public HrWorkhistory() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWorkhistoryStartdate() {
		return workhistoryStartdate;
	}
	public void setWorkhistoryStartdate(String workhistoryStartdate) {
		this.workhistoryStartdate = workhistoryStartdate;
	}
	public String getWorkhistoryEnddate() {
		return workhistoryEnddate;
	}
	public void setWorkhistoryEnddate(String workhistoryEnddate) {
		this.workhistoryEnddate = workhistoryEnddate;
	}
	public String getWorkhistoryWorkunit() {
		return workhistoryWorkunit;
	}
	public void setWorkhistoryWorkunit(String workhistoryWorkunit) {
		this.workhistoryWorkunit = workhistoryWorkunit;
	}
	
	public String getWorkhistoryWorktype() {
		return workhistoryWorktype;
	}
	public void setWorkhistoryWorktype(String workhistoryWorktype) {
		this.workhistoryWorktype = workhistoryWorktype;
	}
	public String getWorkhistoryWorknature() {
		return workhistoryWorknature;
	}
	public void setWorkhistoryWorknature(String workhistoryWorknature) {
		this.workhistoryWorknature = workhistoryWorknature;
	}
	public String getWorkhistorySite() {
		return workhistorySite;
	}
	public void setWorkhistorySite(String workhistorySite) {
		this.workhistorySite = workhistorySite;
	}
	public Integer getHrEmpId() {
		return hrEmpId;
	}
	public void setHrEmpId(Integer hrEmpId) {
		this.hrEmpId = hrEmpId;
	}
	public String getWorkhistoryJobPosition() {
		return workhistoryJobPosition;
	}
	public void setWorkhistoryJobPosition(String workhistoryJobPosition) {
		this.workhistoryJobPosition = workhistoryJobPosition;
	}
	public HrWorkhistory(Integer id, String workhistoryStartdate, String workhistoryEnddate, String workhistoryWorkunit,
			String workhistoryJobPosition, String workhistoryWorktype, String workhistoryWorknature,
			String workhistorySite, Integer hrEmpId) {
		super();
		this.id = id;
		this.workhistoryStartdate = workhistoryStartdate;
		this.workhistoryEnddate = workhistoryEnddate;
		this.workhistoryWorkunit = workhistoryWorkunit;
		this.workhistoryJobPosition = workhistoryJobPosition;
		this.workhistoryWorktype = workhistoryWorktype;
		this.workhistoryWorknature = workhistoryWorknature;
		this.workhistorySite = workhistorySite;
		this.hrEmpId = hrEmpId;
	}
	@Override
	public String toString() {
		return "HrWorkhistory [id=" + id + ", workhistoryStartdate=" + workhistoryStartdate + ", workhistoryEnddate="
				+ workhistoryEnddate + ", workhistoryWorkunit=" + workhistoryWorkunit + ", workhistoryJobPosition="
				+ workhistoryJobPosition + ", workhistoryWorktype=" + workhistoryWorktype + ", workhistoryWorknature="
				+ workhistoryWorknature + ", workhistorySite=" + workhistorySite + ", hrEmpId=" + hrEmpId + "]";
	}
	
	
}
