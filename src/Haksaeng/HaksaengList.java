package Haksaeng;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class HaksaengList {
	// components
	Vector<Haksaeng> haksaengVector;

	public HaksaengList() {
		this.haksaengVector = new Vector<Haksaeng>();

	}

	public void readFromFile() {
		File file = new File("haksaeng.txt");
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				Haksaeng haksaeng = new Haksaeng();
				haksaeng.readFromFile(sc);
				this.haksaengVector.add(haksaeng);
	
			}
			sc.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void writeToFile() {
		Object[] objs = haksaengVector.toArray();

		Arrays.sort(objs);

		for (int i=0; i < objs.length; i++){

		       System.out.println(objs[i] + " ");

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
}
