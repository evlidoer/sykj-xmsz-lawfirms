package com.jt.lawfirm.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.XMLStreamException;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.FieldExtension;


import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.ServiceTask;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
public class ActivitiUtils {
	
	public static BpmnModel convertToBpmnModel(List<Map<String,Object>> MyProcess) throws XMLStreamException{
		 //创建流程对象
		 Process process=new Process();
		 String name = null;
		 String id = null; 
		 System.out.println(MyProcess);
		for (Map<String, Object> map : MyProcess) {
			 name = (String) map.get("name");
			 id = (String) map.get("id");
			 
		}
		 process.setName(name);
		 process.setId(id);
		
		 BpmnModel bm=new BpmnModel();
		
		 		 //创建节点对象
		 String startNodeId="";
		 
		 for (Map<String, Object> map : MyProcess) {
			//得到线条
			Map<String, Object> sequenceFlowMap = (Map<String, Object>) map.get("sequenceFlow");
			Set<String> sequenceFlowKey = sequenceFlowMap.keySet();
			
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				if(key.equals("startEvent")) {
					process.addFlowElement(createStartEvent());
					 startNodeId=key;
				}else if(key.equals("endEvent")) {
					process.addFlowElement(createEndEvent());
					 startNodeId=String.valueOf(key);
				}else if(key.equals("userTask")) {
					Map<String, Object> userTaskMap = (Map<String, Object>) map.get(key);
					
					
						Set<String> userTaskkey = userTaskMap.keySet();
						for (String userTaskkeyValue : userTaskkey) {
							JSONObject JsonObject = JSON.parseObject(JSONUtils.wirte(userTaskMap.get(userTaskkeyValue)));
							String userid = (String) JsonObject.get("id");
							String userName = (String) JsonObject.get("name");
							System.out.println(userid);
							process.addFlowElement(createUserTask(userid, userName,"")); 
							
							startNodeId=String.valueOf(userid);
							//循环线条
							for (String sequenceFlowValue : sequenceFlowKey) {
								JSONObject sequenceFlowJsonObject = JSON.parseObject(JSONUtils.wirte(sequenceFlowMap.get(sequenceFlowValue)));
								String sourceRef = (String) sequenceFlowJsonObject.get("sourceRef");
								String targetRef = (String) sequenceFlowJsonObject.get("targetRef");
								
								if(targetRef.equals(startNodeId)) {
									process.addFlowElement(createSequenceFlow(sourceRef,targetRef, "", "")); 
									continue;
								}
								if(!sourceRef.equals(startNodeId)){
									continue;
								}
								
								startNodeId="";
									
								process.addFlowElement(createSequenceFlow(sourceRef,targetRef, "", "")); 
							}
						}
						
					
				}
				
				
					//循环线条
					for (String sequenceFlowValue : sequenceFlowKey) {
						JSONObject JsonObject = JSON.parseObject(JSONUtils.wirte(sequenceFlowMap.get(sequenceFlowValue)));
						String sourceRef = (String) JsonObject.get("sourceRef");
						String targetRef = (String) JsonObject.get("targetRef");
						if(!sourceRef.equals(startNodeId)){
							continue;
						}
						if(targetRef.equals("endEvent")){
							process.addFlowElement(createSequenceFlow(sourceRef,targetRef, "", "")); 
							continue;
						}
						startNodeId="";
						process.addFlowElement(createSequenceFlow(sourceRef,targetRef, "", "")); 
					}
			}
		}
		
		 	bm.addProcess(process);
		 	return bm;
	}
	

	//连线
	protected static SequenceFlow createSequenceFlow(String from, String to,String name,String conditionExpression) {
		SequenceFlow flow = new SequenceFlow();
		flow.setSourceRef(from);
		flow.setTargetRef(to);
		flow.setName(name);
		if(StringUtils.isNotEmpty(conditionExpression)){
			flow.setConditionExpression(conditionExpression);
		}		
		return flow;
	}
	
	
	/*任务节点*/
	protected static UserTask createUserTask(String id, String name, String candidateGroup) {
		List<String> candidateGroups=new ArrayList<String>();
		candidateGroups.add(candidateGroup);
		UserTask userTask = new UserTask();
		userTask.setName(name);
		userTask.setId(id);
		userTask.setCandidateGroups(candidateGroups);
		return userTask;
	}
	/*开始节点*/
	protected static StartEvent createStartEvent() {
		StartEvent startEvent = new StartEvent();
		startEvent.setId("startEvent");
		return startEvent;
	}
	/*结束节点*/
	protected static EndEvent createEndEvent() {
		EndEvent endEvent = new EndEvent();
		endEvent.setId("endEvent");
		return endEvent;
	}
}
