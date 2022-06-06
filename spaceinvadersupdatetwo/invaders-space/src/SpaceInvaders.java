/**
 * GUI
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SpaceInvaders extends JFrame {
	SpaceInvadersAI spaceInvadersAI = new SpaceInvadersAI(this);
	SpaceInvadersPlayer spaceInvadersPlayer = new SpaceInvadersPlayer(this);
	
	
	
	JButton b1, b2, b3, b4; 
	ImageIcon playImg, rules, start, howToPlay, book, win, title;  //ImageIcon to store images

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceInvaders frame = new SpaceInvaders();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SpaceInvaders() {
		
		
		
	}
}
