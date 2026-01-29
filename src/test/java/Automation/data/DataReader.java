package Automation.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		       //read json to string
		//FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
		String jsconcontent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Automation\\data\\PurchaseOrder.json") ,StandardCharsets.UTF_8);
		
		
	
	
	//String to Hashmap  -->jackson bind
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>>  data=mapper.readValue(jsconcontent, new TypeReference<List<HashMap<String,String>>>() {
		});
	return data;  //{} { }

}}
