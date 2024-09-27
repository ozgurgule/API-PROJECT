package apitest;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
public class jsonToJavaCollection {
    @BeforeClass

    public void beforeclass(){

        baseURI= ConfigurationReader.get("hr_api_url");


    }


    @Test
    public void SpartanToMap(){
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 67)
                .when().get("/api/spartans/{id}");
        assertEquals(response.statusCode(),200);

        // we will convert json response to java map

        Map<String,Object> jsonDataMap = response.body().as(Map.class);

        System.out.println("jsonDataMap = " + jsonDataMap);

        String name = (String) jsonDataMap.get("name");

        assertEquals(name, "Janette");
        //De-serialization = converting your json to java collection
        //Serialization = converting your java collection to json

        double phone = (double) jsonDataMap.get("phone");
        System.out.println("phone = " + phone);


    }

    @Test
    public void allSpartansToListOfMap(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        assertEquals(response.statusCode(),200);

        //we need to de serialize json response to List Of Map

        List<Map<String,Object>> allSpartanList = response.body().as(List.class);
        System.out.println(allSpartanList);

        //print second spartan first name


        System.out.println(allSpartanList.get(1).get("name"));

        Map<String,Object> spatan3 = allSpartanList.get(2);
        System.out.println(spatan3);


    }
    @Test
    public void regionToMap(){
        Response response = when().get("/regions");

        assertEquals(response.statusCode(),200);
        //we de serialize JSON response to Map
        Map<String,Object> regionMap = response.body().as(Map.class);
        System.out.println(regionMap.get("count"));

        System.out.println(regionMap.get("hasMore"));
        System.out.println(regionMap.get("items"));
        List<Map<String ,Object>> itemsList = (List<Map<String ,Object>>) regionMap.get("items");

        //print first region name
        System.out.println(itemsList.get(0).get("region_name"));


    }
}
