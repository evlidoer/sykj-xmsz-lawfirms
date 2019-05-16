package com.jt.lawfirm.bean.shouye;

import java.util.Date;

public class Calendar {
	private Integer id;
	private String calendartype;
	private String worktype;
	private String eventname;
	private String starttime;
	private String endtime;
	private Integer law_id;
	private String describe;
	private String place;
	private String publicstatus;
	private String filepath;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCalendartype() {
		return calendartype;
	}
	public void setCalendartype(String calendartype) {
		this.calendartype = calendartype;
	}
	public String getWorktype() {
		return worktype;
	}
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public Integer getLaw_id() {
		return law_id;
	}
	public void setLaw_id(Integer law_id) {
		this.law_id = law_id;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPublicstatus() {
		return publicstatus;
	}
	public void setPublicstatus(String publicstatus) {
		this.publicstatus = publicstatus;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public Calendar() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Calendar [id=" + id + ", calendartype=" + calendartype + ", worktype=" + worktype + ", eventname="
				+ eventname + ", starttime=" + starttime + ", endtime=" + endtime + ", law_id=" + law_id + ", describe="
				+ describe + ", place=" + place + ", publicstatus=" + publicstatus + ", filepath=" + filepath + "]";
	}
	
}
