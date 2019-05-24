package com.amaris.automation.model.utils.objects;

import java.util.ArrayList;
import java.util.List;

import com.amaris.automation.model.utils.ArrayUtils;

/**
 * The HtmlElement class is a node structure containing elements that a HTML element contains, like tag, attributes and
 * content, this class is used to construct an HTML page by nodes and then it is printed in a recursive way to generate
 * the HTML using the method toString()
 *
 * @author Alfredo Moises Boullosa Ramones
 */
public class HtmlElement {

	private String tag;
	private String id = "";
	private String attributes = "";
	private String content = "";
	private HtmlElement parentNode = null;
	private List<HtmlElement> children = new ArrayList<>();
	private static String[] notFinishingTags = new String[]{ "br", "hr"};

	public HtmlElement(String tag) {
		this.tag = tag;
	}

	public HtmlElement(String tag, String attributes) {
		this.tag = tag;
		this.attributes = attributes;
	}

	public HtmlElement(String tag, String attributes, String content) {
		this.tag = tag;
		this.attributes = attributes;
		this.content = content;
	}

	public HtmlElement(String tag, HtmlElement parentNode) {
		this.tag = tag;
		this.parentNode = parentNode;
	}

	public HtmlElement(String tag, String attributes, HtmlElement parentNode) {
		this.tag = tag;
		this.attributes = attributes;
		this.parentNode = parentNode;
	}

	public HtmlElement(String tag, String attributes, String content, HtmlElement parentNode) {
		this.tag = tag;
		this.attributes = attributes;
		this.content = content;
		this.parentNode = parentNode;
	}

	// region Html element methods
	public String getTag() {
		return tag;
	}

	public String getAttributes() {
		return attributes;
	}

	public String getAttribute(String attribute) {
		String value = "";

		if(attributes.contains(attribute)) {
			int index = attributes.indexOf(attribute) + attribute.length();

			if(index < attributes.length() && attributes.charAt(index) == '=') {
				value = attributes.substring(index + 1);
				char characterToSearch = ' ';

				if(value.charAt(0) == '"') {
					characterToSearch = '"';
				} else if(value.charAt(0) == '\'') {
					characterToSearch = '\'';
				}

				if(characterToSearch != ' ') {
					value = value.substring(1);
				}

				while(index < value.length() && value.charAt(index) != characterToSearch) {
					index++;
				}

				value = value.substring(0, index);
			}
		}

		return value;
	}

	public String getContent() {
		return content;
	}

	public HtmlElement setTag(String tag) {
		this.tag = tag;

		return this;
	}

	public HtmlElement setAttributes(String attributes) {
		this.attributes = attributes;

		return this;
	}

	public HtmlElement addAttribute(String attribute, String value) {
		this.attributes += (attributes.isEmpty() ? "" : " ") + attribute + "=\"" + value + "\"";

		return this;
	}

	public HtmlElement removeAttribute(String attribute) {
		int initialIndex = attributes.indexOf(attribute);
		int finalIndex = initialIndex + attribute.length();

		if(attributes.contains(attribute) && finalIndex < attributes.length() && attributes.charAt(finalIndex) == '=') {

			char characterToSearch = ' ';

			if(attributes.charAt(finalIndex + 1) == '"') {
				characterToSearch = '"';
			} else if(attributes.charAt(finalIndex + 1) == '\'') {
				characterToSearch = '\'';
			}

			if(characterToSearch != ' ') {
				finalIndex += 2;
			}

			while(finalIndex < attributes.length() && attributes.charAt(finalIndex) != characterToSearch) {
				finalIndex++;
			}

			if(attributes.length() != finalIndex) finalIndex++;

			attributes = attributes.substring(0, initialIndex) + attributes.substring(finalIndex);
		}

		return this;
	}

	public HtmlElement setAttribute(String attribute, String value) {
		removeAttribute(attribute);
		addAttribute(attribute, value);

		return this;
	}

