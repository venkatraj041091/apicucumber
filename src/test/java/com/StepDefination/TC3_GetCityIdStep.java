package com.StepDefination;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;

import com.POJO.GetCityId.CityLIst_Input_POJO;
import com.POJO.GetCityId.CityList_Output_POJO;
import com.POJO.GetCityId.city;
import com.base.BaseClass;
import com.endpoints.EndPoints;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TC3_GetCityIdStep extends BaseClass{

	@When("User add request body for add new state {string}")
	public void user_add_request_body_for_add_new_state(String string) {

		CityLIst_Input_POJO cityLIst_Input_POJO=new CityLIst_Input_POJO(TC1_LoginStep.gobaldatas.getStatevalue());
		addBody(cityLIst_Input_POJO);

	}
	
	@When("User send {string} request for city endpoint")
	public void user_send_request_for_city_endpoint(String POST) throws FileNotFoundException, IOException {

		response = requesttype(POST,EndPoints.CITYENDPOINT);

		int getstatus = getstatus(response);
		System.out.println(getstatus);
		TC1_LoginStep.gobaldatas.setStatuscode(getstatus);

		}

	@Then("User verify the login response body cityname present as {string} and get the cityId saved")
	public void user_verify_the_login_response_body_cityname_present_as_and_get_the_city_id_saved(String string) {

		CityList_Output_POJO as = response.as(CityList_Output_POJO.class);
		ArrayList<city> arrayList = as.getData();
		for (city city : arrayList) {
			String name = city.getName();
			if (name.equals("Vriddhachalam")) {
			int	CityId = city.getId();
				System.out.println(CityId);
				TC1_LoginStep.gobaldatas.setCityId(CityId);
				Assert.assertEquals("verify the city",string,name);
				break;
			}

		}


	}



}
