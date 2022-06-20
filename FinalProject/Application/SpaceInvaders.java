/**
 * Main code for game
 * 
 * modified     20220619
 * date         20220606
 * @filename    SpaceInvaders.java
 * @author      Oscar Lam
 * @author      Asher Zaidi 
 * @author      Anuja Perera
 * @version     1.0
 * @see         ICS4U Content Unit 4 
 *
*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.ArrayList;



public class SpaceInvaders extends JPanel implements ActionListener, KeyListener  {
	SpaceInvadersPlayer playerF = new SpaceInvadersPlayer(this);
	SpaceInvadersAI invader = new SpaceInvadersAI(this);
	SpaceInvadersGameFunction function = new SpaceInvadersGameFunction(this);

	String txt="";
	int xOfPlayer=460, yOfPlayer=625; 
	int xCovid, yCovid;
	int bulletSpeedP = 10;
	int bulletSpeedS = 5;
	int ATK_SPEED_LEN = 150;
	boolean covid = false;

	ArrayList<Integer> listInvaderX = new ArrayList<Integer>();
	ArrayList<Integer> listInvaderY = new ArrayList<Integer>();
	ArrayList<Integer> covidX = new ArrayList<Integer>();
	ArrayList<Integer> covidY = new ArrayList<Integer>();

	// Bullets set to default values 
	int [][] bulletA = {{-10, -10, -10},  // x-component
					 	{-10, -10, -10}}; // y-component
	
	int [][] invaderBulletA = {{-10, -10, -10},  // x-component
							   {-10, -10, -10}}; // y-component
	String name;

	int score = 0; 
	int health = 3; 
	int count = 0;
	int timeCounter = 2000; 
	int tempCounter = 0;
	int powerUpCooldown = 300;

	JButton b1, b2, b3, b4, b5;    
	JLabel lblImg;

	boolean running = false; 
	boolean answer = true;

	ImageIcon rules, covid19, play, bg, spaceInvader, paused, player, pausePlay, start, bullet, invaderBullet, howToPlay, title,scoreIcon,controller,newRules,exit,theRules ;      //ImageIcon to store images
	Rectangle invaderBulletBox, playerBox, playerBulletBox, spaceInvaderBox, covidBox; 
	Timer timer; 

	public SpaceInvaders(){  
		this.setLayout(null); 

		// Add position of space invaders
		listInvaderX.add(250); 
		listInvaderX.add(250); 
		listInvaderX.add(250); 
		listInvaderX.add(250); 
		listInvaderX.add(475); 
		listInvaderX.add(475); 
		listInvaderX.add(475); 
		listInvaderX.add(475);
		listInvaderX.add(700);
		listInvaderX.add(700);
		listInvaderX.add(700);
		listInvaderX.add(700);

		listInvaderY.add(150);
		listInvaderY.add(250);
		listInvaderY.add(350);
		listInvaderY.add(450);
		listInvaderY.add(150);
		listInvaderY.add(250);
		listInvaderY.add(350);
		listInvaderY.add(450);
		listInvaderY.add(150);
		listInvaderY.add(250);
		listInvaderY.add(350);
		listInvaderY.add(450);

		title = new ImageIcon ("Images//title.png"); 
		covid19 = new ImageIcon("Images//covid19.png");
		rules = new ImageIcon("Images//rules.png");
		bg = new ImageIcon("Images//bg2.png");
		spaceInvader = new ImageIcon("Images//ant.png");
		timer = new Timer(30, this);
		howToPlay = new ImageIcon ("Images//howToPlay.jpg"); ;
		player = new ImageIcon("Images//bee.png");
		pausePlay = new ImageIcon("Images//pausePlay.png");
		bullet = new ImageIcon("Images//bullet.png"); 
		invaderBullet = new ImageIcon("Images//invaderBullet.png");
		theRules = new ImageIcon("Images//theRules.png");
		scoreIcon = new ImageIcon("Images//scoreImageIcon.png");
		controller = new ImageIcon("Images//controllerIcon.png");
		newRules = new ImageIcon("Images//rule.png");
		exit = new ImageIcon("Images//theExitImageIcon.png");
		
		//set button 1 
		b1 = new JButton(scoreIcon); 
		b1.setBounds(25, 120, 100, 100);
		this.add(b1);
		b1.addActionListener(this);
		b1.addKeyListener(this);
		b1.setBackground(new Color(186,85,211));	

		//set button b2 
		b2= new JButton(pausePlay);
		b2.setBounds(25, 275, 100, 100);
		this.add(b2);
		b2.addActionListener(this);
		b2.addKeyListener(this); 
		b2.setBackground(new Color(186, 85, 211));

		//set button b3  
		b3= new JButton(controller);
		b3.setBounds(25, 570, 100, 100);// x, y, width, height
		this.add(b3);
		b3.addActionListener(this);
		b3.addKeyListener(this);
		b3.setBackground(new Color(186, 85, 211));
		 
		//set button b4
		b4= new JButton(theRules);
		b4.setBounds(25, 425, 100, 100);
		this.add(b4);
		b4.addActionListener(this);
		b4.addKeyListener(this);
		b4.setBackground(new Color(186, 85, 211));
		
		b5= new JButton(exit);
		b5.setBounds(25, 25, 100, 50);
		this.add(b5);
		b5.addActionListener(this);
		b5.addKeyListener(this);
		b5.setBackground(new Color(186, 85, 211));

		timer.start(); 

	}

	public void paintComponent(Graphics g){ // https://docs.oracle.com/javase/7/docs/api/javax/swing/JComponent.html#paintComponent(java.awt.Graphics)
		super.paintComponent(g);

		g.drawImage(bg.getImage(), 0, 0, 1000, 800, null);  // paint background
		
		Color purple = new Color(102, 0 , 153);
		g.setColor(purple);

		g.drawString(txt,400,20);   
		g.drawImage(player.getImage(), xOfPlayer, yOfPlayer, 90, 70,null);
		g.setFont(new Font("SansSerif", Font.BOLD, 20));
		g.setColor(Color.red);
		g.drawString("Score: " + score , 460, 145);
		g.drawString(txt, 100, 50);

		Color pink = new Color(255,0,255);
		g.setColor(pink);

		if(covid) {
			g.drawImage(covid19.getImage(), covidX.get(0), covidY.get(0), 75, 75, null);
		}
		if(tempCounter>0 && tempCounter-ATK_SPEED_LEN<=timeCounter && timeCounter<tempCounter) {
			g.drawString("Power-Up time left: " + (timeCounter+ATK_SPEED_LEN-tempCounter) , 150, 50);
		}

		g.drawString("Timer: " + timeCounter , 800, 50); 
		g.drawString("PAUSE/PLAY", 18, 270);
		g.drawString("RULES", 45, 420);
		g.drawString("CONTROLS", 20, 566);
		g.drawString("SCORES", 35, 115);
		g.drawImage(title.getImage(), 380, 0, null);
		g.setColor(Color.red);

		// Draw the health bar 
		g.fillRect(xOfPlayer+22,yOfPlayer+80, 15*health, 10); 

		g.setColor(purple);

		//Draw the border 
		for (int i =0; i<5; i++) {
			g.drawRect(150 + i, 120 + i, 700, 600);  
		}

		// Repaint the space invaders 
		for (int i =0; i<listInvaderX.size(); i++) {
			g.drawImage(spaceInvader.getImage(), listInvaderX.get(i), listInvaderY.get(i), 60, 64, null);
		}
		
		// Repaint the player bullets 
		for (int i =0; i<bulletA[0].length; i++) {
			if (bulletA[0][i] > -10) {
				g.drawImage(bullet.getImage(),bulletA[0][i], bulletA[1][i], 15, 45, null); 
			}
		}
		// repaint the invader bullets 
		for (int i =0; i<invaderBulletA[0].length; i++) {
			g.drawImage(invaderBullet.getImage(), invaderBulletA[0][i],invaderBulletA[1][i], 16, 36, null); 
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		function.actionPerformed(e);
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		playerF.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		playerF.keyReleased(e);
	}

	// set up the window and the main class 
	public static void main(String[] args) {
		JFrame f = new JFrame("Space Invaders");//java JFrame object

		Container cont = f.getContentPane();  // get container - top of the frame
		cont.setLayout(new BorderLayout());  // set Layout to Border 

		SpaceInvaders bp= new SpaceInvaders();  // create an object of our game panel
		cont.add(bp, BorderLayout.CENTER ); // add this game panel to the center of the frame

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // make frame closed when x button is pressed
		f.setVisible(true);// make the frame visible
		f.setResizable(false); // make the frame resizable
		f.setSize(1000, 800);  // set the size of the frame
	}
}