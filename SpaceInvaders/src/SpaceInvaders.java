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

public class SpaceInvaders extends JFrame {
	SpaceInvadersAI spaceInvadersAI = new SpaceInvadersAI(this);
	SpaceInvadersPlayer spaceInvadersPlayer = new SpaceInvadersPlayer(this);
	SpaceInvadersMenu spaceInvadersMenu = new SpaceInvadersMenu(this);
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
		super ("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		title = new ImageIcon ("Title.png"); 
		book = new ImageIcon ("Book.png");
		rules = new ImageIcon("Rules.png");
		howToPlay = new ImageIcon ("HowToPlay.png"); 
		start = new ImageIcon("Start.png"); 
		
		b1 = new JButton(start); // img 
		b1.setBounds(40, 420, 100, 100);
		b1.addActionListener(spaceInvadersMenu);
		
		//set button b2 
		b2= new JButton(book); // img
		b2.setBounds(40, 190, 100, 100);
		b2.addActionListener(spaceInvadersMenu);
		
		//set button b3  
		b3= new JButton("Exit");
		b3.setBounds(40, 340, 100, 30);// x, y, width, height
		b3.addActionListener(spaceInvadersMenu);
		
		//set button b4
		b4= new JButton(rules);
		b4.setBounds(40, 570, 100, 100);
		b4.addActionListener(spaceInvadersMenu);
	}

}
