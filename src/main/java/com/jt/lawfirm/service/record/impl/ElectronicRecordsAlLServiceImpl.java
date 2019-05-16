/**
 * 2019年4月28日下午5:03:57
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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.mapper.record.ElectronicRecordsAlLMapper;
import com.jt.lawfirm.service.record.ElectronicRecordsAlLService;

/**
 * 2019年4月28日下午5:03:57
 * @author 许威
 * @Desc 
 */
@Service("ElectronicRecordsAlLService")
public class ElectronicRecordsAlLServiceImpl implements ElectronicRecordsAlLService{
	@Autowired
	private ElectronicRecordsAlLMapper ElectronicRecordsAlLMapper;
	/**
	 * 2019年4月28日下午5:04:06
	 * @author 许威
	 * @Desc 
	 * @param map
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> findElectronicRecordsAlLAll(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");
		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());
		List<HashMap<String,Object>> selectList = new ArrayList<HashMap<String,Object>>();
		if (map.get("title") != null && !"".equals(map.get("title"))) {
			selectList = ElectronicRecordsAlLMapper.selElectronicRecordsAlLAll(map);
		}else {
			selectList = ElectronicRecordsAlLMapper.selElectronicRecordsAlLAll(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */
		pageBean.setRows(selectList);
		System.err.println(pageBean.getRows().toString());
		return ElectronicRecordsAlLMapper.selElectronicRecordsAlLAll(map);
	}

}
