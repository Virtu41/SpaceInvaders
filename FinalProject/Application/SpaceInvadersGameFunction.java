/**
 * functions of the game
 * 
 * modified     20220619
 * date         20220606
 * @filename    SpaceInvadersGameFunction.java
 * @author      Oscar Lam
 * @author      Asher Zaidi 
 * @author      Anuja Perera
 * @version     1.0
 * @see         ICS4U Content Unit 4 
 *
 */

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class SpaceInvadersGameFunction implements ActionListener{
	SpaceInvaders gui;
	ArrayList<all> scoreBoard = new ArrayList<all>();
	Integer [] storedScore;
	String [] storedName;

	public SpaceInvadersGameFunction(SpaceInvaders in) {
		gui = in;
	}

	public void actionPerformed(ActionEvent e) {
		all c;
		if(e.getSource()==gui.b1) { // score board
			gui.running = false;
			UIManager.put("OptionPane.background", new Color(186, 85, 211));
			UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(186, 85, 211));
			String board = "";
			for(int i = 0; i< scoreBoard.size();i++) {
				board+= "Name: "+scoreBoard.get(i).name+", score: "+scoreBoard.get(i).scores+"\n";
			}
			JOptionPane.showMessageDialog(null, board, "ScoreBoard", JOptionPane.NO_OPTION, gui.scoreIcon);
			if(gui.timeCounter < 2000) {
				gui.running = true;
			}
		} 

		// Check press and display Joptionpane for each button 
		// Display how to play 
		if (e.getSource()==gui.b2) { // play
			UIManager.put("OptionPane.background", new Color(186, 85, 211));
			UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(186, 85, 211));
		}

		// Display  message 
		if (e.getSource()==gui.b3){ // how to play
			gui.running = false;
			UIManager.put("OptionPane.background", new Color(186, 85, 211));
			UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(186, 85, 211));
			JOptionPane.showMessageDialog(null, "", "How to Play", JOptionPane.NO_OPTION, gui.howToPlay);

			if(gui.timeCounter < 2000) {
				gui.running = true;
			}
		}

		// Rules button 
		if (e.getSource()==gui.b4) {

			gui.running = false;

			gui.newRules = new ImageIcon("Images//rule.png");

			UIManager.put("OptionPane.background", new Color(186, 85, 211));
			UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(186, 85, 211));

			JOptionPane.showMessageDialog(null, "", "Instructions", JOptionPane.NO_OPTION, gui.newRules);

			if(gui.timeCounter < 2000) {
				gui.running = true;
			}
		}

		if (e.getSource()==gui.b5){ // exit
			UIManager.put("OptionPane.background", new Color(186, 85, 211));
			UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(186, 85, 211));
			System.exit(0);
		}

		if (gui.running) {
			if (e.getSource() == gui.timer ) { 
				// Seperate counter created for moving the invaders 
				gui.timeCounter--; 
				gui.timeCounter = gui.timeCounter % 1000000; 

				if(gui.timeCounter % gui.powerUpCooldown == 0 && gui.timeCounter != 0) {
					// random spawn position of covid power-up
					int xCovid = (int)(Math.random()*300+1)+300;
					int yCovid = (int)(Math.random()*200+1)+200;
					gui.covidX.add(xCovid);
					gui.covidY.add(yCovid);
					gui.covid = true;
				}
				if(gui.tempCounter - gui.timeCounter == 150) {
					gui.bulletSpeedP = 10;
				}

				if (gui.timeCounter % 4 == 0) {
					gui.invader.moveInvaders(); 
				}
				// Methods to do everything while running 
				gui.playerF.moveBullets(); 
				gui.invader.moveInvaderBullet(); 
				bulletcheck();
				gui.repaint(); 
				try {
					checkWin();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}

			if(gui.timeCounter == 0 || gui.health == 0) {
				gui.name = JOptionPane.showInputDialog("What is your name?: ");
				c = new all(gui.name, gui.score);
				scoreBoard.add(c);
				sort();
				gui.running = false;
				UIManager.put("OptionPane.background", new Color(186, 85, 211));
				UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(186, 85, 211));
				int answer;
				answer = JOptionPane.showConfirmDialog(null, "Your final score is: "+ gui.score+ ". Wanna Try Again?", "Play Again?", JOptionPane.YES_NO_OPTION);

				if(answer == JOptionPane.YES_OPTION) {
					gui.running = true;
					//resets game, but the bullets in the previous game moves on the screen.

					gui.setLayout(null); 
					gui.timeCounter = 2000;
					gui.tempCounter = 0;
					gui.xOfPlayer = 460;
					gui.yOfPlayer = 625;
					gui.bulletSpeedP = 10;
					gui.health = 3;
					gui.score = 0;
					gui.bulletSpeedS = 5;
					gui.listInvaderX = new ArrayList<Integer>();
					gui.listInvaderY = new ArrayList<Integer>();
					for(int i = 0; i<gui.bulletA[0].length;i++) {
						gui.bulletA[0][i]= -10;
						gui.bulletA[1][i]= -10;
					}

					for(int i = 0; i<gui.invaderBulletA[0].length;i++) {
						gui.invaderBulletA[0][i]= -10;
						gui.invaderBulletA[1][i]= -10;
					}

					gui.listInvaderX.add(250); 
					gui.listInvaderX.add(250); 
					gui.listInvaderX.add(250); 
					gui.listInvaderX.add(250); 
					gui.listInvaderX.add(475); 
					gui.listInvaderX.add(475); 
					gui.listInvaderX.add(475); 
					gui.listInvaderX.add(475);
					gui.listInvaderX.add(700);
					gui.listInvaderX.add(700);
					gui.listInvaderX.add(700);
					gui.listInvaderX.add(700);

					gui.listInvaderY.add(150);
					gui.listInvaderY.add(250);
					gui.listInvaderY.add(350);
					gui.listInvaderY.add(450);
					gui.listInvaderY.add(150);
					gui.listInvaderY.add(250);
					gui.listInvaderY.add(350);
					gui.listInvaderY.add(450);
					gui.listInvaderY.add(150);
					gui.listInvaderY.add(250);
					gui.listInvaderY.add(350);
					gui.listInvaderY.add(450);

					gui.invader.invaderBulletReset(e);
					if(gui.covidX.size()==1) {
						gui.covidX.remove(0);
						gui.covidY.remove(0);
					}
					gui.covid = false;

				} else if(answer == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
			} 
		}
		if(e.getSource() == gui.b2 && gui.running == true) {
			gui.running = false;
		} else if(e.getSource() == gui.b2 && gui.running == false) {
			gui.running = true;
		}

		// if game is not running, stop timer.
		if(!gui.running) {
			if(e.getSource() == gui.timer) {
				gui.timeCounter = (gui.timeCounter + 0) % 1000000;
			}
		}
	}


	public void checkWin() throws UnsupportedAudioFileException, IOException, LineUnavailableException { // https://www.youtube.com/watch?v=SyZQVJiARTQ&t=249s
		File file = new File("Images//stayinyourlane.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		if(gui.score % 120 == 0 && gui.listInvaderX.size() == 0) {
			clip.start();
			gui.timeCounter+=500;
			gui.tempCounter=0;
			gui.bulletSpeedS++;
			gui.bulletSpeedP = 10;
			gui.listInvaderX.add(250); 
			gui.listInvaderX.add(250); 
			gui.listInvaderX.add(250); 
			gui.listInvaderX.add(250); 
			gui.listInvaderX.add(475); 
			gui.listInvaderX.add(475); 
			gui.listInvaderX.add(475); 
			gui.listInvaderX.add(475);
			gui.listInvaderX.add(700);
			gui.listInvaderX.add(700);
			gui.listInvaderX.add(700);
			gui.listInvaderX.add(700);

			gui.listInvaderY.add(150);
			gui.listInvaderY.add(250);
			gui.listInvaderY.add(350);
			gui.listInvaderY.add(450);
			gui.listInvaderY.add(150);
			gui.listInvaderY.add(250);
			gui.listInvaderY.add(350);
			gui.listInvaderY.add(450);
			gui.listInvaderY.add(150);
			gui.listInvaderY.add(250);
			gui.listInvaderY.add(350);
			gui.listInvaderY.add(450);		
		}
	}

	public void bulletcheck() {
		// Check if invader bullet colides with player 
		for (int i=0; i<gui.invaderBulletA[0].length; i++) {

			gui.invaderBulletBox = new Rectangle(gui.invaderBulletA[0][i],gui.invaderBulletA[1][i], 16,36);
			gui.playerBox=new Rectangle(gui.xOfPlayer+25,gui.yOfPlayer, 40,67);
			if (gui.invaderBulletBox.intersects(gui.playerBox)) {
				// Remove the invader bullet 
				gui.invaderBulletA[0][i] = -10; 
				gui.invaderBulletA[1][i] = -10;
				gui.health--;
				break; 
			}
		}

		// check if player bullet collides with invader 
		for (int i=0; i<gui.bulletA[0].length; i++) {

			gui.playerBulletBox = new Rectangle (gui.bulletA[0][i],gui.bulletA[1][i], 8,35);

			for (int j=0; j<gui.listInvaderX.size(); j++) {

				gui.spaceInvaderBox = new Rectangle (gui.listInvaderX.get(j)+5,gui.listInvaderY.get(j)+5, 47, 50);
				if (gui.playerBulletBox.intersects(gui.spaceInvaderBox)) {
					// Update the score and remove the invader from array 
					gui.score+=10;  
					gui.listInvaderX.remove(j);
					gui.listInvaderY.remove(j);

					// remove the user bullets 
					gui.bulletA[0][i] = -10;
					gui.bulletA[1][i] = -10; 

					// move j backwards as array is shifted 
					if (j != 0) {
						j--; 
					}
				}
			}
			if(gui.covid) {
				gui.covidBox = new Rectangle(gui.covidX.get(0), gui.covidY.get(0),75,75);
				if(gui.playerBulletBox.intersects(gui.covidBox)) {
					gui.covidX.remove(0);
					gui.covidY.remove(0);
					gui.covid = false;
					int chance = (int)(Math.random()*2)+1;
					if(chance == 1) {
						gui.tempCounter = gui.timeCounter;
						gui.bulletSpeedP = 20;
					}
					else if(chance == 2) {
						gui.health++;
					}
					gui.repaint(); 
				}
			}
		}
		// check if player bullet collides with invader bullet 
		for (int i=0; i<gui.invaderBulletA[0].length; i++) {

			// draw box around invader 
			gui.invaderBulletBox = new Rectangle(gui.invaderBulletA[0][i],gui.invaderBulletA[1][i], 16,36);

			for (int j =0; j<gui.bulletA[0].length; j++)  {

				// draw box around playerbox 
				gui.playerBulletBox = new Rectangle (gui.bulletA[0][j],gui.bulletA[1][j], 8,35); 

				if (gui.playerBulletBox.intersects(gui.invaderBulletBox)) {
					// Reset values of both bullets 
					gui.invaderBulletA[0][i] = -10; 
					gui.invaderBulletA[1][i] = -10;
					gui.bulletA[0][j]  = -10; 
					gui.bulletA[1][j]  = -10; 
				}
			}
		}
	}
	public void sort() {
		all c;
		storedScore = new Integer[scoreBoard.size()];
		storedName = new String[scoreBoard.size()];
		Integer [] rev = new Integer[scoreBoard.size()];


		//selection sort

		for(int i = 0; i<scoreBoard.size(); i++) {
			storedScore[i] = scoreBoard.get(i).scores;
		}
		for(int i = 0; i<scoreBoard.size(); i++) {
			storedName[i] = scoreBoard.get(i).name;
		}
		for (int i = 0; i < scoreBoard.size() - 1; i++)  
		{  
			int index = i;  
			for (int j = i + 1; j < scoreBoard.size(); j++){  
				if (storedScore[j] < storedScore[index]){  
					index = j;
				}
			}  
			int smallerNumber = storedScore[index];   
			String smallerString = storedName[index];
			storedScore[index] = storedScore[i];  
			storedName[index] = storedName[i];
			storedScore[i] = smallerNumber; 
			storedName[i] = smallerString;
		}
		rev = storedScore;
		for(int i = 0; i < scoreBoard.size()/ 2; i++)
		{
			int temp = storedScore[i];
			String temps = storedName[i];
			storedName[i] = storedName[storedName.length - i - 1];
			storedScore[i] = storedScore[storedScore.length - i - 1];
			storedScore[storedScore.length - i - 1] = temp;
			storedName[storedName.length - i - 1] = temps;
		}
		for(int i = 0; i< scoreBoard.size(); i++) {
			c  = new all(storedName[i], storedScore[i]);
			scoreBoard.set(i,c);
		}

	}
	public void list() {

		for(int i = 0; i<scoreBoard.size();i++) {

		}
	}

	class all{
		String name;
		int scores; 
		all(String _name, int _scores){
			name = _name;
			scores = _scores;
		}
	}
}