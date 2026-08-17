package com.rideshare.Pages;

import com.rideshare.genericPages.CommonMethods;

public class LoginPage extends CommonMethods {

	public LoginPage() throws Exception {
		super();

	}

	public void Sign_in_with_Email() {
		clickOn("Sign_in_with_Email");

	}

	public void clickonEmail() {
		clickOn("Email");

	}

	public void enterEmail() {
		enterData("Email", "AdminEmail");

	}

	public void clickonPassword() {
		clickOn("Password");

	}

	public void enterPassword() {
		enterData("Password", "AdminPassword");

	}

	public void clickonSubmit() {
		clickOn("Submit");

	}

}