	public HtmlElement addStyle(String value) {
		String style = "style=\"";
		if(attributes.contains(style)) {
			for(int i = 0; i < attributes.length(); i++) {
				if(i - style.length() >= 0 && attributes.substring(i - style.length(), i).equals(style)) {
					String styleContent = attributes.substring(i);
					styleContent = styleContent.substring(0, styleContent.indexOf('"'));

					attributes = attributes.replace(styleContent, styleContent + " " + value);
				}
			}
		} else {
			addAttribute("style", value);
		}

		return this;
	}

	public HtmlElement setContent(String content) {
		this.content = content;

		return this;
	}
	// endregion

	// region Node methods
	public String getId() {
		return id;
	}

	public HtmlElement getParent() {
		return parentNode;
	}

	public int getLevel() {
		return this.parentNode == null ? 0 : this.parentNode.getLevel() + 1;
	}

	public List<HtmlElement> getChildren() {
		return children;
	}

	public HtmlElement setId(String newId) {
		this.id = newId;

		return this;
	}

	public HtmlElement setParent(HtmlElement parent) {
		this.parentNode = parent;

		return this;
	}

	public HtmlElement getChild(int index) {
		return children.get(index);
	}

	public HtmlElement getChildByTag(String tag) {
		return getChildByTag(tag, 0);
	}

	public HtmlElement getChildByTag(String tag, int nth) {
		int currentIndex = 0;
		HtmlElement child = null;

		for(int i = 0; i < children.size(); i++) {
			if(children.get(i).getTag().equals(tag)) {
				if(currentIndex == nth) {
					child = children.get(i);
				}

				currentIndex++;
			}
		}

		return child;
	}

	public HtmlElement addChild(String tag) {
		return addChild(tag, "", "");
	}

	public HtmlElement addChild(String tag, String attribute) {
		return addChild(tag, attribute, "");
	}

	public HtmlElement addChild(String tag, String attribute, String content) {
		HtmlElement element = new HtmlElement(tag, attribute, content);
		children.add(element);
		element.setParent(this);

		return this;
	}

	public HtmlElement addChild(HtmlElement child) {
		children.add(child);
		child.setParent(this);

		return this;
	}

	public HtmlElement addChildAt(HtmlElement child, int index) {
		if(index < 0) {
			index = children.size() + index + 1;
		}

		children.add(index, child);
		child.setParent(this);

		return this;
	}

	public HtmlElement removeChild(HtmlElement child) {
		children.remove(child);

		return this;
	}

	public HtmlElement removeChildAt(int index) {
		if(index < 0) {
			index = children.size() - index;
		}

		children.remove(index);

		return this;
	}

	public HtmlElement cloneNode() {
		HtmlElement clonedNode = new HtmlElement(tag, attributes, content);

		for(int i = 0; i < this.children.size(); i++) {
			clonedNode.addChild(children.get(i).cloneNode());
		}

		return clonedNode;
	}

	public String toString() {
		StringBuilder tab = new StringBuilder();
		StringBuilder htmlText = new StringBuilder();

		for(int i = 0; i < getLevel(); i++) {
			tab.append("\t");
		}

		if(getTag().isEmpty()) {
			htmlText.append(getContent());
		} else {
			htmlText.append(tab.toString() + "<" + (getTag() + " " + getAttributes()).trim() + ">"
				+ ((!getContent().isEmpty() || !getChildren().isEmpty()) && !getTag().equals("pre") ? "\n\t" + tab.toString() : "") + getContent());
		}

		for(int i = 0; i < getChildren().size(); i++) {
			htmlText.append("\n" + getChildren().get(i).toString());
		}

		if(!getTag().isEmpty() && !ArrayUtils.stringInArray(notFinishingTags, getTag())) {
			htmlText.append(((!getContent().isEmpty() || !getChildren().isEmpty()) && !getTag().equals("pre") ? "\n" + tab.toString() : "") + "</" + getTag() + ">");
		}

		return htmlText.toString();
	}
	// endregion
}
