package exceptions;

public class HaksaengNumberNotFoundException extends Exception {
	   private static final long serialVersionUID = 1L;

	   
	public HaksaengNumberNotFoundException (String string) {
		super(string);
		System.out.println(string);

	}
}
