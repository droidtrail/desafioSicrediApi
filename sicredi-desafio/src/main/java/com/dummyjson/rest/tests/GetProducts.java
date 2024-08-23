package com.dummyjson.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Before;
import org.junit.Test;

import com.dummyjson.rest.core.BaseTest;
import com.dummyjson.rest.helpers.BuscarStatusDaAplicacao;

public class GetProducts extends BaseTest {

	private BuscarStatusDaAplicacao buscarStatusDaAplicacao;

	@Before
	public void setUp() {
		buscarStatusDaAplicacao = new BuscarStatusDaAplicacao();
		buscarStatusDaAplicacao.verificarStatusDaAplicacao();
	}
	
	@Test
	public void deveObterObjetoComTodosProdutosCadastrados() {
		
		given()
		.when()
			.get("/products")
			
		.then()
			.log().all()
			.statusCode(200)
			.body("products", not(empty()))
			.body("products.id", everyItem(not(emptyOrNullString())))
			;
	}

}
