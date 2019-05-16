
package com.jt.lawfirm.bean.log;

/**
 * 
 * @author 二乐
 *system_type
 */
public class Type1 {
	private int id;//主键
	private String systemTypeLogtype;
	public Type1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type1(int id, String systemTypeLogtype) {
		super();
		this.id = id;
		this.systemTypeLogtype = systemTypeLogtype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSystemTypeLogtype() {
		return systemTypeLogtype;
	}
	public void setSystemTypeLogtype(String systemTypeLogtype) {
		this.systemTypeLogtype = systemTypeLogtype;
	}
	@Override
	public String toString() {
		return "Type1 [id=" + id + ", systemTypeLogtype=" + systemTypeLogtype + "]";
	}

	
	
}