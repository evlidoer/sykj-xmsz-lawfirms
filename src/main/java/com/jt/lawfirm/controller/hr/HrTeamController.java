package com.jt.lawfirm.controller.hr;
/**
 * @author 代
 * */
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.hr.HrTeam;
import com.jt.lawfirm.service.hr.IHrTeamService;
import com.jt.lawfirm.util.HRBoolean;

@Controller
@RequestMapping(value="/hr/team")
public class HrTeamController {
	
	@Resource(name="teamservice")
	private IHrTeamService teamService;
	
	@ResponseBody
	@RequestMapping(value="/selectteam",method=RequestMethod.GET)
	public Object selectteam(Integer offset,Integer limit,HttpServletRequest req,String tname,Map<String, Object> map){
		PageBean pb = new PageBean(offset, limit, 0L, null);
		if (tname != null && tname != "") {
			map.put("team_name",tname);
		}
		teamService.selectteampage(map, pb);
		return pb;
	}
	
	@ResponseBody
	@RequestMapping(value="/selectuser",method=RequestMethod.GET)
	public Object selectuser(Integer offset,Integer limit,HttpServletRequest req,String string){
		PageBean pb = new PageBean(offset,limit,0L,null);
		teamService.selectuser(string,pb);
		return pb;
	}
	
	@ResponseBody
	@RequestMapping(value="/selectbyid/{id}",method=RequestMethod.GET)
	public Object selectteamid(@PathVariable("id")int id,Map<String, Object> map){
		map.put("id", id);
		return teamService.selectteam(map);
	}

	@ResponseBody
	@RequestMapping(value="/insertteam",method=RequestMethod.GET)
	public Object insertteam(HrTeam hrTeam){
		System.out.println(hrTeam);
		return HRBoolean.yesOrNo(teamService.insertteam(hrTeam));
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteteam/{id}",method=RequestMethod.GET)
	public Object deleteteam(@PathVariable("id")int id){
		System.out.println(id);
		return HRBoolean.yesOrNo(teamService.deleteteam(id));
	}
	
	@ResponseBody
	@RequestMapping(value="/upteam",method=RequestMethod.GET)
	public Object upteam(HrTeam hrTeam){
		return HRBoolean.yesOrNo(teamService.upteam(hrTeam));
	}
	
	@RequestMapping(value="/toupteam")
	public String toupteam(){
		return "/hr/hrupteam";
	}
}
