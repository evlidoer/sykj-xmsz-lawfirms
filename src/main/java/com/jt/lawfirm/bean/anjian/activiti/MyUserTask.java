package com.jt.lawfirm.bean.anjian.activiti;

public class MyUserTask {
	private String id;
	private String name;
	private String type;
	public MyUserTask() {
		super();
	}
	public MyUserTask(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	@Override
	public String toString() {
		return "MyUserTask [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
