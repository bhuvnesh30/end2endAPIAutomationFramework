package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;
import junit.framework.Assert;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITests2 {
	@Test(description = "Verify if Login APi is working")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("aditi", "aditi1234");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getRoles());

		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(), "adit@gmail.com");
		Assert.assertEquals(loginResponse.getId(), 75);
	}

}
