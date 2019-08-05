package com.main.huzefa.spring_project.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class User {

	//private HashMap<String,String> credentials = new HashMap<>();
	private String username;
	private String password;

	/*public HashMap<String, String> getCredentials() {
		return credentials;
	}

	public void setCredentials(String username, String password) {
		this.credentials.put(username, password);
		//this.credentials = credentials;
	}*/
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean validateCredentials(String username, String password) {
		System.out.println(username+"-----"+password);
//		for(Map.Entry<String, String> map:credentials.entrySet()) {
			if(username.equals("Huzefa"))
				if(password.equals("sparrow")) {
					System.out.println("Credentails are true");
					return true;
				}
		return false;
		
	}
	
	
}
