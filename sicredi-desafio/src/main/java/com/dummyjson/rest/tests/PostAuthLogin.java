package com.dummyjson.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.dummyjson.rest.core.BaseTest;

public class PostAuthLogin extends BaseTest {

	private Map<String, String> createLoginPayload(String username, String password) {
		Map<String, String> login = new HashMap<String, String>();
		login.put("username", username);
		login.put("password", password);
		return login;
	}

	@Test
	public void deveGerarTokenComSucesso() {
		Map<String, String> login = createLoginPayload("emilys", "emilyspass");
		given()
			.body(login)
		.when()
			.post("/auth/login")
		.then()
			.log().all()
			.statusCode(200)
			.body("token", not(empty()))
			.extract().path("token");
	}

	@Test
	public void naoDeveGerarTokenSemUsername() {
		Map<String, String> login = createLoginPayload("", "emilyspass");
		given()
			.body(login)
		.when()
			.post("/auth/login")
		.then()
			.log().all()
			.statusCode(400)
			.body("message",is("Username and password required"));
	}

	@Test
	public void naoDeveGerarTokenSemPassword() {
		Map<String, String> login = createLoginPayload("emilys", "");
		given()
			.body(login)
		.when()
			.post("/auth/login")
		.then().log().all()
			.statusCode(400)
			.body("message",Matchers.is("Username and password required"));
	}
}