package com.amaris.automation.model.utils.objects;

import java.util.ArrayList;
import java.util.List;

public class StringNode {
	
	private String id = "";
	private String content;
	private StringNode parentNode = null;
	private ArrayList<StringNode> children = new ArrayList<>();

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
	
	public StringNode getParent() {		
		return parentNode;
	}
	
	public int getLevel() {		
		return this.parentNode == null ? 0 : this.parentNode.getLevel() + 1;
	}
	
	public List<StringNode> getChilds() {		
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
