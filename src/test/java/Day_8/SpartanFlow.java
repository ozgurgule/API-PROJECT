package Day_8;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;

public class SpartanFlow {  @BeforeClass
public void beforeClass(){
    baseURI = ConfigurationReader.get("spartan_api_url");
}
@Test
    public void test1(){
    given()
            .accept(ContentType.JSON)
            .and()
            .when().get("http://54.225.26.215:8000/api/spartans")
            .then().log().all()
            .statusCode(200);
}
}
