package gangjwa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Haksaeng.HaksaengList;
import exceptions.HaksaengNumberNotFoundException;
import main.GwamokList;

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

	public void readFromFile() {
		File file = new File("gangjwa1.txt");
		Scanner scanner;

		try {
			scanner = new Scanner(file);
			Gangjwa gangjwa = new Gangjwa();
			int i = 0;
			while (scanner.hasNext()) {
				if (i == 0) {

					gangjwa.readFromFile(scanner);
					this.gangjwaVector.add(gangjwa);

				}
				Score score = new Score();

				score.readFromFile(scanner, i);
				i++;
				this.scoreVector.add(score);

			}
			scanner.close();

		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void printInfo() throws Exception {
		String gwamokName1 = this.gwamokList.getGwamokName(Gangjwa.gwamokID);

		if (gwamokName1 != null) {
			System.out.print(gwamokName1);

			for (Gangjwa gangjwa : this.gangjwaVector) {
				gangjwa.writeToFile();
			}

			for (Score score : this.scoreVector) {
				score.writeToFile();
			}

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
			if(kimal>90) {
				grade='A';
			}else if(kimal>80) {
				grade='B';
			}
			else if(kimal>70) {
				grade='C';
			}else if(kimal>70) {
				grade='D';
			}else {
				grade='F';
			}
			
			String haksaengName = haksaengList.getHaksaengName(this.haksaengID);
			if (haksaengName != null) {
				System.out.println(haksaengName + " - " + getScore() +" - " +grade);
			} else {
				throw new HaksaengNumberNotFoundException("해당 학생번호가 존재하지 않습니다. ");

			}

		}
	}

}
