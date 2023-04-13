package test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;



public class GetPostMethod 
{

	@Test
	public void getmethod()
	{
		
		baseURI = "https://reqres.in/api"; 
		///users?page=2 	
		
		given()
		.get("users?page=2").
		then().log().all()
		.statusCode(200)
		.log().all().body("data[4].first_name",equalTo("George"))
		.body("data.first_name", hasItems("George","Rachel"));
			
		
	}
	
	@Test
	public void getpost() 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
	    map.put("name", "Dilip");
	    map.put("job", "Software Tester");
		System.out.println(map);
		
		
		/* As of now this has not been converted to json format to convert it we have to add json simple dependency in
		   pom.xml file.
		   
		   After that we have to creat an JSONObject request = new JSONObject(map);
		   System.out.println(request);
		
		*/
		
		
		
		JSONObject request = new JSONObject();
		request.put("name", "Kiranmayee");
		request.put("job", "Intern");
		System.out.println(request.toJSONString(request));
		
		
		baseURI = "https://reqres.in/api"; 
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).// this is Explicity saying and telling server that i am sending to you is of type json 
		
		 body(request.toJSONString()). // response i will should also be of type Json 
		when().
		 post("/users").
		then().log().all().
		 statusCode(201);
		
		
		System.out.println("This is How we handle post request");
		
		
	}


	
	
	
}
