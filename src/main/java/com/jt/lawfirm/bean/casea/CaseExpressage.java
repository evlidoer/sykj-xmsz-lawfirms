package com.jt.lawfirm.bean.casea;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jt.lawfirm.bean.administration.Expressage;

/**
 * 
 * 	@author evildoer
 *	设计的中间表
 */
@TableName("case_expressage")
public class CaseExpressage {
	private Integer id;
	private int law_case_id;
	private int expressage_id;
	
	private Expressage expressage;
	private Law law;

	public CaseExpressage() {
	}

	public CaseExpressage(Integer id, int law_case_id, int expressage_id, Expressage expressage, Law law) {
		super();
		this.id = id;
		this.law_case_id = law_case_id;
		this.expressage_id = expressage_id;
		this.expressage = expressage;
		this.law = law;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getLaw_case_id() {
		return law_case_id;
	}

	public void setLaw_case_id(int law_case_id) {
		this.law_case_id = law_case_id;
	}

	public int getExpressage_id() {
		return expressage_id;
	}

	public void setExpressage_id(int expressage_id) {
		this.expressage_id = expressage_id;
	}

	public Expressage getExpressage() {
		return expressage;
	}

	public void setExpressage(Expressage expressage) {
		this.expressage = expressage;
	}

	public Law getLaw() {
		return law;
	}

	public void setLaw(Law law) {
		this.law = law;
	}

	@Override
	public String toString() {
		return "CaseExpressage [id=" + id + ", law_case_id=" + law_case_id + ", expressage_id=" + expressage_id
				+ ", expressage=" + expressage + ", law=" + law + "]";
	}
}
