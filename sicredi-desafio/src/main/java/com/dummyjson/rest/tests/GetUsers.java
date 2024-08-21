package com.dummyjson.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.dummyjson.rest.core.BaseTest;

public class GetUsers extends BaseTest{
	@Test
	public void deveVerificarStatusDaAplicacao() {
		given()
		.when()
			.get("/users")
		.then()
			.log().all()
			.statusCode(200)
			.body("users.username", everyItem(not(emptyOrNullString())))
			.body("users.password", everyItem(not(emptyOrNullString())))
			;
	}
}