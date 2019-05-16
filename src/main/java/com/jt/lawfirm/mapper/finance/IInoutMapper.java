package com.jt.lawfirm.mapper.finance;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.finance.Inout;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyBudget;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyIncomeOfSive;
import com.jt.lawfirm.bean.finance.fuzzyQueryBean.MyStatisticsOfSive;
import com.jt.lawfirm.mapper.finance.sqlProvider.InoutSqlProvider;

public interface IInoutMapper extends BaseMapper<Inout> {
	
	@SelectProvider(type=InoutSqlProvider.class, method="selectInoutOfSive")
	List<Inout> selectInoutOfSive(MyBudget myBudget);
	
	@SelectProvider(type=InoutSqlProvider.class, method="selectIncomeOfSive")
	List<Inout> selectIncomeOfSive(MyIncomeOfSive myIncome);
	
	@SelectProvider(type=InoutSqlProvider.class, method="selectIncomeOfSive")
	List<Map<String, Object>> selectIncomeOfSives(MyIncomeOfSive myIncome);
	
	@SelectProvider(type=InoutSqlProvider.class, method="selectReserved")
	List<Map<String, String>> selectReservedOfSive(MyIncomeOfSive myIncome);
	
	@SelectProvider(type=InoutSqlProvider.class, method="selectCommission")
	List<Map<String, String>> selectCommission(MyIncomeOfSive myIncome);
	
	@InsertProvider(type=InoutSqlProvider.class,method="insertInout")
	boolean insertInout(Map<String, String> map);
	
	@InsertProvider(type=InoutSqlProvider.class,method="insertInoutOneRow")
	boolean insertInoutOneRow(Map<String, String> map);
	
	@SelectProvider(type=InoutSqlProvider.class, method="selectIncomeOfSivePlus")
	List<Inout> selectIncomeOfSivePlus(MyStatisticsOfSive my);
	
	@SelectProvider(type=InoutSqlProvider.class, method="selectIncomeOfSivePlus")
	List<Map<String, Object>> selectIncomeOfSivesPlus(MyStatisticsOfSive my);
	
	@SelectProvider(type=InoutSqlProvider.class, method="selectReservedPlus")
	List<Map<String, String>> selectReservedOfSivePlus(MyStatisticsOfSive my);
	
	@SelectProvider(type=InoutSqlProvider.class, method="selectCommissionPlus")
	List<Map<String, String>> selectCommissionPlus(MyStatisticsOfSive my);
	
}
