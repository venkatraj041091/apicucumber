package com.StepDefination;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.goblabdatas.GobalDatas;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClass{
	
	static GobalDatas gobaldatas= new GobalDatas();
	Response response;

	@When("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() throws FileNotFoundException, IOException {

		basicauthentication(getpropertyFileValue("username"),getpropertyFileValue("password"));


	}
	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String POST) throws FileNotFoundException, IOException {

		response = requesttype(POST,EndPoints.BASICAUTHPOINT);

		int getstatus = getstatus(response);
		System.out.println(getstatus);
		gobaldatas.setStatuscode(getstatus);

	}

	@Then("User verify the login response body firstname present as {string} and get the logtoken saved")
	public void user_verify_the_login_response_body_firstname_present_as_and_get_the_logtoken_saved(String string) {

		com.POJO.Login.Login_Output_POJO as = response.as(com.POJO.Login.Login_Output_POJO.class);

		String first_name = as.getData().getFirst_name();


		String logusertoken = as.getData().getLogtoken();
		gobaldatas.setLogusertoken(logusertoken);


		Assert.assertEquals("the values are verifed", string,first_name);
	}





}
