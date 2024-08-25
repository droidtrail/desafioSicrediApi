package com.dummyjson.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.*;


import com.dummyjson.rest.core.BaseTest;
import com.dummyjson.rest.helpers.BuscarStatusDaAplicacao;

public class GetUsers extends BaseTest{
	
	private BuscarStatusDaAplicacao buscarStatusDaAplicacao;
	
	@Before
    public void setUp() {
		buscarStatusDaAplicacao = new BuscarStatusDaAplicacao();
		buscarStatusDaAplicacao.verificarStatusDaAplicacao();
    }
	
	@Test
	public void deveVerificarStatusDaAplicacao() {
		given()
		.when()
			.get("/users")
		.then()
			.log().all()
			.statusCode(200)
			.body("users", not(empty()))
			.body("users.username", everyItem(not(emptyOrNullString())))
			.body("users.password", everyItem(not(emptyOrNullString())))
			;
	}
}