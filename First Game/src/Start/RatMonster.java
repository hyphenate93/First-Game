package Start;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RatMonster extends GameObject {

	public RatMonster(int x, int y, ID id) {
		super(x, y, health, id);
		velX = 0;
		velY = 0;
		health = 20;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 40, 40);
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

		g.setColor(Color.GRAY);
		g.fillRect(x, y, 40, 40);

	}

}