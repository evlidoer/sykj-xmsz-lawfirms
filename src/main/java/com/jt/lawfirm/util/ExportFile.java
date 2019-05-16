package com.jt.lawfirm.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 导出文件工具类
 * @author theFlyingCat
 *
 */
public class ExportFile {
	
	/**
	 * 生成有多个工作表的excel文件
	 * @param request 当前请求,用于获取当前服务器绝对路径
	 * @param filename xlsx文件名称
	 * @param tableName 传入工作表的参数
	 * @param arrs 传入工作表的值
	 * @return
	 */
	@SafeVarargs
	public static<T> HSSFWorkbook exportExcelOfS(HttpServletResponse response,String filename, List<Map<String, Object>> tableName, 
		  T... arrs) {
		HSSFWorkbook wb = new HSSFWorkbook();
		for(int i = 0; i < arrs.length; i++) {
			List<?> list = (List<?>) arrs[i];
			ExportFile.setSheet(wb, list, tableName.get(i));
		}
		filename = filename + ".xlsx";
		try {
			ExportFile.downFile(response, filename, wb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}
	
	@SuppressWarnings("unchecked")
	public static HSSFSheet setSheet(HSSFWorkbook wb ,List<?> list, Map<String, Object> map) {
		if(list.size() == 0) return null;
		HSSFSheet sheet = wb.createSheet(map.get("sheetName").toString());
		Map<String, Object> object = (Map<String, Object>) map.get("sheetVal");
		if(list.get(0) instanceof Map) {
			Set<String> set = object.keySet();
			int i = 1;
			int j = 0;
			HSSFRow row = sheet.createRow(0);
			for (String string : set) {
				HSSFCell cell = row.createCell(j++);
				cell.setCellValue(object.get(string).toString());
			}
			j = 0;
			for (Object o : list) {
				HSSFRow row1 = sheet.createRow(i++);
				for (String string : set) {
					Map<String, String> my = ((Map<String, String>) o);
					HSSFCell cell1 = row1.createCell(j++);
					if(my.get(string) == null) {
						cell1.setCellValue("-");
						continue;
					}
					cell1.setCellValue(String.valueOf(my.get(string)));
				}
				j = 0;
			}
		}
		return sheet;
	}
	
	/**
	 * 下载
	 * @param response
	 * @param filename
	 * @param wb
	 * @throws IOException
	 */
	public static void downFile(HttpServletResponse response, String filename, HSSFWorkbook wb) throws IOException {
		 String encode = URLEncoder.encode(filename, "UTF-8");
		 response.setContentType("application/octet-stream");
         response.setHeader("Content-disposition", "attachment;filename=" + encode);
         response.flushBuffer();
         wb.write(response.getOutputStream());
         wb.close();
	}
	
	
	
}
