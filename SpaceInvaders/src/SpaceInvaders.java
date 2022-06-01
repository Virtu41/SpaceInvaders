/**
 * GUI
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SpaceInvaders extends JFrame {
	SpaceInvadersAI spaceInvadersAI = new SpaceInvadersAI(this);
	SpaceInvadersPlayer spaceInvadersPlayer = new SpaceInvadersPlayer(this);
	JButton b1, b2, b3, b4; 

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		b1 = new JButton(start); // img 
		b1.setBounds(40, 420, 100, 100);
		spaceInvaders.add(b1);
		b1.addActionListener(spaceInvaders);
		b1.addKeyListener(spaceInvaders);
		
		//set button b2 
		b2= new JButton(book); // img
		b2.setBounds(40, 190, 100, 100);
		spaceInvaders.add(b2);
		b2.addActionListener(spaceInvaders);
		b2.addKeyListener(spaceInvaders);
		
		//set button b3  
		b3= new JButton("Exit");
		b3.setBounds(40, 340, 100, 30);// x, y, width, height
		spaceInvaders.add(b3);
		b3.addActionListener(spaceInvaders);
		b3.addKeyListener(spaceInvaders);
		
		//set button b4
		b4= new JButton(rules);
		b4.setBounds(40, 570, 100, 100);
		spaceInvaders.add(b4);
		b4.addActionListener(spaceInvaders);
		b4.addKeyListener(spaceInvaders);
	}

}
