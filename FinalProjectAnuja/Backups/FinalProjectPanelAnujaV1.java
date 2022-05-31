import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Anuja Perera
//ICS3U1 Final Project
public class FinalProjectPanelAnuja extends JPanel implements KeyListener, ActionListener, MouseListener  {
	String txt="";
	int x=385, y=0;          //coordinates
	int dx=0,dy=0; 	//changes in x(x component of speed) and y(y component of speed)
	int [] InvaderX = {375, 250};
	int [] InvaderY = {100, 300};
	JButton b1, b2, b3 ;     //declare 3 buttons
	JTextField txtField;
	JLabel plainLbl, lblImg, lblAnimated;
	boolean running = false; 
	ImageIcon playImg, Rules, bg, SpaceInvader, logo, player, start  ;      //ImageIcon to store images
	Timer timer; 

	public static void main(String[] args) {
	}
	public FinalProjectPanelAnuja(){    // constructor
		this.setLayout(null); 
		// load images
		playImg = new ImageIcon("play_100_100.png");
		Rules = new ImageIcon("Rules.png");
		bg = new ImageIcon("bg2.png");
		SpaceInvader = new ImageIcon("SpaceInvader.png");
		timer = new Timer(100, this);
		
		logo =new ImageIcon("Logo.png");
		player = new ImageIcon("Gun.png");
		start = new ImageIcon("Start.png");
		// set txtField
		/*
		txtField=new JTextField();
		txtField.setBounds(320, 275, 120, 20);// x, y, width, height
		this.add(txtField);
		*/ 
		//set plainLbl
		/*
		plainLbl=new JLabel("Enter your first name");
		plainLbl.setBounds(320, 250, 150, 20);// x, y, width, height
		this.add(plainLbl);
		*/ 
		//set button b1  

		//set button 1 
		b1 = new JButton(start); 
		b1.setBounds(40, 500, 100, 100);
		this.add(b1);
		b1.addActionListener(this);
		b1.addKeyListener(this);
		
		//set button b2 
		b2= new JButton(Rules);
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
		//set button lblImg
		/*
		lblImg=new JLabel(SpaceInvader);  //img instead of text
		lblImg.setBounds(InvaderX, InvaderY, 100, 100);// x, y, width, height
		this.add(lblImg);
		*/ 
		//set button lblAnimated
		lblImg=new JLabel(logo);  //img instead of text
		lblImg.setBounds(650, 30, 200, 143);// x, y, width, height
		this.add(lblImg);

		addKeyListener( this );  // add key listener to the panel
		addMouseListener( this );  // add mouse listener to the panel
		timer.start();
	}// end of constructor


	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bg.getImage(), 0, 0, 900, 800, null);  // paint background
		g.setFont(new Font("SansSerif", Font.BOLD, 28));  // set a new font
		g.setColor(Color.red);
		g.drawString("Welcome to Space Invaders",250,30);   // display the string starting at the coordinate (100, 200)
		g.drawString(txt,400,20);   // display the string starting at the coordinate (100, 200)
		g.drawImage(player.getImage(), x, 625, 90, 70,null);//(img, x, y, width, height, observer)
		g.drawImage(SpaceInvader.getImage(), InvaderX, InvaderY, 120, 100, null);

	}//end of paint   

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			running = true; 
		}
		
		if (e.getSource()==b2)
			JOptionPane.showMessageDialog(null, "Rules: The rules will be written here  ", "Button action",JOptionPane.INFORMATION_MESSAGE ); 
		if (e.getSource()==b3){
			JOptionPane.showMessageDialog(null, "That was an exit button. \n Good Bye", "My exit message",JOptionPane.WARNING_MESSAGE ); 
			System.exit(0);
		}
		if (running) {
			if (e.getSource() == timer ) {
			int random = (int)(Math.random()*2)+1;
			if (random == 1 && InvaderX < 775) {
				InvaderX +=20; 
			}
			else if (random == 2 && InvaderX > 10) {
				InvaderX -=20; 
			} 
			repaint(); 
			}
			}
		}
	
		
	

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if (running) {
			if(e.getKeyCode() == 37 && x > 140) { // if left is clicked
				x -=10; 
				repaint(); 
			}
			else if(e.getKeyCode() == 39 && x < 790) { // if right is clicked
				x +=10; 
				repaint(); 
			}
		}
		/*
		txt="Key " + e.getKeyText( e.getKeyCode())+" is pressed"+e.getKeyCode();
		repaint();
		if(e.getKeyCode()==65)// 65 is the code for key "A"
			txtField.setText("A is pressed");
		else
			txtField.setText("");
		*/ 
	}

	public void keyReleased(KeyEvent e) {}

	public void mouseClicked(MouseEvent e) {

	}

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