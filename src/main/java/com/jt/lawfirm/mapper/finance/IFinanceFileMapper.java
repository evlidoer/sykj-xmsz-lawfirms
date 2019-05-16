package com.jt.lawfirm.mapper.finance;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.lawfirm.bean.record.RecordFile;
import com.jt.lawfirm.mapper.finance.sqlProvider.FinanceFileSqlProvider;

public interface IFinanceFileMapper extends BaseMapper<RecordFile>{
	
	@Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
	@InsertProvider(type=FinanceFileSqlProvider.class, method="insertFileOfInvoice")
	boolean insertFileOfInvoice(RecordFile rf);
	
}
