package Haksaeng;

import java.util.Scanner;
import java.util.Vector;

import gangjwa.GangjwaList;
import main.GwamokList;
import main.Sungjeok;

public class Haksaeng {
	GangjwaList gangjwaList;
	private int id;
	private String name;

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

	public void readFromFile(Scanner sc) {
		this.id = sc.nextInt();
		this.name = sc.next();
		// Vector <Sungjeok> seongjeokList=this.gangjwaList.getSeongjeok(this.id);

	}

	public void writeToFile() {
		System.out.print(this.id + " " + this.name +" : ");
		GwamokList gwamokList = new GwamokList();
		System.out.println(GangjwaList.map.get(this.id+1)[0]);
		System.out.println( "강좌 아이디 - " +GangjwaList.map.get(this.id)[0] + " 과목 아이디 - " + GangjwaList.map.get(this.id)[1] + " 점수 - "
				+ GangjwaList.map.get(this.id)[2] + "  성적- " + GangjwaList.map.get(this.id)[3]);
//		System.out.println(GangjwaList.map.get(this.id)[4] + " - " + GangjwaList.map.get(this.id)[5] + " - "
//				+ GangjwaList.map.get(this.id)[6] + " - " + GangjwaList.map.get(this.id)[7]);

	}

	public void associate(GangjwaList gangjwaList) {
		this.gangjwaList = gangjwaList;

	}
}
