package apitest;


import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
public class HamcrestMatchersApiTest {

    @Test
    public void OneSparthWithHamcrest(){
given().accept(ContentType.JSON)
        .and().pathParam("id",67).when().get("http://54.225.26.215:8000/api/spartans/{id}")
        .then().statusCode(200)
        .and().contentType("application/json").and().assertThat().body("id",equalTo(67),"name",
                equalTo("Janette"),"gender", equalTo("Female"),"phone",equalTo(9887020445L));


    }


}
