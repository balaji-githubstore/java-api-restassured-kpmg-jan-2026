package com.kpmg.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo2PostMethods {
	public String baseURL="https://petstore.swagger.io/v2";
	
	
	@Test
	public void addValidPetTest()
	{
		String resource="/pet";
		
		String requestBody="{\r\n"
				+ "  \"id\": 606,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie-606\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		String response= RestAssured
				.given()
				.header("Content-Type", "application/json")
				.body(requestBody)
				.when().post(baseURL+resource)
				.then().statusCode(200).extract().asPrettyString();
				
				System.out.println(response);
	}

}
