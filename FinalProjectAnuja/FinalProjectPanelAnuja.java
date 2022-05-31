import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

//Anuja Perera
//ICS3U1 Final Project

public class FinalProjectPanelAnuja extends JPanel implements KeyListener, ActionListener, MouseListener  {
	//Variables and arrays  
	String txt="";
	int xOfPlayer=460, yOfPlayer=625;  //coordinates of player 
	
	ArrayList<Integer> listInvaderX = new ArrayList<Integer>();
	ArrayList<Integer> listInvaderY = new ArrayList<Integer>();
	
	// Bullets set to default values 
	int [] bulletX = {-10, -10, -10};
	int [] bulletY = {-10, -10, -10};
	int [] invaderBulletX = {-10, -10, -10, -10};
	int [] invaderBulletY = {-10, -10, -10, -10};
	// Initialize score and health 
	int score = 0; 
	int health = 2; 
	
	JButton b1, b2, b3, b4;     //declare 4 buttons and label 
	JLabel lblImg;
	
	boolean running = false; // Should the program be running 
	
	// initialize the Images 
	ImageIcon playImg, rules, bg, spaceInvader, logo, player, start, bullet, invaderBullet, howToPlay, gameover, book, amongUS, amongUS2, win, title ;      //ImageIcon to store images
	Rectangle invaderBulletBox, playerBox, playerBulletBox, spaceInvaderBox; 
	Timer timer; 
	int timercounter = 0; // declare and start the timer 
	
	
	
	public FinalProjectPanelAnuja(){    // constructor
		this.setLayout(null); 
		
		// Add calues to the arrays 
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
		
		// set images to ImageIcons 
		title = new ImageIcon ("Title.png"); 
		win = new ImageIcon ("Win.png");
		amongUS2 = new ImageIcon("AmongUs2.png");
		amongUS = new ImageIcon("AmongUs.png");
		book = new ImageIcon ("Book.png");
		playImg = new ImageIcon("play_100_100.png");
		rules = new ImageIcon("Rules.png");
		bg = new ImageIcon("bg2.png");
		spaceInvader = new ImageIcon("SpaceInvader.png");
		timer = new Timer(30, this);
		howToPlay = new ImageIcon ("HowToPlay.png"); 
		logo =new ImageIcon("Logo.png");
		player = new ImageIcon("Gun.png");
		start = new ImageIcon("Start.png");
		bullet = new ImageIcon("Bullet.png"); 
		invaderBullet = new ImageIcon("InvaderBullet.png");
		gameover = new ImageIcon ("GameOver.png"); 
		
		
		//set button 1 
		b1 = new JButton(start); 
		b1.setBounds(40, 420, 100, 100);
		this.add(b1);
		b1.addActionListener(this);
		b1.addKeyListener(this);
		
		//set button b2 
		b2= new JButton(book);
		b2.setBounds(40, 190, 100, 100);
		this.add(b2);
		b2.addActionListener(this);
		b2.addKeyListener(this);
		
		//set button b3  
		b3= new JButton("Exit");
		b3.setBounds(40, 340, 100, 30);// x, y, width, height
		this.add(b3);
		b3.addActionListener(this);
		b3.addKeyListener(this);
		
		//set button b4
		b4= new JButton(rules);
		b4.setBounds(40, 570, 100, 100);
		this.add(b4);
		b4.addActionListener(this);
		b4.addKeyListener(this);
		
		//set button Logo
		lblImg=new JLabel(logo);  //img instead of text
		lblImg.setBounds(5, 5, 160, 120);// x, y, width, height
		this.add(lblImg);
		

		addKeyListener( this );  // add key listener to the panel
		addMouseListener( this );  // add mouse listener to the panel
		
		timer.start(); // start the timer 
		
	}// end of constructor
	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(bg.getImage(), 0, 0, 900, 800, null);  // paint background
		
		// Create new colour puruple 
		Color purple = new Color(102, 0 , 153);
		g.setColor(purple);
		
		// Display String and Images on my Panel 
		g.drawString(txt,400,20);   
		g.drawImage(player.getImage(), xOfPlayer, yOfPlayer, 90, 70,null);
		g.setFont(new Font("SansSerif", Font.BOLD, 20));
		g.setColor(Color.red);
		g.drawString("Score: " + score , 460, 145);
		g.drawString(txt, 100, 50);
		
		// Set new colour yellow 
		Color yellow = new Color(255,255,0);
		g.setColor(yellow);
		
		//Draw labels and Images 
		g.drawString("RULES", 60, 555);
		g.drawString(txt, 100, 50);
		g.drawString("CONTROLS", 35, 175);
		g.drawImage(amongUS.getImage(), 725, 19, null);
		g.drawImage(amongUS2.getImage(), 190, 20, null);
		g.drawImage(title.getImage(), 380, 0, null);
		g.setColor(Color.red);
		
		// Draw the health bar 
		g.fillRect(xOfPlayer+30,yOfPlayer+80, 15*health, 10); // X Y  width height  
		
		g.setColor(purple);
		
