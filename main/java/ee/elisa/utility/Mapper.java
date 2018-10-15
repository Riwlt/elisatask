package ee.elisa.utility;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
	
	private Mapper() {
		throw new IllegalStateException("Utility class");
	}
	
	public static Object mapFromJsonToClass(Class<?> entity, String jsonString) throws IOException {
		Object obj = null;
		if (entity != null && Mapper.isJSONValid(jsonString)) {
			ObjectMapper mapper = new ObjectMapper();
			obj = mapper.readValue(jsonString, entity);
		}
		return obj;
	}

	public static String mapToJsonFromObject(Object obj) throws JsonProcessingException {
		String jsonString = null;
		if (obj != null) {
			ObjectMapper mapper = new ObjectMapper();
			jsonString = mapper.writeValueAsString(obj);
		}
		return jsonString;
	}

	public static boolean isJSONValid(String jsonString) {
		try {
			new JSONObject(jsonString);
		} catch (JSONException ex) {
			try {
				new JSONArray(jsonString);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}
}
