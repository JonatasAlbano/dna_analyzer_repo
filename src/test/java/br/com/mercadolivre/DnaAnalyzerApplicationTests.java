package br.com.mercadolivre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DnaAnalyzerApplicationTests {

	@LocalServerPort
	private int port;

	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
	}
	
	@Test
	public void whenHumanDna_thenReturns200() {
		
		RestAssured.basePath = "/simian";
		
		String[] dna = {"ATGCGA", "CAGTCC", "TTATGT", "AGACGG", "CCGCTA", "TCACTG"};
		JSONObject requestParams = new JSONObject();
		requestParams.put("dna", dna);
		
		RestAssured
		.given()
		.body(requestParams.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.statusCode(403);
	}
	
	@Test
	public void whenSimianDnaHorizontalSequence_thenReturns200() {
		
		RestAssured.basePath = "/simian";
		
		String[] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
		JSONObject requestParams = new JSONObject();
		requestParams.put("dna", dna);
		
		RestAssured
		.given()
		.body(requestParams.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.statusCode(200);
	}
	
	@Test
	public void whenSimianDnaVerticalSequence_thenReturns200() {
		
		RestAssured.basePath = "/simian";
		
		String[] dna = {"CTGA", "CTGA", "CATT", "CGAG"};
		JSONObject requestParams = new JSONObject();
		requestParams.put("dna", dna);
		
		RestAssured
		.given()
		.body(requestParams.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.statusCode(200);
	}
	
	@Test
	public void whenSimianDnaDiagonalRightSequence_thenReturns200() {
		
		RestAssured.basePath = "/simian";
		
		String[] dna = {"ATGA", "GAGA", "CTAT", "CGCA"};
		JSONObject requestParams = new JSONObject();
		requestParams.put("dna", dna);
		
		RestAssured
		.given()
		.body(requestParams.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.statusCode(200);
	}
	
	@Test
	public void whenSimianDnaDiagonalLeftSequence_thenReturns200() {
		
		RestAssured.basePath = "/simian";
		
		String[] dna = {"ATGA", "GAGA", "CTAT", "CGCA"};
		JSONObject requestParams = new JSONObject();
		requestParams.put("dna", dna);
		
		RestAssured
		.given()
		.body(requestParams.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.statusCode(200);
	}
	
	@Test
	public void whenMatrixIsNotSquare_thenReturns400() {
		
		RestAssured.basePath = "/simian";
		
		String[] dna = {"CTGGA", "CTAGA", "TATTA", "TATTA"};
		JSONObject requestParams = new JSONObject();
		requestParams.put("dna", dna);
		
		RestAssured
		.given()
		.body(requestParams.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.statusCode(400);
	}
	
	@Test
	public void whenDnaContainInvalidCharacter_thenReturns400() {
		
		RestAssured.basePath = "/simian";
		
		String[] dna = {"BBBAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
		JSONObject requestParams = new JSONObject();
		requestParams.put("dna", dna);
		
		RestAssured
		.given()
		.body(requestParams.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.statusCode(400);
	}
	
	@Test
	public void whenMatrixIsLessThanFourRowsAndColumns_thenReturns400() {
		
		RestAssured.basePath = "/simian";
		
		String[] dna = {"CTG", "CTG", "TAT"};
		JSONObject requestParams = new JSONObject();
		requestParams.put("dna", dna);
		
		
		RestAssured
		.given()
		.body(requestParams.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.statusCode(400);
	}
	
	@Test
	public void whenSimpleGetInStats_thenReturns200() {
		
		RestAssured.basePath = "/stats";
		RestAssured
		.given()
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(200);
	}

}
