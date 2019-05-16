/**
 * 
 */
package com.jt.lawfirm.bean.administration;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author evildoer
 *
 */
@TableName("kdmanager")
public class KdManager {
	private Integer id;
	private Integer user_id;
	private String  sj_date ;
	private Integer  law_id;
	private String  company;
	private String  kdtype;
	private Double  kdmonery;
	private Integer  hr_sj_id;
	private String  sj_status;
	private String  path;
	private String  lj_date;
	private String  sjdesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getSj_date() {
		return sj_date;
	}
	public void setSj_date(String sj_date) {
		this.sj_date = sj_date;
	}
	public Integer getLaw_id() {
		return law_id;
	}
	public void setLaw_id(Integer law_id) {
		this.law_id = law_id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getKdtype() {
		return kdtype;
	}
	public void setKdtype(String kdtype) {
		this.kdtype = kdtype;
	}
	public Double getKdmonery() {
		return kdmonery;
	}
	public void setKdmonery(Double kdmonery) {
		this.kdmonery = kdmonery;
	}
	public Integer getHr_sj_id() {
		return hr_sj_id;
	}
	public void setHr_sj_id(Integer hr_sj_id) {
		this.hr_sj_id = hr_sj_id;
	}
	public String getSj_status() {
		return sj_status;
	}
	public void setSj_status(String sj_status) {
		this.sj_status = sj_status;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getLj_date() {
		return lj_date;
	}
	public void setLj_date(String lj_date) {
		this.lj_date = lj_date;
	}
	public String getSjdesc() {
		return sjdesc;
	}
	public void setSjdesc(String sjdesc) {
		this.sjdesc = sjdesc;
	}
	@Override
	public String toString() {
		return "KdManager [id=" + id + ", user_id=" + user_id + ", sj_date=" + sj_date + ", law_id=" + law_id
				+ ", company=" + company + ", kdtype=" + kdtype + ", kdmonery=" + kdmonery + ", hr_sj_id=" + hr_sj_id
				+ ", sj_status=" + sj_status + ", path=" + path + ", lj_date=" + lj_date + ", sjdesc=" + sjdesc + "]";
	}

	/**
	 * @author 许威
	 * 2019年4月27日
	 */
	public KdManager() {
		// TODO Auto-generated constructor stub
	}
}