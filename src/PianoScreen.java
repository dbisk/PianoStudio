
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.*;

/**
 * This class represents the screen on which the Piano object is drawn and other buttons and
 * features can be accessed.
 * 
 * @author Dean Biskup and Julie Shen
 * @version 5/22/16
 *
 */
public class PianoScreen extends PApplet implements MouseListener {

	private int width, height; //only here to make things easier in case we want to change size
	private Piano piano;
	private ArrayList<Song> songs;
	private PImage title, backButton, stopButton;
	private PImage song1, song2, song3;
	private ArduinoInput arduino;
	private Main main;

	/** Creates a PianoScreen object (a DrawingSurface) with width w and height h
	 * 
	 * @param w width of the window
	 * @param h height of the window
	 * @param main the Main class this PianoScreen was called in
	 */
	public PianoScreen(int w, int h, Main main) {
		this.width = w; //should be passed in as 800
		this.height = h; //should be passed in as 600
		this.main = main;
		piano = new Piano(); 
		songs = new ArrayList<Song>();
		
		Song mary = new Song("Mary Had a Little Lamb", new int[]{2, 1, 0, 1, 2, 2, 2, 1, 1, 1, 2, 4, 4, 2, 1, 0, 1, 2, 2, 2, 0, 1, 1, 2, 1, 0}, piano);
		Song twinkle = new Song("Twinkle, Twinkle, Little Star", new int[]{0, 0, 4, 4, 5, 5, 4, 3, 3, 2, 2, 1, 1, 0, 4, 4, 3, 3, 2, 2, 1, 4, 4, 3, 3, 2, 2, 1, 0, 0, 4, 4, 5, 5, 4, 3, 3, 2, 2, 1, 1, 0}, piano);
		Song row = new Song("Row, Row, Row Your Boat", new int[]{0, 0, 0, 1, 2, 2, 1, 2, 3, 4, 7, 7, 7, 4, 4, 4, 2, 2, 2, 0, 0, 0, 4, 3, 2, 1, 0}, piano);
		songs.add(mary);
		songs.add(twinkle);
		songs.add(row);
		
		try{
			arduino = new ArduinoInput();
		}catch(NullPointerException e){
			e.printStackTrace();
			System.out.println("Arduino is not plugged in");
		}
		
	}

	/**
	 * Statements in the setup() function execute once when the program begins
	 */
	public void setup() {
		size(width, height);
		title = loadImage("lib\\piano studio.PNG");
		backButton = loadImage("lib\\backbutton.png");
		stopButton = loadImage("lib\\stopbutton.png");
		song1 = loadImage("lib\\one.png");
		song2 = loadImage("lib\\two.png");
		song3 = loadImage("lib\\three.png");
		
	}
	
	/**
	 * The draw method executes each frame, and controls the drawing of the piano
	 * screen to the window. Also uses the arduino input to call sound methods of 
	 * the keys
	 */
	public void draw() {
		background(255);
		float xRatio = width / 820f;
		float yRatio = height / 650f;
		scale(xRatio, yRatio);
		
		// Code edited 5/22
		if (arduino != null) {
			if (arduino.getOutput() == -1) {
				for (int i = 0; i < piano.getWhiteKeys().length; i++) 
					piano.getWhiteKeys()[i].setIsPressed(false);
			}
			else {
				piano.getWhiteKeys()[arduino.getOutput()-48].setIsPressed(true);
				piano.playWhiteKey(arduino.getOutput()-48);
			}
		}
		
		// Draw stuff here
		piano.draw(this);
		
		image(title, 265, 10, 300, 75); //title
		image(backButton, 20, 500, 50, 50); //back button
		image(stopButton, 100, 35, 100, 35); //stop button
		image(song1, 600, 34, 40, 40); //song button 1
		image(song2, 660, 34, 40, 40); //song button 2
		image(song3, 720, 34, 40, 40); //song button 3
	}
	
	/**
	 * Executes when the mouse is clicked. If the mouse is clicked on the back button 
	 * in the bottom-left corner, the panel changes back to the menu. If the mouse is clicked
	 * on the stop button in the top-left corner, the play-along feature stops. If the mouse is
	 * clicked on one of the numbered buttons in the top-right corner, the corresponding song in
	 * the play-along feature starts.
	 */
	public void mouseClicked(MouseEvent e){
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		if(mouseX > 20 && mouseX < 70 && mouseY > 500 && mouseY < 500+50){ //back button
			main.changePanel("1");
		}
		
		if(mouseX > 600 && mouseX < 640 && mouseY > 34 && mouseY < 74){ //song button 1
			if(songs.get(0).getHasStarted() == false && songs.get(1).getHasStarted() == false && songs.get(2).getHasStarted() == false){
				songs.get(0).startThread();
			}
		}
		
		if(mouseX > 660 && mouseX < 700 && mouseY > 34 && mouseY < 74){ //song button 2
			if(songs.get(0).getHasStarted() == false && songs.get(1).getHasStarted() == false && songs.get(2).getHasStarted() == false){
				songs.get(1).startThread();
			}
		}
		
		if(mouseX > 720 && mouseX < 760 && mouseY > 34 && mouseY < 74){ //song button 3
			if(songs.get(0).getHasStarted() == false && songs.get(1).getHasStarted() == false && songs.get(2).getHasStarted() == false){
				songs.get(2).startThread();
			}
		}
		
		if(mouseX > 100 && mouseX < 200 && mouseY > 35 && mouseY < 70){ //stop button
			for(Song s : songs){
				if(s.getHasStarted()){
					s.stopThread();
				}
			}
		}
	}

	/**
	 * Executes when the mouse buttons are pressed. Allows the piano keys to be played if pressed.
	 */
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		//Experimental Code to allow clicking to play notes 5/19
		//if (arduino == null) {
			WhiteKey[] keys = piano.getWhiteKeys();
			BlackKey[] blackKeys = piano.getBlackKeys();
			boolean flag = true;
			// Code works, but may be slow (?)
			// Note to self: Potentially, separate the loops, keep the flag so that the second 
			// loop (white keys) does not execute if the flag is false
			for (int i = 0; i < keys.length; i++) {
				if (mouseX > keys[i].getX() && mouseX < keys[i].getX() + keys[i].getWidth() &&
						mouseY > keys[i].getY() && mouseY < keys[i].getY()+keys[i].getHeight()) {
					for (int j = 0; j < blackKeys.length; j++) {
						if (mouseX > blackKeys[j].getX() && mouseX < blackKeys[j].getX() + blackKeys[j].getWidth() &&
								mouseY > blackKeys[j].getY() && mouseY < blackKeys[j].getY()+blackKeys[j].getHeight()) {
							blackKeys[j].setIsPressed(true);
							piano.playBlackKey(j);
							flag = false;
						}
					}
					if (flag) {
						keys[i].setIsPressed(true);
						piano.playWhiteKey(i);
					}
				}
			}
		//}
	}
	
	/**
	 * Executes when the mouse buttons are released. Allows the piano keys to be played if pressed.
	 */
	public void mouseReleased(MouseEvent e) {
		//Experimental Code to allow clicking to play notes 5/19
		//if (arduino == null) {
			WhiteKey[] keys = piano.getWhiteKeys();
			for (int i = 0; i < keys.length; i++) {
				keys[i].setIsPressed(false);
			}
			// Code for black keys 5/20
			BlackKey[] blackKeys = piano.getBlackKeys();
			for (int i = 0; i < blackKeys.length; i++) {
				blackKeys[i].setIsPressed(false);
			}
		//}
	}
	
	
}
