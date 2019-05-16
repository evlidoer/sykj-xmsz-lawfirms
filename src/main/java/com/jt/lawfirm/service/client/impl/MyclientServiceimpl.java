package com.jt.lawfirm.service.client.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.bean.client.AddclientBean;
import com.jt.lawfirm.bean.client.Client;
import com.jt.lawfirm.mapper.client.IMyclientMapper;
import com.jt.lawfirm.service.client.IMyclientService;
@Service
public class MyclientServiceimpl implements IMyclientService{
	@Autowired
	private IMyclientMapper clientmapper;
	@Override
	public List<Client> SelectAll(Map<String, Object> map) {
		PageBean pb = (PageBean) map.get("pb");
		Page pg = PageHelper.startPage(pb.getOffset(),pb.getLimit());
		List<Client> selectAll = clientmapper.FindAll(map);
		pb.setTotal(pg.getTotal());
		pb.setRows(selectAll);
		return selectAll;
	}
	@Override
	public int Insertclient_insertTetail_Insertmsg(AddclientBean client) {
	int clientid = clientmapper.Addclient(client);
					clientmapper.AddTetail(client);
					clientmapper.Addmsg(client);
		return clientid;
	}
	
	
	@Override
	public void updateclient_updateclientdetail_updateclientmsg(AddclientBean client) {
	int number = clientmapper.modifclient(client);
				 clientmapper.modifclientdetail(client);
				 clientmapper.modifclientmsg(client);
	}
	@Override
	public List<AddclientBean> SelectClient(Integer id) {
		List<AddclientBean> findClient = clientmapper.FindClient(id);
		return findClient;
	}
	@Override
	public int lawNumber(Integer id) {
		int lawnum = clientmapper.lawnum(id);
		return lawnum;
	}
	@Override
	public int deleteById(Integer id) {
		int removeById = clientmapper.removeById(id);
		return removeById;
	}
	@Override
	public int clientcount(String client,Integer empid) {
		int clientCount = clientmapper.clientCount(client,empid);
		//System.err.println(clientCount);
		return clientCount;
	}
	

	@Override
	public List<Map<String, Object>> SelectLawById(Integer id) {
		List<Map<String, Object>> listmap =	clientmapper.FindclientlawByid(id);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : listmap) {
			Date date = Date.valueOf(map2.get("case_subtime").toString());
			map2.put("case_subtime",simp.format(date));
		}
		return listmap;
	}
	@Override
	public List<Map<String, Object>> Selectemp(Map<String, Object> cmap) {
		PageBean pb = (PageBean) cmap.get("pb");
		Page pg = PageHelper.startPage(pb.getOffset(),pb.getLimit());
		
		
		List<Map<String, Object>> Selectemp = clientmapper.FindEmp(cmap);
		pb.setTotal(pg.getTotal());	
		pb.setRows(Selectemp);
		return Selectemp;
	}
	@Override
	public int updateclientEmp(Map<String, Object> map) {
		int number = clientmapper.updateclientEmpid(map);
		return number;
	}
	@Override
	public Object SelectAllexport(Map<String, Object> cmap) {
		List<Map<String,Object>> selectAll = clientmapper.FindAllexport(cmap);
		return selectAll;
	}
	@Override
	public List<Map<String, Object>> logSelectById(Integer id) {
		List<Map<String, Object>> listmap =	clientmapper.FindLogbyId(id);
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		for (Map<String, Object> map2 : listmap) {
			Date date = Date.valueOf(map2.get("joblog_startTime").toString());
			map2.put("joblog_startTime",simp.format(date));
		}
		return listmap;
	}
	@Override
	public int foridnumber(Map<String,Object> map) {
	 int number = clientmapper.foridnumber(map);
		return number;
	}
	@Override
	public int forclientIdcardSel(Map<String,Object> map) {
	int number = 	clientmapper.forclientIdcardSel(map);
		return number;
	}
}
