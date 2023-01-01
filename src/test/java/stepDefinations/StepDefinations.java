package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddBook;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;



public class StepDefinations extends Utils {
	RequestSpecification res;
	TestDataBuild AddBook=new TestDataBuild();
	ResponseSpecification resspec;
	Response response;
	String id="1";
	
	@Given("^Create a Book PayLoad with (.+), (.+), (.+), (.+), (.+), (.+)$")
    public void create_a_book_payload_with_(String id, String title, String description, String pagecount, String excerpt, String publishdate) throws Throwable {
		res=given().spec(requestSpecification()).body(AddBook.addBookPayLoad(id, title, description, pagecount, excerpt, publishdate));
        
    }

    @When("^User calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_calls_something_with_something_http_request(String resource, String method) throws Throwable {
    	
    	APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		
		if(method.equalsIgnoreCase("POST")) {
			response=res.when().post(resourceAPI.getResource()).then().extract().response();
			}
		else if(method.equalsIgnoreCase("GET")) {
			response=res.when().get(resourceAPI.getResource()).then().extract().response();
		}
		else if(method.equalsIgnoreCase("PUT")) {
			response=res.when().put(resourceAPI.getResource()).then().extract().response();
		}
		else if(method.equalsIgnoreCase("DELETE")) {
			response=res.when().delete(resourceAPI.getResource()).then().extract().response();
        
    }
    }

    @Then("^API call got success with status code 200$")
    public void api_call_got_success_with_status_code_200() throws Throwable 
    {
    	
    	assertEquals(response.getStatusCode(),200);
    }
    	

    @And("^\"([^\"]*)\" in the response body is \"([^\"]*)\"$")
    public void something_in_the_response_body_is_something(String key, String value) throws Throwable {
    	
    	assertEquals(getJsonPath(response,key),value);
        
    }
    
    @Given("^pass the book (.+) to \"([^\"]*)\" book$")
    public void pass_the_book_to_something_book(String id, String strArg1) throws Throwable {
    	
    	res=given().spec(requestSpecification()).pathParam("id", id);
       
    }
    

    @Given("^Update a Book with payload (.+), (.+), (.+), (.+), (.+), (.+)$")
    public void update_a_book_with_payload_(String id, String title, String description, String pagecount, String excerpt, String publishdate) throws Throwable {
    	
    	res=given().spec(requestSpecification()).pathParam("id",id)
				 .body(AddBook.addBookPayLoad(id, title, description, pagecount, excerpt, publishdate));
        
    }

}
