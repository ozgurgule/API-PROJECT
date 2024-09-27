package Day_8;

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
import static io.restassured.RestAssured.baseURI;
public class deleteRequestDemo {


    @BeforeClass
        public void beforeClass(){
            baseURI = ConfigurationReader.get("spartan_api_url");
        }
        @Test
        public void test1(){
            //create one map for the put request json body



            given().log().all()
                    .given()
                    .pathParam("id",776)

                    .when().delete("api/spartans/{id}")
                    .then().log().all()
                    .assertThat().statusCode(204);



    }






}
