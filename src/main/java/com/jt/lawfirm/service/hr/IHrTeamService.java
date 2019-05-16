package com.jt.lawfirm.service.hr;
/**
 * @author 代
 * */
import java.util.List;
import java.util.Map;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.hr.HrTeam;
import com.jt.lawfirm.bean.system.mysystembean.MycyBean;

public interface IHrTeamService {
	List<HrTeam> selectteam(Map<String, Object> map);
	List<MycyBean> selectuser(String string,PageBean pageBean);
	boolean insertteam(HrTeam hrTeam);
	boolean deleteteam(int id);
	boolean upteam(HrTeam hrTeam);
	List<HrTeam> selectteampage(Map<String, Object> map,PageBean bean);
}
