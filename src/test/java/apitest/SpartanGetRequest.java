package apitest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;




public class SpartanGetRequest {
    String spartanUrl = "http://54.225.26.215:8000";
    @Test
    public void test1(){
        Response response = when().get(spartanUrl+ "/api/spartans");
        System.out.println(response.statusCode());
        response.prettyPrint();


    }
    /*
    task
    When user sends a get request to api/spartans/3
    Then status code should be 200
    and content type should be application/json;charset=UFT-8
    and json body should contain fidole


     */
    @Test
    public void test2(){
        Response response = when().get(spartanUrl+ "/api/spartans/82");
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json;charset=UFT-8");
        Assert.assertTrue(response.body().asString().contains("fidole"));
    }
    /*
    given no headers provided
    when users sends get request to /api/hello
    Then repsonse status code should be 200
    and content type header should be "text/plain;charset=UTF-8"
    and header should contain date
    and content-length should be 17
    and body should be "Hello from Sparta"


     */
    @Test
    public void test3(){
        //get request

        Response response = when().get(spartanUrl + "/api/hello");
        //verify status code
        Assert.assertEquals(response.statusCode(),200);

        //verify content-type
        Assert.assertEquals(response.contentType(),"text/plain;charset=UTF-8");


        // verify we have headers named date
        // header and hearders different type of method for verifying
        Assert.assertTrue(response.headers().hasHeaderWithName("Date"));

        System.out.println(response.header("Content-Length"));
        System.out.println(response.header("Date"));
//verify content length is 17
        Assert.assertEquals(response.header("Content-Length"),"17");
    }

}
