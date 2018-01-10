import java.awt.Color;

/**
 * This class represents a Song object that has a name and a sequence of notes. It also can detect
 * whether it has started in the play-along feature.
 * 
 * @author Julie Shen
 * @version 5/23/16
 *
 */
public class Song implements Runnable{
	
	private String name;
	private int[] notes;
	private Piano piano;
	private boolean hasStarted;
	
	/**
	 * This constructor creates a Song object with a name, notes, and a piano passed in 
	 * as arguments.
	 * 
	 * @param name The name of the song
	 * @param notes An array of integers indicating the sequence of keys to be pressed
	 * @param piano A Piano object that is used
	 */
	public Song(String name, int[] notes, Piano piano){
		this.name = name;
		this.notes = notes;
		this.piano = piano;
		hasStarted = false;
	}
	
	public int[] getNotes(){
		return notes;
	}
	
	public String getName(){
		return name;
	}
	
	public void setHasStarted(boolean b){
		hasStarted = b;
	}
	
	public boolean getHasStarted(){
		return hasStarted;
	}
	
	/**
	 * Starts the play-along feature in the program. Each key in the sequence of notes lights up
	 * red for the User to follow.
	 */
	public void playAlong(){
		for(int i = 0; i < notes.length; i++){
			if(hasStarted){
				Key key = piano.getWhiteKeys()[notes[i]];
				while(key.isPressed == false && hasStarted){
					key.isPlayAlong = true;
					Thread.yield();
				}
				key.isPlayAlong = false;
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		stopThread();	
	}
	
	/**
	 * Starts a new Thread to allow the play-along feature to run simultaneously while the keys
	 * are being pressed.
	 */
	public void startThread(){
		hasStarted = true;
		new Thread(this).start();
	}
	
	/**
	 * Stops the Thread by stopping the play-along feature.
	 */
	public void stopThread(){
		hasStarted = false;
	}
	
	/**
	 * Allows the play-along feature to run in a new Thread. Runs when the Thread begins.
	 */
	@Override
	public void run(){
		while(hasStarted)
			playAlong();
		
	}
}
