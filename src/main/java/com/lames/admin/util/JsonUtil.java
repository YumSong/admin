package com.lames.admin.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtil {
	private static ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper();
	}
	
	/**
	 * object转json
	 * @param obj
	 * @return
	 */
	public static String objectToJson(Object obj) {
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * json转Object
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static Object jsonToObject(String jsonStr, Class clazz) {
		Object obj = null;
		try {
			obj = mapper.readValue(jsonStr, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
