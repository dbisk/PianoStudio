import java.awt.Color;

import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;

import processing.core.PApplet;

/**
 * This class represents a key on a piano. It has a note name, a frequency of the pitch,
 * x/y coordinates, a width, a height, and a color. It has detects whether the key is pressed
 * and is part of the play-along feature.
 * 
 * @author Dean Biskup and Julie Shen
 * @version 5/22/16
 *
 */
public class Key {

	private String note;
	private double frequency;
	protected double x, y;
	private double KEY_WIDTH;
	private double KEY_HEIGHT;
	protected Color color;
	protected boolean isPressed, isPlayAlong;
	//private RealtimePlayer player; // Added 5/19/2016
	
	/**
	 * The constructor that creates a key of the piano. There are 13 in total.
	 * 
	 * @param n The name of the note
	 * @param f The frequency of the pitch in Hertz
	 * @param xCoord The x coordinate of the top-left corner of the key
	 * @param yCoord The y coordinate of the top-left corner of the key
	 * @param width The width of the key
	 * @param height The height of the key
	 * @param c The color of the key
	 */
	public Key(String n, double f, double xCoord, double yCoord, double width, double height, Color c){
		note = n; //name of the note
		frequency = f; //number indicating frequency of pitch
		x = xCoord; //x coordinate of the top left corner of the rectangle key
		y = yCoord; //y coordinate of the top left corner of the rectangle key
		color = c;
		isPressed = false;
		isPlayAlong = false;
		KEY_WIDTH = width;
		KEY_HEIGHT = height;
	}
	
	/**
	 * Returns the name of the note of the key
	 * 
	 * @return note of the piano key
	 */
	public String getNote(){
		return note;
	}
	
	/**
	 * Returns the frequency of the pitch of the key
	 * 
	 * @return frequency of the pitch of the piano key
	 */
	public double getFrequency(){
		return frequency;
	}
	
	/**
	 * Returns the x coordinate of the top left corner of the key
	 * 
	 * @return x coordinate of the top left corner of the piano key
	 */
	public double getX(){
		return x;
	}
	
	/**
	 * Returns the y coordinate of the top left corner of the key
	 * 
	 * @return y coordinate of the top left corner of the piano key
	 */
	public double getY(){
		return y;
	}
	
	/**
	 * Returns the width of the key
	 * 
	 * @return width of the piano key
	 */
	public double getWidth(){
		return KEY_WIDTH;
	}
	
	/**
	 * Returns the height of the key
	 * 
	 * @return height of the piano key
	 */
	public double getHeight(){
		return KEY_HEIGHT;
	}
	
	/**
	 * Returns a String representing the Key object
	 * 
	 * @return a String containing the note name and frequency of the pitch
	 */
	public String toString(){
		return "Note: " + note + " Frequency: " + frequency + " Hz";
	}
	
	/**
	 * Switches the piano key to an octave above by doubling its frequency
	 */
	public void highOctave(){
		frequency = frequency*2.0;
	}
	
	/**
	 * Switches the piano key to an octave below.
	 */
	public void lowOctave() {
		frequency = frequency/2.0;
	}
	
	public void setIsPressed(boolean b){
		isPressed = b;
	}
	
	/**
	 * Draws a new instance of a Key object. Draws nothing except what is 
	 * specified in the subclass.
	 *  
	 * @param drawer PApplet object used to draw
	 */
	public void draw(PApplet drawer){
		
	}
}
