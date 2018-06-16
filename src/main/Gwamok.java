package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import gangjwa.Gangjwa;

public class Gwamok {

		public int id;
		public String name;
		
		public static ArrayList<Integer> gangjwaID1 = new ArrayList<Integer>();
		public static ArrayList<Integer> gwamokID1 = new ArrayList<Integer>();

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
			gangjwaID1.add(this.id);
			gwamokID1.add(Gangjwa.gwamokID);
		}

		public void writeToFile() {
			System.out.println(this.id+" "+this.name);
			
		}

		

	}