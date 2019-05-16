package com.jt.lawfirm.controller.anjian;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 * 批量导入
 * @author ASUS
 *
 */
@Controller
public class BulkLoadController {
	@RequiresPermissions(value= {"anjian:pldr","admin","test"},logical=Logical.OR)
	@RequestMapping("bulkLoad")
	public String bulkLoad() {
		return "anjian/bulkLoad";
	}
	
	//上传   /upload/bulkload
	@RequestMapping(value="bulkload",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object uploadBulkload(@RequestParam("file")CommonsMultipartFile partFile,
			HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println(path);
		//文件名字
		String originalFilename = partFile.getOriginalFilename();
		File file = new File(path+"/"+originalFilename);
		InputStream inputStream;
		try {
			inputStream = partFile.getInputStream();
			FileUtils.copyInputStreamToFile(inputStream, file);
			if (inputStream!=null) {
				inputStream.close();
			}
			return "0";
		} catch (IOException e) {
			e.printStackTrace();
			return "上传失败";
		}
	}
	
	/**
     * 文件下载
     * 单个文件下载
     * @param request
     * @return
     * @throws IOException 
     */
	@RequestMapping("/bulkDown")
    private void down(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String path = request.getServletContext().getRealPath("/upload");
        File file = new File(path);
        File[] files = file.listFiles();
        response.addHeader("content-disposition", "attachment;filename="+"CaseList.xls");
        FileUtils.copyFile(files[0], response.getOutputStream());
    }
}
