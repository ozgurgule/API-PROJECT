package apitest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class SimpleGetRequest {

   String hrurl = "\n" +
           "http://54.225.26.215:1000/ords/hr/regions";
    @Test

    public void test1(){
        Response response = RestAssured.get(hrurl);
        System.out.println(response.statusCode());
        //print the json body
        response.prettyPrint();
        /*
        given accept type is json
        when user sends get request to regions endpoint
        Then response status code must be 200
        and body is json format

         */


    }
    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(hrurl);
        //verify response status code is 200
        Assert.assertEquals(response.statusCode(),200);

        //verify content type is application/json

        System.out.println(response.contentType());
        Assert.assertEquals(response.contentType(),"application/json");


    }

@Test
    public void test3(){
        RestAssured.given().accept(ContentType.JSON)
                .when().get(hrurl).then()
                .assertThat().statusCode(200)
                .and().contentType("application/json");
}


/*
Given accept type is json
when user sends get request to regions/2
Then response status code must be 200
and body is json format
and response body contains Americas
 */

@Test
    public void test4(){
            Response response = given().accept(ContentType.JSON)
            .when().get(hrurl+"/2");

         Assert.assertEquals(response.getStatusCode(), 200);
         Assert.assertEquals(response.contentType(),"application/json");
         Assert.assertTrue(response.body().asString().contains("Americas"));


}



    }











