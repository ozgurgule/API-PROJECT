package apitest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpartanTest {
String BASEURL = "\n" +
        "http://54.225.26.215:8000";

    @Test
    public void test1(){
        Response response = RestAssured.get(BASEURL + "/api/spartans");
        //response.prettyPrint();
        System.out.println("response.statusCode() = " + response.statusCode());

    }
    @Test
    public void test2(){
        Response response = RestAssured.get(BASEURL + "/api/spartans");
        //System.out.println("response.prettyPrint() = " + response.prettyPrint());
        System.out.println("response.contentType() = " + response.contentType());
        //response.contentType(ContentType.JSON);
        Assert.assertEquals(response.contentType(),"application/json");
    }



}
