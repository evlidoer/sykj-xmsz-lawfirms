/**
 * 2019年4月28日下午4:53:31
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.controller.record;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.service.record.ElectronicRecordsAlLService;

/**
 * 2019年4月28日下午4:53:31
 * @author 许威
 * @Desc 
 */
@Controller
public class ElectronicRecordsAlLController {
	@Resource(name = "ElectronicRecordsAlLService")
	private ElectronicRecordsAlLService  ElectronicRecordsAlLService ;
	
	@RequestMapping(value = "ElectronicRecordsAlL/sel",method = RequestMethod.GET)
	public @ResponseBody PageBean  findNoticeList(int offset ,int limit,HttpServletRequest request){

		java.util.Map<String,Object> map = new java.util.HashMap<String, Object>();
		/**
		 * 	模糊查询所需条件
		 */
		String title = request.getParameter("title");
		if (title != null && !title.equals(""))
			map.put("title", title);
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
		ElectronicRecordsAlLService.findElectronicRecordsAlLAll(map);
		return pageBean;
	}
}
