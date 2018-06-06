import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;


public class GangjwaList {

	GwamokList gwamokList;
	private int gwamokID;
	HaksaengList haksaengList;
	Vector<Score> scoreVector;
	Vector<Gangjwa> gangjwaVector;
	String s[]= new String[4];
	int ss[]= new int[4];

	public GangjwaList() {
		this.scoreVector = new Vector<Score>();
	}

	public void readFromFile() {
		File file = new File("gangjwa1.txt");
		Scanner scanner;

		try {
			scanner = new Scanner(file);

			int i = 0;
			while (scanner.hasNext()) {

				Score score = new Score();

				score.readFromFile(scanner, i);
				i++;
				this.scoreVector.add(score);

			}
			scanner.close();

		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printGangjwaInfo() throws Exception {

		String gwamokName = this.gwamokList.getGwamokName(this.gwamokID);
		if (gwamokName != null) {

			System.out.println(this.gwamokID + " " + gwamokName + " "+s[1] +" "+ ss[2]+" "+ ss[3]);
			for (Score score : this.scoreVector) {
				score.writeToFile();
			}

		} else {
			throw new Exception("과목이 존재하지 않습니다. :");
		}
	}

	public void associate(GwamokList gangjwaList, HaksaengList haksaengList) {
		this.gwamokList = gangjwaList;
		this.haksaengList = haksaengList;

	}
	
	public class Score {
		private int haksaengID;
		private int kimal;
		
		public int getScore() {
			return kimal;
		}

		public void readFromFile(Scanner scanner, int i) {

			if (i == 0) {
				gwamokID = scanner.nextInt();
				s[1]=scanner.next();
				ss[2]=scanner.nextInt();
				ss[3]=scanner.nextInt();
			}
			

			this.haksaengID = scanner.nextInt();
			this.kimal = scanner.nextInt();
		}

		public void writeToFile() throws Exception {

			String haksaengName = haksaengList.getHaksaengName(this.haksaengID);
			if (haksaengName != null) {
				System.out.println(haksaengName + " " + getScore());
			} else {
				throw new HaksaengNumberNotFoundException("해당 학생번호가 존재하지 않습니다. ");

			}

		}
	}

}
