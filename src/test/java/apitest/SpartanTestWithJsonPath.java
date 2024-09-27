package apitest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class SpartanTestWithJsonPath {
    @BeforeClass

    public void beforeclass(){

        baseURI="http://54.225.26.215:8000";


    }
    /*
    given accept type is json
    and path param spartan id is 11
    When user sends a get request to /spartan/{id}
    Then status code is 200
    and content-type is json
    and
     */
    @Test
    public void test1(){
        Response response =  given().accept(ContentType.JSON)
                .and().pathParam("id",67)
                .when().get("/api/spartans/{id}");
        response.prettyPrint();

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json");

        int id = response.path("id");
        String name = response.path("name");
        assertEquals(id,67);
        assertEquals(name,"Janette");
        JsonPath jsonPath = response.jsonPath();

        int idJson = jsonPath.getInt("id");
        String nameJson = jsonPath.getString("name");
        String gender = jsonPath.getString("gender");
        long phone = jsonPath.getLong("phone");

        System.out.println("idJson = " + idJson);
        System.out.println("nameJson = " + nameJson);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);
        // verification

        assertEquals(idJson,67);
        assertEquals(nameJson,"Janette");
        assertEquals(gender,"Female");
        assertEquals(phone,"9887020445");














    }


}
