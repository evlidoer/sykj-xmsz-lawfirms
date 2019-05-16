package com.jt.lawfirm.service.record.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.record.RecordArchiveslibrary;
import com.jt.lawfirm.mapper.record.IRecordArchiveslibraryMapper;
import com.jt.lawfirm.service.record.RecordArchiveslibraryService;
@Service("RecordArchiveslibraryService")
public class RecordArchiveslibraryServiceImpl implements RecordArchiveslibraryService{
	@Autowired
	private IRecordArchiveslibraryMapper iRecordArchiveslibraryMapper;
	@Override
	public List<RecordArchiveslibrary> findRecordArchiveslibraryAll(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");
		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
		List<RecordArchiveslibrary> selectList = new ArrayList<RecordArchiveslibrary>();
		if (map.get("title") != null && !"".equals(map.get("title"))  ||
				map.get("case_propernum") != null && !"".equals(map.get("case_propernum")) || 
				map.get("case_filenumber") != null && !"".equals(map.get("case_filenumber")) ||
				map.get("file_name") != null && !"".equals(map.get("file_name")) ||
				map.get("user_name") != null && !"".equals(map.get("user_name")) || 
				map.get("archiveslibrary_return_status") != null && !"".equals(map.get("archiveslibrary_return_status"))
				||	map.get("jie_yue_desc") != null && !"".equals(map.get("jie_yue_desc")) || 
				map.get("jie_yue") != null && !"".equals(map.get("jie_yue")) ||
				map.get("gui_huan_desc") != null && !"".equals(map.get("gui_huan_desc")) ||
				map.get("gui_huan") != null && !"".equals(map.get("gui_huan"))
				) {
			selectList = iRecordArchiveslibraryMapper.selRecordArchiveslibraryAll(map);
		}else {
			selectList = iRecordArchiveslibraryMapper.selRecordArchiveslibraryAll(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */
		pageBean.setRows(selectList);
		System.err.println(pageBean.getRows().toString());
		return iRecordArchiveslibraryMapper.selRecordArchiveslibraryAll(map);
	}
	/**
	 * 2019年4月28日下午10:39:21
	 * @author 许威
	 * @Desc 
	 * @param asList
	 * @return
	 */
	@Override
	public boolean findByArrId(List<String> List) {
		ArrayList<Integer> asList  = new ArrayList<Integer>();
		for (String integer : List) {
			asList.add(Integer.parseInt(integer));
		}	
		List<RecordArchiveslibrary> selByArrId = iRecordArchiveslibraryMapper.selByArrId(asList);
		for (RecordArchiveslibrary recordArchiveslibrary : selByArrId) {
			System.err.println(recordArchiveslibrary.getArchiveslibraryReturnStatus());
			if (recordArchiveslibrary.getArchiveslibraryReturnStatus().equals("N")) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 2019年4月28日下午10:51:57
	 * @author 许威
	 * @Desc 
	 * @param asList
	 * @return
	 */
	@Override
	public Boolean removeByArr(List<String> asList) {
		try {
			iRecordArchiveslibraryMapper.delByArr(asList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 2019年4月28日下午11:52:05
	 * @author 许威
	 * @Desc 
	 * @param format
	 */
	@Override
	public boolean modyfi_y(String format,int id) {
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("str", format);
		map.put("id", id);
		try {
			int update_y = iRecordArchiveslibraryMapper.update_y(map);
			if (update_y > 0)
				return true;
			else 
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean modyfi_n(int id) {
		try {
			int update_y = iRecordArchiveslibraryMapper.update_n(id);
			if (update_y > 0)
				return true;
			else 
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}