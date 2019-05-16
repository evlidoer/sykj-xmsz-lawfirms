package com.jt.lawfirm.bean.hr;
//-- 民族表（员工表关联）
public class HrNation {
	private Integer id;// bigint primary key auto_increment,	#民族id
	private String nationName;// varchar(20)			#民主名称
	public HrNation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HrNation(Integer id, String nationName) {
		super();
		this.id = id;
		this.nationName = nationName;
	}
	@Override
	public String toString() {
		return "Nation [id=" + id + ", nationName=" + nationName + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	
}
