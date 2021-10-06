package RestAPI;
import apiEngine.request.AddBooksRequest;
import apiEngine.request.AuthorizationRequest;
import apiEngine.request.ISBN;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class APIEnd2End {

       private static final String base_url = "https://bookstore.toolsqa.com";
       private static final String content_type = "application/json";
       private static final String generate_token_path = "/Account/v1/GenerateToken";
       private static final String books_path = "/BookStore/v1/Books";
       private static final String userName = "TOOLSQA-Test";
       private static final String password = "Test@@123";

       private static final String userID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
       private static final String bookId = "1002003004005";

       @Test
       public void getBooks(){
           // 1. request
           RestAssured.baseURI = base_url;
           RequestSpecification request = RestAssured.given();
           request.header("Content-Type", content_type);

           // 2. get response - get token
           AuthorizationRequest authorizationRequest = new AuthorizationRequest(userName, password);
           Response response = request.body(authorizationRequest)
                   .post(generate_token_path);
           String jsonString = response.asString();
           //System.out.println(jsonString);

           String token = JsonPath.from(jsonString).get("token");

           // 3. get books list
           response = request.get(books_path);
           System.out.println(response.asString());

           List<Map<String, String>> mapList = JsonPath.from(response.asString()).get("books");

           // 4. add a book
           request.header("Authorization", "Bearer " + token)
                   .header("Content-Type", "application/json");
           AddBooksRequest addBooksRequest = new AddBooksRequest(userID, new ISBN(bookId));

           response = request.body(addBooksRequest)
                   .post("/BookStore/v1/Books");

           System.out.println(response.getStatusCode());



        }


}
