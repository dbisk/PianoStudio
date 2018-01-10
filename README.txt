Source: http://www.instructables.com/id/Capacitive-Touch-Arduino-Keyboard-Piano/


README


Title: Piano Simulator
Authors: Dean Biskup, Julie Shen
Date: 5/23/16


Description


This simple piano simulator, PianoStudio, is created for those who can’t afford the thousands of dollars a real piano costs but have always wanted to learn how to play. This is an easy, affordable solution to a common problem for budding musicians and piano-playing novices.


This piano simulator includes 8 white piano keys connected to an Arduino Uno through wires and resistors. The white keys are made of copper foil tape and play the corresponding notes (C, D, E, F, G, A, B, C) through the computer program. PianoStudio also has a user interface with a graphical representation of the piano keys (8 white piano keys, 5 black piano keys). When each copper key is pressed, the corresponding piano key on the program interface (which is labeled with the corresponding note) lights up. 


There are also features to aid the piano learning process, including a play-along feature. The play-along feature teaches the user how to play a simple song by lighting up the key and waiting for the user to play that key on the keyboard. 


Instructions can be reached from the corresponding option on the Menu Screen.


Let your imagination run wild and make some music!


Instructions


Make sure the Arduino is plugged into the computer using the gray cable. Make sure all the wires connecting the keys to the Arduino are plugged in all the way to the serial ports (should already be done, just a check). Open the Java program, PianoStudio, and using the menu screen, navigate to the Instructions and Piano screens, and now you’re ready to play to your heart’s content!


The player can use the traditional piano form and place all 5 fingers of their dominant hand on adjacent keys connected to the Arduino. The player can also hit the keys one at a time with an index finger, similar to how a kindergartener types. Just press down on a key connected to the Arduino to play a note! If the arduino is not plugged in, you may click on the keys to make the sound.


Use the left-key on the mouse to open and close the Java program and navigate between the menu, Piano Studio, and instructions screens by clicking on the buttons.


Features List


MUST-HAVE (DONE)
* 8 piano keys connected to an Arduino Uno (DONE)
* Java GUI with a graphical representation of 8 white piano keys (DONE)
* Computer correctly plays notes corresponding to keys pressed on the Arduino (DONE)
* Graphical representation of piano keys light up to corresponding key on Arduino when pressed (DONE)
* Piano keys on GUI are labeled with the letter for the note (DONE)


WANT-TO-HAVES
* Menu screen that provides different options (ALMOST DONE)
   * Instructions (DONE)
   * Play (DONE)
   * Piano Hero (optional) (NOT DONE)
* Add 5 keys for the black piano keys (both on the GUI and on the arduino) (ONLY ON GUI)
   * The keys also play the correct pitches
* Add octave feature (INCOMPLETE)
   * A button can be pressed either on the piano screen or on the keyboard that changes the octave to one above and can switch it back (toggle)
* Recording studio (NOT DONE)
   * Have record/playback buttons on the piano screen that record your playing and play it back
   * There will also be a save button on the interface that writes the recording to an mp3 file
* Play-along with me (DONE!!!!)
   * The on-screen keyboard will light up, and wait for the user to hit the corresponding key on the Arduinoboard, and go on to the next note. 
   * Used to teach piano to the user
* Piano Hero (NOT DONE)
   * Similar to the game Guitar Hero
   * A 3 min. long song’s notes scroll across the screen and the player must hit the correct piano keys on the Arduino
   * The game gives a score:
      * Perfect +100
      * Great +80
      * Good +60
      * OK +30
      * Poor -50
   * There are 3 songs -- 1 for each difficulty level (easy, medium, hard)
* Metronome (NOT DONE)
   * Metronome feature on piano screen that keeps tempo and can be adjusted using spinner/drop-down menu/input box
   * Metronome can play beats simultaneously with the piano
* Pedals (NOT DONE)
   * 2 keys on the keyboard that correspond to the soft and sustaining piano pedals
   * The sustaining key extends the sound of the piano key when held (or until it reaches a maximum amount of time)
   * The soft key lowers the volume of the note played to a certain volume when pressed (toggle)
   * May include graphical representations of both pedals on the screen (2 pedals that light up when pressed or held)


STRETCH (NOT DONE)
* Add drums to Arduino
   * Connect different keys for the different features on a drum set (suspended cymbal, bass, snare, etc.)
   * The drums feature will also be on the GUI and menu
* Two-player mode
   * Two players can play drums and piano in both freestyle and Piano Hero mode
* Add more songs to Piano Hero
   * Have 3 songs for each difficulty (for a total of 9)
* Add a video tutorial on the menu screen and piano screen for how to play piano on Arduino (how to set it up, the technique/form, etc.)
* High score feature for Piano Hero
   * Saves the top 5 scores for the game for each difficulty
   * Add this option to the menu screen
* Pause/resume feature for Piano Hero game


Class List
* Main
* PianoScreen
* MenuScreen
* InstructionScreen
* Piano
* Key
* WhiteKey
* BlackKey
* ArduinoInput
* Song


Responsibility (Subject to Change)
Dean: InstructionScreen, Menu Screen, ArduinoInput, Main, PianoScreen, Key
Julie: Piano, Key, WhiteKey, BlackKey, PianoScreen, Main, Song + the preprogrammed songs