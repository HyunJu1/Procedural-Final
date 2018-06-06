import java.util.Scanner;

public class Gangjwa {


	public int gwamokID;
	public String name;
	public int year;
	public int hakgi;
	

	public void readFromFile(Scanner scanner) {
		this.gwamokID=scanner.nextInt();
		this.name = scanner.next();
		this.year = scanner.nextInt();
		this.hakgi = scanner.nextInt();
		

	}

	public int getGwamokID() {
		return gwamokID;
	}


	public void setGwamokID(int gwamokID) {
		this.gwamokID = gwamokID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getHakgi() {
		return hakgi;
	}


	public void setHakgi(int hakgi) {
		this.hakgi = hakgi;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


//	public void writeToFile() {
//		System.out.println(this.id+" "+this.name);
//		
//	}



}