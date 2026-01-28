package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.model.Pet;
import com.kpmg.model.Pet1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import tools.jackson.databind.JsonNode;

public class Demo4ReadResponse {
	public String baseURL = "https://petstore.swagger.io/v2";

	/**
	 * not type safe, tree like structure, supports json expression
	 * https://docs.hevodata.com/sources/engg-analytics/streaming/rest-api/writing-jsonpath-expressions/
	 */
	@Test
	public void JsonPathTest() {

		String resource = "/pet/{petId}";

		JsonPath response = RestAssured.given().pathParam("petId", 605).when().get(baseURL + resource).then()
				.statusCode(200).extract().jsonPath();

		System.out.println(response.prettify());
		System.out.println(response.getInt("id"));

		System.out.println(response.getString("name"));
		System.out.println(response.getString("category.id"));
	}

	/**
	 * not recommended for complete validation.
	 */
	@Test
	public void JsonNodeTest() {
		String resource = "/pet/{petId}";

		JsonNode response = RestAssured.given().pathParam("petId", 605).when().get(baseURL + resource).then()
				.statusCode(200).extract().as(JsonNode.class);

		System.out.println(response.get("id"));
		System.out.println(response.get("category").get("id").asInt());

		System.out.println(response.get("tags").get(0).get("id").asInt());
	}

	/**
	 * Use pojo class for automation. Type safety, easy maintenance, stable for
	 * automation, schema validation
	 */
	@Test
	public void pojoClassTest() {
		String resource = "/pet/{petId}";

		Pet responsePetObj = RestAssured.given().pathParam("petId", 605).when().get(baseURL + resource).then()
				.statusCode(200).extract().as(Pet.class);

		System.out.println(responsePetObj.getId());
		System.out.println(responsePetObj.getCategory().getId());
	}

//	@Test
//	public void lombokCheckTest() {
//
//
//        String resource = "/pet/{petId}";
//
//        Pet1 responsePetObj = RestAssured
//                .given().pathParam("petId", 605)
//                .when().get(baseURL + resource)
//                .then()
//                .statusCode(200).extract().as(Pet1.class);
//
//        System.out.println(responsePetObj.getId());
//
//	}
	
	

}
