package gangjwa;

import java.util.Scanner;

import Haksaeng.HaksaengList;
import main.GwamokList;

public class Gangjwa {
	GwamokList gwamokList1 = new GwamokList();
	HaksaengList haksaengList;
	public static int gwamokID;
	public int gangjwaID;
	public String name;
	public int year;
	public int hakgi;

	public void readFromFile(Scanner scanner) {
		this.gwamokID = scanner.nextInt();
		this.gangjwaID = scanner.nextInt();
		this.name = scanner.next();
		this.year = scanner.nextInt();
		this.hakgi = scanner.nextInt();

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

	public void associate(GwamokList gwamokList, HaksaengList haksaengList) {
		this.gwamokList1 = gwamokList;
		this.haksaengList = haksaengList;
	}

	public void writeToFile() throws Exception {

		System.out.println(" / " + this.gangjwaID + " / " + this.name + " / " + this.year + " / " + this.hakgi);

	}

}