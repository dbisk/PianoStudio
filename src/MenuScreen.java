
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The MenuScreen represents the screen the user first lands on when the program is
 * loaded. It includes buttons leading to the Instructions screen and the Piano screen.
 * 
 * @author Dean Biskup and Julie Shen
 * @version 5/22/2016
 *
 */
public class MenuScreen extends JPanel implements ActionListener {
	
	private Main w;
	private JButton start, help;
	private ImageIcon title, background;
	
	/**
	 * Constructs a MenuScreen with its Main class as specified in the parameter. When invoking
	 * this constructor from a Main class, the parameter should almost always be "this". 
	 * 
	 * @param w The Main object this MenuScreen was called from
	 */
	public MenuScreen(Main w) {
		this.w = w;
		JPanel panel = new JPanel();
		setBackground(Color.white);
		
		title = new ImageIcon("lib\\piano studio.PNG");
		background = new ImageIcon("lib\\piano background.jpg");
		
		start = new JButton("Start Piano Studio!");
		help = new JButton("How to Play");
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		layout.setConstraints(start, c);
		start.addActionListener(this);
		start.setBackground(Color.white);
		start.setForeground(Color.black);
		panel.add(start, c);
		
		
		c.weightx = 0.0;
		c.gridx = 1;
		layout.setConstraints(help, c);
		help.addActionListener(this);
		help.setBackground(Color.black);
		help.setForeground(Color.white);
		panel.add(help, c);
		
		setLayout(layout);
		add(panel);
	}
	
	/**
	 * The paintComponent method draws the background image and title image to the screen
	 * 
	 * @param g the Graphics object this method will draw on
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint
									// the background
		Graphics2D g2 = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double) width / 840.0;
		double ratioY = (double) height / 630.0;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		background.paintIcon(this, g, 0 , 0);
		title.paintIcon(this, g, 420-title.getIconWidth()/2, 40);

		g2.setTransform(at);

		// TODO Add any custom drawings here
	}
	
	/**
	 * The actionPerformed method (inherited from the interface ActionListener)
	 * is called whenever a button in MenuScreen is pressed. Based on the button 
	 * invoking the method, actionPerformed will do different things.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(start)) {
			w.changePanel("2");
		}
		else if (e.getSource().equals(help))
			w.changePanel("3");
	}

	
}