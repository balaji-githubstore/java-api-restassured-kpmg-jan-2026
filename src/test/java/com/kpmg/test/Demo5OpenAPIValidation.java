package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import com.kpmg.model.Pet;
import com.kpmg.model.Pet1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import tools.jackson.databind.JsonNode;

public class Demo5OpenAPIValidation {
	public String baseURL = "https://petstore.swagger.io/v2";

	
	@Test
	public void findPetByIdWithOpenAPIValidationTest() {
		
		OpenApiValidationFilter validator=new OpenApiValidationFilter("files/petstore.yaml");
		//either pass the path as string or file object

        String resource = "/pet/{petId}";

        Pet responsePetObj = RestAssured
                .given()
                .filter(validator)
                .pathParam("petId", 605)
                .when().get(baseURL + resource)
                .then()
                .statusCode(200).extract().as(Pet.class);

        System.out.println(responsePetObj.getId());

	}
	
	
	

}
