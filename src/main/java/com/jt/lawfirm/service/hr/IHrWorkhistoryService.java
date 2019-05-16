package com.jt.lawfirm.service.hr;
/*
 * 
 * @author代国繁
 * */
import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.hr.HrWorkhistory;

public interface IHrWorkhistoryService {
List<HrWorkhistory> selectworkby(Map<String, Object> map);
boolean updatework(HrWorkhistory hrWorkhistory);
boolean deletework(int id);
boolean insertwork(HrWorkhistory hrWorkhistory);

}
