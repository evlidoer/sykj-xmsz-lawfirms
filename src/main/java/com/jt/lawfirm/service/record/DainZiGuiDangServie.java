
package com.jt.lawfirm.service.record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jt.lawfirm.exception.IdBeEmpty;

/**
 * @author evildoer
 *
 */
public interface DainZiGuiDangServie {

	/**
	 * 2019年4月28日上午10:56:26
	 * @User 许威
	 * @Desc 
	 * @param map
	 */
	List<HashMap<String, Object>> findDocumentSel_all(Map<String, Object> map);

	/**
	 * 2019年4月28日下午3:59:58
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	String findDocumentSel_Byid(int id);

	/**
	 * 2019年4月28日下午4:28:48
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	boolean RemoveDocumentDEL_Byid(int id);

	/**
	 * 2019年4月29日上午9:28:14
	 * @User 许威
	 * @Desc 
	 * @param map
	 * @throws IdBeEmpty 
	 */
	Boolean add_Record_file(HashMap<String, Object> map);


}
