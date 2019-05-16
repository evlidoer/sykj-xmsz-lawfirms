package com.jt.lawfirm.mapper.record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;

import com.jt.lawfirm.bean.record.RecordArchiveslibrary;

public interface IRecordArchiveslibraryMapper {

	List<RecordArchiveslibrary> selRecordArchiveslibraryAll(Map<String, Object> map);

	/**
	 * 2019年4月28日下午10:40:45
	 * @User 许威
	 * @Desc 
	 * @param asList
	 */
	List<com.jt.lawfirm.bean.record.RecordArchiveslibrary> selByArrId(List<Integer> asList);

	/**
	 * 2019年4月28日下午10:53:00
	 * @User 许威
	 * @Desc 
	 * @param asList
	 */
	void delByArr(List<String> asList);

	/**
	 * 2019年4月28日下午11:53:29
	 * @User 许威
	 * @Desc 
	 * @param format
	 * @param id
	 */
	@Update("update record_archiveslibrary set archiveslibrary_returndate = #{str},archiveslibrary_return_status = 'Y' where id = #{id}")
	int update_y(HashMap<String,Object> map);
	
	
	@Update("update record_archiveslibrary set archiveslibrary_returndate = NULL,archiveslibrary_return_status = 'N' where id = #{id}")
	int update_n(int id);

}
