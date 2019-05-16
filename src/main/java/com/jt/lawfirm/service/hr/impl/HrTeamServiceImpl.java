package com.jt.lawfirm.service.hr.impl;
/**
 * @author 代
 * */
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.hr.HrTeam;
import com.jt.lawfirm.bean.system.mysystembean.MycyBean;
import com.jt.lawfirm.mapper.hr.IHrTeamMapper;
import com.jt.lawfirm.service.hr.IHrTeamService;

@Service("teamservice")
public class HrTeamServiceImpl implements IHrTeamService {
	
	@Resource(name="IHrTeamMapper")
	private IHrTeamMapper teamMapper;

	@Override
	public List<HrTeam> selectteam(Map<String, Object> map) {
		return teamMapper.selectByMap(map);
	}

	@Override
	public List<MycyBean> selectuser(String string,PageBean pageBean) {
		Page<Object> page = PageHelper.offsetPage(pageBean.getOffset(), pageBean.getLimit());
		List<MycyBean> selectuser = teamMapper.selectuser(string);
		pageBean.setTotal(page.getTotal());
		pageBean.setRows(selectuser);
		return  selectuser;
	}

	@Override
	public List<HrTeam> selectteampage(Map<String, Object> map, PageBean bean) {
		Page<Object> page = PageHelper.offsetPage(bean.getOffset(), bean.getLimit());
		List<HrTeam> selectByMap = teamMapper.selectByMap(map);
		bean.setTotal(page.getTotal());
		bean.setRows(selectByMap);
		return selectByMap;
	}
	@Override
	public boolean insertteam(HrTeam hrTeam) {
		return teamMapper.insert(hrTeam)>0;
	}

	@Override
	public boolean deleteteam(int id) {
		return teamMapper.deleteById(id)>0;
	}

	@Override
	public boolean upteam(HrTeam hrTeam) {
		return teamMapper.updateById(hrTeam)>0;
	}
}
