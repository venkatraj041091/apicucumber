package com.POJO.GetCityId;

import java.util.ArrayList;
public class CityList_Output_POJO {
	

	
	
	private int status;
	private String message;
	public ArrayList<city> data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<city> getData() {
		return data;
	}
	public void setData(ArrayList<city> data) {
		this.data = data;
	}
	


}
