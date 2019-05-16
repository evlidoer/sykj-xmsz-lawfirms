package com.jt.lawfirm.bean.anjian.activiti;

public class MySequenceFlow {
	private String id;
	private String sourceRef; //from
	private String targetRef;//to
	private String conditionExpression;//expression
	private String name;
	
	private String sourceRefXY;
	private String targetRefXY;
	
	private String type;
	
	
	
	public String getConditionExpression() {
		return conditionExpression;
	}
	public void setConditionExpression(String conditionExpression) {
		this.conditionExpression = conditionExpression;
	}
	public String getSourceRefXY() {
		return sourceRefXY;
	}
	public void setSourceRefXY(String sourceRefXY) {
		this.sourceRefXY = sourceRefXY;
	}
	public String getTargetRefXY() {
		return targetRefXY;
	}
	public void setTargetRefXY(String targetRefXY) {
		this.targetRefXY = targetRefXY;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MySequenceFlow() {
		super();
	}
	public MySequenceFlow(String id, String sourceRef, String targetRef) {
		super();
		this.id = id;
		this.sourceRef = sourceRef;
		this.targetRef = targetRef;
	}
	@Override
	public String toString() {
		return "MySequenceFlow [id=" + id + ", sourceRef=" + sourceRef + ", targetRef=" + targetRef + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSourceRef() {
		return sourceRef;
	}
	public void setSourceRef(String sourceRef) {
		this.sourceRef = sourceRef;
	}
	public String getTargetRef() {
		return targetRef;
	}
	public void setTargetRef(String targetRef) {
		this.targetRef = targetRef;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
