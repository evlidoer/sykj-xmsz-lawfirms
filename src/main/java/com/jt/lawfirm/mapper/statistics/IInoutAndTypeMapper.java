package com.jt.lawfirm.mapper.statistics;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.finance.Inout;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyIncomeOfSive;
import com.jt.lawfirm.mapper.statistics.sqlProvider.InoutAndTypeSqlProvider;

public interface IInoutAndTypeMapper extends BaseMapper<Inout> {
	
	@SelectProvider(type=InoutAndTypeSqlProvider.class, method="selectFinanceStatistics")
	List<Map<String, String>> selectFinanceStatistics(MyIncomeOfSive myOfSive);
	
}
