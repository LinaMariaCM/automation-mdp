package com.amaris.automation.model.utils;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.httprequest.RequestHelper;

public class JiraMessager {

	private static final String CREATE_TICKET_PATH = "/secure/QuickCreateIssue.jspa?decorator=none";
	private static final String LOGIN_PATH = "/login.jsp";
	private static final String NEW_TICKET_PATH = "/secure/QuickCreateIssue!default.jspa?decorator=none";
	private static final String UPDATE_ZEPHYR_TICKET_PATH = "/rest/zephyr/latest/execution/";

	private static final String PROJECT_KEY = "pid";
	private static final String ISSUE_TYPE_KEY = "issuetype";
	private static final String SUMMARY_KEY = "summary";
	private static final String PRIORITY_KEY = "priority";
	private static final String DUE_DATE_KEY = "duedate";
	private static final String COMPONENTS_KEY = "components";
	private static final String VERSIONS_KEY = "versions";
	private static final String FIX_VERSIONS_KEY = "fixVersions";
	private static final String ASSIGNEE_KEY = "asignee";
	private static final String REPORTER_KEY = "reporter";
	private static final String ENVIRONMENT_KEY = "reporter";
	private static final String DESCRIPTION_KEY = "description";
	private static final String ISSUE_LINKS_KEY = "issuelinks";
	private static final String LINK_TYPE_KEY = "issuelinks-linktype";
	private static final String LINK_ISSUES_KEY = "issuelinks-issues";

	private String user;
	private String pass;
	private String cookie;
	private String jiraToken;

	private String jiraUrl;

	public JiraMessager(String jiraUrl, String user, String pass) {
		this.user = user;
		this.pass = pass;
		this.jiraUrl = jiraUrl;
	}

	private void login() {
		if(cookie == null) {
			RequestHelper request = new RequestHelper(jiraUrl + LOGIN_PATH)
				.addHeader("Content-Type", "application/x-www-form-urlencoded");

			request.addFormParam("os_username", user);
			request.addFormParam("os_password", pass);

			request.post();

			cookie = request.getResponse().cookie("JSESSIONID");
			jiraToken = request.getResponse().cookie("atlassian.xsrf.token");

			boolean success = false;

			try {
				request.post();

				if(request.getStatusCode() == 201) {
					success = true;
				}
			} catch(Exception e) {}

			if(success) {
				cookie = request.getResponse().cookie("JSESSIONID");
				jiraToken = request.getResponse().cookie("atlassian.xsrf.token");
			} else {
				System.out.println("Error in Jira login");
			}
		}
	}

	private String getFormToken() {
		RequestHelper request = new RequestHelper(jiraUrl + NEW_TICKET_PATH)
			.addHeader("Cookie", cookie + "; " + jiraToken)
			.addHeader("X-AUSERNAME", user)
			.addHeader("X-Requested-With", "XMLHttpRequest");

		request.setResetAuth(true);
		request.setResetRequest(true);

		request.post();

		String result = null;

		try {
			request.post();

			if(request.getStatusCode() == 201) {
				result = request.getResponse().jsonPath().getString("formToken");
			}
		} catch(Exception e) {}

		return result;
	}

