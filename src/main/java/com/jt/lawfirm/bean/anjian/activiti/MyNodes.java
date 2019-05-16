package com.jt.lawfirm.bean.anjian.activiti;

public class MyNodes {
	private MyStartEvent startEvent; //startEvent对应开始节点；
	
	private MyUserTask task1; //userTask对应用户任务节点；
	private MyUserTask task2;
	private MyEndEvent endEvent;//	 endEvent对应结束节点；
	public MyNodes() {
		super();
	}
	public MyNodes(MyStartEvent startEvent, MyUserTask task1, MyUserTask task2, MyEndEvent endEvent) {
		super();
		this.startEvent = startEvent;
		this.task1 = task1;
		this.task2 = task2;
		this.endEvent = endEvent;
	}
	@Override
	public String toString() {
		return "MyNodes [startEvent=" + startEvent + ", task1=" + task1 + ", task2=" + task2 + ", endEvent=" + endEvent
				+ "]";
	}
	public MyStartEvent getStartEvent() {
		return startEvent;
	}
	public void setStartEvent(MyStartEvent startEvent) {
		this.startEvent = startEvent;
	}
	public MyUserTask getTask1() { return task1; }
	public void setTask1(MyUserTask task1) { this.task1 = task1; }
	public MyUserTask getTask2() {
		return task2;
	}
	public void setTask2(MyUserTask task2) {
		this.task2 = task2;
	}
	public MyEndEvent getEndEvent() {
		return endEvent;
	}
	public void setEndEvent(MyEndEvent endEvent) {
		this.endEvent = endEvent;
	}

}
