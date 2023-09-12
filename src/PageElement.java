//package com.zenrows.data; 
import java.util.HashMap;

public class PageElement { 
	private String url; 
	private String image; 
	private String name; 
	private String price; 
	private static HashMap<String,String> values = new HashMap<>(); 
 
	// getters and setters omitted for brevity... 
 
	@Override 
	public String toString() { 
		return "{ \"url\":\"" + url + "\", " 
				+ " \"image\": \"" + image + "\", " 
				+ "\"name\":\"" + name + "\", " 
				+ "\"price\": \"" + price + "\" }"; 
	} 
	
	public static void setProperty(String propName, String propVal) {
		values.put(propName, propVal);
	}
}