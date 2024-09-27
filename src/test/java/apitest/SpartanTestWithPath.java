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


public class SpartanTestWithPath {  @BeforeClass
public void beforeclass(){

    baseURI="http://54.225.26.215:8000";


}
/*

given accept type is json
and path param id is 10
When user sends a get request to "api/spartans/{id}
Then status code is 200
And content-type is "application/json"

 */

    @Test
    public void getOneSpartan_Path(){
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 82)
                .when().get("/api/spartans/{id}");
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json");

        //printing each key value in the json body

        response.prettyPrint();
        System.out.println(response.path("id").toString());
        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());

int id = response.path("id");
String name = response.path("name");
String gender = response.path("gender");
long phone = response.path("phone");
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);
        Assert.assertEquals(id, 82);
        Assert.assertEquals(name,"Catie");
        Assert.assertEquals(gender,"Female");
        Assert.assertEquals(phone,4758237746l);




    }

















}
