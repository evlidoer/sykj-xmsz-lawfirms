package com.jt.lawfirm.mapper.hr;
/**
 * @author 代
 * */
import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.hr.HrTeam;
import com.jt.lawfirm.bean.system.mysystembean.MycyBean;
import com.jt.lawfirm.mapper.hr.sqlProvider.HrTeamSqlProvider;

public interface IHrTeamMapper extends BaseMapper<HrTeam> {

	@SelectProvider(type=HrTeamSqlProvider.class,method="selectuser")
	List<MycyBean> selectuser(String string);
}
