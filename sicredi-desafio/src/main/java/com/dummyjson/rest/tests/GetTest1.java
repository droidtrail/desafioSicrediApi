package com.dummyjson.rest.tests;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.dummyjson.rest.core.BaseTest;

public class GetTest1 extends BaseTest{
	@Test
	public void deveVerificarStatusDaAplicacao() {
		given()
		.when()
			.get("/test")
		.then()
			.log().all()
			.statusCode(200)
			.body( "status", Matchers.is("ok"))
			.body( "method", Matchers.is("GET"))
			;
	}
}