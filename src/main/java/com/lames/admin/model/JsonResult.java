package com.lames.admin.model;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {

	private boolean status;
	private String message;
	private Map<String, Object> data = new HashMap<String, Object>();
	
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(String key, Object value) {
		data.put(key, value);
	}
	public Object getData(String key) {
		return data.get(key);
	}
}
