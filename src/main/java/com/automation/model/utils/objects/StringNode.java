package com.automation.model.utils.objects;

import java.util.ArrayList;

public class StringNode {
	
	private String id = "";
	private String content;
	private StringNode parentNode = null;
	private ArrayList<StringNode> children = new ArrayList<StringNode>();

	public StringNode(String content) {
		this.content = content;
	}

	public StringNode(String content, StringNode parentNode) {
		this.content = content;
		this.parentNode = parentNode;
	}
	
	public String getId() {		
		return id;
	}
	
	public String getContent() {		
		return content;
	}
	
	public String getParent() {		
		return content;
	}
	
	public int getLevel() {		
		return this.parentNode == null ? 0 : this.parentNode.getLevel() + 1;
	}
	
	public ArrayList<StringNode> getChilds() {		
		return children;
	}
	
	public StringNode setId(String newId) {
		this.id = newId;
		
		return this;
	}
	
	public StringNode setContent(String content) {
		this.content = content;
		
		return this;
	}
	
	public StringNode setParent(StringNode parent) {
		this.parentNode = parent;
		
		return this;
	}
	
	public StringNode addNodeChild(StringNode child) {
		children.add(child);
		child.setParent(this);
		
		return this;
	}
	
	public StringNode addNodeChild(String content) {
		children.add(new StringNode(content, this));
		
		return this;
	}
	
	public StringNode cloneNode() {
		StringNode clonedNode = new StringNode(content);
		
		for(int i = 0; i < this.children.size(); i++) {
			clonedNode.addNodeChild(children.get(i).cloneNode());
		}
		
		return clonedNode;
	}
}
