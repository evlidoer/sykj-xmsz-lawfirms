package com.jt.lawfirm.mapper.finance;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.finance.Inout;
import com.jt.lawfirm.mapper.finance.sqlProvider.AllInoutSqlProvider;

public interface IAllInoutMapper extends BaseMapper<Inout> {
	
	@SelectProvider(type=AllInoutSqlProvider.class, method="selectAllBudgetOfSive")
	List<Map<String, String>> selectAllBudgetOfSive(Map<String, String> map);
	
}
