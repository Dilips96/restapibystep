package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Ekb 
{

	
	@Test
	public void getmethodekb()
	
		
		{
		
		RestAssured.baseURI ="http://tradeapi.ekbazaar.com/api";
		given().log().all().queryParam("client", "one").when().get("/referralcode?client=one")
		.then().log().all().assertThat().statusCode(200);
			
		}
		
	
	
	
	
	

}
