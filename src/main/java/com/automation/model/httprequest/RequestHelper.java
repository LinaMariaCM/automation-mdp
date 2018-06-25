package com.automation.model.httprequest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.commons.lang3.StringEscapeUtils;

import com.automation.model.utils.ArrayUtils;

import javafx.util.Pair;

public class RequestHelper {

	private String url;
	private String body;
	private String responseBody;
	private String parameters = "";
	private String contentType = "";
	private String userAgent = "";
	private ArrayList<Pair<String, String>> headers = new ArrayList<Pair<String, String>>();
	private HttpURLConnection connection = null;

	public RequestHelper(String url) {
		this.url = url;
		HttpURLConnection.setFollowRedirects(false);
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setJsonContentType() {
		this.contentType = "application/json";
	}

	public void setURLEncodedContentType() {
		this.contentType = "application/x-www-form-urlencoded";
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getURL() {
		String url = null;

		if(connection != null && connection.getURL() != null) url = connection.getURL().toString();

		return url;
	}

	public RequestHelper setCookie(String value) {
		return addHeader("Cookie", value);
	}

	public RequestHelper addHeader(String key, String value) {
		headers.add(new Pair<String, String>(key, value));

		return this;
	}

	public RequestHelper addParameter(String key, String value) {
		try {
			if(parameters == null || parameters.isEmpty()) {
				parameters = URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8");
			} else {
				parameters += "&" + URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8");
			}
		} catch(Exception e) {}

		return this;
	}

	public RequestHelper setBody(String body) {
		this.body = body;

		return this;
	}

	public String[] getHeaders() {
		String[] headers = null;

		if(connection != null && connection.getHeaderFields() != null) {
			ArrayList<String> auxList = new ArrayList<String>();

			for(Object obj : connection.getHeaderFields().keySet()) {
				if(obj != null) {
					auxList.add(obj.toString());
				} else {}
			}

			headers = ArrayUtils.objetArrayToStringArray(auxList.toArray());
		}

		return headers;
	}

	public String getHeader(String key) {
		return connection.getHeaderField(key);
	}

	public String getCookie() {
		String cookie = null;
		String setCookieHeader = getHeader("Set-Cookie");

		if(setCookieHeader != null) {
			cookie = setCookieHeader.split(";")[0];
		}

		return cookie;
	}

	public String getBody() {
		return body;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public String getResponseMessage() {
		String result = null;

		try {
			result = connection.getResponseMessage();
		} catch(Exception e) {}

		return result;
	}

	public int getResponseCode() {
		int result = -1;

		try {
			result = connection.getResponseCode();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private String getResponse() {
		String result = null;
		BufferedReader in = null;

		try {
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line;
			StringBuilder content = new StringBuilder();

			while((line = in.readLine()) != null) {
				if(content.length() > 0) content.append(System.lineSeparator());
				content.append(line);
			}

			result = StringEscapeUtils.unescapeJava(content.toString());
		} catch(Exception e) {} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}

		return result;
	}

	private void setHeaders() {
		if(userAgent != null && !userAgent.isEmpty()) connection.setRequestProperty("User-Agent", userAgent);
		if(contentType != null && !contentType.isEmpty()) connection.setRequestProperty("Content-Type", contentType);

		for(Pair<String, String> header : headers) {
			connection.setRequestProperty(header.getKey(), header.getValue());
		}
	}

	private void setBody() {
		DataOutputStream wr = null;

		try {
			wr = new DataOutputStream(connection.getOutputStream());

			if(body != null && !body.isEmpty()) {
				wr.write(body.getBytes());
			}
		} catch(Exception e) {} finally {
			if(wr != null) {
				try {
					wr.close();
				} catch(Exception e) {}
			}
		}
	}

	public RequestHelper get() {
		doRequest("GET");

		return this;
	}

	public RequestHelper delete() {
		doRequest("DELETE");

		return this;
	}

	public RequestHelper post() {
		doRequest("POST");

		return this;
	}

	public RequestHelper put() {
		doRequest("PUT");

		return this;
	}

	private void doRequest(String requestMethod) {
		try {
			connection = (HttpURLConnection) new URL(this.url + (parameters.isEmpty() ? parameters : "?" + parameters)).openConnection();

			connection.setRequestMethod(requestMethod);
			setHeaders();

			switch(requestMethod) {
				case "POST":
				case "PUT":
				case "DELETE":
					connection.setDoOutput(true);
					setBody();
			}

			responseBody = getResponse();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
	}
}
