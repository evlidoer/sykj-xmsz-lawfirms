package com.jt.lawfirm.bean.hr.myhrbean;
/*
 * 
 * @author代国繁
 * 
 * */
public class Myempident {
 private String nameorphone;//姓名或者电话
 private String identid;//律师id
 private String mindate;//开始时间
 private String maxdate;//结束时间
 private String datefun;//排序时间方式
 private String nameord;//姓名排序
public Myempident() {
	super();
}
public Myempident(String nameorphone, String identid, String mindate, String maxdate, String datefun, String nameord) {
	super();
	this.nameorphone = nameorphone;
	this.identid = identid;
	this.mindate = mindate;
	this.maxdate = maxdate;
	this.datefun = datefun;
	this.nameord = nameord;
}
@Override
public String toString() {
	return "Myempident [nameorphone=" + nameorphone + ", identid=" + identid + ", mindate=" + mindate + ", maxdate="
			+ maxdate + ", datefun=" + datefun + ", nameord=" + nameord + "]";
}
public String getNameorphone() {
	return nameorphone;
}
public void setNameorphone(String nameorphone) {
	if (nameorphone.trim().equals("")) {
		nameorphone = null;
	}
	this.nameorphone = nameorphone;
}
public String getIdentid() {
	return identid;
}
public void setIdentid(String identid) {
	if (identid.trim().equals("")) identid = null;
	this.identid = identid;
}
public String getMindate() {
	return mindate;
}
public void setMindate(String mindate) {
	if (mindate.trim().equals("")) mindate = null;
	this.mindate = mindate;
}
public String getMaxdate() {
	return maxdate;
}
public void setMaxdate(String maxdate) {
	if (maxdate.trim().equals("")) maxdate = null;
	this.maxdate = maxdate;
}
public String getDatefun() {
	return datefun;
}
public void setDatefun(String datefun) {
	if (datefun.trim().equals("")) datefun = null;
	this.datefun = datefun;
}
public String getNameord() {
	return nameord;
}
public void setNameord(String nameord) {
	if (nameord.trim().equals("")) nameord = null;
	this.nameord = nameord;
}
 
}
