package com.StepDefination;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class CommonStep extends BaseClass{

	
	
@Given("User add header and bearer authorization only accesing address endpoint")
	public void user_add_header_and_bearer_authorization_only_accesing_address_endpoint() {
	
	List<Header>listheader=new ArrayList<Header>();
	Header h1=new Header("accept","application/json");
	Header h2=new Header("Authorization"," Bearer " +TC1_LoginStep.gobaldatas.getLogusertoken());

	listheader.add(h2);
	listheader.add(h1);

	Headers header=new Headers(listheader);
	addheaders(header);

}
	
	@Given("User add header")
	public void user_add_header() {
		addHeader("accept","application/json");
	}
	
	@Given("User add header and bearer authorization for accesing address endpoint")
	public void user_add_header_and_bearer_authorization_for_accesing_address_endpoint() {
		List<Header>listheader=new ArrayList<Header>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization"," Bearer " + TC1_LoginStep.gobaldatas.getLogusertoken());
		Header h3=new Header("Content-Type","application/json");

		listheader.add(h3);
		listheader.add(h2);
		listheader.add(h1);

		Headers header=new Headers(listheader);
		addheaders(header);
		
	}
	
	@Given("User add header and bearer authorization only for accesing address endpoint")
	public void user_add_header_and_bearer_authorization_only_for_accesing_address_endpoint() {
	

		List<Header>listheader=new ArrayList<Header>();
		Header h1=new Header("accept","application/json");
		Header h3=new Header("Content-Type","application/json");

		listheader.add(h3);
		listheader.add(h1);

		Headers header=new Headers(listheader);
		addheaders(header);

	
	
	}

	@Then("User verify the status code is {int}")
	public void user_verify_the_status_code_is(int int1) {
	int statuscode = TC1_LoginStep.gobaldatas.getStatuscode();
	Assert.assertEquals("verify the status",int1,statuscode);

}
}
