package gangjwa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Haksaeng.HaksaengList;
import exceptions.HaksaengNumberNotFoundException;
import main.GwamokList;
import main.Sungjeok;

public class GangjwaList {

	GwamokList gwamokList;
	HaksaengList haksaengList;
	Vector<Score> scoreVector;
	Vector<Gangjwa> gangjwaVector;
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

					if (i == 0 || i==10 || i==20 || i==30) {
						
						// scanner2=new Scanner(name);
						Gangjwa gangjwa = new Gangjwa();
						gangjwa.associate(this.gwamokList, this.haksaengList);
						gangjwa.readFromFile(scanner2);

						this.gangjwaVector.add(gangjwa);

					}
					Score score = new Score();

					score.readFromFile(scanner2, i);
					i++;
					this.scoreVector.add(score);

				}
				scanner2.close();
				printInfo();
			}
			scanner.close();

		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
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
		private char grade;

		public int getScore() {
			return kimal;
		}

		public void readFromFile(Scanner scanner, int i) {

			this.haksaengID = scanner.nextInt();
			this.kimal = scanner.nextInt();
	
		}

		public void writeToFile() throws Exception {
			if (kimal > 90) {
				grade = 'A';
			} else if (kimal > 80) {
				grade = 'B';
			} else if (kimal > 70) {
				grade = 'C';
			} else if (kimal > 70) {
				grade = 'D';
			} else {
				grade = 'F';
			}

			String haksaengName = haksaengList.getHaksaengName(this.haksaengID);
			if (haksaengName != null) {
				System.out.println(haksaengName + " - " + getScore() + " - " + grade);
			} else {
				throw new HaksaengNumberNotFoundException("해당 학생번호가 존재하지 않습니다. ");

			}

		}
	}

	public Vector<Sungjeok> getSeongjeok(int id) {
		Vector<Sungjeok> sungjeokList ;
		for(Gangjwa ganjwa : this.gangjwaVector) {
			
		}
		return null;
	}

}
