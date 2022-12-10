package com.StepDefination;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.profilepicture.POJO.Profile_picture_Output_POJO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;;

public class TC6_ChangeProfilePicStep extends BaseClass {
	
	
	@Given("User add header with multipart")
	public void user_add_header_with_multipart() {
		List<Header>listheader=new ArrayList<Header>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization"," Bearer " + TC1_LoginStep.gobaldatas.getLogusertoken());
		Header h3=new Header("Content-Type","multipart/form-data");

		listheader.add(h3);
		listheader.add(h2);
		listheader.add(h1);

		Headers header=new Headers(listheader);
		addheaders(header);
		
		
		
	}
	@When("User add pic in the formdata")
	public void user_add_pic_in_the_formdata() throws FileNotFoundException, IOException {
		
		addformdata("profile_picture", new File(getprojectpath()+getpropertyFileValue("file")));
		
	}
	@When("User send {string} request for updatepic endpoint")
	public void user_send_request_for_updatepic_endpoint(String POST) {
		
		 response = requesttype(POST, EndPoints.UPDATEPICTUREENDPOINT);


		int getstatus = getstatus(response);
		System.out.println(getstatus);
		TC1_LoginStep.gobaldatas.setStatuscode(getstatus);
}
	@Then("User verify the login response body message present as {string} in Login page")
	public void user_verify_the_login_response_body_message_present_as_in_login_page(String string) {
		
		Profile_picture_Output_POJO as = response.as(Profile_picture_Output_POJO.class);
		String message = as.getMessage();
		Assert.assertEquals("verify the picture",string,message);
	}




}
