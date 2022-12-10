package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	public static String getprojectpath() { 
		String path=System.getProperty("user.dir");
		return path;
	}
	public static String getpropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties =new Properties();
		properties.load(new FileInputStream(getprojectpath()+"\\config\\config.properties"));
		String value=(String)properties.get(key);
		return value;
	}

	public static RequestSpecification reqspec;

	public static Response response;
	

	public void addformdata(String key,File value) {
		reqspec=reqspec.multiPart(key,value);

	}

	public void addHeader(String key,String value) {
		reqspec=RestAssured.given().header(key,value);
	}

	public void addheaders(Headers header) {

		reqspec=RestAssured.given().headers(header);
	}

	public void addBody(Object body) {

		reqspec=reqspec.body(body);
	}

	public void basicauthentication(String username,String password) {
		reqspec=reqspec.auth().preemptive().basic(username, password);
	}

	public void getbody(String body) {
		reqspec=reqspec.body(body);
	}

	public void getqueryparam(String key,String value) {
		reqspec=reqspec.queryParam(key,value);
	}

	public void getpathparam(String key,String value) {
		reqspec=reqspec.pathParam(key,value);
	}

	public Response requesttype(String type,String endpoint) {

		switch (type) {
		case "GET":
			response = reqspec.log().all().get(endpoint);
			break;

		case "PUT":
			response = reqspec.log().all().put(endpoint);
			break;

		case "POST":
			response = reqspec.log().all().post(endpoint);
			break;

		case "DELETE":
			response = reqspec.log().all().delete(endpoint);
			break;
		}

		return response;

	}

	public int getstatus(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}

	public String getasstring(Response response) {
		String asString = response.asString();
		return asString;

	}
	public String getprettystring(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}


}
