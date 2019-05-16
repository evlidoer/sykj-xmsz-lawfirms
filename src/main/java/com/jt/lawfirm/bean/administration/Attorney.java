package com.jt.lawfirm.bean.administration;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jt.lawfirm.bean.hr.HrEmp;

/**
 * 律师表
 * 2019年4月17日下午4:44:28
 * @User 许威
 * @Desc 
 * @return
 */
@TableName(value = "adm_addressList")
public class Attorney {
	private Integer  id;
	private String AddressListUser;//用户名
	private String AddressListName;//姓名
	private String addresslistCellphonenumber;//手机号
	private String AddressListTelephone;//座机号
	private String AddressListFax;//传真号码
	private String AddressListState;//状态(在职  不在职)
	private Integer AddressListQQ;
	private String AddressListPostbox;//邮箱
	private String AddressListSex;//性别
	private String AddressListImg;//图片;
	private String AddressListDuty;//职务
	private String AddressListFamily;//家庭住址
	private String AddressListComment;//备注说明
	private HrEmp hrEmp;
	public Attorney() {
	}
	public Attorney(Integer id, String addressListUser, String addressListName, String addresslistCellphonenumber,
			String addressListTelephone, String addressListFax, String addressListState, Integer addressListQQ,
			String addressListPostbox, String addressListSex, String addressListImg, String addressListDuty,
			String addressListFamily, String addressListComment, HrEmp hrEmp) {
		super();
		this.id = id;
		AddressListUser = addressListUser;
		AddressListName = addressListName;
		this.addresslistCellphonenumber = addresslistCellphonenumber;
		AddressListTelephone = addressListTelephone;
		AddressListFax = addressListFax;
		AddressListState = addressListState;
		AddressListQQ = addressListQQ;
		AddressListPostbox = addressListPostbox;
		AddressListSex = addressListSex;
		AddressListImg = addressListImg;
		AddressListDuty = addressListDuty;
		AddressListFamily = addressListFamily;
		AddressListComment = addressListComment;
		this.hrEmp = hrEmp;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddressListUser() {
		return AddressListUser;
	}
	public void setAddressListUser(String addressListUser) {
		AddressListUser = addressListUser;
	}
	public String getAddressListName() {
		return AddressListName;
	}
	public void setAddressListName(String addressListName) {
		AddressListName = addressListName;
	}
	public String getAddresslistCellphonenumber() {
		return addresslistCellphonenumber;
	}
	public void setAddresslistCellphonenumber(String addresslistCellphonenumber) {
		this.addresslistCellphonenumber = addresslistCellphonenumber;
	}
	public String getAddressListTelephone() {
		return AddressListTelephone;
	}
	public void setAddressListTelephone(String addressListTelephone) {
		AddressListTelephone = addressListTelephone;
	}
	public String getAddressListFax() {
		return AddressListFax;
	}
	public void setAddressListFax(String addressListFax) {
		AddressListFax = addressListFax;
	}
	public String getAddressListState() {
		return AddressListState;
	}
	public void setAddressListState(String addressListState) {
		AddressListState = addressListState;
	}
	public Integer getAddressListQQ() {
		return AddressListQQ;
	}
	public void setAddressListQQ(Integer addressListQQ) {
		AddressListQQ = addressListQQ;
	}
	public String getAddressListPostbox() {
		return AddressListPostbox;
	}
	public void setAddressListPostbox(String addressListPostbox) {
		AddressListPostbox = addressListPostbox;
	}
	public String getAddressListSex() {
		return AddressListSex;
	}
	public void setAddressListSex(String addressListSex) {
		AddressListSex = addressListSex;
	}
	public String getAddressListImg() {
		return AddressListImg;
	}
	public void setAddressListImg(String addressListImg) {
		AddressListImg = addressListImg;
	}
	public String getAddressListDuty() {
		return AddressListDuty;
	}
	public void setAddressListDuty(String addressListDuty) {
		AddressListDuty = addressListDuty;
	}
	public String getAddressListFamily() {
		return AddressListFamily;
	}
	public void setAddressListFamily(String addressListFamily) {
		AddressListFamily = addressListFamily;
	}
	public String getAddressListComment() {
		return AddressListComment;
	}
	public void setAddressListComment(String addressListComment) {
		AddressListComment = addressListComment;
	}
	public HrEmp getHrEmp() {
		return hrEmp;
	}
	public void setHrEmp(HrEmp hrEmp) {
		this.hrEmp = hrEmp;
	}
	@Override
	public String toString() {
		return "Attorney [id=" + id + ", AddressListUser=" + AddressListUser + ", AddressListName=" + AddressListName
				+ ", addresslistCellphonenumber=" + addresslistCellphonenumber + ", AddressListTelephone="
				+ AddressListTelephone + ", AddressListFax=" + AddressListFax + ", AddressListState=" + AddressListState
				+ ", AddressListQQ=" + AddressListQQ + ", AddressListPostbox=" + AddressListPostbox
				+ ", AddressListSex=" + AddressListSex + ", AddressListImg=" + AddressListImg + ", AddressListDuty="
				+ AddressListDuty + ", AddressListFamily=" + AddressListFamily + ", AddressListComment="
				+ AddressListComment + ", hrEmp=" + hrEmp + "]";
	}
}
