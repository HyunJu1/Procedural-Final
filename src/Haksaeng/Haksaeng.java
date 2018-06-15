package Haksaeng;

import java.util.Scanner;
import java.util.Vector;

import gangjwa.GangjwaList;
import main.Sungjeok;

public class Haksaeng {
	GangjwaList gangjwaList;
	private int id;
	// 학생테이블에 강좌아이디도 집어넣어야한다.

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
		this.id = sc.nextInt();
		this.name = sc.next();
		// Vector <Sungjeok> seongjeokList=this.gangjwaList.getSeongjeok(this.id);

	}

	public void writeToFile() {
		System.out.println(this.id + " " + this.name);
	}

	public void associate(GangjwaList gangjwaList) {
		this.gangjwaList = gangjwaList;

	}
}
