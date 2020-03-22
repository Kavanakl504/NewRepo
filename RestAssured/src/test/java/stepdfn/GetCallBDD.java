package stepdfn;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetCallBDD {

	@Test
	public void test_numberOfCircuitsFor2017()
	{
		given().
		when().
			get("http://ergast.com/api/f1/2017/circuits.json").
		then().
			assertThat().
			statusCode(200).
			and().
			body("MRData.CircuitTable.Circuits.circuitId",hasSize(20)).and().
			
			header("Content-Length",equalTo("4551"));
		
	
	}
	@Test
	public void test_numberOfRoundsFor2018()
	{
		given().
		when().
			get("http://ergast.com/api/f1/2018.json").
		then().
			assertThat().
			statusCode(200).
			and().
			body("MRData.RaceTable.Races.round",hasSize(21));
			
			
		
	
	}
	@Test
	public void test_currentF1()
	{
		given().
		when().
			get("http://ergast.com/api/f1/current.json").
		then().
			assertThat().
			statusCode(200).
			and().
			body("MRData.RaceTable.Races.Circuit.circuitName",hasSize(21));
			
			
		
	
	}
}
