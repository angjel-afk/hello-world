import java.util.ArrayList;

public class User {
	ArrayList<Movies> lista = new ArrayList<Movies>();
private String name;
private String surName;
private int phone;
private String email;
@MyAnottation
public User(String name, String surName, int phone, String email) {
	this.name = name;
	this.surName = surName;
	this.phone = phone;
	this.email = email;
}
}