		//Draw the border 
		for (int i =0; i<5; i++) {
			g.drawRect(150 + i, 120 + i, 700, 600); // X Y  width height  
		}
		
		//Draw all moving parts in a loop to display on the screen
		// Repaint the space invaders 
		for (int i =0; i<listInvaderX.size(); i++) {
			g.drawImage(spaceInvader.getImage(), listInvaderX.get(i), listInvaderY.get(i), 60, 64, null);
		}
		// Repaint the player bullets 
		for (int i =0; i<bulletX.length; i++) {
			if (bulletX[i] > -10) {
			g.drawImage (bullet.getImage(),bulletX[i], bulletY[i], 15, 45, null); 
			}
		}
		// repaint the invader bullets 
		for (int i =0; i<invaderBulletX.length; i++) {
			g.drawImage(invaderBullet.getImage(), invaderBulletX[i],invaderBulletY[i], 16, 36, null); 
		}
		
		
		// Debugging Rectanges 
		
		/*
		for (int i =0; i<invaderBulletX.length; i++) {
			g.drawRect(invaderBulletX[i]+2,invaderBulletY[i], 10, 36); 
		}
		for (int i =0; i<listInvaderX.size(); i++) {
			g.drawRect(listInvaderX.get(i)+5,listInvaderY.get(i)+5, 47, 50); 
		}
		for (int i =0; i<bulletX.length; i++) {
			g.drawRect(bulletX[i]+3,bulletY[i], 8,40); 
		}
		g.drawRect(xOfPlayer+25,yOfPlayer, 40,67); 
		*/ 
			
		
		
	}//end of paint   

	public void actionPerformed(ActionEvent e) {
		// Start running the program if start button is pressed 
		if(e.getSource()==b1) {
			running = true; 
		}
		
		// Check press and display Joptionpane for each button 
		// Display how to play 
		if (e.getSource()==b2) {
			JOptionPane.showMessageDialog(null, "", "How to Play", JOptionPane.NO_OPTION, howToPlay);	
		}
		
		// Display exit message 
		if (e.getSource()==b3){
			JOptionPane.showMessageDialog(null, "Good Bye", "See You Next Time",JOptionPane.WARNING_MESSAGE ); 
			System.exit(0);
		}
		
		// Rules button 
		if (e.getSource()==b4) {
			JOptionPane.showMessageDialog(null, "<html> <font size=5, face='Arial' color='red'> Rules/Controls: </font> <br> 1. Use the A and D keys for Movement <br> 2. Use the R key to shoot the invaders(You have to let go of the key) <br> <u> you only have 3 bullets </u> <br> 3. Avoid getting shot by the invaders  <br> 4. You can not move and shoot at the same time <b></b> <br>5. You can hit the invaders bullets with your bullets <br> 6. You have a health bar and can Take up to 3 hits <br> 7. The speed of the invaders bullets can vary </html>", "Rules",JOptionPane.INFORMATION_MESSAGE ); 
		}
		
		
		if (running) {
			// update screen on the timer 
			if (e.getSource() == timer ) { 
				// Seperate counter created for moving the invaders 
				timercounter++; 
				timercounter = timercounter % 1000000; 
				
			if (timercounter % 4 == 0) {
				moveInvaders(); 
			}
				// Methods to do everything while running 
				moveBullets(); 
				moveInvaderBullet(); 
				repaint(); 
				bulletcheck(); 
				checkWin(); 
				
			}
		}
	}
	
	//Check to see if the user won 
	public void checkWin () {
		if (score == 12) {
			JOptionPane.showMessageDialog(null, "", "You Won", JOptionPane.NO_OPTION, win);	
			System.exit(0);
		}
	}
	
	// Move the invaders 
	public void moveInvaders () {
	for (int i =0; i<listInvaderX.size(); i++) {
			// Randomly generate the movment of the invaders 
			int randomX = (int)(Math.random()*2)+1;
			int randomY = (int)(Math.random()*10)+1;
			
			// Move a random number of times 
			int random = (int) (Math.random()*10)+1; 
			
			for (int j=0; j<random; j++) {
				// Move to the right randomly / check outside border 
				if (randomX == 1 && listInvaderX.get(i) < 700) {
					listInvaderX.set(i, listInvaderX.get(i) + 3);  
				}
				// Move to the left randomly / check outside border 
				if (randomX == 2 && listInvaderX.get(i) > 160) {
					listInvaderX.set(i, listInvaderX.get(i)- 3); 		
				}
				// Move up randomly / check outisde border 
				else if (randomY == 1 && listInvaderY.get(i) > 120) {
					listInvaderY.set(i, listInvaderY.get(i) - 3); 
						
				}
				// move downwards randomly / check outside border 
				else if (randomY == 2 && listInvaderY.get(i) < 500) {
					listInvaderY.set(i, listInvaderY.get(i) + 4); 
						
				}
			}
		}
	}
	// Move the bullets of the user 
	public void moveBullets () {
		for (int i =0; i<bulletX.length; i++) {
			if (bulletX[i] != -10) {
				bulletY[i] -= 10;  
			}
			
			// update screen if bullet leaves the border 
			if (bulletY[i] < 120) {
				bulletX[i] = -10;
				bulletY[i] = -10;
			}
		}
		
	}
	// Move the invader bullets 
	public void moveInvaderBullet () {
		for (int i=0; i<invaderBulletX.length; i++) {
			if (invaderBulletX[i] == -10) {
				// randomly select an invader to shoot from 
				int random = (int)(Math.random( )*(listInvaderX.size()));
				invaderBulletX[i] = listInvaderX.get(random) + 25;
				invaderBulletY[i] = listInvaderY.get(random) + 10;
				break;						
			}
		}
		// Move the invader bullets 
		for (int i =0; i<invaderBulletX.length; i++) {
			if (invaderBulletX[i] != -10) {
				// randomly generate the spped of the bullet 
				invaderBulletY[i] += (int)(Math.random()*4)+2;
			}
			// update screen if bullet leaves the border 
			if (invaderBulletY[i] > 700) {
				invaderBulletX[i] = -10;
				invaderBulletY[i] = -10;
			}
					
		}
	}
	// Check for collisions 
	public void bulletcheck() {
		// Check if invader bullet colides with player 
		for (int i=0; i<invaderBulletX.length; i++) {
			
			invaderBulletBox = new Rectangle(invaderBulletX[i],invaderBulletY[i], 16,36);
			playerBox=new Rectangle(xOfPlayer+25,yOfPlayer, 40,67);
			
			if (invaderBulletBox.intersects(playerBox)) {
				// Remove the invader bullet and subtract from the health 
				invaderBulletX[i] = -10; 
				invaderBulletY[i] = -10;
				// If the player dies update the screen 
				if (health == 0) {
					JOptionPane.showMessageDialog(null, "", "GameOver", JOptionPane.NO_OPTION, gameover);
					System.exit(0);
				}
				// update the health 
				health--;
				break; 
			}
		}
		
		// check if player bullet collides with invader 
		for (int i=0; i<bulletX.length; i++) {
			
			playerBulletBox = new Rectangle (bulletX[i],bulletY[i], 8,35);
			
				for (int j=0; j<listInvaderX.size(); j++) {
					
					spaceInvaderBox = new Rectangle (listInvaderX.get(j)+5,listInvaderY.get(j)+5, 47, 50);
					
					if (playerBulletBox.intersects(spaceInvaderBox)) {
						// Update the score and remove the invader from array 
						score++;  
						listInvaderX.remove(j);
						listInvaderY.remove(j);
						
						// remove the user bullets 
						bulletX [i] = -10;
						bulletY [i] = -10; 
						
						// move j backwards as array is shifted 
						if (j != 0) {
							j--; 
						}
					}
				}
		}
		// check if player bullet collides with invader bullet 
		for (int i=0; i<invaderBulletX.length; i++) {
			
			// draw box around invader 
			invaderBulletBox = new Rectangle(invaderBulletX[i],invaderBulletY[i], 16,36);
			
			for (int j =0; j<bulletX.length; j++)  {
				
				// draw box around playerbox 
				playerBulletBox = new Rectangle (bulletX[j],bulletY[j], 8,35); 
				
				if (playerBulletBox.intersects(invaderBulletBox)) {
					// Reset values of both bullets 
					invaderBulletX[i] = -10; 
					invaderBulletY[i] = -10;
					bulletX [j]  = -10; 
					bulletY [j]  = -10; 
					
				}
			}
		}
	}
	
	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		// Check if game is running and see what button the user clicked 
		if (running) {
			
			// if left arrow is clicked
			if(e.getKeyCode() == 65 && xOfPlayer > 150) { 
				xOfPlayer -=10; 
				repaint(); 
			}
			
			// if right arrow is clicked
			else if(e.getKeyCode() == 68 && xOfPlayer < 762) { 
				xOfPlayer +=10; 
				repaint(); 
			}
		}
		
	}
	// Move the player bullets 
	public void shooting () {
		for (int i =0; i<bulletX.length; i++) {
			if (bulletX[i] == -10) {
				
				// Set the bullet location 
				bulletX[i] = xOfPlayer + 36;
				bulletY[i] = yOfPlayer - 20; 
				break;					
			}
		}		
	}
	
	// Check if the shoot button is pressed 
	public void keyReleased(KeyEvent e) {
		if (running) {
			if (e.getKeyCode() == 82) {
				shooting(); 
			}
			
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	
	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
	
	// set up the window and the main class 
	public static void main(String[] args) {
		JFrame f = new JFrame("Final Project Anuja");//java JFrame object

		Container cont = f.getContentPane();  // get container - top of the frame
		cont.setLayout(new BorderLayout());  // set Layout to Border 

		FinalProjectPanelAnuja bp= new FinalProjectPanelAnuja();  // create an object of our game panel
		cont.add(bp, BorderLayout.CENTER ); // add this game panel to the center of the frame

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // make frame closed when x button is pressed
		f.setVisible(true);     // make the frame visible
		f.setSize(900, 800);  // set the size of the frame

	}//end of main
}//end of class