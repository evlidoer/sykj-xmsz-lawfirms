package com.jt.lawfirm.service.client;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.client.AddclientBean;
import com.jt.lawfirm.bean.client.Client;

public interface IMyclientService {
	List<Client> SelectAll(Map<String,Object> map);

	public int Insertclient_insertTetail_Insertmsg(AddclientBean client);
	
	void updateclient_updateclientdetail_updateclientmsg(AddclientBean client);
	List<AddclientBean> SelectClient(Integer id);
	int lawNumber(Integer id);
	int deleteById(Integer id);
	int clientcount(String client,Integer empid);
	List<Map<String, Object>> SelectLawById(Integer id);

	List<Map<String, Object>> Selectemp(Map<String, Object> cmap);

	int updateclientEmp(Map<String, Object> map);

	Object SelectAllexport(Map<String, Object> cmap);

	List<Map<String, Object>> logSelectById(Integer id);

	int foridnumber(Map<String,Object> map);

	int forclientIdcardSel(Map<String,Object> map);
}
