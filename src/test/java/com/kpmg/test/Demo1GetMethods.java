package com.kpmg.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo1GetMethods {
	
	public String baseURL="https://petstore.swagger.io/v2";
	
	/**
	 * Example for get- path parameter
	 */
	@Test
	public void findValidPetIdTest()
	{
		String resource = "/pet/{petId}"; 
		
		String response= RestAssured
		.given().pathParam("petId", 605)
		.when().get(baseURL+resource)
		.then().statusCode(200).extract().asPrettyString();
		
		System.out.println(response);
	}

	@Test
	public void findInvalidPetIdTest()
	{
		String resource = "/pet/{petId}"; 
		
		String response= RestAssured
		.given().pathParam("petId", 105454455)
		.when().get(baseURL + resource)
		.then().statusCode(404).extract().asPrettyString();

		System.out.println(response);
	}

	/**
	 * Example for get- query parameter
	 */
	@Test
	public void findpetByValidStatus() {
		String resource = "/pet/findByStatus";

		String response = RestAssured
				.given().queryParam("status", "sold")
				.when().get(baseURL + resource)
				.then().statusCode(200).extract().asPrettyString();
		System.out.println(response);
	}
	
	
	

}
