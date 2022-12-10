package com.StepDefination;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.searchproduct.POJO.SearchProduct_Input_POJO;
import com.searchproduct.POJO.Searchproduct_Output_POJO;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC5_SearchProductStep extends BaseClass {

	@When("User send {string} request for searchproduct endpoint")
	public void user_send_request_for_searchproduct_endpoint(String POST) {

		SearchProduct_Input_POJO searchProduct_Input_POJO=new SearchProduct_Input_POJO("nuts");
		addBody(searchProduct_Input_POJO);

		response = requesttype(POST,EndPoints.SEARCHPRODUCTENDPOINT);

		int getstatus = getstatus(response);
		System.out.println(getstatus);	
		TC1_LoginStep.gobaldatas.setStatuscode(getstatus);

	}

	@Then("User verify the login response body as {string} message")
	public void user_verify_the_login_response_body_as_message(String string) {

		Searchproduct_Output_POJO as = response.as(Searchproduct_Output_POJO.class);
		String message = as.getMessage();
		Assert.assertEquals("verify the search product", string,message);

	}




}
