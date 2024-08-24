package com.dummyjson.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.dummyjson.rest.core.BaseTest;
import com.dummyjson.rest.helpers.BuscarStatusDaAplicacao;

public class GetProductsId extends BaseTest{
	private BuscarStatusDaAplicacao buscarStatusDaAplicacao;

	@Before
	public void setUp() {
		buscarStatusDaAplicacao = new BuscarStatusDaAplicacao();
		buscarStatusDaAplicacao.verificarStatusDaAplicacao();
	}
	
	@Test
	public void deveObterProdutoPorId() {
		
		given()
		.when()
			.get("/products/1")
		.then()
			.log().all()
			.statusCode(200)
			.body(not(empty()))
			.body( "id", is(1))
			;
	}

	@Test
	public void deveExibirErroDeProdutoNaoEncontrado() {
		
		given()
		.when()
			.get("/products/0")
		.then()
			.log().all()
			.statusCode(404)
			.body(not(empty()))
			.body( "message", is("Product with id '0' not found" ))
			;
	}
	
	@Test
	public void deveExibirMensagemDeNaoAutorizado() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJlbWlseXMiLCJlbWFpbCI6ImVtaWx5LmpvaG5zb25AeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiRW1pbHkiLCJsYXN0TmFtZSI6IkpvaG5zb24iLCJnZW5kZXIiOiJmZW1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2VtaWx5cy8xMjgiLCJpYXQiOjE3MjQzMzcyOTAsImV4cCI6MTcyNDM0MDg5MH0.3V3LhYUHc0rr7Lg9jnZl8Zt8v4YIhHpY8m5J6RTAotk";
        given()
            .header("Authorization", "Bearer " + token)
        .when()
            .get("/auth/products")
        .then()
            .log().all()
            .statusCode(401)
            .body( "message", is("Token Expired!"))
            ;
    }
}
