package com.ncs.Day9;

import static org.junit.Assert.*;


import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import org.json.simple.JSONArray;



public class JSONdataReadTest {
	@Before
	public void setUpBeforeClass() throws Exception {
	}

	@After
	public void tearDownAfterClass() throws Exception {
	}

	// Find file browser.data, Read objects of it, convert it into json data & Print
	
	@Test
	public void test() throws IOException, ParseException, org.json.simple.parser.ParseException {

		// Find file instance.json, Read Array objects of it, convert it into json data & Print
	
	 //Json Array Object
	
	FileReader fr2 = new FileReader(System.getProperty("user.dir")+ "/data/instancedata.json");
	JSONParser jsp1 = new JSONParser(); // pass json data into java  object
	JSONArray jo1 = (JSONArray) jsp1.parse(fr2); 
	
	JSONObject job1 = (JSONObject) ((JSONObject)jo1.get(0)).get("1");
	System.out.println(job1.get("browsername"));
	System.out.println(job1.get("browserversion"));


}
	@Test
	public void test2() throws IOException, ParseException, org.json.simple.parser.ParseException {
		
		FileReader fr = new FileReader(System.getProperty("user.dir")+ "/data/browserdata.json");
		JSONParser jsp = new JSONParser();
		JSONObject jo = (JSONObject)jsp.parse(fr);  // cast it into JSON Object
	
		System.out.println(jo.get("browsername"));
		System.out.println(jo.get("browserversion"));

		System.out.println(jo.get("os"));

		System.out.println(jo.get("os.version"));

	

}
}
