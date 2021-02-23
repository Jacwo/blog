package com.yyl.blog.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JacksonJsonUtil {

	private static ObjectMapper mapper;


	public static synchronized ObjectMapper getMapperInstance(boolean createNew) {
		if (createNew) {
			return new ObjectMapper();
		} else if (mapper == null) {
			mapper = new ObjectMapper();
		}
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}


	public static String beanToJson(Object obj){
		if (obj instanceof String) {
			return (String) obj;
		}
		try {
			ObjectMapper objectMapper = getMapperInstance(false);
			String json =objectMapper.writeValueAsString(obj);
			return json;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}


	public static String beanToJson(Object obj,Boolean createNew) {
		try {
			ObjectMapper objectMapper = getMapperInstance(createNew);
			String json =objectMapper.writeValueAsString(obj);
			return json;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}


	public static <T> T jsonToBean(String json, Class<T> cls) {
		try {
			ObjectMapper objectMapper = getMapperInstance(false);
			T vo = objectMapper.readValue(json, cls);
			return vo;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public static <T> List<T> jsonToBeanList(String json, Class<T> cls) {
		try {
			JavaType javaType = getCollectionType(ArrayList.class, cls);
			List<T> lst =  (List<T>)mapper.readValue(json, javaType);
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}


	public static <T> T jsonToBean(String json, Class<T> cls,Boolean createNew) {
		try {
			ObjectMapper objectMapper = getMapperInstance(createNew);
			T vo = objectMapper.readValue(json, cls);
			return vo;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}


	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return getMapperInstance(false).getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}


	public static Object jsonToBeanList(String json, JavaType javaType) {
		try {
			return mapper.readValue(json, javaType);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
}