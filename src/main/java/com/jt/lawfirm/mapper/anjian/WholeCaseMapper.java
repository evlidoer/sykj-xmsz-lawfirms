package com.jt.lawfirm.mapper.anjian;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jt.lawfirm.bean.finance.Invoice;

public interface WholeCaseMapper {
	
	@Update("update case_law set case_recycle = #{case_recycle} where id=#{id}")
	boolean upWholeCaseCZ3(@Param("id")Integer id, @Param("case_recycle")String case_recycle);
	@Update("update case_law set case_clash = #{case_clash} where id=#{id}")
	boolean upWholeCaseCZ4(@Param("id")Integer id, @Param("case_clash")String case_clash);
	@SelectProvider(type=WholeCaseSql.class, method="insertInvoiceAll")
	Integer addWholeCaseCZ2(Invoice invoice);
		
}



