package com.dummyjson.rest.helpers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BuscarStatusDaAplicacao {
	public void verificarStatusDaAplicacao() {
        given()
        .when()
            .get("/test")
        .then()
            .log().all()
            .statusCode(200)
            .body("status", is("ok"))
            .body("method", is("GET"));
    }
}