/**
 * Space invader movement and bullet movement
 * 
 * modified     20220619
 * date         20220606
 * @filename    SpaceInvadersAI.java
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

public class SpaceInvadersAI implements ActionListener {
	SpaceInvaders gui;
	public SpaceInvadersAI(SpaceInvaders in) {
		// TODO Auto-generated constructor stub
		gui = in;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void moveInvaders () {
		for (int i =0; i<gui.listInvaderX.size(); i++) {
			// Randomly generate the movment of the invaders 
			int randomX = (int)(Math.random()*2)+1;
			int randomY = (int)(Math.random()*10)+1;

			// Move a random number of times 
			int random = (int) (Math.random()*10)+1; 

			for (int j=0; j<random; j++) {
				// Move to the right randomly / check outside border 
				if (randomX == 1 && gui.listInvaderX.get(i) < 700) {
					gui.listInvaderX.set(i, gui.listInvaderX.get(i) + 3);  
				}
				// Move to the left randomly / check outside border 
				if (randomX == 2 && gui.listInvaderX.get(i) > 160) {
					gui.listInvaderX.set(i, gui.listInvaderX.get(i)- 3); 		
				}
				// Move up randomly / check outisde border 
				else if (randomY == 1 && gui.listInvaderY.get(i) > 120) {
					gui.listInvaderY.set(i, gui.listInvaderY.get(i) - 3); 

				}
				// move downwards randomly / check outside border 
				else if (randomY == 2 && gui.listInvaderY.get(i) < 450) {
					gui.listInvaderY.set(i, gui.listInvaderY.get(i) + 4); 
				}
			}
		}
	}
	
	// reset invader bullets when game is reseted.

	public void invaderBulletReset(ActionEvent e) {
		for(int i=0; i<gui.invaderBulletA[0].length; i++) {
			int answer = 0;
			if(answer == JOptionPane.YES_OPTION) {
				gui.invaderBulletA[0][i] = -10; 
				gui.invaderBulletA[1][i] = -10;
			}
		}
	}
	public void moveInvaderBullet () {
		for (int i=0; i<gui.invaderBulletA[0].length; i++) {
			if (gui.invaderBulletA[0][i] == -10) {
				// randomly select an invader to shoot from 
				int random = (int)(Math.random( )*(gui.listInvaderX.size()));
				gui.invaderBulletA[0][i] = gui.listInvaderX.get(random) + 25;
				gui.invaderBulletA[1][i] = gui.listInvaderY.get(random) + 10;
				break;						
			}
		}
		// Move the invader bullets 
		for (int i =0; i<gui.invaderBulletA[0].length; i++) {
			if (gui.invaderBulletA[0][i] != -10) {
				// randomly generate the spped of the bullet 
				gui.invaderBulletA[1][i] += (int)(Math.random()*4)+gui.bulletSpeedS;
			}
			// update screen if bullet leaves the border 
			if (gui.invaderBulletA[1][i]  > 700) {
				gui.invaderBulletA[0][i] = -10;
				gui.invaderBulletA[1][i] = -10;
			}
		}
	}
}