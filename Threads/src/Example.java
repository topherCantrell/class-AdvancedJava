
public class Example {
	
	public static int getInteger() {
		return 0;
	}
	
	public static void showInteger(int v) {		
	}
	
	public static void drawObject() {		
	}
	
	public static void moveObject() {		
	}
	
	public static void pause() {		
	}
	
	public static void animation() {
		do {
			drawObject();
			moveObject();
			pause();
		} while(true);
	}
	
	public static void doCalculation() {
		
		int a;
		int b;
		int c;
		
		a = getInteger();
		b = getInteger();
		
		c = a + b;
		a = getInteger();
		
		c = c * a;
		
		showInteger(c);
				
	}

}
