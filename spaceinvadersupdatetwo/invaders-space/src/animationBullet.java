import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class animationBullet extends JPanel {
	
	private int x, y;
	private int velocityX, velocityY;
	private Timer t;
	
	public animationBullet() {
		x = 0;
		y = 100;
		velocityY = 2;
		t = new Timer(50, new MoveListener());
		
		t.start();
	}
	
private class MoveListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(y >= 0 && y <= 270) {
				y = y + velocityY;
			} else {
				velocityY = -velocityY;
				y = y + velocityY;
			}
			
			repaint();
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double c = new Ellipse2D.Double(x,y,30,30);
		
		g2.setColor(Color.RED);
		g2.fill(c);
	}
	
	
}