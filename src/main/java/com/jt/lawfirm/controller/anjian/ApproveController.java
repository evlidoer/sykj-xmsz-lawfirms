package com.jt.lawfirm.controller.anjian;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.lawfirm.bean.anjian.activiti.MyEndEvent;
import com.jt.lawfirm.bean.anjian.activiti.MySequenceFlow;
import com.jt.lawfirm.bean.anjian.activiti.MyStartEvent;
import com.jt.lawfirm.bean.anjian.activiti.MyUserTask;
import com.jt.lawfirm.service.anjian.ApproveService;
import com.jt.lawfirm.util.ActivitiUtils;
import com.jt.lawfirm.util.JSONUtils;
import com.jt.lawfirm.util.Myoc;



@Controller
public class ApproveController {
	@Resource(name="processEngine")
	private ProcessEngine processEngine;
	@Resource
	private ApproveService approveService;
	
	@RequestMapping("approve")
	@RequiresPermissions(value= {"anjian:splcm","admin","test"},logical=Logical.OR)
	public String approve() {
		return "anjian/approve";
	}
	
	
	@RequestMapping(value="approveShow")
	public Object approveShow() {
		return "anjian/approveShow";
	}
	
	@RequestMapping(value="ajaxapproveShow",method=RequestMethod.POST)
	@ResponseBody
	public Object ajaxapproveShow() {
		List<Map<String,Object>> list = approveService.approveShow();
		System.out.println(list);
		return list;
	}
	
	@RequestMapping(value="addLApprove",method=RequestMethod.POST)
	@ResponseBody
	public String addApprove(String userTask,String sequenceFlow,String name,String end) throws Exception  {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JavaType userTaskJavaType  = objectMapper.getTypeFactory().constructParametricType(List.class, MyUserTask.class);
		List<MyUserTask> userTaskValue = objectMapper.readValue(userTask, userTaskJavaType);
		
		JavaType sequenceFlowJavaType  = objectMapper.getTypeFactory().constructParametricType(List.class, MySequenceFlow.class);
		List<MySequenceFlow> sequenceFlowValue = objectMapper.readValue(sequenceFlow, sequenceFlowJavaType);
		
		 Map<String,Object> map = new HashMap<>();
	       
	       MyStartEvent startEvent = new MyStartEvent();
		       startEvent.setId("startEvent");
		       startEvent.setType("Start");
		   MyEndEvent endEvent = new MyEndEvent();
			   endEvent.setId("endEvent");
			   endEvent.setType("End");
			   
			   Map<String,Object> userTaskMap = new HashMap<>();
			for (int i = 0; i < userTaskValue.size(); i++) {
				
				userTaskMap.put("task"+(i+1), userTaskValue.get(i));
				 
			}
			 Map<String,Object> sequenceFlowMap = new HashMap<>();
			for (int i = 0; i < sequenceFlowValue.size(); i++) {
				
				sequenceFlowMap.put("sequenceFlow"+(i+1), sequenceFlowValue.get(i));
				 
			}
			//添加最后的节点连线
			MySequenceFlow sequenceFlowend = new MySequenceFlow();
			sequenceFlowend.setSourceRef("task"+end);
			sequenceFlowend.setTargetRef("endEvent");
			sequenceFlowMap.put("sequenceFlowend", sequenceFlowend);
	       List<Map<String,Object>> MyProcess = new ArrayList<Map<String,Object>>();
	      
	       map.put("id", name);
	       map.put("name", name);
	       map.put("startEvent", startEvent);
	       map.put("endEvent", endEvent);
	       map.put("userTask", userTaskMap);
	      map.put("sequenceFlow", sequenceFlowMap);
	       MyProcess.add(map);
	       System.out.println(MyProcess);
	      // String wirte = JSONUtils.wirte(MyProcess);
	       BpmnModel bm = ActivitiUtils.convertToBpmnModel(MyProcess);
	       
	       //new BpmnAutoLayout(bpmnModel).execute();
			BpmnXMLConverter bpmnXMLConverter=new BpmnXMLConverter();

			byte[] convertToXML= bpmnXMLConverter.convertToXML(bm);

			String bytes=new String(convertToXML);

			System.out.println(bytes);
			
			
			String PROCESSID = name;
			
			// 2. 生成图形信息 
					new BpmnAutoLayout(bm).execute();
					
					       // 3. 将流程部署到引擎  
					Deployment deployment = processEngine.getRepositoryService().createDeployment().addBpmnModel(PROCESSID+".bpmn", bm).name(PROCESSID+"_deployment").deploy();  
							   
							// 4. 启动流程实例  
							//ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(PROCESSID); 
							
							// 5. 检查任务是否可用  
							//List<Task> tasks = processEngine.getTaskService().createTaskQuery().processInstanceId(processInstance.getId()).list();
							//Assert.assertEquals(1, tasks.size()); 		
							
							// 6. 将流程图保存到文件中    
							//InputStream processDiagram = processEngine.getRepositoryService().getProcessDiagram(processInstance.getProcessDefinitionId());  
							//FileUtils.copyInputStreamToFile(processDiagram, new File("H:\\Workspaces_Eclipse_JAVA_EE02\\lawfirms\\src\\main\\resources\\"+PROCESSID+".png"));  
							   
							// 7.将生成的BPMN xml保存到一个文件中  
							//File file = new File("H:\\Workspaces_Eclipse_JAVA_EE02\\lawfirms\\src\\main\\resources\\"+PROCESSID+".bpmn");
							//InputStream processBpmn = processEngine.getRepositoryService().getResourceAsStream(deployment.getId(), PROCESSID+".bpmn");  
							//FileUtils.copyInputStreamToFile(processBpmn,file);
							//System.out.println(file.getAbsolutePath());
							//System.out.println(file.getPath());
					System.out.println(".........end...");
		
		return "1";
	}
	
	
	
	 @RequestMapping(value="showappimg/{id}",method = RequestMethod.GET)
	    public void getImages(@PathVariable("id")String id,HttpServletResponse response) throws IOException{
		 
		 RepositoryService repositoryService = processEngine.getRepositoryService();
	       			String imgName = null;
	 
	                //根据id去图片表获取数据
	            	List<String> deploymentResourceNames = repositoryService.getDeploymentResourceNames(id);
	            	
	            	for (String string : deploymentResourceNames) {
						
	            		if(string.indexOf(".png")>=0) {
	            			imgName = string;
	            		}
	            		
					}
	               
	          	InputStream in = repositoryService.getResourceAsStream(id, imgName);
	            	  byte[] b = new byte[1024];  
				        int len = -1;  
				        while((len = in.read(b, 0, 1024)) != -1) {  
				            response.getOutputStream().write(b, 0, len);  
				        } 
				        in.close();
	
	    }

}
