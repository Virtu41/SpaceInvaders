import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SpaceInvadersMenuPanel {

	public static void main(String[] args) {
		
		SpaceInvadersMenu frame = new SpaceInvadersMenu();
		frame.setResizable(false);
		
		Container cont = frame.getContentPane();
		cont.setLayout(new BorderLayout());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // make frame closed when x button is pressed
		frame.setVisible(true);     // make the frame visible
		frame.setSize(800, 900);  // set the size of the frame
		
	}


}
