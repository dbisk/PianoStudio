import java.awt.Color;

import processing.core.PApplet;

/**
 * This class represents a black key on a piano. It has a note name, a frequency of the pitch,
 * x/y coordinates, a width, a height, and a color.
 * 
 * @author Dean Biskup and Julie Shen
 * @version 5/23/16
 *
 */
public class BlackKey extends Key{
	private static final double KEY_WIDTH = 60;
	private static final double KEY_HEIGHT = 240;
	
	/**
	 * The constructor that creates a black key of the piano. There are 5 in total.
	 * 
	 * @param n The name of the note
	 * @param f The frequency of the pitch in Hertz
	 * @param xCoord The x coordinate of the top left corner of the key
	 * @param yCoord The y coordinate of the top left corner of the key
	 */
	public BlackKey(String n, double f, double xCoord, double yCoord){
		super(n, f, xCoord, yCoord, KEY_WIDTH, KEY_HEIGHT, Color.black);
	}
	
	/**
	 * Draws a new instance of a blackKey object starting at top left corner (x, y)
	 * with a height of KEY_HEIGHT and width of KEY_WIDTH
	 *  
	 * @param drawer PApplet object used to draw
	 */
	public void draw(PApplet drawer){
		drawer.stroke(0);
		drawer.strokeWeight(2);
		if(isPressed)
			color = Color.yellow;
		else if(isPlayAlong)
			color = Color.red;
		else
			color = Color.black;
		
		drawer.fill(color.getRGB());
		
		drawer.rect((float)x, (float)y, (float)KEY_WIDTH, (float)KEY_HEIGHT);
	}
	
	
}
