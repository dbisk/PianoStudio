
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;

/**
 * The InstructionScreen class represents the Instructions screen, where users
 * learn about the program and how to use its functions. It can be reached from
 * the MenuScreen, and can also redirect back to the Menu Screen.
 * 
 * InstructionScreen currently uses JPanel's paintComponent method to draw.
 * 
 * @author Dean Biskup and Julie Shen
 * @version 5/22/2016
 *
 */
public class InstructionScreen extends JPanel implements ActionListener {

	private String subtitle1, subtitle2, subtitle3;
	private String body1, body2, body3, body4, body5, body6, body7;
	private JButton back;
	private Main w;
	private ImageIcon background;

	/**
	 * Constructs a new InstructionScreen object with the parameter being the
	 * Main object the InstructionScreen was created in. 
	 * 
	 * @param w the Main object which this InstructionScreen was created in (usually)
	 */
	public InstructionScreen(Main w) {
		super();
		this.w = w;
		setBackground(Color.WHITE);
		background = new ImageIcon("lib\\sheetmusic.jpg");
		
		subtitle1 = "With the Arduino:";
		subtitle2 = "Without the Arduino:";
		subtitle3 = "Play-Along Feature:";
		
		body1 = "*Make sure the Arduino is plugged into the computer.";
		body4 = "Touch the copper foil keys to play to your heart's content!*";
		body2 = "Use the mouse to click the black and white piano keys on the screen.";
		body3 = "Click one of the numbered buttons on the piano screen to start the play-";
		body7 = "along feature.";
		body5 = "Follow the keys that light up red to learn a song!";
		body6 =	"Click the 'Stop' button to stop the play-along feature.";
		
		back = new JButton("Back"); //back button
		back.setBackground(new Color(74, 188, 150));
		back.setForeground(Color.white);
		
		JPanel buttonPanel = new JPanel();
		back.addActionListener(this);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(back);
		add(buttonPanel, BorderLayout.EAST);
	}

	/**
	 * The paintComponent method draws the Instructions to the screen
	 * 
	 * @param g the Graphics object this method will draw on
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint the background
		Graphics2D g2 = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / 840.0;
		double ratioY = (double) height / 630.0;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		background.paintIcon(this, g, 0, 0); //background image
		
		g.setColor(Color.white); //background white rectangle
		g.fillRect(55, 75, 735, 480);

		g.setColor(new Color(74, 188, 150));
		g.setFont(new Font("SansSerif", Font.BOLD, 20));
		g.drawString(subtitle1, 80, 125); // w/ arduino
		g.drawString(subtitle2, 80, 250); // w/o arduino
		g.drawString(subtitle3, 80, 325); // play-along
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("SansSerif", Font.PLAIN, 20));
		g.drawString(body4, 105, 150); // w/ arduino
		g.drawString(body1, 105, 200); 
		g.drawString(body2, 105, 275); // w/o arduino
		g.drawString(body5, 105, 350); // play-along
		g.drawString(body3, 105, 425);
		g.drawString(body7, 105, 450);
		g.drawString(body6, 105, 500);
		
		g2.setTransform(at);

		// TODO Add any custom drawings here
	}

	@Override
	/**
	 * When the actionPerformed method is called by a button trigger,
	 * the panel will change to the menu screen.
	 */
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		w.changePanel("1");
	}

}
