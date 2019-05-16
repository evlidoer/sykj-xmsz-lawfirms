package com.jt.lawfirm.bean.system.mysystembean;

public class MySysTemSelect {
private String nameorip;
private String choice;
private String userid;
public MySysTemSelect() {
	super();
	// TODO Auto-generated constructor stub
}
public MySysTemSelect(String nameorip, String choice, String userid) {
	super();
	this.nameorip = nameorip;
	this.choice = choice;
	this.userid = userid;
}
@Override
public String toString() {
	return "MySysTemSelect [nameorip=" + nameorip + ", choice=" + choice + ", userid=" + userid + "]";
}
public String getNameorip() {
	return nameorip;
}
public void setNameorip(String nameorip) {
	if (nameorip.trim().equals("")) {
		nameorip = null;
	}
	this.nameorip = nameorip;
}
public String getChoice() {
	return choice;
}
public void setChoice(String choice) {
	if (choice.trim().equals("")) {
		choice = null;
	}
	this.choice = choice;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	if (userid.trim().equals("")) {
		userid = null;
	}
	this.userid = userid;
}

}
