package Haksaeng;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import gangjwa.GangjwaList;

public class HaksaengList {
	// components
	Vector<Haksaeng> haksaengVector;
	private GangjwaList gangjwaList;
	

	public HaksaengList() {
		this.haksaengVector = new Vector<Haksaeng>();

	}

	public void readFromFile() {
		File file = new File("data1/haksaeng.txt");
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				Haksaeng haksaeng = new Haksaeng();
				haksaeng.associate(this.gangjwaList);
				haksaeng.readFromFile(sc);
				this.haksaengVector.add(haksaeng);
	
			}
			sc.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}



	public String getHaksaengName(int haksaengID) {
		//강좌리스트의 getGangjwaName참고하기
		for(Haksaeng haksaeng: this.haksaengVector) {
			if(haksaeng.getID()==haksaengID) {
				return haksaeng.getName();
			}
			
		}
		return null;
	}

	public void associate(GangjwaList gangjwaList) {
		this.gangjwaList=gangjwaList;
		
	}

	public void printHaksaengInfo() {
		System.out.println();
		System.out.println("*********HaksaengList*********");
		for(Haksaeng haksaeng : this.haksaengVector) {
			haksaeng.writeToFile();
		}
	}
}
