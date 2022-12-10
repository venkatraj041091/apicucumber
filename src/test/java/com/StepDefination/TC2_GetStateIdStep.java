package com.StepDefination;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;

import com.POJO.GetStateId.Statelist_Output_POJO;
import com.POJO.GetStateId.stateid;
import com.base.BaseClass;
import com.endpoints.EndPoints;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_GetStateIdStep extends BaseClass{

	String statename;

	@When("User send {string} request for state endpoint")
	public void user_send_request_for_state_endpoint(String GET) throws FileNotFoundException, IOException {

		response = requesttype(GET,EndPoints.STATEENDPOINT);

		int getstatus = getstatus(response);
		System.out.println(getstatus);
		TC1_LoginStep.gobaldatas.setStatuscode(getstatus);

		Statelist_Output_POJO as = response.as(Statelist_Output_POJO.class);
		ArrayList<stateid> data = as.getData();

		for (stateid stateid : data) {
			statename = stateid.getName();
			TC1_LoginStep.gobaldatas.setStatevalue(statename);
			if (statename.equals("Tamil Nadu")) {
				int StateIdNumber = stateid.getId();
				System.out.println(StateIdNumber);
				TC1_LoginStep.gobaldatas.setStateIdNumber(StateIdNumber);
				String statevalue = String.valueOf(StateIdNumber);
				System.out.println(statevalue);
				TC1_LoginStep.gobaldatas.setStatevalue(statevalue);
				break;
			}
		}

	}
	@Then("User verify the stateid response body present as {string} and get the statenumber saved")
	public void user_verify_the_stateid_response_body_present_as_and_get_the_statenumber_saved(String string) {

		Assert.assertEquals("verify the state name",string, statename);

	}









}
