
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {

		try {

			HaksaengList haksaengList = new HaksaengList();
			haksaengList.readFromFile();

			GwamokList gwamokList = new GwamokList();
			gwamokList.readFromFile();
//			Gangjwa gangjwa = new Gangjwa();
//			gangjwa.associate(gwamokList, haksaengList);
			GangjwaList gangjwaList = new GangjwaList();
			gangjwaList.readFromFile();
			gangjwaList.associate(gwamokList, haksaengList);
			gangjwaList.printGangjwaInfo();


			// haksaengList.printHaksaengInfo();
			// haksaengList.associate(gangjwaList);

			// 1. print ganjwa info
			// 2. print haksaeng info

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}