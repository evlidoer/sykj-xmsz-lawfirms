package com.jt.lawfirm.controller.administration;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.administration.External;
import com.jt.lawfirm.service.administration.ExternalService;

@Controller
public class ExternalControoller {
	
	@Resource(name = "ExternalService")
	private ExternalService externalservice;
	
	/**
	 * 	这个是  外部联系人查询
	 * 2019年4月18日上午9:55:55
	 * @User 许威
	 * @Desc 
	 * @param offset
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "external/sel",method = RequestMethod.GET)
	public @ResponseBody PageBean  selNoticeList(Integer offset ,Integer limit,HttpServletRequest request){
		
		java.util.Map<String,Object> map = new java.util.HashMap<String, Object>();
		/**
		 * 	模糊查询所需条件
		 */
		String title = request.getParameter("title");
		if (title != null && !"".equals(title)) {
			map.put("title", "%"+title+"%");
		}
		/**
		 * 	先传入 limit 再传入 offset
		 */
		PageBean pageBean = new PageBean();
		if (limit == null) {
			limit = 3;
		}
		if (offset == null) {
			offset  = 1;
		}
		pageBean.setLimit(limit);
		pageBean.setOffset(offset);
		
		/**
		 * 	将该 pageBean 放入map 
		 */
		map.put("pageBean", pageBean);
		/**
		 * 	传入 service ,让service操作传过去的map里边的pageBean里边的List<?> , 不需要返回值,只需service层setRows()值
		 */
		externalservice.findExternalAll(map);
		return pageBean;
	}
	
	
	/**
	 * 		删除 外部联系人 ,修改状态
	 * 2019年4月19日上午10:30:50
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "external/del/{id}",method = RequestMethod.GET)
	public String  del(@PathVariable("id") int id) {
		externalservice.removeExternalById(id);
		return "redirect:/external/sel";
	}
	
	
	/**
	 * 		查看外部联系人详情
	 * 2019年4月19日上午10:28:36
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	/*
	 * @RequestMapping(value = "external/selInfo",method = RequestMethod.GET)
	 * public @ResponseBody External selInfoByID() { return
	 * externalservice.selInfoExternalById(SaveIdUtil.getID()); }
	 */
	/**
	 * 		查看外部联系人详情
	 * 2019年4月19日上午10:28:36
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequestMapping(value = "external/selInfo/{id}",method = RequestMethod.GET)
	public @ResponseBody External   selInfoByID2(@PathVariable("id") int id) {
		return  externalservice.selInfoExternalById(id);
	}
	
	/**
	 * 	修改 外部联系人信息之前的赋值查询
	 * 2019年4月19日上午10:29:32
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequestMapping(value = "external/selUpd/{id}",method = RequestMethod.GET)
	public @ResponseBody External  selUpdByID(@PathVariable("id") int id) {
		return externalservice.selUpdExternalById(id);
	}
	
	/**
	 *  	修改通讯  外部联系人,
	 * 2019年4月19日上午10:27:12
	 * @User 许威
	 * @Desc 
	 * @param external
	 * @return
	 */
	@RequestMapping(value = "external/upd",method = RequestMethod.POST)
	public String upd(External external) {
		System.err.println(external);
		externalservice.upd(external);
		return "/addressBook/External"; 
	}
	
	@RequestMapping(value = "external/add",method = RequestMethod.POST)
	public String add(External external) {
		System.err.println(external);
		externalservice.add(external);
		return "/addressBook/External"; 
	}
}
