package com.jt.lawfirm.service.administration.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.administration.Notice;
import com.jt.lawfirm.mapper.administration.INoticeMapper;
import com.jt.lawfirm.service.administration.Noticeservice;

@Service(value = "Noticeservice")
public class NoticeserviceImpl implements Noticeservice {
	@Autowired
	private INoticeMapper iNoticeMapper;

	@Override
	public List<Notice> findNoticeAll(Map<String, Object> map) {
		PageBean pageBean = (PageBean) map.get("pageBean");

		// 得到总页数，设置到 pb中
		@SuppressWarnings("rawtypes")
		Page pg = PageHelper.startPage(pageBean.getOffset(),pageBean.getLimit());

		List<Notice> selectList  = new ArrayList<Notice>();
		if (map.get("title") != null && !"".equals(map.get("title"))  ||
			map.get("stime") != null && !"".equals(map.get("stime")) || 
			map.get("stime") != null && !"".equals(map.get("stime")) 
				) {
			selectList = iNoticeMapper.selNoticeAll(map);
		}else {
			selectList = iNoticeMapper.selNoticeAll(null);
		}

		// 将分页查询到的数据 放入到  pb中， 返回给前台
		pageBean.setTotal((int) pg.getTotal());
		/**
		 * 	操作的是传过来map里边的pagebean,set他的集合,不用返回值
		 */

		pageBean.setRows(selectList);
		return iNoticeMapper.selNoticeAll(map);
	}

	
	/**
	 * 按照id查询
	 */
	@Override
	public Map<String, Object> findInfoById(int id) {
		return iNoticeMapper.selInfoById(id);
	}

	
	/**
	 *  修改信息
	 */
	@Override
	public int updNotice(Notice notice) {
		 return iNoticeMapper.updateById(notice);
	}

	
	/**
	 *  修改状态相当于删除
	 */
	@Override
	public void removeById(int id) {
		Notice notice = new Notice(id, null, null, null, null, null, null, null, "N");
		iNoticeMapper.updateById(notice);
	}


	/** 
	 * 	添加哎   Notice
	 */
	@Override
	public void addNotice(Notice notice) {
		notice.setId(null);
		if (notice.getNoticeDesc().equals("点击上传，或将文件拖拽到此处")) {
			notice.setNoticeDesc(null);
		}
		System.err.println(notice);
		iNoticeMapper.insert(notice);
	}


	/**
	 * 2019年5月12日下午5:49:05
	 * @author 许威
	 * @Desc 
	 * @param string
	 * @return
	 */
	@Override
	public Integer selIdByUserName(String string) {
		return iNoticeMapper.selIdByUserName(string);
	}
}
