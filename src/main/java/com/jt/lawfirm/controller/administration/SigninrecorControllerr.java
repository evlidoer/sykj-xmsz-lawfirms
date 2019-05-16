package com.jt.lawfirm.controller.administration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.lawfirm.bean.PageBean;
import com.jt.lawfirm.bean.administration.dtd.MySigninrecor;
import com.jt.lawfirm.service.administration.SigninrecorService;

@Controller
public class SigninrecorControllerr {
	@Resource(name = "SigninrecorService")
	private SigninrecorService signinrecorService;


	@RequestMapping(value = "administration/selSigninrecor",method = RequestMethod.GET)
	public @ResponseBody PageBean  selNoticeList(Integer offset ,Integer limit,HttpServletRequest request){

		java.util.Map<String,Object> map = new java.util.HashMap<String, Object>();
		/**
		 * 	模糊查询所需条件
		 */
		String title = request.getParameter("title");
		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		String classifyId = request.getParameter("classifyId");
		if (title != null && !"".equals(title)) {
			map.put("title", "%"+title.trim()+"%");
		}
		if (stime != null && !"".equals(stime)) {
			map.put("stime", stime.trim());
		}
		if (etime != null && !"".equals(etime)) {
			map.put("etime", etime.trim());
		}
		if (classifyId != null && !"".equals(classifyId)) {
			map.put("classifyId", classifyId.trim());
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
		signinrecorService.findSigninrecorAll(map);
		return pageBean;
	}


	@RequestMapping(value = "download/Signinrecor/Excel",method = RequestMethod.GET)
	public String getExcel(HttpServletRequest request, HttpServletResponse response) {
		List<MySigninrecor> list =  signinrecorService.findMySigninrecorAll();
        // 创建excel
        HSSFWorkbook wk = new HSSFWorkbook();
        // 创建一张工作表
        HSSFSheet sheet = wk.createSheet();
        // 2
        sheet.setColumnWidth(0, 5000);
        HSSFRow row = sheet.createRow(0);
        // 创建第一行的第一个单元格
        // 想单元格写值
        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("序号");
        cell = row.createCell((short)1);
        cell.setCellValue("签到人");
        cell = row.createCell((short)2);
        cell.setCellValue("签到类型");
        cell = row.createCell((short)3);
        cell.setCellValue("签到地点");
        cell = row.createCell((short)4);
        cell.setCellValue("签到时间");
        cell = row.createCell((short)5);
        cell.setCellValue("签/退");

        // 创建第一行
        for (short i=0;i<list.size();i++)
        {
            row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(list.get(i).getId());
            row.createCell(1).setCellValue(list.get(i).getEname());
            row.createCell(2).setCellValue(list.get(i).getClassifyId());
            row.createCell(3).setCellValue(list.get(i).getSigninrecordSite());
            row.createCell(4).setCellValue(list.get(i).getSigninrecordEtime());
            row.createCell(5).setCellValue(list.get(i).getAdmSigninrecorStatis());
        }
        try {
            /**
             * 	弹出下载选择路径框
             */
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=Signinrecor.xls");//默认Excel名称
            response.flushBuffer();
            wk.write(response.getOutputStream());
            wk.write(new FileOutputStream(new File("C:\\Users\\evildoer\\Downloads\\Signinrecor.xls")));
            wk.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }
        return null;
	}
}