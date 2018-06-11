package main;

import java.util.Scanner;
import java.util.Vector;

public class Gwamok {

		public int id;
		public String name;
		

		public int getID() {
			return id; 
		}
		
		public void setID(int id) {
			this.id=id;
		}
		public void setName(String name) {
			this.name=name;
		}
		public String getName() {

			return name;
		}

		public void readFromFile(Scanner scanner) {
			this.id = scanner.nextInt();
			this.name = scanner.next();
	
		}

		public void writeToFile() {
			System.out.println(this.id+" "+this.name);
			
		}

		

	}