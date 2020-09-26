package day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
public class ApiTEst {
/*    Verify sorting hat
1.Send a get request to /sortingHat. Request includes :
            2.Verify status code 200,
            3.Verify the content type is application/json; charset=utf-8
            4. Verify that response body contains one of the following houses:
            "Gryﬃndor", "Ravenclaw", "Slytherin", "Huﬄepuﬀ"*/
    @Test

    public void test(){
        String path="https://www.potterapi.com/v1/";
Response response = given().when().get(path+"sortingHat");
response.then().assertThat().statusCode(200);
response.prettyPrint();
List<String> list= new ArrayList<>();
list.add("\"Gryffndor\"");
list.add("\"Ravenclaw\"");
list.add("\"Hufflepuff\"");
Assert.assertTrue(list.contains(response.asString()));





    }

/*    Verify no key
1.Send a get request to /characters. Request includes :
            • Header Accept with value application/json
2. Verify status code 409, content type application/json; charset=utf-8
            3. Verify response status line include message Conﬂict
4. Verify that response body says "error": "Must pass API key for request"*/
    @Test
    public void test1(){
        String path="https://www.potterapi.com/v1/";
        Response response= given().when().get(path+"characters");
        response.prettyPrint();
        System.out.println(response.getContentType());







    }




}
