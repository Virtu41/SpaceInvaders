import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpaceInvadersMenu extends JFrame {

	private JPanel contentPane;

	ArrayList<String> pictures = new ArrayList<String>();
	ImageIcon a = new ImageIcon("SpaceInvader.png");
	ImageIcon b = new ImageIcon("spaceshipone-spacecraft-pixel-art-pixel-art.jpg");
	ImageIcon c = new ImageIcon("InvaderBullet.png");
	ImageIcon d = new ImageIcon("Bullet.png");
	boolean startGame = true;
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Background = new JPanel();
		Background.setBackground(new Color(128, 0, 128));
		Background.setBounds(0, 0, 850, 700);
		contentPane.add(Background);
		Background.setLayout(null);
		
		JPanel panelContainer = new JPanel();
		panelContainer.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panelContainer.setBackground(new Color(138, 43, 226));
		panelContainer.setBounds(195, 11, 400, 661);
		Background.add(panelContainer);
		panelContainer.setLayout(null);
		
		JPanel TitleBackground = new JPanel();
		TitleBackground.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		TitleBackground.setBackground(new Color(186, 85, 211));
		TitleBackground.setBounds(10, 11, 380, 70);
		panelContainer.add(TitleBackground);
		TitleBackground.setLayout(null);
		
		JLabel Title = new JLabel("SPACE INVADERS");
		Title.setForeground(new Color(255, 215, 0));
		Title.setFont(new Font("DialogInput", Font.BOLD, 37));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(10, 11, 360, 48);
		TitleBackground.add(Title);
		
		JPanel StartGameBackground = new JPanel();
		StartGameBackground.setLayout(null);
		StartGameBackground.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		StartGameBackground.setBackground(new Color(153, 50, 204));
		StartGameBackground.setBounds(87, 110, 225, 70);
		panelContainer.add(StartGameBackground);
		
		JButton btnStartGame = new JButton("START GAME");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnStartGame.setForeground(new Color(255, 215, 0));
		btnStartGame.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnStartGame.setBackground(new Color(186, 85, 211));
		btnStartGame.setBounds(10, 11, 205, 48);
		StartGameBackground.add(btnStartGame);
		
		JPanel StartGameBackground_1 = new JPanel();
		StartGameBackground_1.setLayout(null);
		StartGameBackground_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		StartGameBackground_1.setBackground(new Color(153, 50, 204));
		StartGameBackground_1.setBounds(87, 210, 225, 70);
		panelContainer.add(StartGameBackground_1);
		
		JButton btnInstructions = new JButton("INSTRUCTIONS");
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnInstructions.setForeground(new Color(255, 215, 0));
		btnInstructions.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnInstructions.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnInstructions.setBackground(new Color(186, 85, 211));
		btnInstructions.setBounds(10, 11, 205, 48);
		StartGameBackground_1.add(btnInstructions);
		
		JPanel StartGameBackground_2 = new JPanel();
		StartGameBackground_2.setLayout(null);
		StartGameBackground_2.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		StartGameBackground_2.setBackground(new Color(153, 50, 204));
		StartGameBackground_2.setBounds(87, 310, 225, 70);
		panelContainer.add(StartGameBackground_2);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(new Color(255, 215, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnExit.setBackground(new Color(186, 85, 211));
		btnExit.setBounds(10, 11, 205, 48);
		StartGameBackground_2.add(btnExit);
		
		JButton Pic1 = new JButton("");
		Pic1.setBorder(null);
		Pic1.setBackground(new Color(138, 43, 226));
		Pic1.setBounds(10, 390, 80, 70);
		panelContainer.add(Pic1);
		Pic1.setIcon(a);
		
		JButton Pic2 = new JButton("");
		Pic2.setBorder(null);
		Pic2.setBackground(new Color(138, 43, 226));
		Pic2.setBounds(110, 391, 80, 70);
		panelContainer.add(Pic2);
		Pic2.setIcon(a);
		
		JButton Pic3 = new JButton("");
		Pic3.setBorder(null);
		Pic3.setBackground(new Color(138, 43, 226));
		Pic3.setBounds(215, 390, 80, 70);
		panelContainer.add(Pic3);
		Pic3.setIcon(a);
		
		JButton Pic4 = new JButton("");
		Pic4.setBorder(null);
		Pic4.setBackground(new Color(138, 43, 226));
		Pic4.setBounds(310, 391, 80, 70);
		panelContainer.add(Pic4);
		Pic4.setIcon(a);
		
		JButton Pic9 = new JButton("");
		Pic9.setBorder(null);
		Pic9.setBackground(new Color(138, 43, 226));
		Pic9.setBounds(10, 580, 80, 70);
		panelContainer.add(Pic9);
		Pic9.setIcon(a);
		
		JButton Pic10 = new JButton("");
		Pic10.setBorder(null);
		Pic10.setBackground(new Color(138, 43, 226));
		Pic10.setBounds(110, 580, 80, 70);
		panelContainer.add(Pic10);
		Pic10.setIcon(a);
		
		JButton Pic11 = new JButton("");
		Pic11.setBorder(null);
		Pic11.setBackground(new Color(138, 43, 226));
		Pic11.setBounds(215, 580, 80, 70);
		panelContainer.add(Pic11);
		Pic11.setIcon(a);
		
		JButton Pic12 = new JButton("");
		Pic12.setBorder(null);
		Pic12.setBackground(new Color(138, 43, 226));
		Pic12.setBounds(310, 580, 80, 70);
		panelContainer.add(Pic12);
		Pic12.setIcon(a);
		
		JButton Pic5 = new JButton("");
		Pic5.setBorder(null);
		Pic5.setBackground(new Color(138, 43, 226));
		Pic5.setBounds(10, 486, 80, 70);
		panelContainer.add(Pic5);
		Pic5.setIcon(a);
		
		JButton Pic6 = new JButton("");
		Pic6.setBorder(null);
		Pic6.setBackground(new Color(138, 43, 226));
		Pic6.setBounds(110, 486, 80, 70);
		panelContainer.add(Pic6);
		Pic6.setIcon(a);
		
		JButton Pic7 = new JButton("");
		Pic7.setBorder(null);
		Pic7.setBackground(new Color(138, 43, 226));
		Pic7.setBounds(215, 486, 80, 70);
		panelContainer.add(Pic7);
		Pic7.setIcon(a);
		
		JButton Pic8 = new JButton("");
		Pic8.setBorder(null);
		Pic8.setBackground(new Color(138, 43, 226));
		Pic8.setBounds(310, 486, 80, 70);
		panelContainer.add(Pic8);
		Pic8.setIcon(a);
		
		JButton Pic9_1 = new JButton("");
		Pic9_1.setBorder(null);
		Pic9_1.setBackground(new Color(138, 43, 226));
		Pic9_1.setBounds(10, 602, 80, 70);
		Background.add(Pic9_1);
		
		JButton Pic9_2 = new JButton("");
		Pic9_2.setBorder(null);
		Pic9_2.setBackground(new Color(138, 43, 226));
		Pic9_2.setBounds(105, 602, 80, 70);
		Background.add(Pic9_2);
		
		JButton Pic9_3 = new JButton("");
		Pic9_3.setBorder(null);
		Pic9_3.setBackground(new Color(138, 43, 226));
		Pic9_3.setBounds(605, 602, 80, 70);
		Background.add(Pic9_3);
		 
	}
}
