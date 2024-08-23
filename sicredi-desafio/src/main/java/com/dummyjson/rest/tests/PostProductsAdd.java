package com.dummyjson.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


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
	public void deveAdicionarProdutoComSucesso() {
		Products prod = new Products();
		prod.setTitle("hot wheels");
		prod.setDescription("Desconto na primeira compra");
		prod.setPrice(1);
		prod.setDiscountPercentage(9.5);
		prod.setRating(5.0);
		prod.setStock(100);
		prod.setBrand("hot wheels");
		prod.setCategory("Carros em miniatura");
		prod.setThumbnail("https://portforward.com/hot-wheels-unleashed/hot-wheels-unleashed-header-large.webp");
		
		given()
			.body(prod)
		.when()
			.post("/products/add")
			
		.then()
			.log().all()
			.statusCode(201)
			.body("id", not(empty()))
			.body("title",is("hot wheels"));
			;
	}
}
