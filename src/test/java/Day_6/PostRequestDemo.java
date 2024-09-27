package Day_6;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;


public class PostRequestDemo {
    /*
    given accept tppe and content type is json
    and request json body is
    {
    "gender" : "male"
    "name" : "MikeEU"
    "phone" : "856485215"
    }
    when user sends post request to '/api/spartans'
    then status code need to be 201
    And content Type should be application/json
    and json payload/body/response should contain
    "A spartan is born !" message and same data what is posted


     */

    @BeforeClass

    public void beforeclass(){

        baseURI="http://54.225.26.215:8000";


    }
    @Test
    public void test1 (){

        String jsonBody = "{\n" +
                "   \n" +
                "  \"name\": \"ozgur\",\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"phone\": 1234567890\n" +
                "}";
        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(jsonBody)
                .when().post("/api/spartans");

        //verify status code 201 for post

        assertEquals(response.statusCode(),201);

        //verify content type

        assertEquals(response.contentType(),"application/json");
        //verify successful message
        String actualmessage = response.path("message");
        String expectedMessage = "A Spartan is Born!";
        assertEquals(actualmessage,expectedMessage);

        //if you want to write in a one part code short way
        //assertEquals(response.path("succes"),"A Spartan is Born!");

        //assertion for spartan data

        String name = response.path("data.name");
        String gender = response.path("data.gender");
        int phone = response.path("data.phone");

      assertEquals(name,"ozgur");
      assertEquals(gender,"Male");
        assertEquals(phone,1234567890);
        response.prettyPrint();


    }
    @Test
    public void PostNewSpartan2(){
        //Create a map keep request json body information

        Map<String, Object> requestMap = new HashMap<>();

        //adding value that we want to post

        requestMap.put("name","Freeperson");
        requestMap.put("gender","Female");
        requestMap.put("phone",15245856422l);

        given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(requestMap)
                .when()
                .post("/api/spartans")
                .then().log().all()
                .statusCode(201)
                .and()
                .contentType("application/json")
                .and()
                .body("message", is("A Spartan is Born!"),
        "data.name", equalTo("Freeperson"),
        "data.gender", equalTo("Female"),
        "data.phone",equalTo(15245856422l));


    }
    @Test
    public void PostNewSpartan3(){

        Spartan spartanEU = new Spartan();

        spartanEU.setName("Freeperson");
        spartanEU.setGender("Female");
        spartanEU.setPhone(15245856422l);



        given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(spartanEU)
                .when()
                .post("/api/spartans")
                .then().log().all()
                .statusCode(201)
                .and()
                .contentType("application/json")
                .and()
                .body("message", is("A Spartan is Born!"),
                        "data.name", equalTo("Freeperson"),
                        "data.gender", equalTo("Female"),
                        "data.phone",equalTo(15245856422l));
    }

}
