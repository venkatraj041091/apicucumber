package com.StepDefination;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.POJO.Address.AddUserAddrees_Input_POJO;
import com.POJO.Address.AddUserAddress_Output_POJO;
import com.POJO.Address.Address_Delete_Input;
import com.POJO.Address.Address_Delete_Output;
import com.POJO.Address.Getuseraddress_Output_POJO;
import com.POJO.Address.UpdateUserAddress_Input_Pojo;
import com.POJO.Address.UpdateUserAddress_Output_POJO;
import com.base.BaseClass;
import com.endpoints.EndPoints;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC4_AddressStep extends BaseClass{


	@When("User add request body for add new address {string},{string},{string},{string}, {int} , {int} , {int} ,{string},{string} and {string}")
	public void user_add_request_body_for_add_new_address_and(String string, String string2, String string3, String string4, Integer int1, Integer int2, Integer int3, String string5, String string6, String string7) {   

		AddUserAddrees_Input_POJO addUserAddrees_Input_POJO = new AddUserAddrees_Input_POJO(
				"praveen", "raj", "1234567890", "456",TC1_LoginStep.gobaldatas.getCityId(),TC1_LoginStep.gobaldatas.getStateIdNumber(), 868, "put", "get", "home");

		addBody(addUserAddrees_Input_POJO);

	}

	@When("User send {string} request for adduseraddress endpoint")
	public void user_send_request_for_adduseraddress_endpoint(String POST) throws FileNotFoundException, IOException {

		response = requesttype(POST,EndPoints.ADDADDRESSENDPOINT);
		int getstatus = getstatus(response);
		System.out.println(getstatus);
		TC1_LoginStep.gobaldatas.setStatuscode(getstatus);


	}

	@Then("User verify the adduseraddress reponse message matches {string}")
	public void user_verify_the_adduseraddress_reponse_message_matches(String string) {

		AddUserAddress_Output_POJO as = response.as(AddUserAddress_Output_POJO.class);

		String message = as.getMessage();
		int address_id = as.getAddress_id();
		System.out.println(address_id);
		String AddressId = String.valueOf(address_id);
		System.out.println(AddressId);
		TC1_LoginStep.gobaldatas.setAddressId(AddressId);
		Assert.assertEquals("verift the message",string,message);

	}

	@When("User add request body for add new addressid {string},{string},{string},{string}, {int} , {int} , {int} ,{string},{string} and {string}")
	public void user_add_request_body_for_add_new_addressid_and(String string, String string2, String string3, String string4, Integer int1, Integer int2, Integer int3, String string5, String string6, String string7) {

		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo =new UpdateUserAddress_Input_Pojo(TC1_LoginStep.gobaldatas.getAddressId(), "praveen", "raj", "1234567890", "456", TC1_LoginStep.gobaldatas.getStateIdNumber(),TC1_LoginStep.gobaldatas.getCityId(), 868, "put", "get", "home");	
		addBody(updateUserAddress_Input_Pojo);

	}

	@When("User send {string} request for updateuseraddress endpoint")
	public void user_send_request_for_updateuseraddress_endpoint(String PUT) throws FileNotFoundException, IOException {

		response = requesttype(PUT,EndPoints.UPDATEDADDRESSENDPOINT);

		int getstatus = getstatus(response);
		System.out.println(getstatus);
		TC1_LoginStep.gobaldatas.setStatuscode(getstatus);

	}

	@Then("User verify the userputaddress reponse message matches {string}")
	public void user_verify_the_userputaddress_reponse_message_matches(String string) {

		UpdateUserAddress_Output_POJO as = response.as(UpdateUserAddress_Output_POJO.class);
		String message = as.getMessage();

		Assert.assertEquals("verify the update message",string,message);
	}


	@When("User send {string} request for usergetaddress endpoint")
	public void user_send_request_for_usergetaddress_endpoint(String GET) throws FileNotFoundException, IOException {


		response = requesttype(GET,EndPoints.GETADDRESSENDPOINT);


		int getstatus = getstatus(response);
		System.out.println(getstatus);
		TC1_LoginStep.gobaldatas.setStatuscode(getstatus);



	}

	@Then("User verify the usergetaddress reponse message matches {string}")
	public void user_verify_the_usergetaddress_reponse_message_matches(String string) {

		Getuseraddress_Output_POJO as = response.as(Getuseraddress_Output_POJO.class);
		String message = as.getMessage();
		Assert.assertEquals("verify the ok message",string,message);

	}

	@When("User add request body for add new address {string}")
	public void user_add_request_body_for_add_new_address(String string) {

		Address_Delete_Input address_Delete_Input=new Address_Delete_Input(TC1_LoginStep.gobaldatas.getAddressId());
		addBody(address_Delete_Input);


	}
	@When("User send {string} request for deleteuseraddress endpoint")
	public void user_send_request_for_deleteuseraddress_endpoint(String DELETE) throws FileNotFoundException, IOException {

		response = requesttype(DELETE, EndPoints.DELETEADDRESSENDPOINT);

		int getstatus = getstatus(response);
		System.out.println(getstatus);
		TC1_LoginStep.gobaldatas.setStatuscode(getstatus);


	}

	@Then("User verify the useraddressdelete reponse message matches {string}")
	public void user_verify_the_useraddressdelete_reponse_message_matches(String string) {

		Address_Delete_Output as = response.as(Address_Delete_Output.class);
		String message = as.getMessage();

		Assert.assertEquals("verify the delete message", string,message);

	}


}
