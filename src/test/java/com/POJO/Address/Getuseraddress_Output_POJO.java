package com.POJO.Address;

import java.util.ArrayList;


public class Getuseraddress_Output_POJO {
	
	 private int status;
	 private String message;
	 private ArrayList<getuser> data;
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
	public ArrayList<getuser> getData() {
		return data;
	}
	public void setData(ArrayList<getuser> data) {
		this.data = data;
	}
	

}
