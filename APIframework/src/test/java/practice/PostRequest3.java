package practice;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class PostRequest3 {
	
	@Test
	public void createPlaceXML() throws IOException

	 // when input and output is xml, we use GenerateStringFromResource method.
	{
		
		String postdata=GenerateStringFromResource("path\\post.xml");
		RestAssured.baseURI = "http://216.10.245.166";
		Response res=given().queryParam("key", "qaclick123").
		body(postdata).
		when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).and()
		.contentType(ContentType.XML).
		extract().response();    // extracting response
		
		String resp=res.asString();   // converting to string format
		XmlPath x=new XmlPath(resp);  // converting to xml format
		System.out.println(x.get("PlaceAndReposne.place_id"));

	}

	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}


