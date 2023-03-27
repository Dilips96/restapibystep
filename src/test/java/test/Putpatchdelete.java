package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class Putpatchdelete 
{

	@Test
	public void putmethod() 
	{
		JSONObject request = new JSONObject();
		
		request.put("name", "Kiranmayee");
		request.put("job", "Intern");
		System.out.println(request.toJSONString());
		
		

		baseURI = "https://reqres.in/api"; 
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).// this is Explicity saying and telling server that i am sending to you is of type json 
		
		 body(request.toJSONString()). // response i will should also be of type Json 
		when().
		 put("/users/2").
		then().log().all().
		 statusCode(200);
		
		
		System.out.println("This is How we handle put request");	
		
	}
	
	
	@Test
	public void patchmethod()
	{
        JSONObject request = new JSONObject();
		
		request.put("name", "Kiranmayee");
		request.put("job", "Intern");
		System.out.println(request.toJSONString());
		
		
        baseURI = "https://reqres.in"; 
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).// this is Explicity saying and telling server that i am sending to you is of type json 
		
		 body(request.toJSONString()). // response i will should also be of type Json 
		when().
		 patch("/api/users/2").
		then().log().all().
		 statusCode(200);
		
		
		
		
		
		System.out.println("This is the Function for Patch request");	
		
	}
	
	@Test
	public void deletemethod()
	{
		
		
        baseURI = "https://reqres.in"; 
		
		
		when().
		 delete("/api/users/2").
		then().log().all().
		 statusCode(204);
		
		
	  System.out.println("This is for the delete method");
		
	}
	
	
	
}
