package apitest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;
public class CBTraingWithJsonPath {


    @BeforeClass
    public void beforeClass(){
        baseURI = ConfigurationReader.get("cbt_api_url");
    }
    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id",2)
                .when().get("/student/{id}");

        assertEquals(response.statusCode(),200);


        //assing response  to jsonpath

        JsonPath jsonPath = response.jsonPath();

        //get values from jsonpath

        String first_name =  jsonPath.getString("students.firstName[0]");
        System.out.println("first_name = " + first_name);

        String phoneNumber = jsonPath.getString("students.contact[0].phone");
        System.out.println("phoneNumber = " + phoneNumber);
String city = jsonPath.getString("students.company[0].address.city");
        System.out.println("city = " + city);
        assertEquals(city,"McLean");

        //get zip code


     int zipcode = jsonPath.getInt("students.company[0].address.zipCode");
        System.out.println("zipcode = " + zipcode);

        assertEquals(zipcode,33222);

        String firstname2 = jsonPath.getString("students.firstName");
        System.out.println("firstname2 = " + firstname2);


    }


}
