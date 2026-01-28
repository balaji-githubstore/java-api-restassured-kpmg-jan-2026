package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Demo4ReadResponse {
	public String baseURL="https://petstore.swagger.io/v2";
	
	/**
	 * not type safe, tree like structure, supports json expression
	 * https://docs.hevodata.com/sources/engg-analytics/streaming/rest-api/writing-jsonpath-expressions/
	 */
	@Test
	public void JsonPathTest()
	{
		
		String resource = "/pet/{petId}"; 
		
		JsonPath response= RestAssured
		.given().pathParam("petId", 605)
		.when().get(baseURL+resource)
		.then().statusCode(200).extract().jsonPath();
		
		System.out.println(response.prettify());
		System.out.println(response.getInt("id"));
		
		System.out.println(response.getString("name"));
		System.out.println(response.getString("category.id"));
	}
	
	@Test
	public void JsonNodeTest()
	{
		
		String resource = "/pet/{petId}"; 
		
		JsonPath response= RestAssured
		.given().pathParam("petId", 605)
		.when().get(baseURL+resource)
		.then().statusCode(200).extract().jsonPath();
		
		System.out.println(response.prettify());
		System.out.println(response.getInt("id"));
		
		System.out.println(response.getString("name"));
		System.out.println(response.getString("category.id"));
	}

}
