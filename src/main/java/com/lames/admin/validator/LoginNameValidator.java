package com.lames.admin.validator;

import java.util.ArrayList;
import java.util.List;

public class LoginNameValidator {
	private static String NOT_NULL = "loginName cannot be empty";

	public LoginNameValidator() {
	}

	public List<String> validate(String str) {
		// TODO Auto-generated method stub
		List<String> errMsg = new ArrayList<String>();
		if ("".equals(str) || str == null) {
			errMsg.add(NOT_NULL);
		}
		return errMsg;
	}

}
