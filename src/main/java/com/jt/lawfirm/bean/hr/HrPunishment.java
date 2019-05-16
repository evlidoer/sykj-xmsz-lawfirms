package com.jt.lawfirm.bean.hr;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class HrPunishment {
	 @TableId(type=IdType.AUTO)
	 private Integer id;
	 private String punishmentTime;
	 private String punishmentLevel;
	 private String lssuingBody;
	 private String punishmentContent;
	 private String punishmentMatter;
	 private Integer hrEmpId;
	public HrPunishment() {
		super();
	}
	
	public Integer getHrEmpId() {
		return hrEmpId;
	}

	public void setHrEmpId(Integer hrEmpId) {
		this.hrEmpId = hrEmpId;
	}
	
	public String getLssuingBody() {
		return lssuingBody;
	}

	public void setLssuingBody(String lssuingBody) {
		this.lssuingBody = lssuingBody;
	}

	
	public String getPunishmentMatter() {
		return punishmentMatter;
	}

	public void setPunishmentMatter(String punishmentMatter) {
		this.punishmentMatter = punishmentMatter;
	}

	@Override
	public String toString() {
		return "HrPunishment [id=" + id + ", punishmentTime=" + punishmentTime + ", punishmentLevel=" + punishmentLevel
				+ ", lssuingBody=" + lssuingBody + ", punishmentContent=" + punishmentContent + ", punishmentMatter="
				+ punishmentMatter + ", hrEmpId=" + hrEmpId + "]";
	}

	public HrPunishment(Integer id, String punishmentTime, String punishmentLevel, String lssuingBody,
			String punishmentContent, String punishmentMatter, Integer hrEmpId) {
		super();
		this.id = id;
		this.punishmentTime = punishmentTime;
		this.punishmentLevel = punishmentLevel;
		this.lssuingBody = lssuingBody;
		this.punishmentContent = punishmentContent;
		this.punishmentMatter = punishmentMatter;
		this.hrEmpId = hrEmpId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPunishmentTime() {
		return punishmentTime;
	}
	public void setPunishmentTime(String punishmentTime) {
		this.punishmentTime = punishmentTime;
	}
	public String getPunishmentLevel() {
		return punishmentLevel;
	}
	public void setPunishmentLevel(String punishmentLevel) {
		this.punishmentLevel = punishmentLevel;
	}
	public String getPunishmentContent() {
		return punishmentContent;
	}
	public void setPunishmentContent(String punishmentContent) {
		this.punishmentContent = punishmentContent;
	}
	 
}
