package com.rideshare.Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.rideshare.Pages.LoginPage;
import com.rideshare.genericPages.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class LoginPage_Test extends LoginPage {

	LoginPage_Test() throws Exception {

		super();
	}

	@Test
	public void clickSignInButton() {
		Sign_in_with_Email();

	}

	@Test
	public void testEnteredEmail() {

		clickonEmail();
		enterEmail();
	}

	@Test
	public void testEnteredPassword() {
		clickonPassword();
		enterPassword();

	}

	@Test
	public void testSubmit() {
		clickonSubmit();

	}

}
