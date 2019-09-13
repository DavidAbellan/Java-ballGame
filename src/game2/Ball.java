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

    
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
        private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game2 game;

	public Ball(Game2 game) {
		this.game= game;
	}

	void move() {
            boolean changeDirection = true;
		if (x + xa < 0)
			xa = game.speed;
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.speed;
		if (y + ya < 0)
			ya = game.speed;
		if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
                if(collision()){
                    ya= -game.speed;
                    y = game.raquet.getTopY()- DIAMETER;
                    game.speed++;
                    
                } else { 
                    changeDirection = false;
                }
               
                    
                
		x = x + xa;
		y = y + ya;
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
        private boolean collision(){
            return game.raquet.getBounds().intersects(getBounds());
            
         }
        public Rectangle getBounds(){
            return new Rectangle(x,y,DIAMETER,DIAMETER);
         }
}
