package Day_6;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
public class Pojo_Deserialization {
@Test
    public void oneSpartanPojo(){
    Response response = given().accept(ContentType.JSON)
            .pathParam("id",67)
            .when().get("http://54.225.26.215:8000/api/spartans/{id}");
    assertEquals(response.statusCode(),200);

    /*
    json to POJO --de serialize to java custom class
    json to our spartan class object
     */

    Spartan spartan = response.body().as(Spartan.class);
    System.out.println(spartan);

    System.out.println("spartan.getId() = " + spartan.getId());
    System.out.println("spartan.getGender() = " + spartan.getGender());
    assertEquals(spartan.getId(),67);
    assertEquals(spartan.getGender(),"Female");


}
@Test
    public void test3(){
    Gson gson = new Gson();
    String myJsonData = "{\n" +
            "\"id\": 67,\n" +
            "        \"name\": \"Janette\",\n" +
            "        \"gender\": \"Female\",\n" +
            "        \"phone\": 9887020445\n"+
"}";

    Map<String,Object> map = gson.fromJson(myJsonData, Map.class);

    System.out.println("map = " + map);

    Spartan spartan = gson.fromJson(myJsonData,Spartan.class);
    System.out.println("spartan = " + spartan);
    // java collection or pojo to json

    Spartan spartan12 = new Spartan(200,"Mike","Male",1234569745);
    String jsonSpartanEu = gson.toJson(spartan12);
    System.out.println("jsonSpartanEu = " + jsonSpartanEu);


}






}
