package Day_8;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;
import org.testng.annotations.BeforeClass;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;

public class BookITAuthTest {


        @BeforeClass
        public void beforeClass() {
            baseURI = ConfigurationReader.get("book_it_url");
        }

String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs";
        @Test
    public void getAllCampuses(){
            Response response = given().header("Authorization",token).when().get("/api/campuses");
            response.prettyPrint()
                   ;
            System.out.println("response.statusCode() = " + response.statusCode());

        }

}
