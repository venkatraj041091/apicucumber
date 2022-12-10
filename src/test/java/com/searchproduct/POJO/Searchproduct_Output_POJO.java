package com.searchproduct.POJO;

import java.util.ArrayList;

public class Searchproduct_Output_POJO {
	 public int status;
	    public String message;
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
		public ArrayList<search> getData() {
			return data;
		}
		public void setData(ArrayList<search> data) {
			this.data = data;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public ArrayList<search> data;
	    public String currency;

}
