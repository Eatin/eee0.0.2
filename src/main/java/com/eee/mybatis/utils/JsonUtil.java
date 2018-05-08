package com.eee.mybatis.utils;

import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil<T> {
	
	public String getJsonByEntity(T t) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper om=new ObjectMapper();
		String 	str = om.writeValueAsString(t);
		System.out.println(str);
		return str;
	}
	
	public String getJsonByListObj(List<T> t) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper om=new ObjectMapper();
		String 	str = om.writeValueAsString(t);
		System.out.println(str);
		return str;
	}
	
	public String getJsonByObject(Object t) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper om=new ObjectMapper();
		String 	str = om.writeValueAsString(t);
		System.out.println(str);
		return str;
	}

}
