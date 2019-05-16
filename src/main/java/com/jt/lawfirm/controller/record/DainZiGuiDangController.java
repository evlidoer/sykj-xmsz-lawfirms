/**
 * 
 */
package com.jt.lawfirm.controller.record;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.exception.IdBeEmpty;
import com.jt.lawfirm.service.record.DainZiGuiDangServie;

import net.sf.json.JSONObject;

/**
 * @author evildoer
 *
 */
@Controller
public class DainZiGuiDangController {
	@Resource(name = "DainZiGuiDangServie")
	private DainZiGuiDangServie DainZiGuiDangService;

	/**
	 * 2019年4月28日上午10:48:39
	 * @User 许威
	 * @Desc 我的电子文档  查询所有
	 * @param request
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "record/DainZiGuiDang/MyDocumentSelall",method = RequestMethod.GET)
	public @ResponseBody PageBean MyDocumentSel_all(int offset ,int limit,HttpServletRequest request){
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
		pageBean.setLimit(limit);
		pageBean.setOffset(offset);

		/**
		 * 	将该 pageBean 放入map 
		 */
		map.put("pageBean", pageBean);
		/**
		 * 	传入 service ,让service操作传过去的map里边的pageBean里边的List<?> , 不需要返回值,只需service层setRows()值
		 */
		DainZiGuiDangService.findDocumentSel_all(map);
		return pageBean;
	}

	/**
	 * 	删除操作
	 */
	@RequestMapping(value = "record/DainZiGuiDang/MyDocumentSel_Byid/{id}",method = RequestMethod.DELETE)
	public @ResponseBody boolean MyDocumentSel_Byid(@PathVariable("id")int id){
		return	DainZiGuiDangService.RemoveDocumentDEL_Byid(id);
	}

	/*
	 * 	添加
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "record/DainZiGuiDang/MyDocumentSel_add",method = RequestMethod.POST)
	public @ResponseBody boolean MyDocumentSel_Byid(MultipartFile mypath,String kdManagerF,HttpServletRequest request) throws IllegalStateException, IOException, IdBeEmpty {
		String path1 = request.getServletContext().getRealPath("/upload");
		if(mypath != null){
			File file1 = new File(path1,mypath.getOriginalFilename());
			mypath.transferTo(file1);
		}
		/**
		 * 	前台所有数据
		 */
		JSONObject fromObject = JSONObject.fromObject(kdManagerF);
		@SuppressWarnings("rawtypes")
		HashMap bean = (HashMap)JSONObject.toBean(fromObject, HashMap.class);
		if (mypath != null) {
			bean.put("file_path", mypath.getOriginalFilename());
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		/**
		 * 
		 * 
		 * 
		 * 
		 * session     中获取
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		map.put("file_upload_person",1002);//获取session
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		map.put("file_upload_date",df.format(new Date()).toString());//最后跟新时间
		for (Object key : bean.keySet()) {
			String keyString = bean.get(key).toString();
			if (!"".equals(keyString.trim())) {
				System.err.println(key+" === " + bean.get(key));
				map.put(key.toString().trim(), bean.get(key));
			}
		}
		/**
		 * inert into record_file
		 * 		put 一个id进去,用于返回刚添加的主键
		 */
		Boolean add_Record_file = DainZiGuiDangService.add_Record_file(map);
		return	add_Record_file;
	}
}
