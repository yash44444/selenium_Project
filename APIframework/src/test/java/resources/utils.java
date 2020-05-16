package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class utils {
	
	RequestSpecification req;
	public RequestSpecification requestSpecification() throws FileNotFoundException {
		
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt")); 			
		req =new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))				
				.setContentType(ContentType.JSON).build();				
				return req;	
	}
	
	private String getGlobalValue(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String globalproperties(String key) throws IOException {
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\YashuVerma\\eclipse-workspace\\APIframework\\src\\test\\java\\files\\environment.properties");
		pro.load(fis);
		return pro.getProperty(key);
		
	}

}
