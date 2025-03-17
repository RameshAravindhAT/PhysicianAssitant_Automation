package Restassured;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
public class Customlogin {
	
		
		    public static void main(String[] args) {
		        // Base URI
		        RestAssured.baseURI = "https://staging.api.physicianassist.com";
		        
		        // Creating JSON object for request body
		        JSONObject requestBody = new JSONObject();
		        JSONObject data = new JSONObject();
		        data.put("email", "thejaswini+bynkkstaging@navadhiti.com");
		        data.put("password", "Teju@5555");
		        requestBody.put	("data", data);
		        
		        // Sending POST request
		        Response response = 
		            given()
		                .contentType(ContentType.JSON)
		                .body(requestBody.toString())
		            .when()	
		                .post("/api/v1/auth/login/custom")
		            .then()
		                .statusCode(200) // Expecting a 200 response
		                .extract()
		                .response();
		        
		        // Print Response
		        System.out.println("Response: " + response.asString());
		    }
		}



