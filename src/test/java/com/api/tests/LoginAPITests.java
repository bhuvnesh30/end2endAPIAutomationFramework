package com.api.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class LoginAPITests {
	@Test(description = "Verify if Login APi is working")
	public void loginTest() {
		Response response = given().baseUri("http://64.227.160.186:8080").header("Content-Type", "application/json")
				.body("{\"username\": \"aditi\",\"password\": \"aditi1234\"}").post("/api/auth/login");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
