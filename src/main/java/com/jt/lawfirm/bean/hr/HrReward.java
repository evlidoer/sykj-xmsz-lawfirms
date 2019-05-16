package com.jt.lawfirm.bean.hr;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

//奖励表
public class HrReward {
	 @TableId(type=IdType.AUTO)
	 private Integer id;
	 private String rewardTime;
	 private String rewardLevel;
	 private String lssuingBody;
	 private String rewardContent;
	 private Integer hrEmpId;
	 
	 
	public String getLssuingBody() {
		return lssuingBody;
	}
	public void setLssuingBody(String lssuingBody) {
		this.lssuingBody = lssuingBody;
	}
	@Override
	public String toString() {
		return "HrReward [id=" + id + ", rewardTime=" + rewardTime + ", rewardLevel=" + rewardLevel + ", lssuingBody="
				+ lssuingBody + ", rewardContent=" + rewardContent + ", hrEmpId=" + hrEmpId + "]";
	}
	public HrReward(Integer id, String rewardTime, String rewardLevel, String lssuingBody, String rewardContent,
			Integer hrEmpId) {
		super();
		this.id = id;
		this.rewardTime = rewardTime;
		this.rewardLevel = rewardLevel;
		this.lssuingBody = lssuingBody;
		this.rewardContent = rewardContent;
		this.hrEmpId = hrEmpId;
	}
	public HrReward() {
		super();
	}
	public Integer getHrEmpId() {
		return hrEmpId;
	}
	public void setHrEmpId(Integer hrEmpId) {
		this.hrEmpId = hrEmpId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRewardTime() {
		return rewardTime;
	}
	public void setRewardTime(String rewardTime) {
		this.rewardTime = rewardTime;
	}
	public String getRewardLevel() {
		return rewardLevel;
	}
	public void setRewardLevel(String rewardLevel) {
		this.rewardLevel = rewardLevel;
	}
	public String getRewardContent() {
		return rewardContent;
	}
	public void setRewardContent(String rewardContent) {
		this.rewardContent = rewardContent;
	}
	 
}
