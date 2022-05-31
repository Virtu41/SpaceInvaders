import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Anuja Perera
//ICS3U1 Final Project
public class FinalProjectPanelAnuja extends JPanel implements KeyListener, ActionListener, MouseListener  {
	//Variables 
	String txt="";
	int x=455, y=625;  //coordinates of player 
	int [] invaderX = {200, 200, 200, 200, 200, 400, 400, 400, 400, 400, 600, 600, 600, 600, 600 };
	int [] invaderY = {100, 200, 300, 400, 500, 100, 200, 300, 400, 500, 100, 200, 300, 400, 500 };
	int [] bulletX = {-10, -10, -10, -10, -10, };
	int [] bulletY = {-10, -10, -10, -10, -10, };
	int score = 0;  
	JButton b1, b2, b3 ;     //declare 3 buttons
	JLabel lblImg;
	boolean running = false; 
	ImageIcon playImg, rules, bg, spaceInvader, logo, player, start, bullet ;      //ImageIcon to store images
	Timer timer; 
	int timercounter = 0; 
	
	public FinalProjectPanelAnuja(){    // constructor
		this.setLayout(null); 
		// load images
		playImg = new ImageIcon("play_100_100.png");
		rules = new ImageIcon("Rules.png");
		bg = new ImageIcon("bg2.png");
		spaceInvader = new ImageIcon("SpaceInvader.png");
		timer = new Timer(30, this);
		
		logo =new ImageIcon("Logo.png");
		player = new ImageIcon("Gun.png");
		start = new ImageIcon("Start.png");
		bullet = new ImageIcon("Bullet.png"); 

		//set button 1 
		b1 = new JButton(start); 
		b1.setBounds(40, 500, 100, 100);
		this.add(b1);
		b1.addActionListener(this);
		b1.addKeyListener(this);
		
		//set button b2 
		b2= new JButton(rules);
		b2.setBounds(40, 250, 100, 100);
		this.add(b2);
		b2.addActionListener(this);
		b2.addKeyListener(this);

		//set button b3  
		b3= new JButton("Exit Button");
		b3.setBounds(40, 400, 100, 30);// x, y, width, height
		this.add(b3);
		b3.addActionListener(this);
		b3.addKeyListener(this);
		//set button lblAnimated
		lblImg=new JLabel(logo);  //img instead of text
		lblImg.setBounds(5, 5, 160, 120);// x, y, width, height
		this.add(lblImg);
		

		addKeyListener( this );  // add key listener to the panel
		addMouseListener( this );  // add mouse listener to the panel
		timer.start();
	}// end of constructor


	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bg.getImage(), 0, 0, 900, 800, null);  // paint background
		g.setFont(new Font("SansSerif", Font.BOLD, 28)); 	// set a new font
		Color purple = new Color(102, 0 , 153);
		g.setColor(purple);
		g.drawString("Welcome to Space Invaders",310,30);   // display the string starting at the coordinate (100, 200)
		g.drawString(txt,400,20);   // display the string starting at the coordinate (100, 200)
		for (int i =0; i<5; i++) {
			g.drawRect(150 + i, 120 + i, 700, 600); // X Y  width height  
		}
		g.drawImage(player.getImage(), x, y, 90, 70,null);//(img, x, y, width, height, observer)
		for (int i =0; i<invaderX.length; i++) {
			g.drawImage(spaceInvader.getImage(), invaderX[i], invaderY[i], 200, 150, null);
		}
		 
		g.setFont(new Font("SansSerif", Font.BOLD, 20));
		score++; 
		g.drawString("Score: " + score , 460, 100);
		g.drawString(txt, 100, 50);
		g.setColor(Color.red);
			for (int i =0; i<bulletX.length; i++) {
				if (bulletX[i] > -10) {
				g.drawImage (bullet.getImage(),bulletX[i], bulletY[i], 40, 40, null); 
				}
			}
		
		
	}//end of paint   

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			running = true; 
		}
		if (e.getSource()==b2)
			JOptionPane.showMessageDialog(null, "<html> <font size=5, face='Arial' color='red'> Rules/Controls: </font> <br> 1.Use the Left and Right Arrows for Movement <br> 2.Use the R key to shoot the invaders <br> 3.  <br> 4. <b><u> there </u></b> <br><br>here</html>", "Button action",JOptionPane.INFORMATION_MESSAGE ); 
		if (e.getSource()==b3){
			JOptionPane.showMessageDialog(null, "That was an exit button. \n Good Bye", "My exit message",JOptionPane.WARNING_MESSAGE ); 
			System.exit(0);
		}
		if (running) {
			if (e.getSource() == timer ) { 
				timercounter++; 
				timercounter = timercounter % 1000000; 
				if (timercounter % 4 == 0) {
					for (int i =0; i<invaderX.length; i++) {
					int random = (int)(Math.random()*2)+1;
					int random2 = (int) (Math.random()*10)+1; 
					for (int j=0; j<random2; j++) {
					if (random == 1 && invaderX[i] < 700) {
						invaderX[i] +=3; 
						
					}
					else if (random == 2 && invaderX[i] > 100) {
						invaderX[i] -=3; 
						
					} 
				
					}
				}
			}
			
				for (int i =0; i<bulletX.length; i++) {
				 if (bulletX[i] != -10) {
					bulletY[i] -= 10;  
				 }
					if (bulletY[i] < 120) {
						bulletX[i] = -10;
						bulletY[i] = -10;
					}
				} 
				repaint();
		}
	}
}
	
	
		
	public void shooting(ActionEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if (running) {
			if(e.getKeyCode() == 37 && x > 150) { // if left arrow is clicked
				x -=10; 
				repaint(); 
			}
			else if(e.getKeyCode() == 39 && x < 762) { // if right arrow is clicked
				x +=10; 
				repaint(); 
			}
			else if (e.getKeyCode() == 82) {
				for (int i =0; i<bulletX.length; i++) {
					if (bulletX[i] == -10) {
					bulletX[i] = x + 25;
					bulletY[i] = y; 
					break;					
					}
				}
			}
		}
		
	}

	public void keyReleased(KeyEvent e) {}

	public void mouseClicked(MouseEvent e) {}
	

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

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