package com.jt.lawfirm.bean.hr;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

//-- 团队表
public class HrTeam {
	@TableId(type=IdType.AUTO)
	private Integer id;// bigint primary key auto_increment,	#团队id
	private String teamName;// varchar(30),					#团队名称
	private String teamPrincipal;// varchar(30),				#团队负责人
	private String teamMember;// varchar(30),				#团队成员
	private String teamIntro;// varchar(100),				#团队介绍
	public HrTeam() {
		super();
	}
	
	@Override
	public String toString() {
		return "HrTeam [id=" + id + ", teamName=" + teamName + ", teamPrincipal=" + teamPrincipal + ", teamMember="
				+ teamMember + ", teamIntro=" + teamIntro + "]";
	}

	public HrTeam(Integer id, String teamName, String teamPrincipal, String teamMember, String teamIntro) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.teamPrincipal = teamPrincipal;
		this.teamMember = teamMember;
		this.teamIntro = teamIntro;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamPrincipal() {
		return teamPrincipal;
	}
	public void setTeamPrincipal(String teamPrincipal) {
		this.teamPrincipal = teamPrincipal;
	}
	public String getTeamMember() {
		return teamMember;
	}
	public void setTeamMember(String teamMember) {
		this.teamMember = teamMember;
	}
	public String getTeamIntro() {
		return teamIntro;
	}
	public void setTeamIntro(String teamIntro) {
		this.teamIntro = teamIntro;
	}
	
}
