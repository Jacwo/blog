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
	
	/**
	 * 获取ObjectMapper实例
	 * @param createNew 方式：true，新实例；false,存在的mapper实例
	 * @return
	 */
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
	
	/**
	 * 将java对象转换成json字符串
	 * @param obj 准备转换的对象
	 * @return json字符串
	 * @throws Exception 
	 */
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
	
	/**
	 * 将java对象转换成json字符串
	 * @param obj 准备转换的对象
	 * @param createNew ObjectMapper实例方式:true，新实例;false,存在的mapper实例
	 * @return json字符串
	 * @throws Exception
	 */
	public static String beanToJson(Object obj,Boolean createNew) {
		try {
			ObjectMapper objectMapper = getMapperInstance(createNew);
			String json =objectMapper.writeValueAsString(obj);
			return json;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}
	
	/**
	 * 将json字符串转换成java对象
	 * @param json 准备转换的json字符串
	 * @param cls  准备转换的类
	 * @return 
	 * @throws Exception 
	 */
	public static <T> T jsonToBean(String json, Class<T> cls) {
		try {
		ObjectMapper objectMapper = getMapperInstance(false);
		T vo = objectMapper.readValue(json, cls);
		return vo;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}	
	}
	/**
	 * 将json字符串转换成java对象
	 * @param json 准备转换的json字符串
	 * @param cls  准备转换的类
	 * @return 
	 * @throws Exception 
	 */
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
	
	/**
	 * 将json字符串转换成java对象
	 * @param json 准备转换的json字符串
	 * @param cls  准备转换的类
	 * @param createNew ObjectMapper实例方式:true，新实例;false,存在的mapper实例
	 * @return
	 * @throws Exception
	 */
	public static <T> T jsonToBean(String json, Class<T> cls,Boolean createNew) {
		try {
		ObjectMapper objectMapper = getMapperInstance(createNew);
		T vo = objectMapper.readValue(json, cls);
		return vo;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}	
	}
	
	   /**   
     * 获取泛型的Collection Type  
     * @param collectionClass 泛型的Collection   
     * @param elementClasses 元素类   
     * @return JavaType Java类型   
     * @since 1.0   
     */   
 public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
     return getMapperInstance(false).getTypeFactory().constructParametricType(collectionClass, elementClasses);   
 }
 
 /**
	 * 将json字符串转换成java对象
	 * @param json 准备转换的json字符串
	 * @param cls  准备转换的类
	 * @return 
	 * @throws Exception 
	 */
	public static Object jsonToBeanList(String json, JavaType javaType) {
		try {	       		
		      return mapper.readValue(json, javaType);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}	
	}
}