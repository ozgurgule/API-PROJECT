package apitest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;
public class hrApiWithJsonPath {

    @BeforeClass
    public void beforeClass(){

        baseURI= ConfigurationReader.get("hr_api_url");
    }
    @Test
    public void test1(){

        Response response = get("/countries");
        JsonPath jsonPath = response.jsonPath();
        String secondCountryName = jsonPath.getString("items.country_name[1]");
        System.out.println("secondCountryName = " + secondCountryName);

        // get all country ids

        List<String> countryIDs = jsonPath.getList("items.country_id");
        System.out.println("countryIDs = " + countryIDs);

        //get all country names their region id is equal to 2

        List<String > contryNamesWithRegionID2 = jsonPath.getList("items.findAll{it.region_id==2}.country_id");
        System.out.println("contryNamesWithRegionID2 = " + contryNamesWithRegionID2);


    }
    @Test
    public void test2 (){
        Response response = given().queryParam("limit", 107)
                .when().get("/employees");
        JsonPath jsonPath = response.jsonPath();
        // get me all email of employees who is working as IT_PROG

        List<String> firstName = jsonPath.getList("items.findAll{it.job_id==\"IT_PROG\"}.email");

        System.out.println(firstName);

        //get me all firstname of employees who is making more than 10000
        List<String> firstname2 = jsonPath.getList("items.findAll{it.salary>10000}.firstname");
        System.out.println(firstname2);

        String kingName = jsonPath.getString("items.max{it.salary}.first_name");
        System.out.println(kingName);


    }

    @Test
    public void test5 (){

        Response response = given().accept(ContentType.JSON)
                .when().get("/employees");
        response.prettyPrint();
        System.out.println("************************************");

   given().get("region_id");
   response.prettyPrint();
    }


}
