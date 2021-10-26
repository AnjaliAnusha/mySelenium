package com.myown.mySeleniumProject.AutomateAPI;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.*;

import static org.testng.Assert.assertEquals;

import org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;



/**
 * Hello world!
 *
 */
public class AutomateAPI 
{
	@Test
    public void APIresponse( )
    {
       
	
    	RestAssured.baseURI="http://localhost:8081/api/persons/";
    	RequestSpecification httpRequest = RestAssured.given();
    //Post Request
    	JSONObject requestParams = new JSONObject();
    	requestParams.put("id", 6); 
    	requestParams.put("name", "anukanth2");
    	requestParams.put("email", "anu@gmail.com");
    	requestParams.put("actived", true);
    	httpRequest.header("Content-Type", "application/json");
    	httpRequest.body(requestParams.toJSONString());
    	
    	Response postresponse = httpRequest.post("/");
    	
    	int poststatuscode=postresponse.getStatusCode();
    	Assert.assertEquals(poststatuscode,201,"As expected");
    	
    	//Get
    	Response getresponse = httpRequest.get("/");
    	int getstatuscode=getresponse.getStatusCode();
    	Assert.assertEquals(getstatuscode,200,"As expected");
    	
    	getresponse.prettyPrint();
    	
    	//Environment 1
    	//Conflict with Environment1
   
    	
    }	
		
}

