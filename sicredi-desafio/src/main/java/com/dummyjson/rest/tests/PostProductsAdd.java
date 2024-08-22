package com.dummyjson.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.not;

import org.junit.*;


import com.dummyjson.rest.core.BaseTest;
import com.dummyjson.rest.helpers.BuscarStatusDaAplicacao;

public class PostProductsAdd extends BaseTest{
	
private BuscarStatusDaAplicacao buscarStatusDaAplicacao;
	
	@Before
    public void setUp() {
		buscarStatusDaAplicacao = new BuscarStatusDaAplicacao();
		buscarStatusDaAplicacao.verificarStatusDaAplicacao();
    }
	
	@Test
	public void deveAdicionarProdutosComSucesso() {
		given()
		.when()
			.get("/products/add")
		.then()
			.log().all()
			.statusCode(200)
//			.body("users", not(empty()))
//			.body("users.username", everyItem(not(emptyOrNullString())))
//			.body("users.password", everyItem(not(emptyOrNullString())))
			;
	}

}
