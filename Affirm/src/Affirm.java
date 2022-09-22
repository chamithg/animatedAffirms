import java.awt.Color;

// Encapsulate data for one affirmation: a string and an x,y
public class Affirm {
	private String myString; 
	private int myX;
	private int myY;
	private Color myColor;
	
	// Creates an affirm with the given string and x,y and R G B values
	public Affirm(String string, int x, int y, Color newColor) { 
		myString = string;
		myX = x;
		myY = y;
		myColor = newColor;
		
	}
	
	// create getters and setters to my color
	public Color getMyColor() {
		return myColor;
	}

	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}

	public String getString( ) { 
		return myString;
	}
	public int getX( ) { 
		return myX;
	}
	public int getY( ) { 
		return myY;
	}
	// Moves x,y by the given deltas
	public void move(int dx, int dy) { 
		myX += dx;
		myY += dy; 
	}
	// True if x,y is within the rect (0,0), (width,height)
	public boolean isWithin(int width, int height) { 
		return(myX >= 0 && myX < width&& myY >= 0 && myY < height);
	}
	// Sets x and y
	public void set(int newX, int newY) {
		myX= newX;
		myY= newY;
	
	}

}


