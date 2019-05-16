/**
 * 2019年5月2日下午7:57:41
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.bean.system;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 2019年5月2日下午7:57:41
 * @author 许威
 * @Desc 
 */
@TableName("system_permission")
public class Permission {
	private Integer id;
	private String  authorityName;
	private String authorityMode;
	private String authorityPath;
	private String  authorityCreatedate;
	private String authorityDesc;
	private String authorityStatus;
	public Permission() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getAuthorityMode() {
		return authorityMode;
	}
	public void setAuthorityMode(String authorityMode) {
		this.authorityMode = authorityMode;
	}
	public String getAuthorityPath() {
		return authorityPath;
	}
	public void setAuthorityPath(String authorityPath) {
		this.authorityPath = authorityPath;
	}
	public String getAuthorityCreatedate() {
		return authorityCreatedate;
	}
	public void setAuthorityCreatedate(String authorityCreatedate) {
		this.authorityCreatedate = authorityCreatedate;
	}
	public String getAuthorityDesc() {
		return authorityDesc;
	}
	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}
	public String getAuthorityStatus() {
		return authorityStatus;
	}
	public void setAuthorityStatus(String authorityStatus) {
		this.authorityStatus = authorityStatus;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", authorityName=" + authorityName + ", authorityMode=" + authorityMode
				+ ", authorityPath=" + authorityPath + ", authorityCreatedate=" + authorityCreatedate
				+ ", authorityDesc=" + authorityDesc + ", authorityStatus=" + authorityStatus + "]";
	}
}
