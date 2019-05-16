package com.jt.lawfirm.service.record;

import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.record.RecordArchiveslibrary;

public interface RecordArchiveslibraryService {

	List<RecordArchiveslibrary> findRecordArchiveslibraryAll(Map<String, Object> map);

	/**
	 * 2019年4月28日下午10:39:05
	 * @User 许威
	 * @Desc 
	 * @param asList
	 * @return
	 */
	boolean findByArrId(List<String> asList);

	/**
	 * 2019年4月28日下午10:51:06
	 * @User 许威
	 * @Desc 
	 * @param asList
	 */
	Boolean removeByArr(List<String> asList);

	/**
	 * 2019年4月28日下午11:53:07
	 * @User 许威
	 * @Desc 
	 * @param format
	 * @param id
	 * @return 
	 */
	boolean modyfi_y(String format, int id);
	
	public boolean modyfi_n(int id);

}
