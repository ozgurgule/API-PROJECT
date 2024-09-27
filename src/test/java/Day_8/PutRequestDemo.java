package Day_8;

import static io.restassured.RestAssured.baseURI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;


public class PutRequestDemo {
    @BeforeClass
    public void beforeClass(){
        baseURI = ConfigurationReader.get("spartan_api_url");
    }
@Test
    public void test1(){
  //create one map for the put request json body

    Map<String, Object> putRequestMap = new HashMap<>();
    putRequestMap.put("name","Nike");
    putRequestMap.put("gender","Male");
    putRequestMap.put("phone","1234567890");

    given().log().all()
            .and()
            .contentType(ContentType.JSON)
            .and()
            .pathParam("id",82)
            .and()
            .body(putRequestMap)
            .when().put("api/spartans/{id}")
            .then().log().all()
            .assertThat().statusCode(204);


}
@Test
    public void test2(){//create one map for the put request json body

    Map<String, Object> patchRequestMap = new HashMap<>();
    patchRequestMap.put("name","FREE");


    given().log().all()
            .and()
            .contentType(ContentType.JSON)
            .and()
            .pathParam("id",82)
            .and()
            .body(patchRequestMap)
            .when()
            .patch("api/spartans/{id}")
            .then().log().all()
            .assertThat().statusCode(204);


}


}
