package com.jt.lawfirm.mapper.finance.sqlProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class FinanceKdmanagerSqlProvider {
	
	public String selectKdmanagerFAllByY() {
		return new SQL() {
			{
				SELECT("id,gs_name");
				FROM("kdmanager_gs");
				WHERE("gs_status = 'Y'");
			}
		}.toString();
	}
	
	public String selectKdmanagerKdAllByY() {
		return new SQL() {
			{
				SELECT("id,kd_type");
				FROM("kdmanager_kd");
				WHERE("kd_status = 'Y'");
			}
		}.toString();
	}
	
	public String insertKdmanagerFInMap(Map<String, String> map) {
		return new SQL() {
			{	
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				INSERT_INTO("kdmanager_f");
				if(!map.get("user_id").equals("") && map.get("user_id") != null) 
					VALUES("user_id", map.get("user_id"));
				if(!map.get("lawNameId").equals("") && map.get("lawNameId") != null)
					VALUES("law_id", map.get("lawNameId"));
				if(!map.get("wuliuCompany").equals("") && map.get("wuliuCompany") != null)
					VALUES("company", map.get("wuliuCompany"));
				if(!map.get("wuliuType").equals("") && map.get("wuliuType") != null) 
					VALUES("kdtype", map.get("wuliuType"));
				if(!map.get("wuliuNumber").equals("") && map.get("wuliuNumber") != null) 
					VALUES("danhao", map.get("wuliuNumber"));
				if(!map.get("shoujianAddr").equals("") && map.get("shoujianAddr") != null)
					VALUES("dizhi", map.get("shoujianAddr"));
				if(!map.get("lianxiTel").equals("") && map.get("lianxiTel") != null) VALUES("whophone", map.get("lianxiTel"));
				VALUES("fj_date", sdf.format(new Date()));
			}
		}.toString();
	}
	
}
