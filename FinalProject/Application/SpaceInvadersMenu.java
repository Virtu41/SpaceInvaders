/**
 * Main Menu and Starting Screen For Game
 * 
 * modified     20220618
 * date         20220618
 * @filename    SpaceInvadersMenu.java
 * @author      Oscar Lam
 * @author      Asher Zaidi 
 * @author      Anuja Perera
 * @version     1.0
 * @see         ICS4U Content Unit 4 
 *
 */



// program used as starting screen, to: start game, read the how to play and exit game.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpaceInvadersMenu extends JFrame {
	
	private JFrame frame;

	private JPanel contentPane;

	ArrayList<String> pictures = new ArrayList<String>();
	ImageIcon covidImg = new ImageIcon("Images//covid19.png");
	ImageIcon backgroundImg = new ImageIcon("Images//bg2.png");
	ImageIcon newHowToPlayImg = new ImageIcon("Images//Howtoplay.jpg");
	static ImageIcon newRules;
	boolean running = false; 

	ImageIcon bg;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceInvadersMenu frame = new SpaceInvadersMenu();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	} 

	/**
	 * Create the frame.
	 */
	public SpaceInvadersMenu() {

		super ("Space Invaders");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel background = new JPanel();
		background.setBackground(new Color(128, 0, 128));
		background.setBounds(0, 0, 850, 700);
		contentPane.add(background);
		background.setLayout(null);

		JPanel panelContainer = new JPanel();
		panelContainer.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panelContainer.setBackground(new Color(138, 43, 226));
		panelContainer.setBounds(195, 11, 400, 661);
		background.add(panelContainer);
		panelContainer.setLayout(null);

		JPanel titleBackground = new JPanel();
		titleBackground.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		titleBackground.setBackground(new Color(186, 85, 211));
		titleBackground.setBounds(10, 11, 380, 70);
		panelContainer.add(titleBackground);
		titleBackground.setLayout(null);

		JLabel Title = new JLabel("SPACE INVADERS");
		Title.setForeground(new Color(255, 215, 0));
		Title.setFont(new Font("DialogInput", Font.BOLD, 37));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(10, 11, 360, 48);
		titleBackground.add(Title);

		JPanel startGameBackground = new JPanel();
		startGameBackground.setLayout(null);
		startGameBackground.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		startGameBackground.setBackground(new Color(153, 50, 204));
		startGameBackground.setBounds(87, 110, 225, 70);
		panelContainer.add(startGameBackground);

		JButton btnStartGame = new JButton("START GAME");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose(); // https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html#dispose()
				
				SpaceInvadersMenu frame = new SpaceInvadersMenu();
				
				JFrame f = new JFrame("Space Invaders");//java JFrame object
				f.setVisible(true);
				Container cont = f.getContentPane();  // get container - top of the frame
				cont.setLayout(new BorderLayout());  // set Layout to Border 

				SpaceInvaders bp= new SpaceInvaders();  // create an object of our game panel
				cont.add(bp, BorderLayout.CENTER ); // add this game panel to the center of the frame

				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // make frame closed when x button is pressed
				f.setResizable(false); // make the frame resizable
				f.setSize(1000, 800);  // set the size of the frame
			}
		});
		btnStartGame.setForeground(new Color(255, 215, 0));
		btnStartGame.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnStartGame.setBackground(new Color(186, 85, 211));
		btnStartGame.setBounds(10, 11, 205, 48);
		startGameBackground.add(btnStartGame);

		JPanel innerStartGameBackground = new JPanel();
		innerStartGameBackground.setLayout(null);
		innerStartGameBackground.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		innerStartGameBackground.setBackground(new Color(153, 50, 204));
		innerStartGameBackground.setBounds(87, 210, 225, 70);
		panelContainer.add(innerStartGameBackground);

		JButton btnInstructions = new JButton("HOW TO PLAY");
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SpaceInvadersMenu frame = new SpaceInvadersMenu();
				frame.setVisible(false);
				frame.setResizable(false);

				UIManager UI=new UIManager();

				UIManager.put("OptionPane.background", new Color(186, 85, 211));
				UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(186, 85, 211));

				JOptionPane.showMessageDialog(null, "", "Instructions", JOptionPane.NO_OPTION, newHowToPlayImg);
			}
		});
		btnInstructions.setForeground(new Color(255, 215, 0));
		btnInstructions.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnInstructions.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnInstructions.setBackground(new Color(186, 85, 211));
		btnInstructions.setBounds(10, 11, 205, 48);
		innerStartGameBackground.add(btnInstructions);

		JPanel doubleStartGameBackground = new JPanel();
		doubleStartGameBackground.setLayout(null);
		doubleStartGameBackground.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		doubleStartGameBackground.setBackground(new Color(153, 50, 204));
		doubleStartGameBackground.setBounds(87, 310, 225, 70);
		panelContainer.add(doubleStartGameBackground);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(new Color(255, 215, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnExit.setBackground(new Color(186, 85, 211));
		btnExit.setBounds(10, 11, 205, 48);
		doubleStartGameBackground.add(btnExit);

		bg = new ImageIcon("bg2.png");

		JLabel backgroundImg = new JLabel(bg);
		backgroundImg.setBounds(0, 0, 900,800);
		background.add(backgroundImg);
	}
}