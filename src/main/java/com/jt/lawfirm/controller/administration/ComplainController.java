package com.jt.lawfirm.controller.administration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.service.administration.ComplainService;

@Controller
public class ComplainController {
	@Resource(name = "ComplainService")
	private ComplainService complainService;

	/**
	 * 这个是建议/投诉查询
	 * 2019年4月18日上午9:56:30
	 * @User 许威
	 * @Desc 
	 * @param offset
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "complain/sel",method = RequestMethod.GET)
	public @ResponseBody PageBean  findNoticeList(int offset ,int limit,HttpServletRequest request){

		java.util.Map<String,Object> map = new java.util.HashMap<String, Object>();
		/**
		 * 	模糊查询所需条件
		 */
		String title = request.getParameter("title");
		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		if (title != null && !"".equals(title)) {
			map.put("title", "%"+title+"%");
		}
		if (stime != null && !"".equals(stime)) {
			map.put("stime", stime);
		}
		if (etime != null && !"".equals(etime)) {
			map.put("etime", etime);
		}
		/**
		 * 	先传入 limit 再传入 offset
		 */
		PageBean pageBean = new PageBean();
		pageBean.setLimit(limit);
		pageBean.setOffset(offset);

		/**
		 * 	将该 pageBean 放入map 
		 */
		map.put("pageBean", pageBean);
		/**
		 * 	传入 service ,让service操作传过去的map里边的pageBean里边的List<?> , 不需要返回值,只需service层setRows()值
		 */
		complainService.findComplainAll(map);
		
		System.err.println(pageBean.getRows());
		return pageBean;
	}

}
