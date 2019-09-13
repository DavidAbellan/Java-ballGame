/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

/**
 *
 * @author barry
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Game2 extends JPanel {

	Ball ball = new Ball(this);
        Raquet raquet = new Raquet(this);
        int speed = 1;
        
        private int getScore(){
         return speed - 1;    }
        
        public Game2(){
            addKeyListener(new KeyListener(){
                @Override
                 public void keyTyped(KeyEvent e){};
                @Override
                 public void keyReleased(KeyEvent e){
                  raquet.keyRelease(e);};
                @Override
                 public void keyPressed(KeyEvent e){
                  raquet.keyPressed(e);};
                 
            
            
            });
            setFocusable(true);
            
            
        
        }
        public void gameOver(){
            JOptionPane.showMessageDialog(this, "Your score was " + getScore(),"Game Over", JOptionPane.YES_NO_OPTION );
            System.exit(ABORT);
        
        }

	private void move() {
		ball.move();
                raquet.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
                raquet.paint(g2d);
                
                g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("ARIAL",Font.BOLD,30));
		g2d.drawString(String.valueOf(getScore()),10,30);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game2 game = new Game2();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}

        
