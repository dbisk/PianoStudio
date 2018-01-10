import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

public class Main extends JFrame {

	JPanel cardPanel;
	private static int width;
	private static int height;
	
	public Main(String title) {
		super(title);
		setBounds(10, 10, width, height);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		MenuScreen panel1 = new MenuScreen(this);    
	    JPanel panel2 = new JPanel();
	    panel2.setBackground(Color.white);
	    PianoScreen p = new PianoScreen(width, height, this);
	    panel2.add(p);
	    p.init();
	    InstructionScreen howToPlay = new InstructionScreen(this);
	    
	
	    cardPanel.add(panel1,"1");
	    cardPanel.add(panel2,"2");
	    cardPanel.add(howToPlay, "3");
	    
	    add(cardPanel);
	
	    setVisible(true);
	}

	public static void main(String[] args)
	{
		width = 840;
		height = 630;
		Main w = new Main("PianoStudio");
	}
  
	/**
	 * Changes the active panel/panel in front to the panel with the specified name
	 * @param name name of the panel to be in front
	 */
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
  
}