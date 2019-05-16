package com.jt.lawfirm.bean.client;

public class Ctype {
	private Integer id;
	private String clientType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public Ctype() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ctype [id=" + id + ", clientType=" + clientType + "]";
	}
	
}
