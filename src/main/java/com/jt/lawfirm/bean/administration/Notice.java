package com.jt.lawfirm.bean.administration;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jt.lawfirm.bean.system.User;

/**
 *	公告
 */
@TableName("adm_notice")
public class Notice {
	@TableId(type = IdType.AUTO)
	private Integer	id;
	private Integer systemUserId;
	public Integer getSystemUserId() {
		return systemUserId;
	}
	public void setSystemUserId(Integer systemUserId) {
		this.systemUserId = systemUserId;
	}
	private String  title;
	private String  noticeReleasetime;
	private String  noticeNotificationtime ;
	private String noticeDesc;
	private String noticeAccessoryurl;
	private String  noticeNotificationendtime;
	private User user;
	private String noticeStatus ;
	public String getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	public Notice(Integer id, String title, String noticeReleasetime, String noticeNotificationtime, String noticeDesc,
			String noticeAccessoryurl, String noticeNotificationendtime, User user, String noticeStatus) {
		super();
		this.id = id;
		this.title = title;
		this.noticeReleasetime = noticeReleasetime;
		this.noticeNotificationtime = noticeNotificationtime;
		this.noticeDesc = noticeDesc;
		this.noticeAccessoryurl = noticeAccessoryurl;
		this.noticeNotificationendtime = noticeNotificationendtime;
		this.user = user;
		this.noticeStatus = noticeStatus;
	}
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	public Notice(Integer id, String title, String noticeReleasetime, String noticeNotificationtime, String noticeDesc,
			String noticeAccessoryurl, String noticeNotificationendtime, User user) {
		super();
		this.id = id;
		this.title = title;
		this.noticeReleasetime = noticeReleasetime;
		this.noticeNotificationtime = noticeNotificationtime;
		this.noticeDesc = noticeDesc;
		this.noticeAccessoryurl = noticeAccessoryurl;
		this.noticeNotificationendtime = noticeNotificationendtime;
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNoticeReleasetime() {
		return noticeReleasetime;
	}
	public void setNoticeReleasetime(String noticeReleasetime) {
		this.noticeReleasetime = noticeReleasetime;
	}
	public String getNoticeNotificationtime() {
		return noticeNotificationtime;
	}
	public void setNoticeNotificationtime(String noticeNotificationtime) {
		this.noticeNotificationtime = noticeNotificationtime;
	}
	public String getNoticeDesc() {
		return noticeDesc;
	}
	public void setNoticeDesc(String noticeDesc) {
		this.noticeDesc = noticeDesc;
	}
	public String getNoticeAccessoryurl() {
		return noticeAccessoryurl;
	}
	public void setNoticeAccessoryurl(String noticeAccessoryurl) {
		this.noticeAccessoryurl = noticeAccessoryurl;
	}
	public String getNoticeNotificationendtime() {
		return noticeNotificationendtime;
	}
	public void setNoticeNotificationendtime(String noticeNotificationendtime) {
		this.noticeNotificationendtime = noticeNotificationendtime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", noticeReleasetime=" + noticeReleasetime
				+ ", noticeNotificationtime=" + noticeNotificationtime + ", noticeDesc=" + noticeDesc
				+ ", noticeAccessoryurl=" + noticeAccessoryurl + ", noticeNotificationendtime="
				+ noticeNotificationendtime + ", user=" + user + "]";
	}
}
