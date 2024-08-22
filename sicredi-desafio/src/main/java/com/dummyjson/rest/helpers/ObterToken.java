package com.dummyjson.rest.helpers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class ObterToken {
	 public static String gerarToken(String username, String password) {
	        Map<String, String> login = new HashMap<String, String>();
	        login.put("username", username);
	        login.put("password", password);

	        return given()
	                    .body(login)
	                .when()
	                    .post("/auth/login")
	                .then()
	                    .statusCode(200)
	                    .body("token", not(empty()))
	                    .extract().path("token");
	    }
}
