package com.json.JSONExample;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Hello world!
 *
 */
public class App {
	String s = "{\"Name\":\"Bhavin\",\"Salary\":60000.0,\"Age\":27}";
	Object object = JSONValue.parse(s);
	JSONObject jsonObject2 = (JSONObject) object;
	private String name;
	private double salary;
	private Long age;

	public String getName() {
		return (String) jsonObject2.get("Name");
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return (Double) jsonObject2.get("Salary");
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Long getAge() {
		return (Long) jsonObject2.get("Age");
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public static void main(String[] args) {

		// Array,SimpleString Encoding Example
		/*
		 * Map<Object, Object> map = new HashMap<Object, Object>(); map.put("Firstname",
		 * "Bhavin"); map.put("LastName", "Bhavsar"); map.put("Age", new Integer(22));
		 * String jsonText = JSONValue.toJSONString(map);
		 * 
		 * JSONObject jsonObject = new JSONObject(); jsonObject.put("JSON-FirstName",
		 * "Test1"); jsonObject.put("Json-LastName", "Test1");
		 * jsonObject.put("JSON-Age", new Integer(22)); System.out.println(jsonObject);
		 * 
		 * JSONArray jsonArray = new JSONArray(); jsonArray.add("Bhavin");
		 * jsonArray.add("Bhavsar"); jsonArray.add(new Integer(22));
		 * System.out.println(jsonArray);
		 * 
		 * // JSON Format data Decoding : String s =
		 * "{\"Name\":\"Bhavin\",\"Salary\":60000.0,\"Age\":27}"; Object object =
		 * JSONValue.parse(s); JSONObject jsonObject2 = (JSONObject) object; String name
		 * = (String) jsonObject2.get("Name"); double salary = (Double)
		 * jsonObject2.get("Salary"); Long age = (Long) jsonObject2.get("Age");
		 * System.out.println(" Name : " + name + "\n Salary : " + salary + "\n Age :" +
		 * age);
		 */

		App app = new App();
		System.out.println("Name :" + app.getName());
	}
}
