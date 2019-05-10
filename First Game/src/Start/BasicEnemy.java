package Start;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

	public BasicEnemy(int x, int y, int health, ID id) {
		super(x, y, health, id);
		velX = 0;
		velY = 0;
		this.health = health;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}
	


	public void tick() {
		
		x += velX;
		y += velY;

		if (y <= 0 || y >= Game.HEIGHT - 16) {
			velY *= -1;
		}
		if (x <= 0 || x >= Game.HEIGHT - 16) {
			velX *= -1;
		}
	}

	public void render(Graphics g) {
		if(BasicEnemy.getHealth() > 0) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
		}
		else {
			g.setColor(Color.black);
			g.fillRect(0, 0, 0, 0 );
			
		}
		
		
	}
	

}
