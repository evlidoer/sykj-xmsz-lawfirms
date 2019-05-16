package com.jt.lawfirm.controller.administration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
import com.jt.lawfirm.bean.administration.KdManager;
import com.jt.lawfirm.bean.system.User;
import com.jt.lawfirm.exception.InHttpServletIsEmptyException;
import com.jt.lawfirm.service.administration.ExpressageService;
import com.jt.lawfirm.service.login.LoginService;
import com.jt.lawfirm.util.AutoConversion;

import net.sf.json.JSONObject;

@Controller
public class ExpressageController {
	@Resource(name = "ExpressageService")
	private ExpressageService expressageService;
	@Resource
	private LoginService loginService;
	/**
	 * 	这个是  快递
	 * 2019年4月18日上午9:55:55
	 * @User 许威
	 * @Desc 
	 * @param offset
	 * @param limit
	 * @param request
	 * @return
	 * @throws InHttpServletIsEmptyException 
	 */
	@RequestMapping(value = "Expressage/sel",method = RequestMethod.GET)
	public @ResponseBody PageBean  selNoticeList(Integer offset ,Integer limit,HttpServletRequest request) throws InHttpServletIsEmptyException{
		java.util.Map<String,Object> map = new java.util.HashMap<String, Object>();

		/**
		 *  map 放入一个 id ,从当前用户获取
		 */
		// 需要获取session 里边的值
		// 需要获取session 里边的值
		// 需要获取session 里边的值
		// 需要获取session 里边的值
		// 需要获取session 里边的值
		// 需要获取session 里边的值
		String username = request.getSession(false).getAttribute("userName").toString();
		if  (username == null || username.equals(""))
			throw new InHttpServletIsEmptyException("重新登录异常!");


		User finUserByNamw = loginService.finUserByNamw(username);
		map.put("id",finUserByNamw.getId());
		/**
		 * 	模糊查询所需条件
		 */
		String title = request.getParameter("title");
		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		String status = request.getParameter("status");
		String DateType = request.getParameter("DateType");
		String company = request.getParameter("company");
		if (title != null && !"".equals(title)) {
			map.put("title", "%"+title+"%");
		}
		if (DateType != null && "S".equals(DateType)) {
			if (stime != null && !"".equals(stime)) {
				map.put("stime", stime);
			}
			if (etime != null && !"".equals(etime)) {
				map.put("etime", etime);
			}
		}else if (DateType != null && "L".equals(DateType)){
			if (stime != null && !"".equals(stime)) {
				map.put("stime2", stime);
			}
			if (etime != null && !"".equals(etime)) {
				map.put("etime2", etime);
			}
		}

		if (status != null && !"".equals(status)) {
			map.put("status", status);
			System.err.println(map.get("status"));
		}
		if (company != null && !"".equals(company)) {
			map.put("company", "%"+company+"%");
			System.err.println(map.get("company"));
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
		expressageService.findEexpressageAll(map);
		System.out.println(pageBean.getRows());
		return pageBean;
	}

	/**
	 *  	发件
	 * 2019年4月27日下午8:37:42
	 * @User 许威
	 * @Desc 
	 * @param offset
	 * @param limit
	 * @param request
	 * @return
	 * @throws InHttpServletIsEmptyException 
	 */
	@RequestMapping(value = "Expressage/F_sel",method = RequestMethod.GET)
	public @ResponseBody PageBean  F_sel(Integer offset ,Integer limit,HttpServletRequest request) throws InHttpServletIsEmptyException{
		java.util.Map<String,Object> map = new java.util.HashMap<String, Object>();

		/**
		 *  map 放入一个 id ,从当前用户获取
		 */
		// 需要获取session 里边的值
		// 需要获取session 里边的值
		// 需要获取session 里边的值
		// 需要获取session 里边的值
		// 需要获取session 里边的值
		// 需要获取session 里边的值
		String username = request.getSession(false).getAttribute("userName").toString();
		if  (username == null || username.equals(""))
			throw new InHttpServletIsEmptyException("重新登录异常!");
		map.put("id",expressageService.selUserIdByName(username));

		/**
		 * 	模糊查询所需条件
		 */
		String title = request.getParameter("title");
		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		String status = request.getParameter("status");
		String DateType = request.getParameter("DateType");
		String company = request.getParameter("company");
		if (title != null && !"".equals(title)) {
			map.put("title", "%"+title+"%");
		}
		if (DateType != null && "S".equals(DateType)) {
			if (stime != null && !"".equals(stime)) {
				map.put("stime", stime);
			}
			if (etime != null && !"".equals(etime)) {
				map.put("etime", etime);
			}
		}else if (DateType != null && "L".equals(DateType)){
			if (stime != null && !"".equals(stime)) {
				map.put("stime2", stime);
			}
			if (etime != null && !"".equals(etime)) {
				map.put("etime2", etime);
			}
		}

		if (status != null && !"".equals(status)) {
			map.put("status", status);
			System.err.println(map.get("status"));
		}
		if (company != null && !"".equals(company)) {
			map.put("company", "%"+company+"%");
			System.err.println(map.get("company"));
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
		expressageService.findEexpressageFAll(map);
		System.out.println(pageBean.getRows());
		return pageBean;
	}

	/**
	 *  添加页面的收件人选择
	 */

	@RequestMapping(value = "Expressage/add/selUser",method =  RequestMethod.GET)
	public @ResponseBody PageBean selUser(Integer offset ,Integer limit,HttpServletRequest request) {

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
		expressageService.addRequest_selUser(map);
		return pageBean;
	}

	@RequestMapping(value = "Expressage/del/{id}")
	public String Del(@PathVariable("id")int id) {
		expressageService.remove_ExpressageById(id);
		return "administration/AddExpressage_KuaidiSel";
	}

	/**
	 * 
	 * 	案件表的查询
	 */
	@RequestMapping(value = "Expressage/sellaw",method =  RequestMethod.GET)
	public @ResponseBody PageBean selLawAndEmp(Integer offset ,Integer limit,HttpServletRequest request) {
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
		expressageService.findlawAndEmp(map);
		System.err.println(pageBean);
		return pageBean;
	}

	@RequestMapping(value = "Expressage/selById/{id}",method = RequestMethod.GET)
	public @ResponseBody Map<String,Object>  selNoticeList(@PathVariable("id") int id){
		return expressageService.findExpressageById(id);
	}

	/**
	 * 	快递公司查询
	 */

	@RequestMapping(value = "Expressage/sel/selkuaidi",method = RequestMethod.GET)
	public @ResponseBody PageBean  selkuaidi(Integer offset ,Integer limit,HttpServletRequest request){
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
		expressageService.findselkuaidi(map);
		System.err.println(pageBean);
		return pageBean;
	}

	/**
	 * 	快递公司查询
	 */

	@RequestMapping(value = "Expressage/sel/findselkuaidiType",method = RequestMethod.GET)
	public @ResponseBody PageBean  findselkuaidiType(Integer offset ,Integer limit,HttpServletRequest request){
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
		expressageService.findselkuaidiType(map);
		System.err.println(pageBean);
		return pageBean;
	}
	/**
	 * 	添加
	 */
	@RequestMapping(value = "Expressage/add_myExpressage",method = RequestMethod.POST)
	public @ResponseBody String  addExpressage(HttpServletRequest request){
		/**
		 * 	调方法 , 拿到hmtl from下所有有值的参数
		 */
		HashMap<String, Object> isNotEmptyKeyMap = AutoConversion.IsNotEmptyKeyMap(request);
		/**
		 *  修改 hr_sj_id 传进来的是user id ,需要修改为 hr_emp.id
		 */
		HashMap<String, Object> emp = expressageService.findEmpIDByUserId(isNotEmptyKeyMap.get("hr_sj_id"));
		isNotEmptyKeyMap.put("hr_sj_id", emp.get("hr_emp_id"));
		System.out.println("----------------------"+emp);
		expressageService.addAll(isNotEmptyKeyMap);
		return "goto/administration/Expressage";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "Expressage/add2_myExpressage",method = RequestMethod.POST)
	public @ResponseBody  Boolean  add2Expressage(MultipartFile mypath,String kdManager,HttpServletRequest request) throws IllegalStateException, IOException{
		try {
			String path1 = request.getServletContext().getRealPath("/upload");
			if(mypath != null){
				File file1 = new File(path1,mypath.getOriginalFilename());
				mypath.transferTo(file1);
			}
			/**
			 * 	前台所有数据
			 */
			JSONObject fromObject = JSONObject.fromObject(kdManager);
			HashMap bean = (HashMap)JSONObject.toBean(fromObject, HashMap.class);
			/**
			 *  修改 hr_sj_id 传进来的是user id ,需要修改为 hr_emp.id
			 */
			HashMap<String, Object> emp = expressageService.findEmpIDByUserId(Integer.parseInt(bean.get("hr_sj_id").toString()));
			if (emp != null) {
				bean.put("hr_sj_id", emp.get("hr_emp_id").toString());
			}
			if (mypath != null) {
				bean.put("path", mypath.getOriginalFilename());
			}
			//去掉空值
			HashMap<String, Object> map = new HashMap<String, Object>();
			for (Object key : bean.keySet()) {
				String keyString = (String) bean.get(key);
				if (!"".equals(keyString.trim())) {
					System.out.println("key ===" + bean.get(key));
					map.put(key.toString(), bean.get(key));
				}
			}
			expressageService.addAll(map);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 	修改
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value = "Expressage/updateExpressage",method = RequestMethod.POST)
	public @ResponseBody String  updateExpressage(MultipartFile mypath,KdManager kdManager,HttpServletRequest request) throws IllegalStateException, IOException{
		String path1 = request.getServletContext().getRealPath("/upload");
		if(mypath != null){
			File file1 = new File(path1,mypath.getOriginalFilename());
			mypath.transferTo(file1);
		}
		/**
		 * 	调方法 , 拿到hmtl from下所有有值的参数
		 */
		HashMap<String, Object> isNotEmptyKeyMap = AutoConversion.IsNotEmptyKeyMap(request);
		/**
		 *  修改 hr_sj_id 传进来的是user id ,需要修改为 hr_emp.id
		 */
		HashMap<String, Object> emp = expressageService.findEmpIDByUserId(isNotEmptyKeyMap.get("hr_sj_id"));
		if (emp != null) {
			isNotEmptyKeyMap.put("hr_sj_id", emp.get("hr_emp_id"));
		}
		if (mypath != null) {
			isNotEmptyKeyMap.put("path", mypath.getOriginalFilename());
		}
		isNotEmptyKeyMap.remove("kdManager");
		isNotEmptyKeyMap.remove("mypath");
		System.err.println(isNotEmptyKeyMap);
		/**
		 * 	调方法 , 拿到hmtl from下所有有值的参数
		 */
		expressageService.updAll(isNotEmptyKeyMap);
		return "goto/administration/Expressage";
	}
	/**
	 * 	删除
	 */
	@RequestMapping(value = "Expressage/delExpressage/{id}",method = RequestMethod.DELETE)
	public @ResponseBody void  delExpressage(@PathVariable("id") int id){
		expressageService.removeExpressageByID(id);
	}


	/**
	 * 	修改快递公司 , 下边是 快递type修改
	 */
	@RequestMapping(value = "Expressage/updateExpressageCompanyType",method = RequestMethod.PUT)
	public @ResponseBody void  updateExpressageCompanyType(HttpServletRequest request){
		/**
		 * 	调方法 , 拿到hmtl from下所有有值的参数
		 */
		HashMap<String, Object> isNotEmptyKeyMap = AutoConversion.IsNotEmptyKeyMap(request);
		expressageService.updateExpressageCompanyType(isNotEmptyKeyMap);
	}
	@RequestMapping(value = "Expressage/updateExpressageCompany",method = RequestMethod.PUT)
	public @ResponseBody void  updateExpressageCompany(HttpServletRequest request){
		/**
		 * 	调方法 , 拿到hmtl from下所有有值的参数
		 */
		HashMap<String, Object> isNotEmptyKeyMap = AutoConversion.IsNotEmptyKeyMap(request);
		expressageService.updExpressageCompany(isNotEmptyKeyMap);
	}


	/**
	 * 	 添加 快递公司 , 下边是 快递type
	 */
	@RequestMapping(value = "Expressage/updateExpressageCompanyType_add",method = RequestMethod.POST)
	public @ResponseBody void  updateExpressageCompanyTypeadd(HttpServletRequest request){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("name",request.getParameter("name"));
		System.out.println(request.getParameter("name")+"name");
		expressageService.ExpressageCompanyTypeadd(hashMap);
	}
	@RequestMapping(value = "Expressage/updateExpressageCompany_add",method = RequestMethod.POST)
	public @ResponseBody void  updateExpressageCompanyadd(HttpServletRequest request){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("name",request.getParameter("name"));
		System.out.println(request.getParameter("name")+"name");
		expressageService.ExpressageCompanyadd(hashMap);
	}

	/**
	 * 	删除,使用中不能删
	 */
	@RequestMapping(value = "Expressage/updateExpressageCompanyType_del/{id}",method = RequestMethod.DELETE)
	public @ResponseBody String updateExpressageCompanyType_del(@PathVariable("id")int id){
		boolean expressageCompanydel = expressageService.ExpressageCompanyTypedel(id);
		if (expressageCompanydel) {
			return "true";
		}
		return "false";
	}
	@RequestMapping(value = "Expressage/updateExpressageCompany_del/{id}",method = RequestMethod.DELETE)
	public @ResponseBody String  updateExpressageCompany_del(@PathVariable("id")int id){
		boolean expressageCompanydel = expressageService.ExpressageCompanydel(id);
		if (expressageCompanydel) {
			return "true";
		}
		return "false";
	}
	/**
	 *  	发件部分
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "Expressage/addF_myExpressage",method = RequestMethod.POST)
	public @ResponseBody String  addF_myExpressage(MultipartFile mypath,String kdManagerF,HttpServletRequest request) throws IllegalStateException, IOException{
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
		/**
		 *  修改 hr_sj_id 传进来的是user id ,需要修改为 hr_emp.id
		 */
		System.out.println(Integer.parseInt(bean.get("hr_sj_id").toString()));
		HashMap<String, Object> emp = expressageService.findEmpIDByUserId(Integer.parseInt(bean.get("hr_sj_id").toString()));
		if (emp != null) {
			bean.put("hr_sj_id", emp.get("hr_emp_id").toString());
		}
		if (mypath != null) {
			bean.put("path", mypath.getOriginalFilename());
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (Object key : bean.keySet()) {
			String keyString = (String) bean.get(key);
			if (!"".equals(keyString.trim())) {
				System.err.println("key ===" + bean.get(key));
				map.put(key.toString(), bean.get(key));
			}
		}
		System.err.println(map);
		expressageService.addFAll(map);
		return "true";
	}


	@RequestMapping(value = "Expressage/delExpressageF/{id}",method = RequestMethod.DELETE)
	public @ResponseBody String  updateExpressageF_del(@PathVariable("id")int id){
		boolean expressageCompanydel = expressageService.RemoveExpressageF(id);
		if (expressageCompanydel) {
			return "true";
		}
		return "false";
	}
	/**
	 * 
	 * 2019年4月28日上午12:11:49
	 * @User 许威
	 * @Desc 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "Expressage/selFById/{id}",method = RequestMethod.GET)
	public @ResponseBody HashMap<String,Object>  selFById(@PathVariable("id")int id){
		return expressageService.findFById(id);
	}

	/**
	 * 	修改 发件
	 * 2019年4月28日上午8:51:57
	 * @User 许威
	 * @Desc 
	 * @param mypath
	 * @param kdManagerF
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "modyfyF/byid",method = RequestMethod.POST)
	public @ResponseBody String fdfda(MultipartFile mypath,String kdManagerF,HttpServletRequest request) throws IllegalStateException, IOException {
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
		/**
		 *  修改 hr_sj_id 传进来的是user id ,需要修改为 hr_emp.id
		 */
		HashMap<String, Object> emp = expressageService.findEmpIDByUserId(Integer.parseInt(bean.get("hr_sj_id").toString()));
		if (emp != null) {
			bean.put("hr_sj_id", emp.get("hr_emp_id").toString());
		}
		if (mypath != null) {
			bean.put("path", mypath.getOriginalFilename());
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (Object key : bean.keySet()) {
			String keyString = (String) bean.get(key);
			if (!"".equals(keyString.trim())) {
				System.err.println(key+" === " + bean.get(key));
				map.put(key.toString().trim(), bean.get(key));
			}
		}
		String string = map.get("id").toString();
		map.put("id", Integer.parseInt(string));
		expressageService.updF(map);
		return "true";
	}
}
