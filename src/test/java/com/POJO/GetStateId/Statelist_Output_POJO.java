package com.POJO.GetStateId;

import java.util.ArrayList;

public class Statelist_Output_POJO {
	
	 private int status;
	 private String message;
	 private ArrayList<stateid> data;
	 
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
	public ArrayList<stateid> getData() {
		return data;
	}
	public void setData(ArrayList<stateid> data) {
		this.data = data;
	}
	

}
