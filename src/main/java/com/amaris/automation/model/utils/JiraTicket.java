package com.amaris.automation.model.utils;

public class JiraTicket {

	private String project;
	private String issueType;
	private String summary;
	private String priority;
	private String dueDate;
	private String components;
	private String versions;
	private String fixVersions;
	private String assignee;
	private String reporter;
	private String environment;
	private String description;
	private String linkType;
	private String linkId;

	public JiraTicket() {}

	public String getProject() {
		return project;
	}

	public String getIssueType() {
		return issueType;
	}

	public String getSummary() {
		return summary;
	}

	public String getPriority() {
		return priority;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getComponents() {
		return components;
	}

	public String getVersions() {
		return versions;
	}

	public String getFixVersions() {
		return fixVersions;
	}

	public String getAssignee() {
		return assignee;
	}

	public String getReporter() {
		return reporter;
	}

	public String getEnvironment() {
		return environment;
	}

	public String getDescription() {
		return description;
	}

	public String getLinkType() {
		return linkType;
	}

	public String getLinkIssues() {
		return linkId;
	}

	public JiraTicket setProject(String project) {
		this.project = project;

		return this;
	}

	public JiraTicket setIssueType(String issueType) {
		this.issueType = issueType;

		return this;
	}

	public JiraTicket setSummary(String summary) {
		this.summary = summary;

		return this;
	}

	public JiraTicket setPriority(String priority) {
		this.priority = priority;

		return this;
	}

	public JiraTicket setDueDate(String dueDate) {
		this.dueDate = dueDate;

		return this;
	}

	public JiraTicket setComponents(String components) {
		this.components = components;

		return this;
	}

	public JiraTicket setVersions(String versions) {
		this.versions = versions;

		return this;
	}

	public JiraTicket setFixVersions(String fixVersions) {
		this.fixVersions = fixVersions;

		return this;
	}

	public JiraTicket setAssignee(String assignee) {
		this.assignee = assignee;

		return this;
	}

	public JiraTicket setReporter(String reporter) {
		this.reporter = reporter;

		return this;
	}

	public JiraTicket setEnvironment(String environment) {
		this.environment = environment;

		return this;
	}

	public JiraTicket setDescription(String description) {
		this.description = description;

		return this;
	}

	public JiraTicket setLink(String linkType, String linkId) {
		this.linkType = linkType;
		this.linkId = linkId;

		return this;
	}

}
