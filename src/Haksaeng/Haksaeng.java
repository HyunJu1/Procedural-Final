package Haksaeng;

import java.util.Scanner;

public class Haksaeng {
	private int id;
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

	public void readFromFile(Scanner sc) {
		this.id= sc.nextInt();
		this.name= sc.next();
		
	}

	public void writeToFile() {
		System.out.println(this.id+" "+ this.name);
	}
}
