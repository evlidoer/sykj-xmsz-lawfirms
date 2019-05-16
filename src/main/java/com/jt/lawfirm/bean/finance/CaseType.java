package com.jt.lawfirm.bean.finance;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 
 * @author theFlyingCat
 *
 */
//案件类型
@TableName("case_case_type")
public class CaseType {
	private	 Integer id ;
	private String caseTypeName ; //案件类型
	@TableField(value="type_pid")
	private Integer typeId;  //自关联
	
	@TableField(exist=false)
	private List<CaseType> caseType  = new ArrayList<CaseType>();

	public CaseType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaseType(Integer id, String caseTypeName, Integer typeId, List<CaseType> caseType) {
		super();
		this.id = id;
		this.caseTypeName = caseTypeName;
		this.typeId = typeId;
		this.caseType = caseType;
	}

	@Override
	public String toString() {
		return "CaseType [id=" + id + ", caseTypeName=" + caseTypeName + ", typeId=" + typeId + ", caseType=" + caseType
				+ "]";
	}

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

	public List<CaseType> getCaseType() {
		return caseType;
	}

	public void setCaseType(List<CaseType> caseType) {
		this.caseType = caseType;
	}
	
}
