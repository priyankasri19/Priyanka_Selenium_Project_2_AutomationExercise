package setup;

import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class TestDataReader {
    
	public static JSONObject commonTestData() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader("./test-data/CommonData.json");
		Object obj = jsonParser.parse(fileReader);
		JSONObject commonTestDetails = (JSONObject) obj;
		return commonTestDetails;
	}
	
	public static JSONObject accountDetails() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader("./test-data/AccountAddressInfo.json");
		Object obj = jsonParser.parse(fileReader);
		JSONObject accountDetails = (JSONObject) obj;
		return accountDetails;
	}
	
	public static JSONObject validUserDetails() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader("./test-data/ValidUser.json");
		Object obj = jsonParser.parse(fileReader);
		JSONObject validUserDetails = (JSONObject) obj;
		return validUserDetails;
	}
	
	public static JSONObject invalidUserDetails() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader("./test-data/InvalidUser.json");
		Object obj = jsonParser.parse(fileReader);
		JSONObject invalidUserDetails = (JSONObject) obj;
		return invalidUserDetails;
	}

	
	public static JSONObject paymentDetails() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader("./test-data/PaymentDetails.json");
		Object obj = jsonParser.parse(fileReader);
		JSONObject paymentDetails = (JSONObject) obj;
		return paymentDetails;
	}

	
	public static String poloBrandProducts(String data) throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader("./test-data/PoloBrandProducts.json");
		Object obj = jsonParser.parse(fileReader);
		JSONObject poloBrandProducts = (JSONObject) obj;
        return (String)poloBrandProducts.get(data);
	}

	public static String madameBrandProducts(String data) throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader("./test-data/MadameBrandProducts.json");
		Object obj = jsonParser.parse(fileReader);
		JSONObject madameBrandProducts = (JSONObject) obj;
		return (String)madameBrandProducts.get(data);
	}
		    

}
