/**
 * 2019年4月28日上午11:02:01
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.mapper.record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jt.lawfirm.bean.record.RecordFile; 

/**
 * 2019年4月28日上午11:02:01
 * @author 许威
 * @Desc 
 */
public interface IDainZiGuiDangMapper {

	/**
	 * 2019年4月28日上午11:05:12
	 * @User 许威
	 * @Desc 
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>> selZiGuiDangall(Map<String, Object> map);

	/**
	 * 2019年4月28日下午4:00:56
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return 
	 */
	int selDocumentSel_Byid(int id);

	/**
	 * 2019年4月28日下午4:42:52
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@Delete("delete from record_file where id = #{id}")
	int DocumentDEL_Byid(int id);

	/**
	 * 2019年4月29日上午9:29:48
	 * @User 许威
	 * @Desc 
	 * @param map
	 */
	int insert_Record_file(@Param("dataMap")HashMap<String, Object> map);

	/**
	 * 2019年4月29日上午9:58:11
	 * @User 许威
	 * @Desc 
	 * @param map
	 */
	void insert_Record(com.jt.lawfirm.bean.record.Record www);

	/**
	 * 2019年4月29日上午10:14:32
	 * @User 许威
	 * @Desc 
	 * @param map
	 */
	void insert_record_archiveslibrary(@Param("dataMap")HashMap<String, Object> map);

	/**
	 * 2019年4月29日上午11:37:42
	 * @User 许威
	 * @Desc 
	 * @param map
	 * @return
	 */
	int sel_Record_fileByMap(HashMap<String, Object> map);

	/**
	 * 2019年4月29日下午2:44:58
	 * @User 许威
	 * @Desc 
	 * @param object
	 * @return
	 */
	@Select("select file_name from record_file where file_name = #{file_name}")
	HashMap<String, Object> insert_Record_file_sel(Object file_name);

}
