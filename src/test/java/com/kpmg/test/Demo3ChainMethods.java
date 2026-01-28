package com.kpmg.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Demo3ChainMethods {
	
	public String baseURL="https://petstore.swagger.io/v2";

	@Test(priority = 1)
	public void addValidPetFromJsonTest() throws FileNotFoundException
	{
		FileInputStream file=new FileInputStream("files/new_pet.json");
		JsonPath jsonPath=new JsonPath(file);
		
		
		String requestBody= jsonPath.prettify();
		System.out.println(requestBody);
		
		String resource="/pet";
		
		String response= RestAssured
				.given()
				.header("Content-Type", "application/json")
				.body(requestBody)
				.when().post(baseURL+resource)
				.then().statusCode(200).extract().asPrettyString();
				
				System.out.println(response);
	}
	
	@Test(priority = 2)
	public void updateValidPetFromJsonTest() throws FileNotFoundException
	{
		FileInputStream file=new FileInputStream("files/update_pet.json");
		JsonPath jsonPath=new JsonPath(file);
		
		String requestBody= jsonPath.prettify();
		System.out.println(requestBody);
		
		String resource="/pet";
		
		String response= RestAssured
				.given()
				.header("Content-Type", "application/json")
				.body(requestBody)
				.when().put(baseURL+resource)
				.then().statusCode(200).extract().asPrettyString();
				
				System.out.println(response);
	}
	
	@Test(priority = 3)
	public void findValidPetIdTest()
	{
		String resource = "/pet/{petId}"; 
		
		String response= RestAssured
		.given().pathParam("petId", 705)
		.when().get(baseURL+resource)
		.then().statusCode(200).extract().asPrettyString();
		
		System.out.println(response);
		
		Assert.assertTrue(response.contains("705"));  //expect true
	}
	
	@Test(priority = 4)
	public void deleteValidPetIdTest()
	{
		String resource = "/pet/{petId}"; 
		
		String response= RestAssured
		.given()
		.header("api_key", "special-key")
		.pathParam("petId", 705)
		.when().delete(baseURL+resource)
		.then().statusCode(200).extract().asPrettyString();
		
		System.out.println(response);
	}	
}
