import java.util.Scanner;

public class Gangjwa {
	GwamokList gwamokList =new GwamokList();
	HaksaengList haksaengList;
	public int gwamokID;
	public String name;
	public int year;
	public int hakgi;

	public void readFromFile(Scanner scanner) {
		this.gwamokID = scanner.nextInt();
		this.name = scanner.next();
		this.year = scanner.nextInt();
		this.hakgi = scanner.nextInt();

	}

	public int getGwamokID() {
		return gwamokID;
	}

	public void setGwamokID(int gwamokID) {
		this.gwamokID = gwamokID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHakgi() {
		return hakgi;
	}

	public void setHakgi(int hakgi) {
		this.hakgi = hakgi;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

//	public void associate(GwamokList gwamokList, HaksaengList haksaengList) {
//		this.gwamokList = gwamokList;
//		this.haksaengList = haksaengList;
//	}

	public void writeToFile() throws Exception {
		System.out.println(gwamokID);
		String gwamokName1 = this.gwamokList.getGwamokName(this.gwamokID);
		System.out.println(gwamokName1);
		//if (gwamokName1 != null) {
			System.out.println(
					this.gwamokID + " / "+   " / " + this.name + " / " + this.year + " / " + this.hakgi);
//		} else {
//			throw new Exception("과목이 존재하지 않습니다. :");
//		}

	}

}