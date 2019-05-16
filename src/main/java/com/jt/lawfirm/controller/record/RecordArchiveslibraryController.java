package com.jt.lawfirm.controller.record;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.service.record.RecordArchiveslibraryService;

@Controller
public class RecordArchiveslibraryController {
	@Resource(name = "RecordArchiveslibraryService")
	private RecordArchiveslibraryService recordArchiveslibraryService;

	/**
	 * 	档案借阅查看,以及高级检索
	 * 2019年4月18日上午9:56:30
	 * @User 许威
	 * @Desc 
	 * @param offset
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "RecordArchiveslibrary/sel",method = RequestMethod.GET)
	public @ResponseBody PageBean  findNoticeList(int offset ,int limit,HttpServletRequest request){

		java.util.Map<String,Object> map = new java.util.HashMap<String, Object>();
		/**
		 * 	模糊查询所需条件
		 */
		String title = request.getParameter("title");
		String SearchType = request.getParameter("SearchType");
		String Returnstatus = request.getParameter("Returnstatus");
		String Sort = request.getParameter("Sort");
		if (title != null && !"".equals(title)) {
			switch (SearchType) {
			case "1":
				map.put("user_name", "%"+title+"%");
				break;
			case "2":
				map.put("case_propernum", "%"+title+"%");
				break;
			case "3":
				map.put("case_filenumber", "%"+title+"%");
				break;
			case "4":
				map.put("file_name", "%"+title+"%");
				break;
			}
		}
		if (Returnstatus != null  && !"".equals(Returnstatus)) {
			map.put("archiveslibrary_return_status",Returnstatus);
		}
		switch (Sort) {
		case "1":
			map.put("jie_yue_desc","System.out.print");
			break;
		case "2":
			map.put("jie_yue", "System.out.print");
			break;
		case "3":
			map.put("gui_huan_desc", "System.out.print");
			break;
		case "4":
			map.put("gui_huan", "System.out.print");
			break;
		default:
			break;
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
		recordArchiveslibraryService.findRecordArchiveslibraryAll(map);
		return pageBean;
	}

	/**
	 * 	删除	
	 */
	@RequestMapping(value = "RecordArchiveslibrary/delByArr/{arr}",method = RequestMethod.GET)
	public @ResponseBody boolean  del(@PathVariable("arr")String arr){
		String substring = arr.substring(1, arr.length()-1);
		List<String> asList = Arrays.asList(substring.split(","));
		boolean boo = recordArchiveslibraryService.findByArrId(asList);
		if (boo) {
			Boolean removeByArr = recordArchiveslibraryService.removeByArr(asList);
			if (removeByArr) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 	设置为已归档
	 */
	@RequestMapping(value = "RecordArchiveslibrary/y/{id}",method = RequestMethod.GET)
	public @ResponseBody boolean update_y(@PathVariable("id")int id){
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		 String string = df.format(new Date()).toString();
		 boolean boo = recordArchiveslibraryService.modyfi_y(string,id);
		return boo;
	}
	
	
	/***
	 * 	设置为已归档
	 */
	@RequestMapping(value = "RecordArchiveslibrary/n/{id}",method = RequestMethod.GET)
	public @ResponseBody boolean update_n(@PathVariable("id")int id){
		 boolean boo = recordArchiveslibraryService.modyfi_n(id);
		return boo;
	}
}
