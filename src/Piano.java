import javax.sound.midi.MidiUnavailableException;

import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;

import processing.core.PApplet;

/**
 * This class represents a Piano object that has 8 whiteKeys and 5 blackKeys. There is also a
 * graphical representation of the Piano that is drawn onto the PianoScreen.
 * 
 * @author Dean Biskup and Julie Shen
 * @version 5/22/16
 *
 */
public class Piano {

	private WhiteKey[] whiteKeys;
	private BlackKey[] blackKeys;
	private RealtimePlayer player;
	
	/**
	 * No-args default constructor that creates a Piano object with an array of 8 WhiteKeys and 
	 * 5 BlackKeys
	 */
	public Piano(){
		whiteKeys = new WhiteKey[8];
		blackKeys = new BlackKey[5];
		
		whiteKeys[0] = new WhiteKey("C5", 261.626, 90, 150);
		whiteKeys[1] = new WhiteKey("D5", 293.665, 170, 150);
		whiteKeys[2] = new WhiteKey("E5", 329.628, 250, 150);
		whiteKeys[3] = new WhiteKey("F5", 349.228, 330, 150);
		whiteKeys[4] = new WhiteKey("G5", 391.995, 410, 150);
		whiteKeys[5] = new WhiteKey("A5", 440.000, 490, 150);
		whiteKeys[6] = new WhiteKey("B5", 493.883, 570, 150);
		whiteKeys[7] = new WhiteKey("C6", 523.251, 650, 150);
		
		blackKeys[0] = new BlackKey("C#", 277.183, 140, 150); // Changed 5/20
		blackKeys[1] = new BlackKey("D#", 311.127, 220, 150);
		blackKeys[2] = new BlackKey("F#", 369.994, 380, 150);
		blackKeys[3] = new BlackKey("G#", 415.305, 460, 150);
		blackKeys[4] = new BlackKey("A#", 466.164, 540, 150);
				
		try {
			player = new RealtimePlayer();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	/**
	 * Returns the array of WhiteKeys
	 * 
	 * @return array of WhiteKeys from the Piano
	 */
	public WhiteKey[] getWhiteKeys(){
		return whiteKeys;
	}
	
	/**
	 * Returns the array of BlackKeys
	 * 
	 * @return array of BlackKeys from the Piano
	 */
	public BlackKey[] getBlackKeys(){
		return blackKeys;
	}
	
	/**
	 * Draws a new instance of a Piano object by drawing each of the WhiteKeys and BlackKeys and
	 * labeling each piano key.
	 *  
	 * @param drawer PApplet object used to draw
	 */
	public void draw(PApplet drawer){
		for(WhiteKey k : whiteKeys){
			k.draw(drawer);
			drawer.fill(0);
			drawer.textSize(24);
			drawer.text(k.getNote().substring(0, 1), (float)(k.getX() + k.getWidth()*5.0/12), (float)(k.getY() + k.getHeight() + 30));
		}
		
		for(BlackKey k : blackKeys){
			k.draw(drawer);
			drawer.fill(0);
			drawer.textSize(20);
			drawer.text(k.getNote(), (float)(k.getX())+20, (float)(k.getY() - 20));
		}
		
		drawer.stroke(0);
		drawer.strokeWeight(2);
		drawer.fill(0);
		drawer.rect(700, 150, 30, 240);
	}
	
	/**
	 * Plays (makes sound) the white key with the index specified in parameter whiteKey
	 * @param whiteKey the index of the key that needs to be played (make sound)
	 */
	public void playWhiteKey(int whiteKey) {
		player.startNote(new Note(whiteKeys[whiteKey].getNote()));
	}
	
	/**
	 * Plays (makes sound) the black key with the index specified in parameter blackKey
	 * @param blackKey the index of the key that needs to be played (make sound)
	 */
	public void playBlackKey(int blackKey) {
		player.startNote(new Note(blackKeys[blackKey].getNote()));
	}
	
	/* For use in the future
	public void play(int key) {
		player.startNote(new Note(keys[key].getNote()));
	}*/
}
