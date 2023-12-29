
//package com.mkyong.io.csv.opencsv;
import java.util.HashMap;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteToCSV {
	private String csvName = "leads";
	private String defaultPath = "C:\\Users\\demon\\Downloads\\"+csvName+".csv";
	private static String[] header = { "BID", "Name", "Phone", "Website", "WebsiteDown", "Street", "City", "State", "ZipCode" };
	private List<String[]> csvList = new ArrayList<>() {{
		add(header);
	}};
	private HashMap<String, String> bizInfo;

	WriteToCSV() {
		//
	}

	/*
	public static List<String[]> createCsvData() {
		return csvList;
		/*
		 * String[] header = {"id", "name", "address", "phone"}; String[] record1 =
		 * {"1", "first name", "address 1", "11111"}; String[] record2 = {"2",
		 * "second name", "address 2", "22222"};
		 * 
		 * List<String[]> list = new ArrayList<>(); list.add(header); list.add(record1);
		 * list.add(record2);
		 * 
		 * return list;
		 
	}
*/

	public void addRecord(int bizId, HashMap<String, String> bizInfo) {
		String [] emptyl = {""," "};
		
		if (bizInfo.get("locality")!=null) {
			String[] cityState = (bizInfo.get("locality")!=null ? bizInfo.get("locality").split(", ") : emptyl);
			String[] stateZip = cityState[1].split(" ");
			String stateCode = stateZip[0];
			String zipCode = stateZip[1];
			String[] thisRecord = {
					String.valueOf(bizId),
					bizInfo.get("name"), 
					bizInfo.get("phone"), 
					bizInfo.get("website"), 
					bizInfo.get("websiteDown"), 
					bizInfo.get("streetAddress"), 
					cityState[0],
					stateCode,
					zipCode
					
			};
			csvList.add(thisRecord);
		} else {
			String[] thisRecord = {
					String.valueOf(bizId),
					bizInfo.get("name"), 
					bizInfo.get("phone"), 
					bizInfo.get("website"), 
					bizInfo.get("websiteDown"), 
					bizInfo.get("streetAddress"), 
					" ",
					" ",
					" "
			};
			System.out.println(bizInfo.get("streetAddress"));
			csvList.add(thisRecord);
		}
	}

	public void publishData(String path) {
		defaultPath = "C:\\Users\\demon\\Downloads\\"+csvName+".csv";
		if (path==null || path.equals("")) {
			path = defaultPath;
		} else {
			path+=(csvName+".csv");
			System.out.println(path);
		}
		if (path!=null) {
			try (
				CSVWriter writer = new CSVWriter(new FileWriter(path))) {
				writer.writeAll(csvList);
			} catch(Exception e) {
				System.out.println("ERROR: DATA FAILED TO SAVE");
			}
		} else {
			System.out.println("ERROR: DATA REQUIRES FILE PATH TO SAVE");
		}
	}
	
	public void nameData(String thisCSVName) {
		this.csvName = thisCSVName;
	}

}