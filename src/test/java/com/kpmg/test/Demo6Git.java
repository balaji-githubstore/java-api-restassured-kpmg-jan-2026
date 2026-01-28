package com.kpmg.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import tools.jackson.databind.JsonNode;

public class Demo6Git {
	
	public String baseURL="https://api.github.com";
	
	@Test
	public void listAllPublicRepoForUserTest()
	{
		String resource="/users/{username}/repos";
		
		String response= RestAssured
				.given().pathParam("username", "dbala-cloud")
				.when().get(baseURL+resource)
				.then().statusCode(200).extract().asPrettyString();
		
		System.out.println(response);
	}

	
	@Test
	public void listAllRepoForUserTest() throws FileNotFoundException
	{
		
		FileInputStream file=new FileInputStream("files/secret.json");
		JsonPath jsonPath=new JsonPath(file);
		String token=jsonPath.getString("token");
		
		String resource="/user/repos";
		
		JsonNode response= RestAssured
				.given()
				.auth().preemptive().basic("dbala-cloud", token)
				.when().get(baseURL+resource)
				.then().statusCode(200).extract().as(JsonNode.class);
		
		System.out.println(response.toPrettyString());
		System.out.println(response.get(0).get("name"));
		
		
	}
	
	@Test
	public void listAllRepoForUserBearerTest() throws FileNotFoundException
	{
		
		FileInputStream file=new FileInputStream("files/secret.json");
		JsonPath jsonPath=new JsonPath(file);
		String token=jsonPath.getString("token");
		
		String resource="/user/repos";
		
		JsonNode response= RestAssured
				.given()
				.header("Authorization","Bearer "+token)
				.when().get(baseURL+resource)
				.then().statusCode(200).extract().as(JsonNode.class);
		
		System.out.println(response.toPrettyString());
		System.out.println(response.get(0).get("name"));
		
		
	}
}
