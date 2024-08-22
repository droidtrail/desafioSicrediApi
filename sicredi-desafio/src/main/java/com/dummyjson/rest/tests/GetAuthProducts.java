package com.dummyjson.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.*;

import com.dummyjson.rest.core.BaseTest;
import com.dummyjson.rest.helpers.BuscarStatusDaAplicacao;
import com.dummyjson.rest.helpers.ObterToken;

public class GetAuthProducts extends BaseTest {
	
	private BuscarStatusDaAplicacao buscarStatusDaAplicacao;
	
	@Before
    public void setUp() {
		buscarStatusDaAplicacao = new BuscarStatusDaAplicacao();
		buscarStatusDaAplicacao.verificarStatusDaAplicacao();
    }
	
	
	@Test
	public void deveObterListaDeProdutosComSucesso() {
        String token = ObterToken.gerarToken("emilys", "emilyspass");
        given()
            .header("Authorization", "Bearer " + token)
        .when()
            .get("/auth/products")
        .then()
            .log().all()
            .statusCode(200)
            .body("products", not(empty()));
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
	
	@Test
	public void deveExibirMensagemDeProblemaNaAutenticacao() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJlbWlseXMiLCJlbWFpbCI6ImVtaWx5LmpvaG5zb25AeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiRW1pbHkiLCJsYXN0TmFtZSI6IkpvaG5zb24iLCJnZW5kZXIiOiJmZW1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2VtaWx5cy8xMjgiLCJpYXQiOjE3MjQzMzcyOTAsImV4cCI6MTcyNDM0MDg5MH0.3V3LhYUHc0rr7Lg9jnZl8Zt8v4YIhHpY8m5J6RTAotk";
        given()
            .header("", "Bearer " + token)
        .when()
            .get("/auth/products")
        .then()
            .log().all()
            .statusCode(403)
            .body( "message", is("Authentication Problem"))
            ;
    }
}