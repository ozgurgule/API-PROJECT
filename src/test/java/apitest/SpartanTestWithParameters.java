package apitest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class SpartanTestWithParameters {

    @BeforeClass
            public void beforeclass(){

baseURI="http://54.225.26.215:8000";


    }
    /*
    given accept type is json
    and id parameter value is 5
    When user sends get request to /api/spartans/{id}
    Then response status code should be 200
    And response content-type: application/json;charset=UTF-8
    And "Blythe" should be in response payload(body)
    payload =body
     */

    @Test
    public void test1(){

        System.out.print(get("api/spartans").asString() + "\n");

        Response response = given().accept(ContentType.JSON)
                        .and().pathParams("id",5)
                        .when().get("/api/spartans/{id}");



        //response status code should be 200
        Assert.assertEquals(response.statusCode(),200);
        //response content-type "application/json;charset=UTF-8
        Assert.assertEquals(response.contentType(),"applications/json;charset=UTF-8");

        Assert.assertTrue(response.body().asString().contains("Blythe"));


    }
    /*
    task
    given accept type is json
    and id parameter value is 500
    when user sends GET request to /api/spartan/{id}
    Then response status code should be 404
    and response content-type : application/json;charset=UTF-8
    and spartan not found message should be in response payload or body
     */

    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParams("id",500)
                .when().get("/api/spartan/{id}");
        Assert.assertEquals(response.statusCode(),404);
        Assert.assertEquals(response.contentType(),"application/json");
        Assert.assertTrue(response.body().asString().contains("Spartan Not Found"));


    }
    /*
    given accept type is json
    and query parameter values are
    gender/female
    nameContains / e
    when user sends GET request to /api/spartans/search
    Then response status code should be 200
    and response content-type application/json;charset=UTF-8
     and "Female" should be in response payload or body
     and "janette"should be in response payload or body
     */


@Test
    public void test4(){
    Response response = given().accept(ContentType.JSON)
            .and().queryParam("gender","Female")
            .and().queryParam("nameContains","e")
            .when().get("/api/spartans/search");

    Assert.assertEquals(response.statusCode(),200);

    Assert.assertEquals(response.contentType(),"application/json");

    Assert.assertTrue(response.body().asString().contains("Female"));
    Assert.assertTrue(response.body().asString().contains("Janette"));



}
@Test
    public void positiveTestWithQueryParamWithMaps(){
    //create a map and add query parameters

    Map<String, Object> queryMap = new HashMap<>();
    queryMap.put("gender", "Female");
    queryMap.put("nameContains", "e");

    Response response = given().accept(ContentType.JSON)
            .and().queryParams(queryMap)
            .when().get("api/spartans/search");

    Assert.assertEquals(response.statusCode(),200);

    Assert.assertEquals(response.contentType(),"application/json");

    Assert.assertTrue(response.body().asString().contains("Female"));
    Assert.assertTrue(response.body().asString().contains("Janette"));


}













}
