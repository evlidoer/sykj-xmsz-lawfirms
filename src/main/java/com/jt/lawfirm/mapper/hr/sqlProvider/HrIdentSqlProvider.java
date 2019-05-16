package com.jt.lawfirm.mapper.hr.sqlProvider;
import java.util.Map;

/*
 * 
 * @author代国繁
 * */
import org.apache.ibatis.jdbc.SQL;

import com.jt.lawfirm.bean.hr.myhrbean.Myempident;
/**
 * @author 代
 * */
public class HrIdentSqlProvider {
	
	public String selectIdent(Myempident myempident ){
		return new SQL(){
			{
				SELECT("i.*,l.identity_name identityName,e.emp_name empName,e.emp_phone empPhone,e.emp_entrydate empEntrydate,e.emp_cont_enddate empContEnddate,e.emp_workstatus empWorkstatus,e.emp_social_num empSocialNum,e.emp_status empStatus");
				FROM("hr_ident i");
				INNER_JOIN("hr_emp e on e.id = i.hr_emp_id");
				INNER_JOIN("hr_lawyer_identity l on l.id = i.lawyer_identity_id");
				if (myempident.getNameorphone() != null) WHERE("(e.emp_name like" + "'%" +myempident.getNameorphone()+"%') or (e.emp_phone like" + "'%" +myempident.getNameorphone()+"%') ");
				if (myempident.getIdentid() != null) WHERE("l.id = #{identid}");
				if (myempident.getDatefun().equals("1")) {
					if (myempident.getMindate() != null) WHERE("e.emp_entrydate >= #{mindate}"); 
					if (myempident.getMaxdate() != null) WHERE("e.emp_entrydate <= #{maxdate}"); 
				}
				if (myempident.getDatefun().equals("2")) {
					if (myempident.getMindate() != null) WHERE("e.emp_cont_startdate >= #{mindate}"); 
					if (myempident.getMaxdate() != null) WHERE("e.emp_cont_startdate <= #{maxdate}"); 
				}
				if (myempident.getDatefun().equals("3")) {
					if (myempident.getMindate() != null) WHERE("e.emp_cont_enddate >= #{mindate}"); 
					if (myempident.getMaxdate() != null) WHERE("e.emp_cont_enddate <= #{maxdate}"); 
				}
				if (myempident.getNameord().equals("1")) ORDER_BY("e.emp_name");
			}
		}.toString();
	}
	
	public String selectcase(String casetypename){
		return new SQL(){
			{
				SELECT("case_type_name");
				FROM("case_case_type");
				if (casetypename != null && casetypename != "") WHERE("case_type_name like " + "'%" + casetypename +"%'");
				GROUP_BY("case_type_name");
			}
		}.toString();
	}
	
	public String selectempid(){
		return new SQL(){
			{
				SELECT("id");
				FROM("hr_emp");
				ORDER_BY("id desc");
			}
		}.toString();
	}
	
	public String insertemp(Map<String, String> map){
		return new SQL(){
			{
				INSERT_INTO("hr_emp");
				if (map.get("empName") != null) VALUES("emp_name","'" + map.get("empName")+"'");
				if (map.get("Picturepath") != null) VALUES("emp_picture", "'" + map.get("Picturepath") +"'");
				if (map.get("empPhone") != null) VALUES("emp_phone", "'" + map.get("empPhone") +"'");
				if (map.get("empSite") != null) VALUES("emp_site","'" + map.get("empSite") +"'");
				if (map.get("empEntrydate") != null) VALUES("emp_entrydate","'" + map.get("empEntrydate") +"'");
				if (map.get("empEmail") != null) VALUES("emp_email","'" + map.get("empEmail") +"'");
				if (map.get("empPostcode") != null) VALUES("emp_postcode","'" + map.get("empPostcode")+"'");
				if (map.get("empQq") != null) VALUES("emp_qq","'" + map.get("empQq") +"'");
				if (map.get("empWechat") != null) VALUES("emp_wechat","'" + map.get("empWechat")+"'");
				if (map.get("empContStartdate") != null) VALUES("emp_cont_startdate","'" + map.get("empContStartdate")+"'");
				if (map.get("empContEnddate") != null) VALUES("emp_cont_enddate","'" + map.get("empContEnddate")+"'");
				if (map.get("empWorkstatus") != null) VALUES("emp_workstatus","'" + map.get("empWorkstatus")+"'");
				if (map.get("empSocialNum") != null) VALUES("emp_social_num","'" + map.get("empSocialNum")+"'");
				if (map.get("empStatus") != null) VALUES("emp_status", "'" +map.get("empStatus")+"'");
				if (map.get("empSex") != null) VALUES("emp_sex", "'" +map.get("empSex")+"'");
				if (map.get("empBirthdate") != null) VALUES("emp_birthdate","'" + map.get("empBirthdate")+"'");
				if (map.get("empPaperstype") != null) VALUES("emp_paperstype","'" + map.get("empPaperstype")+"'");
				if (map.get("empPracnum") != null) VALUES("emp_papersnum","'" + map.get("empPracnum")+"'");
				if (map.get("empMaritalsta") != null) VALUES("emp_maritalsta","'" + map.get("empMaritalsta")+"'");
				if (map.get("empEntrancenum") != null) VALUES("emp_entrancenum","'" + map.get("empEntrancenum")+"'");
				if (map.get("empPracnum") != null) VALUES("emp_pracnum","'" + map.get("empPracnum")+"'");
				if (map.get("empPracdate") != null) VALUES("emp_pracdate","'" + map.get("empPracdate")+"'");
				if (map.get("empPracsite") != null) VALUES("emp_pracsite","'" + map.get("empPracsite")+"'");
				if (map.get("empCertifynum") != null) VALUES("emp_certifynum","'" + map.get("empCertifynum")+"'");
				if (map.get("empGainway") != null) VALUES("emp_gainway","'" + map.get("empGainway")+"'");
				if (map.get("empGainsite") != null) VALUES("emp_gainsite","'" + map.get("empGainsite")+"'");
				if (map.get("empEducation") != null) VALUES("emp_education","'" + map.get("empEducation")+"'");
				if (map.get("empAcademic") != null) VALUES("emp_academic","'" + map.get("empAcademic")+"'");
				if (map.get("empGoodfield") != null) VALUES("emp_goodfield","'" + map.get("empGoodfield")+"'");
				if (map.get("empIntroduce") != null) VALUES("emp_introduce","'" + map.get("empIntroduce")+"'");
				if (map.get("hrCertifyId") != null) VALUES("hr_certify_id","'" + map.get("hrCertifyId")+"'");
				if (map.get("hrPractiseId") != null) VALUES("hr_practise_id","'" + map.get("hrPractiseId")+"'");
				if (map.get("hrSpecialtyId") != null) VALUES("hr_specialty_id","'" + map.get("hrSpecialtyId")+"'");
				if (map.get("hrNationId") != null) VALUES("hr_nation_id","'" + map.get("hrNationId")+"'");
				if (map.get("hrPoliticalId") != null) VALUES("hr_political_id","'" + map.get("hrPoliticalId")+"'");
				if (map.get("hrInternalId") != null) VALUES("hr_internal_id","'" + map.get("hrInternalId")+"'");
			}
		}.toString();
	}
}
