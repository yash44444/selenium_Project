package practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import files.Resources;
import files.Payload;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteRequest {

	Properties pro = new Properties();

	@BeforeTest
	public void getData() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\YashuVerma\\eclipse-workspace\\APIframework\\src\\test\\java\\files\\environment.properties");
		pro.load(fis);
	}

	@Test
	public void AddandDeletePlace() {

		// Grab the response
		RestAssured.baseURI = pro.getProperty("HOST");
		Response res = given().queryParam("key", pro.getProperty("KEY")).body(Payload.PostData()).when()
				.post(Resources.postData()).then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.and().body("status", equalTo("OK")).extract().response();

		String responseString = res.asString();
		System.out.println(responseString);

		// Grab id from the response
		// converting string to json path.( response we get is in raw format. we convert
		// the raw reason to string and then to json)
		JsonPath js = new JsonPath(responseString);
		String placeId = js.get("place_id");
		System.out.println("placeId is " + placeId);

		// place this id in the delete request
		given().queryParam("key", pro.getProperty("KEY")).

				body("{" + "\"place_id\": \"" + placeId + "\"" + "}").when().post("/maps/api/place/delete/json").then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status", equalTo("OK"));

	}

}
