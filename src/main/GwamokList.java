package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class GwamokList {

	Vector<Gwamok> gwamokVector;

	public GwamokList() {
		this.gwamokVector = new Vector<Gwamok>();

	}


	public void readFromFile() throws FileNotFoundException {// ½É°¢ÇÑ --> throws FileNotFoundException 
		File file = new File("data1/gaumok.txt");
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				Gwamok gwamok = new Gwamok();
				gwamok.readFromFile(sc);
				this.gwamokVector.add(gwamok);
				
			}
			sc.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	public String getGwamokName(int gwamokID) {
		for (Gwamok gwamok : this.gwamokVector) {
			if (gwamok.getID() == gwamokID) {
				
				return gwamok.getName();
			}
		}
		return null;
	}

	public void printInfo() {
		for (Gwamok gwamok : this.gwamokVector) {
			gwamok.writeToFile();
		}

	}

}
