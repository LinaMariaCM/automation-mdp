package com.amaris.automation.model.httprequest;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.NoAuthScheme;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;

public class RequestHelper {

	private String proxyHost = null;
	private int proxyPort = 0;
	private String basePath = "";
	private String baseURI = "http://localhost";
	private Response response = null;
	private boolean useProxy = false;
	private boolean resetAuth = false;
	private boolean uriDefined = false;
	private boolean pathDefined = false;
	private boolean resetRequest = true;
	private RestAssuredConfig restAssuredConfig = RestAssured.config();
	private AuthenticationScheme authentication = new NoAuthScheme();
	private RequestSpecBuilder requestBuilder = new RequestSpecBuilder();

	public RequestHelper() {
		appendDefaultCharset(false);
	}

	public RequestHelper(String baseURI) {
		setBaseURI(baseURI);
		appendDefaultCharset(false);
	}

	public RequestHelper setResetAuth(boolean value) {
		resetAuth = value;

		return this;
	}

	public RequestHelper setResetRequest(boolean value) {
		resetRequest = value;

		return this;
	}

	public static void resetRequestSpecification() {
		RestAssured.requestSpecification = null;
	}

	public RequestHelper resetRequest() {
		resetRequestSpecification();
		requestBuilder = new RequestSpecBuilder();

		return this;
	}

	public RequestHelper resetAuth() {
		authentication = new NoAuthScheme();

		return this;
	}

	public RequestHelper addParam(String paramKey, String paramValue) {
		requestBuilder.addParam(paramKey, paramValue);

		return this;
	}

	public RequestHelper addFormParam(String paramKey, String paramValue) {
		requestBuilder.addFormParam(paramKey, paramValue);

		return this;
	}

	public RequestHelper addPathParam(String paramKey, String paramValue) {
		requestBuilder.addPathParam(paramKey, paramValue);

		return this;
	}

	public RequestHelper addQueryParam(String paramKey, String paramValue) {
		requestBuilder.addQueryParam(paramKey, paramValue);

		return this;
	}

	public RequestHelper addHeader(String headerKey, String headerValue) {
		requestBuilder.addHeader(headerKey, headerValue);

		return this;
	}

	public RequestHelper addCookie(String cookieName, String cookieValue) {
		requestBuilder.addCookie(cookieName, cookieValue);

		return this;
	}

	public RequestHelper addCookies(Map<String, String> cookies) {
		for(Map.Entry<String, String> cookie : cookies.entrySet()) {
			addCookie(cookie.getKey(), cookie.getValue());
		}

		return this;
	}
	
	public RequestHelper followRedirects(boolean value) {
		restAssuredConfig = restAssuredConfig.redirect(RedirectConfig.redirectConfig().followRedirects(value));
		
		return this;
	}
	
	public RequestHelper appendDefaultCharset(boolean value) {
		restAssuredConfig = restAssuredConfig.encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(value));
		
		return this;
	}
	
	public RequestHelper setRelaxedHTTPSValidation() {
		RestAssured.useRelaxedHTTPSValidation();
		
		return this;
	}

	public String getURI() {
		String resutlUri = "";

		resutlUri += uriDefined ? baseURI : RestAssured.baseURI;
		resutlUri += pathDefined ? basePath : RestAssured.basePath;

		return resutlUri;
	}

	public RequestSpecBuilder getRequestBuilder() {
		return requestBuilder;
	}

	public int getStatusCode() {
		return response.getStatusCode();
	}

	public String getResponseMessage() {
		return response.getStatusLine();
	}

	public Response getResponse() {
		return response;
	}

	public JsonPath getResponseAsJson() {
		return response.jsonPath();
	}

	public String getResponseAsString() {
		return response.asString();
	}

	public XmlPath getResponseAsHtml() {
		return response.htmlPath();
	}

	public XmlPath getResponseAsXml() {
		return response.xmlPath();
	}

	public RequestHelper setBaseURI(String baseURI) {
		this.baseURI = baseURI;
		uriDefined = true;

		return this;
	}

	public RequestHelper setBasePath(String basePath) {
		this.basePath = basePath;
		pathDefined = true;

		return this;
	}

	public RequestHelper setAuth(AuthenticationScheme authentication) {
		this.authentication = authentication;

		return this;
	}

	public RequestHelper setProxy(int port) {
		proxyPort = port;

		return this;
	}

	public RequestHelper setProxy(String host, int port) {
		RestAssured.proxy(host, port);

		return this;
	}

	public RequestHelper setProxy(ProxySpecification proxySpecification) {
		RestAssured.proxy(proxySpecification);

		return this;
	}

	public RequestHelper setSendFile(String fileName, String fileType, String text) {
		return setSendFile("file", fileName, fileType, text);
	}

	public RequestHelper setSendFile(String name, String fileName, String fileType, String text) {
		MultiPartSpecBuilder multipart = new MultiPartSpecBuilder(text)
			.header("Content-Disposition", "form-data; name=\"" + name + "\"; filename=\"" + fileName + "\"")
			.header("Content-Type", fileType);

		requestBuilder.addMultiPart(multipart.build());

		return this;
	}

	public Response get() {
		return get("");
	}

	public Response get(String uri) {
		return sendRequest("GET", uri);
	}

	public Response post() {
		return post("");
	}

	public Response post(String uri) {
		return sendRequest("POST", uri);
	}

	public Response put() {
		return put("");
	}

	public Response put(String uri) {
		return sendRequest("PUT", uri);
	}

	public Response delete() {
		return delete("");
	}

	public Response delete(String uri) {
		return sendRequest("DELETE", uri);
	}

	public Response patch() {
		return patch("");
	}

	public Response patch(String uri) {
		return sendRequest("PATCH", uri);
	}

	private static void setStaticRequestSpec(RequestSpecification specification) {
		RestAssured.requestSpecification = specification;
	}

	private void setProxy() {
		if(useProxy && proxyHost != null) {
			RestAssured.proxy(proxyHost, proxyPort);
		} else if(useProxy) {
			RestAssured.proxy(proxyPort);
		}
	}

	private Response sendRequest(String requestType, String uri) {
		if(uriDefined) {
			requestBuilder.setBaseUri(baseURI);
		}

		if(pathDefined) {
			requestBuilder.setBasePath(basePath);
		}

		requestBuilder.setConfig(restAssuredConfig);
		
		requestBuilder.setAuth(authentication);
		setStaticRequestSpec(requestBuilder.build());

		setProxy();

		switch(requestType) {
			case "GET":
				response = RestAssured.get(uri);
				break;
			case "POST":
				response = RestAssured.post(uri);
				break;
			case "PUT":
				response = RestAssured.put(uri);
				break;
			case "DELETE":
				response = RestAssured.delete(uri);
				break;
			case "PATCH":
				response = RestAssured.patch(uri);
				break;
			default:
		}

		if(resetRequest) {
			resetRequest();
		}

		if(resetAuth) {
			resetAuth();
		}

		return response;
	}
}
