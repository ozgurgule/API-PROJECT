package apitest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;
public class hrApiWithPath {


    @BeforeClass
    public void beforeClass(){
        baseURI="http://54.225.26.215:1000/ords/hr";
    }


    @Test

    public void getCountriesWithPath(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\"region_id\":2}")
                .when().get("/countries");

        assertEquals(response.statusCode(),200);
        //print limit value
        System.out.println("response.path(\"limit\") = " + response.path("limit"));

        System.out.println("response.path(\"hasMore\").toString() = " + response.path("hasMore").toString());
        String firstCountryId = response.path("items.country_id[0]");
        System.out.println("firstCountryId = " + firstCountryId);
        String firstCountryName = response.path("items.country_name[0]");
        System.out.println("firstCountryName = " + firstCountryName);

        //items.country_name[1]
String ninethcountryName = response.path("items.country_name[19]");
        System.out.println("secondCountryName = " + ninethcountryName);


        String secondElementLink = response.path("items.links[2].href[0]");
        System.out.println("secondElementLink = " + secondElementLink);

        List<Object> countryName = response.path("items.country_name");
        System.out.println(countryName);

        //assert that all regions_id are equal to 2

        List<Integer> allRegionID = response.path("items.region_id");

        for (int allRegionIds : allRegionID) {
            System.out.println(allRegionID);
            assertEquals(allRegionID,2);
        }



    }
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q","{\"job_id\":\"IT_PROG\"}")
                .when().get("/employees");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json");
        assertTrue(response.body().asString().contains("IT_PROG"));

        //makes sure we have only IT_PROG as a job_id
        List<String> jobIDs = response.path("items.job_id");

        for (String jobID : jobIDs) {
            System.out.println("jobID = " + jobID);
            assertEquals(jobID,"IT_PROG");
        }


    }
}
