package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagerService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;
import junit.framework.Assert;

public class UpdateProfileTest {

	@Test
	public void testProfileUpdate() {
		try {
			AuthService authService = new AuthService();
			Response response = authService.login(new LoginRequest("aditi", "aditi1234"));
			LoginResponse loginResponse = response.as(LoginResponse.class);
			String token = loginResponse.getToken();
			System.out.println(response.asPrettyString());

			System.out.println("------------");

			UserProfileManagerService userProfileManagerService = new UserProfileManagerService();
			response = userProfileManagerService.getProfile(token);
			System.out.println(response.asPrettyString());
			UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
			Assert.assertEquals(userProfileResponse.getUsername(), "aditi");

			System.out.println("------------");
			ProfileRequest profileRequest = new ProfileRequest.Builder().firstName("Bhuvnesh").lastName("kumar")
					.mobileNumber("9078563424").email("bhuvn@gmail.com").build();
			response = userProfileManagerService.updateProfile(token, profileRequest);
			System.out.println(response.asPrettyString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
