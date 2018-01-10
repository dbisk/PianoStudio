import java.awt.Color;

import processing.core.PApplet;

/* NOTES & FREQUENCIES
 * C4-261.626 Hz
 * D4-293.665 Hz
 * E4-329.628 Hz
 * F4-349.228 Hz
 * G4-391.995 Hz
 * A4-440.000 Hz
 * B4-493.883 Hz
 * C5-523.251 Hz
 */

/**
 * This class represents a white key on a piano. It has a note name, a frequency of the pitch,
 * x/y coordinates, a width, a height, and a color.
 * 
 * @author Dean Biskup and Julie Shen
 * @version 5/22/16
 *
 */
public class WhiteKey extends Key{
	
	private static final double KEY_WIDTH = 80;
	private static final double KEY_HEIGHT = 400;
	
	/**
	 * The constructor that creates a white key of the piano. There are 8 in total.
	 * 
	 * @param n The name of the note
	 * @param f The frequency of the pitch in Hertz
	 * @param xCoord The x coordinate of the top left corner of the key
	 * @param yCoord The y coordinate of the top left corner of the key
	 */
	public WhiteKey(String n, double f, double xCoord, double yCoord){
		super(n, f, xCoord, yCoord, KEY_WIDTH, KEY_HEIGHT, Color.white);
		
	}
	
	/**
	 * Draws a new instance of a WhiteKey object starting at top left corner (x, y)
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
			color = Color.white;
		
		drawer.fill(color.getRGB());
		
		drawer.rect((float)x, (float)y, (float)KEY_WIDTH, (float)KEY_HEIGHT);
		//isPressed = false; //Commented out 5/19/2016, Dean Biskup
	}
	
}
