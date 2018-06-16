package gangjwa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import Haksaeng.HaksaengList;
import exceptions.HaksaengNumberNotFoundException;
import main.Gwamok;
import main.GwamokList;
import main.Sungjeok;

public class GangjwaList {
	public static Map<Integer, String[]> map = new HashMap<>();
	public static List list = new ArrayList();

	GwamokList gwamokList;
	HaksaengList haksaengList;
	Vector<Score> scoreVector;
	Vector<Gangjwa> gangjwaVector;

	public static ArrayList<Integer> kimal1 = new ArrayList<Integer>();
	public static ArrayList<String> grade1 = new ArrayList<String>();
//	public static ArrayList<String,String,String,String> arr1 = new ArrayList<String[]>();

	String s[] = new String[4];
	int ss[] = new int[4];

	public GangjwaList() {
		this.scoreVector = new Vector<Score>();
		this.gangjwaVector = new Vector<Gangjwa>();
	
	}

	public void readFromFile() throws Exception {
		File file = new File("data1/gangjwaList.txt");
		File file2;
		Scanner scanner;
		Scanner scanner2;

		try {
			scanner = new Scanner(file);

			int i = 0;

			while (scanner.hasNext()) {
				String name = scanner.next();

				file2 = new File(name);
				scanner2 = new Scanner(file2);

				while (scanner2.hasNext()) {

					if (i == 0 || i == 10 || i == 20 || i == 30) {

						// scanner2=new Scanner(name);
						Gangjwa gangjwa = new Gangjwa();
						gangjwa.associate(this.gwamokList, this.haksaengList);
						gangjwa.readFromFile(scanner2);

						this.gangjwaVector.add(gangjwa);

					}
					Score score = new Score();

					score.readFromFile(scanner2);
					i++;
					this.scoreVector.add(score);

				}
				scanner2.close();
				printInfo();
			}
			scanner.close();

		}

		catch (FileNotFoundException e) {

			throw new Exception("과목이 존재하지 않습니다. :");
		}
	}

	public void printInfo() throws Exception {
		System.out.println("********Gangjwa List**********");
		String gwamokName1 = this.gwamokList.getGwamokName(Gangjwa.gwamokID);

		if (gwamokName1 != null) {

			for (Gangjwa gangjwa : this.gangjwaVector) {
				gangjwa.writeToFile();
			}
			System.out.println(gwamokName1);

			for (Score score : this.scoreVector) {
				score.writeToFile();
			} // 여기에서 sorting이 되어 나와야 한다.
			this.gangjwaVector.setSize(0);
			this.scoreVector.setSize(0);
		} else {
			throw new Exception("과목이 존재하지 않습니다. :");
		}
	}

	public void associate(GwamokList gwamokList, HaksaengList haksaengList) {
		this.gwamokList = gwamokList;
		this.haksaengList = haksaengList;

	}

	public class Score {
		private int haksaengID;
		private int kimal;
		private String grade;

		public int getScore() {
			return kimal;
		}

		public void readFromFile(Scanner scanner) {
	
			this.haksaengID = scanner.nextInt();
			this.kimal = scanner.nextInt();
			if (kimal >= 85) {
				grade = "A";
			} else if (kimal >= 70) {
				grade = "B";
			} else if (kimal >= 50) {
				grade = "C";
			} else if (kimal >= 20) {
				grade = "D";
			} else {
				grade = "F";
			}
			kimal1.add(this.kimal);
			grade1.add(this.grade);
//			for(int i=0; i<kimal1.size();i++) {
//				System.out.println(kimal1.get(i));
//			}
//			String arr[];
//			for( int i=1; i<4;i++) {
//				arr1.add( Integer.toString(Gwamok.gangjwaID1.get(0)), Integer.toString(Gwamok.gwamokID1.get(0)),
//						Integer.toString(kimal1.get(haksaengID*i)), grade1.get(haksaengID*i));
//			}
			String arr1[] = { Integer.toString(Gwamok.gangjwaID1.get(2)), Integer.toString(Gwamok.gwamokID1.get(2)),
					Integer.toString(this.kimal), (this.grade) };
			String arr[] = { Integer.toString(Gwamok.gangjwaID1.get(3)), Integer.toString(Gwamok.gwamokID1.get(0)),
					Integer.toString(this.kimal), (this.grade) };
			map.put(haksaengID+1, arr1);
			map.put(haksaengID, arr);
		}

		public void writeToFile() throws Exception {
			String haksaengName = haksaengList.getHaksaengName(this.haksaengID);
			if (haksaengName != null) {
				System.out.println(haksaengName + " - " + getScore() + " - " + grade);
			} else {
				throw new HaksaengNumberNotFoundException("해당 학생번호가 존재하지 않습니다. ");

			}

		}
	}



}
