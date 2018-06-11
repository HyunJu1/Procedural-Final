package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import Haksaeng.HaksaengList;
import gangjwa.GangjwaList;

public class Main {
	public static void main(String[] args) {

		try {

			HaksaengList haksaengList = new HaksaengList();
			haksaengList.readFromFile();

			GwamokList gwamokList = new GwamokList();
			gwamokList.readFromFile();
			gwamokList.printInfo();
			
			System.out.println();
			GangjwaList gangjwaList = new GangjwaList();
			gangjwaList.associate(gwamokList, haksaengList);
			gangjwaList.readFromFile();
			
//			gangjwaList.printInfo();


			 haksaengList.associate(gangjwaList);
			 haksaengList.printHaksaengInfo();
			

			// 1. print ganjwa info
			// 2. print haksaeng info

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}