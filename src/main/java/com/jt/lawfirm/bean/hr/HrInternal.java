package com.jt.lawfirm.bean.hr;

public class HrInternal {
private Integer id;
private String internalName;
public HrInternal() {
	super();
	// TODO Auto-generated constructor stub
}
public HrInternal(Integer id, String internalName) {
	super();
	this.id = id;
	this.internalName = internalName;
}
@Override
public String toString() {
	return "HrInternal [id=" + id + ", internalName=" + internalName + "]";
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getInternalName() {
	return internalName;
}
public void setInternalName(String internalName) {
	this.internalName = internalName;
}

}
