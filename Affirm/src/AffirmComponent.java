import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

public class AffirmComponent extends JComponent {
	
	private ArrayList affirms;
	public static final int SIZE = 400;
	public static final Font FONT = new Font("Dialog", 0, 24); 
	public static final int SPEED = 8;
	
	Random rand = new Random();
	
	public int red = rand.nextInt(256);
	public int green = rand.nextInt(256);
	public int blue = rand.nextInt(256);
	
	public AffirmComponent( ) {
		affirms = new ArrayList( ); 
		setPreferredSize(new Dimension(SIZE, SIZE));
	}
	// Draw all the affirmations.
	public void paintComponent(Graphics g) { 
		
		
		g.setFont(FONT);
		
		for (int i=0; i < affirms.size( ); i++) {	
			Affirm a = (Affirm) affirms.get(i); 
			g.drawString(a.getString( ), a.getX( ), a.getY( ));
			// use myColor values to add color to string.
			g.setColor(a.getMyColor());
		} 
	}
	
	public int randomInt(int bound) {
		return (int) (Math.random( )*bound);
	}
	// Adds a string -- make and add an Affirm for the string
	public void add(String string) {
		// generate random RGB values and assign them to colors.
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		
		// generate a new color object using above RGB values,
		
		Color newColor = new Color(red,green,blue);
		
		// pass it to new affirm object.
		Affirm a = new Affirm(string, randomInt(getWidth ( ) ),randomInt(getHeight ( ) ),newColor);		
		affirms.add(a);
		repaint( );
	}
	// Removes an affirmation at random
	public void removeRandom( ) { 
		if (affirms.size( ) > 0) {
			affirms.remove(randomInt(affirms.size( ))); 
		}
		repaint( );
	}
	// Moves all the affirmations a little
	public void moveAll( ) {
		int width = getWidth( );
		int height = getHeight( );
		
		for (int i=0; i < affirms.size( ); i++) {
		Affirm a = (Affirm) affirms.get(i);
		// random values in the range –SPEED ... +SPEED
		int dx = randomInt(2*SPEED + 1) - SPEED; 
		int dy = randomInt(2*SPEED + 1) - SPEED; 
		a.move(dx, dy);
			if ( ! a.isWithin(width, height) ) { 
				a.set(randomInt(width), randomInt(height));
			} 
		}
		repaint( );
	  }
	// get the coordinates of center of the panel
	// update all affirms myX and myY valued to the center value.
	public void centerAll( ) {
		int width = getWidth( );
		int height = getHeight( );
		int centerHeight = height/2;
		int centerWidth = width/2;
		for (int i=0; i < affirms.size( ); i++) {
			Affirm a = (Affirm) affirms.get(i);
			a.set(centerWidth,centerHeight);
		}
		repaint( );
	  }

}
