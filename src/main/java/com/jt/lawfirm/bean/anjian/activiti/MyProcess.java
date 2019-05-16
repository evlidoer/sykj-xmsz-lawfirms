package com.jt.lawfirm.bean.anjian.activiti;

/**
 * 			Process	具体的流程定义
 * @author ASUS
 *
 */
public class MyProcess {
	
	private String id;// <process id="myProcess" name="My process" isExecutable="true">
	private String name;
	private String isExecutable;
	
	private MyNodes nodes;
	
	private MyLines lines;
	
	public MyLines getLines() {
		return lines;
	}

	public void setLines(MyLines lines) {
		this.lines = lines;
	}

	public MyProcess(String id, String name, String isExecutable, MyNodes nodes, MyLines lines) {
		super();
		this.id = id;
		this.name = name;
		this.isExecutable = isExecutable;
		this.nodes = nodes;
		this.lines = lines;
	}

	public MyProcess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyProcess(String id, String name, String isExecutable, MyNodes nodes) {
		super();
		this.id = id;
		this.name = name;
		this.isExecutable = isExecutable;
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return "MyProcess [id=" + id + ", name=" + name + ", isExecutable=" + isExecutable + ", nodes=" + nodes
				+ ", lines=" + lines + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsExecutable() {
		return isExecutable;
	}

	public void setIsExecutable(String isExecutable) {
		this.isExecutable = isExecutable;
	}

	public MyNodes getNodes() {
		return nodes;
	}

	public void setNodes(MyNodes nodes) {
		this.nodes = nodes;
	}
}
