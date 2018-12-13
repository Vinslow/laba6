package ru.rsreu.lukyanov_nikita;

import java.util.*;

public class LoggedCollection {
	private List<String> loggin= new ArrayList<>();;
	private List<Date> dateLogin= new ArrayList<>();;
	
	public void setValue(String login) {
		if (loggin == null) {
			//loggin = new ArrayList<>();
			//dateLogin = new ArrayList<>();
		}
		this.loggin.add(login);
		
	}
	public void setDate(Date date) {
		this.dateLogin.add(date);
	}
	public List<String> getLogin(){
		return loggin;
	}
	public List<Date> getDate(){
		return dateLogin;
	}			
	public int getlength() {
		if(loggin!=null)
			return loggin.size();
		return 0;
	}
}
