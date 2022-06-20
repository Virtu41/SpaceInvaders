/**
 * Player movement and bullet movement
 * 
 * modified     20220619
 * date         20220606
 * @filename    SpaceInvadersPlayer.java
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

public class SpaceInvadersPlayer implements KeyListener {
	SpaceInvaders gui;
	public SpaceInvadersPlayer(SpaceInvaders in) {
		// TODO Auto-generated constructor stub
		gui = in;
	}
	public void shooting () {
		for (int i =0; i<gui.bulletA[0].length; i++) {
			if (gui.bulletA[0][i] == -10) {

				// Set the bullet location 
				gui.bulletA[0][i] = gui.xOfPlayer + 36;
				gui.bulletA[1][i] = gui.yOfPlayer - 20; 
				break;					
			}
		}		
	}
	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		// Check if game is running and see what button the user clicked 
		if (gui.running) {

			// if left arrow is clicked
			if(e.getKeyCode() == 65 && gui.xOfPlayer > 150) { 
				gui.xOfPlayer -=10; 
				gui.repaint(); 
			}

			// if right arrow is clicked
			else if(e.getKeyCode() == 68 && gui.xOfPlayer < 762) { 
				gui.xOfPlayer +=10; 
				gui.repaint(); 
			}
		}

	}
	// Move the player bullets 
	
	// Check if the shoot button is pressed 
	public void keyReleased(KeyEvent e) {
		if (gui.running) {
			if (e.getKeyCode() == 82) {
				shooting(); 
			}
		}

	}
	// Move the bullets of the user 
		public void moveBullets () {
			for (int i =0; i<gui.bulletA[0].length; i++) {
				if (gui.bulletA[0][i] != -10) {
					gui.bulletA[1][i] -= gui.bulletSpeedP;  
				}

				// update screen if bullet leaves the border 
				if (gui.bulletA[1][i] < 120) {
					gui.bulletA[0][i] = -10;
					gui.bulletA[1][i] = -10;
				}
			}
		}
}