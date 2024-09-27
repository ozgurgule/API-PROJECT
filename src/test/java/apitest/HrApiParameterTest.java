package apitest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;


import static io.restassured.RestAssured.baseURI;

public class HrApiParameterTest {@BeforeClass
public void beforeclass(){

    baseURI="http://54.225.26.215:8000";


    baseURI="http://54.225.26.215:1000/ords/hr";



}

/*
given accept type is json
and parameters q = region_id
when users sends a get request to " /contries"
Then status code is 200
And content type is  application/json
and payload/body should contain "United State of America
 */


@Test
    public void test1(){

Response response = given().accept(ContentType.JSON)
        .and().queryParam("q", "{\"region_id\":2}")
                .when().get("/countries");

assertEquals(response.statusCode(),200);
assertEquals(response.contentType(),"application/json");
assertTrue(response.body().asString().contains("United States of America"));


}


@Test
    public void test2(){
    Response response = given().accept(ContentType.JSON).queryParam("q", "{\"job_id\":\"IT_PROG\"}")
            .when().get("/employees");

    assertEquals(response.statusCode(),200);
    assertEquals(response.contentType(),"application/json");
    assertTrue(response.body().asString().contains("IT_PROG"));
}
@Test
    public void getAllSpartanWithPath(){
    Response response = given().accept(ContentType.JSON)
            .when().get("/api/spartans");
    assertEquals(response.statusCode(),200);

    assertEquals(response.getHeader("Content-Type"),"application/json");
    int firstID = response.path("id[0]");
    System.out.println("firstID = " + firstID);
    String firstName = response.path("name[0]");
    System.out.println("firstName = " + firstName);
// When you put the -1 its returns  to last element

    String lastFirstName = response.path("name[-1]");
    System.out.println("lastFirstName = " + lastFirstName);

    int lastId = response.path("id[-1]");
    System.out.println("lastId = " + lastId);
    
    //print all names of spartans

    List<String> names = response.path("name");
    System.out.println("names = " + names);
    //print all the phone number

    List<Object> phones = response.path("phone");
    System.out.println("phones = " + phones);

    for (Object phone : phones) {
        System.out.println(phone);

    }








}






















}
