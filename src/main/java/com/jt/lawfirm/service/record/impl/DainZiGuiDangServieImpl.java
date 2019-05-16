/**
 * 2019年4月28日上午11:00:47
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.service.record.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.record.Record;
import com.jt.lawfirm.exception.IdBeEmpty;
import com.jt.lawfirm.mapper.record.IDainZiGuiDangMapper;
import com.jt.lawfirm.service.record.DainZiGuiDangServie;

/**
 * 2019年4月28日上午11:00:47
 * @author 许威
 * @Desc 
 */
@Service(value = "DainZiGuiDangServie")
public class DainZiGuiDangServieImpl implements DainZiGuiDangServie {

	@Autowired
	private IDainZiGuiDangMapper Mapper;
	/**
	 * 2019年4月28日上午11:00:47
	 * @author 许威
	 * @Desc 
	 * @param map
	 * @return
	 */
	@Override
	public  List<HashMap<String, Object>> findDocumentSel_all(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");

		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());

		List<HashMap<String, Object>> selectList  = new ArrayList<HashMap<String, Object>>();
		if (map.get("title") != null && !"".equals(map.get("title"))) {
			selectList = Mapper.selZiGuiDangall(map);
		}else {
			selectList = Mapper.selZiGuiDangall(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */

		pageBean.setRows(selectList);
		return Mapper.selZiGuiDangall(map);
	}
	/**
	 * 2019年4月28日下午4:00:30
	 * @author 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Override
	public boolean RemoveDocumentDEL_Byid(int id) {
		int i =	Mapper.DocumentDEL_Byid(id);
		if (i > 0 ) {
			return true;
		}
		return false;
	}
	/**
	 * 2019年4月28日下午4:41:33
	 * @author 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Override
	public String findDocumentSel_Byid(int id) {return null;}
	/**
	 * 2019年4月29日上午9:28:29
	 * @author 许威
	 * @Desc 
	 * @param map
	 * @return
	 * @throws IdBeEmpty 
	 */
	@SuppressWarnings("null")
	@Override
	public Boolean add_Record_file(HashMap<String, Object> map){
		try {
			/** 
			 * 	添加之判段名称重复
			 */
			HashMap<String, Object> re = Mapper.insert_Record_file_sel(map.get("file_name"));
			System.err.println("____________________________________"+re);
			if (re == null) {
				/**
				 * 	添加加 Record_file
				 */
				Mapper.insert_Record_file(map);
				/**
				 * 	inert into record
				 */
				int id = -1;
				id = Mapper.sel_Record_fileByMap(map);
				if (id <= 0)
					throw new IdBeEmpty("新加数据的id值未获!");
				else 
					map.put("record_archived_file",id);
				com.jt.lawfirm.bean.record.Record record = new Record(Integer.parseInt(map.get("law_id").toString()), Integer.parseInt(map.get("record_archived_file").toString()));
				Mapper.insert_Record(record);
				/**
				 *  insert into record_archiveslibrary
				 */
				map.put("law_caseid",map.get("law_id"));
				map.put("system_user_id",map.get("user_id"));
				map.put("archiveslibrary_remark", map.get("sjdesc"));
				if (map.get("archiveslibrary_returndate") == null) {
					map.put("archiveslibrary_return_status",'N');
				}else {
					map.put("archiveslibrary_return_status",'Y');
				}
				if (record.getId() <= 0)
					throw new IdBeEmpty("新加数据的id值未获!");
				else 
					map.put("record_id",record.getId());

				for (Object iterable_element : map.keySet()) {
					System.out.println("key :"+ iterable_element + "   values :"+map.get(iterable_element));
				}
				Mapper.insert_record_archiveslibrary(map);
				return true;
			}else {//名称重复
				return false;
			}
		} catch (IdBeEmpty e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
		}
		return false;
	}
}


