package com.jt.lawfirm.mapper.finance;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.casea.Law;
import com.jt.lawfirm.mapper.finance.sqlProvider.FinanceLawSqlProvider;

/**
 * 
 * @author theFlyingCat
 *
 */
public interface IFinanceLawMapper extends BaseMapper<Law> {
	
	@SelectProvider(type=FinanceLawSqlProvider.class, method="selectLawOfSive")
	List<Map<String, String>> selectLawOfSive(Map<String, String> map);
	
}