	public void updateZephyrTicket(String id, String status) {
		login();
		id = id.charAt(id.length() - 1) + "";

		// Refactor to get zephyr test id and execution id
		switch(id) {
			case "6":
				id = "48";
				break;
			case "5":
				id = "47";
				break;
			case "4":
				id = "46";
				break;
			case "3":
				id = "45";
				break;
			case "2":
				id = "44";
				break;
			case "1":
				id = "43";
				break;
			default:
		}
		//////////////////////////////////////////////

		RequestHelper request = new RequestHelper(jiraUrl + UPDATE_ZEPHYR_TICKET_PATH + id + "/execute")
			.addHeader("Content-Type", "application/json")
			.addHeader("AO-7DEABF", "Sw6hW4Hoh1k630O+69Fb6wMS+WYa3+kQxWPOpkbHqMaeKNaAinNezp3u8KWZIHL3EMTaaj95eOQCwwQudbkZlw==")
			.addHeader("Cookie", "jira.editor.user.mode=wysiwyg; JSESSIONID=" + cookie + "; atlassian.xsrf.token=" + jiraToken)
			.addHeader("X-AUSERNAME", user)
			.addHeader("X-Requested-With", "XMLHttpRequest");

		int code = -1;

		switch(status) {
			case AutomationConstants.SUCCESS_ZEPHYR:
				code = 1;
				break;
			case AutomationConstants.FAILURE_ZEPHYR:
				code = 2;
				break;
			case AutomationConstants.NOT_EXECUTED_ZEPHYR:
				code = -1;
				break;
			default:
		}

		request.getRequestBuilder().setBody("{\"status\": \"" + code + "\", \"changeAssignee\": false}");

		request.setResetAuth(true);
		request.setResetRequest(true);

		try {
			request.put();
		} catch(Exception e) {}
	}

	public void sendTicket(JiraTicket ticket) {
		login();

		RequestHelper request = new RequestHelper(jiraUrl + CREATE_TICKET_PATH);

		if(ticket != null) {
			request.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.addHeader("Cookie", "JSESSIONID=" + cookie + "; atlassian.xsrf.token=" + jiraToken)
				.addHeader("X-AUSERNAME", user)
				.addHeader("X-Requested-With", "XMLHttpRequest")
				.addFormParam("atl_token", jiraToken)
				.addFormParam("formToken", getFormToken());

			if(ticket.getProject() != null) {
				request.addFormParam(PROJECT_KEY, ticket.getProject());
			}

			if(ticket.getIssueType() != null) {
				request.addFormParam(ISSUE_TYPE_KEY, ticket.getIssueType());
			}

			if(ticket.getSummary() != null) {
				request.addFormParam(SUMMARY_KEY, ticket.getSummary());
			}

			if(ticket.getPriority() != null) {
				request.addFormParam(PRIORITY_KEY, ticket.getPriority());
			}

			if(ticket.getDueDate() != null) {
				request.addFormParam(DUE_DATE_KEY, ticket.getDueDate());
			}

			if(ticket.getComponents() != null) {
				request.addFormParam(COMPONENTS_KEY, ticket.getComponents());
			}

			if(ticket.getVersions() != null) {
				request.addFormParam(VERSIONS_KEY, ticket.getVersions());
			}

			if(ticket.getFixVersions() != null) {
				request.addFormParam(FIX_VERSIONS_KEY, ticket.getFixVersions());
			}

			if(ticket.getAssignee() != null) {
				request.addFormParam(ASSIGNEE_KEY, ticket.getAssignee());
			}

			if(ticket.getReporter() != null) {
				request.addFormParam(REPORTER_KEY, ticket.getReporter());
			}

			if(ticket.getEnvironment() != null) {
				request.addFormParam(ENVIRONMENT_KEY, ticket.getEnvironment());
			}

			if(ticket.getDescription() != null) {
				request.addFormParam(DESCRIPTION_KEY, ticket.getDescription());
			}

			if(ticket.getLinkType() != null && !ticket.getLinkType().equals("blocks")) {
				request.addFormParam(ISSUE_LINKS_KEY, ISSUE_LINKS_KEY);
				request.addFormParam(LINK_TYPE_KEY, ticket.getLinkType());
				request.addFormParam(LINK_ISSUES_KEY, ticket.getLinkIssues());
			}

			request.setResetAuth(true);
			request.setResetRequest(true);

			boolean success = false;

			try {
				request.post();

				if(request.getStatusCode() == 200) {
					success = true;
				}
			} catch(Exception e) {}

			if(success) {
				System.out.println("Jira ticket created correctly");
			} else {
				System.out.println("Jira ticket was not created");
			}
		}
	}
}
