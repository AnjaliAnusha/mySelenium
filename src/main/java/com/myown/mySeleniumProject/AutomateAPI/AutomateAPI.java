package com.myown.mySeleniumProject.AutomateAPI;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.testng.Assert.assertEquals;

import org.hamcrest.Matchers.*;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;


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
    	Response response = httpRequest.get();
        
    	int statuscode=response.getStatusCode();
    	System.out.println(statuscode);
    	Assert.assertEquals(statuscode,200);
    	
    	
    	/*Soft Asset
    	SoftAssert softassert=new SoftAssert();
    	softassert.assertEquals(statuscode,200,"As expected");
    	softassert.assertAll();
    	*/
    	
    	//given().when().get("http://localhost:8081/api/persons/").prettyPrint();
    	
    }	
		
}

