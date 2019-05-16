package com.jt.lawfirm.bean.hr;
//-- 考核表
public class HrInspect {
	private Integer id;// bigint primary key auto_increment,		#考核id
	private String inspectName;// varchar(30),					#项目名称
	private String inspectNorm1;// varchar(30),					#指标
	private String inspectNorm2;// varchar(30),					#指标
	private String inspectScore;// varchar(30),					#分值
	private String inspectStandard;// varchar(30),				#考核标准
	private String inspectWay;// varchar(30),					#考核办法
	private String inspectGraded;// varchar(30),					#自评分
	private String inspectInsptype;// varchar(30) 	#考核类别id
	public HrInspect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HrInspect(Integer id, String inspectName, String inspectNorm1, String inspectNorm2, String inspectScore,
			String inspectStandard, String inspectWay, String inspectGraded, String inspectInsptype) {
		super();
		this.id = id;
		this.inspectName = inspectName;
		this.inspectNorm1 = inspectNorm1;
		this.inspectNorm2 = inspectNorm2;
		this.inspectScore = inspectScore;
		this.inspectStandard = inspectStandard;
		this.inspectWay = inspectWay;
		this.inspectGraded = inspectGraded;
		this.inspectInsptype = inspectInsptype;
	}
	@Override
	public String toString() {
		return "HrInspect [id=" + id + ", inspectName=" + inspectName + ", inspectNorm1=" + inspectNorm1
				+ ", inspectNorm2=" + inspectNorm2 + ", inspectScore=" + inspectScore + ", inspectStandard="
				+ inspectStandard + ", inspectWay=" + inspectWay + ", inspectGraded=" + inspectGraded
				+ ", inspectInsptype=" + inspectInsptype + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInspectName() {
		return inspectName;
	}
	public void setInspectName(String inspectName) {
		this.inspectName = inspectName;
	}
	public String getInspectNorm1() {
		return inspectNorm1;
	}
	public void setInspectNorm1(String inspectNorm1) {
		this.inspectNorm1 = inspectNorm1;
	}
	public String getInspectNorm2() {
		return inspectNorm2;
	}
	public void setInspectNorm2(String inspectNorm2) {
		this.inspectNorm2 = inspectNorm2;
	}
	public String getInspectScore() {
		return inspectScore;
	}
	public void setInspectScore(String inspectScore) {
		this.inspectScore = inspectScore;
	}
	public String getInspectStandard() {
		return inspectStandard;
	}
	public void setInspectStandard(String inspectStandard) {
		this.inspectStandard = inspectStandard;
	}
	public String getInspectWay() {
		return inspectWay;
	}
	public void setInspectWay(String inspectWay) {
		this.inspectWay = inspectWay;
	}
	public String getInspectGraded() {
		return inspectGraded;
	}
	public void setInspectGraded(String inspectGraded) {
		this.inspectGraded = inspectGraded;
	}
	public String getInspectInsptype() {
		return inspectInsptype;
	}
	public void setInspectInsptype(String inspectInsptype) {
		this.inspectInsptype = inspectInsptype;
	}
	
}
