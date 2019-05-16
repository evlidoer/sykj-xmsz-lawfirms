package com.jt.lawfirm.controller.administration;


import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.administration.Notice;
import com.jt.lawfirm.exception.HttpServletSessionEmpty;
import com.jt.lawfirm.service.administration.Noticeservice;

@Controller
public class NoticeController {
	@Resource(name = "Noticeservice")
	private Noticeservice noticeservice;
	
	/**
	 * 
	 * 2019年4月17日上午11:29:09
	 * @User 许威
	 * @Desc 公告模块模糊查询
	 * @param offset
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "administration/sel",method = RequestMethod.GET)
	public @ResponseBody PageBean  selNoticeList(Integer offset ,Integer limit,HttpServletRequest request){
		
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
		noticeservice.findNoticeAll(map);
		
		return pageBean;
	}
	
	
	/**
	 * 	公告详情查看
	 * 2019年4月17日下午4:03:30
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "administration/selInfoById/{id}",method = RequestMethod.GET)
	public @ResponseBody Map<String,Object>  selNoticeList(@PathVariable("id")int id){
		System.out.println(noticeservice.findInfoById(id));
		return noticeservice.findInfoById(id);
	}
	
	
	/**
	 * 	高级 查询
	 * 2019年4月19日下午6:48:04
	 * @User 许威
	 * @Desc 
	 * @return
	 */
	@RequestMapping(value = "administration/selInfoById2/{id}",method = RequestMethod.GET)
	public @ResponseBody Map<String,Object>  selNoticeInfo(@PathVariable("id")int id){
		return noticeservice.findInfoById(id);
	}
	
	
	/**
	 * 	修改之前查询已赋值与intput
	 * 
	 */
	@RequestMapping(value="administration/SelupdNotice/{id}",method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> SelupdNotice(@PathVariable("id")int id) {
		return noticeservice.findInfoById(id);
	}
	
	
	/**
	 * 	修改 公告
	 */
	@RequestMapping(value="administration/updNotice",method=RequestMethod.POST)
	//MultipartFile 是一个接口，由注解驱动进行实例化其子类
	public @ResponseBody String addEmps(Notice notice,MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println(file);
		if(file != null){
			File file1 = new File(path,file.getOriginalFilename());
			file.transferTo(file1);
		}
		System.err.println(notice);
		noticeservice.updNotice(notice);
		return "true";
	}
	
	/**
	 * 	添加请求
	 * 2019年4月20日下午4:15:51
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @throws HttpServletSessionIsEmpty 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="administration/AddNotice",method=RequestMethod.POST)
	public @ResponseBody String AddNoticeByid(Notice notice,MultipartFile file,HttpServletRequest request) throws HttpServletSessionEmpty, IllegalStateException, IOException{
		/**
		 * 	拿到session 中的当前登录用户
		 */
		Object attribute = request.getSession(false).getAttribute("userName");
		if (attribute == null) {
			throw new HttpServletSessionEmpty("session is to be empty");
		}
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println(file);
		if(file != null){
			File file1 = new File(path,file.getOriginalFilename());
			file.transferTo(file1);
		}
		notice.setSystemUserId(noticeservice.selIdByUserName(attribute.toString()));
//		String noticeAccessoryurl = notice.getNoticeAccessoryurl();
//		notice.setNoticeAccessoryurl("E:/!_unChangeable/Tomcat_AnZhuangBan9/webapps/lawfirms/upload/"+noticeAccessoryurl);
		noticeservice.addNotice(notice);
		return "true";
	}


	/**
	 * 	 删除操作,修改状态
	 * 2019年4月21日上午12:53:47
	 * @User 许威
	 * @Desc 
	 * @param id
	 */
	@RequestMapping(value="delNotice/{id}",method=RequestMethod.GET)
	public String DelNoticeByid222(@PathVariable("id")int id){
		noticeservice.removeById(id);
		return "administration/ManagerNotice";
	}
}
