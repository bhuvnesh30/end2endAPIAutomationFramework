package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;
import junit.framework.Assert;

public class AccountCreationtTest {
	@Test(description = "Verify if sign up is working")
	public void createAccountTest() {
		SignUpRequest signUpRequest = new SignUpRequest.Builder().username("bhuvnesh12").email("bhuvnesh@gmail.com")
				.firstName("bhuvnesh").password("bhuvnesh1234").lastName("kumar").mobileNumber("9817468383").build();

		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());

		// Check if the response status code is 200 (OK)
		Assert.assertEquals(200, response.getStatusCode());

		// Check if the response message is as expected
		Assert.assertEquals("User registered successfully", response.jsonPath().getString("message"));
	}
}
