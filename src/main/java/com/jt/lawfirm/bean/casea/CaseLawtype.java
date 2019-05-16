package com.jt.lawfirm.bean.casea;
//案件类型表
public class CaseLawtype {
	private Integer id;
	private String caseTypeName;
	private Integer typeId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCaseTypeName() {
		return caseTypeName;
	}
	public void setCaseTypeName(String caseTypeName) {
		this.caseTypeName = caseTypeName;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public CaseLawtype() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Casetype [id=" + id + ", caseTypeName=" + caseTypeName + ", typeId=" + typeId + "]";
	}
	
}
