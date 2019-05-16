package com.jt.lawfirm.bean.anjian.activiti;

public class MyLines {
	private MySequenceFlow sequenceFlow1; //sequenceFlow对应用户任务节点
	private MySequenceFlow sequenceFlow2;
	private MySequenceFlow sequenceFlow3;
	public MyLines() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyLines(MySequenceFlow sequenceFlow1, MySequenceFlow sequenceFlow2, MySequenceFlow sequenceFlow3) {
		super();
		this.sequenceFlow1 = sequenceFlow1;
		this.sequenceFlow2 = sequenceFlow2;
		this.sequenceFlow3 = sequenceFlow3;
	}
	@Override
	public String toString() {
		return "MyLines [sequenceFlow1=" + sequenceFlow1 + ", sequenceFlow2=" + sequenceFlow2 + ", sequenceFlow3="
				+ sequenceFlow3 + "]";
	}
	public MySequenceFlow getSequenceFlow1() {
		return sequenceFlow1;
	}
	public void setSequenceFlow1(MySequenceFlow sequenceFlow1) {
		this.sequenceFlow1 = sequenceFlow1;
	}
	public MySequenceFlow getSequenceFlow2() {
		return sequenceFlow2;
	}
	public void setSequenceFlow2(MySequenceFlow sequenceFlow2) {
		this.sequenceFlow2 = sequenceFlow2;
	}
	public MySequenceFlow getSequenceFlow3() {
		return sequenceFlow3;
	}
	public void setSequenceFlow3(MySequenceFlow sequenceFlow3) {
		this.sequenceFlow3 = sequenceFlow3;
	}
}
