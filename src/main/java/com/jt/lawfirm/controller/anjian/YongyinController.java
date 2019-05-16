package com.jt.lawfirm.controller.anjian;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jt.lawfirm.bean.casea.CaseSealApplyfor;
import com.jt.lawfirm.service.anjian.YongYinService;
import com.jt.lawfirm.util.Myoc;


 
@Controller
public class YongyinController {
	
	@Resource
	private  YongYinService yongyinService;
//	
	@RequiresPermissions(value= {"anjian:yysq","admin","test"},logical=Logical.OR)
	@RequestMapping(value="yongyin1")
	public String Yongyin() {
		return "anjian/yongyin1";
	}
	
	
	//接收多个上传的文件
	@RequestMapping(value="upload/{time}",method=RequestMethod.POST)
	@ResponseBody
	public Object gread(@RequestParam("file")CommonsMultipartFile[] partFiles,
			HttpServletRequest request
					) throws IOException {
		
		InputStream inputStream = null;    
        try {
            String path = request.getServletContext().getRealPath("/upload");
            System.out.println(path);
            String name = request.getParameter("name");
//          "其他的参数{}",name);
//            "upload2---------------start---------------------");
//            "这个临时文件的路径是[{}]", path);
            for (int i = 0; i < partFiles.length; i++) {
                String filename = partFiles[i].getOriginalFilename();
               // log.info("文件的名字：{}",filename);
                File file = new File(path+"/"+filename);
                inputStream = partFiles[i].getInputStream();
                FileUtils.copyInputStreamToFile(inputStream, file);
            }
            if(inputStream!=null){
                inputStream.close();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传失败！";
        } 
	}
	
	
	
	
			//yongyin添加	文书表CaseSealApplyfor
	
			@RequestMapping(value="addCaseSealApplyfor",method=RequestMethod.POST)
			@ResponseBody
			public String addCaseSealApplyfor(CaseSealApplyfor cs,HttpServletRequest request,String case_law_id) {
				int year = LocalDate.now().getYear();
				String user = (String) request.getSession().getAttribute("userName");
					int count =  (int)(Math.random()*1000);
					//在前面补0
					 DecimalFormat df=new DecimalFormat("0000");
				     String str2=df.format(count);
					cs.setSanum("("+year+")"+"巨天民第"+str2+"号");
					
					cs.setCase_law_id(Integer.parseInt(case_law_id));
					cs.setApplyforApprovalStatus("未审批");
					
					cs.setApplyforRecipient(user);
					
					System.out.println(cs.toString());
					boolean boo = yongyinService.addCaseSealApplyfor(cs);
					return boo?"true":"false";
			}
	
	
	//自动申请
	@RequestMapping(value="yongyin2")
	public String Yongyin2() {
		
		return "anjian/yongyin2";
	}		
	
	
	//自动申请
		@RequestMapping(value="yongyin3")
		public String Yongyin3() {
			
			return "anjian/yongyin3";
		}	
		
		
		
		//删除  delCaseSealApplyfor      yongyin3
		@RequestMapping(value="delCaseSealApplyfor/{id}")
		@ResponseBody
		public Object delCaseSealApplyfor(@PathVariable("id")Integer id) {
			boolean boo = yongyinService.delCaseSealApplyfor(id);
			return boo;
		}	
}
