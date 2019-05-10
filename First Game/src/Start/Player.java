package Start;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import textPart.CharGUI;
import textPart.Hero;
import textPart.RPGScreen;

public class Player extends GameObject {
	Random r = new Random();
	Handler handler;
	CharGUI rpg = new CharGUI();
	private Hero hero;
	
	
	
	public Player(int x, int y,int z, ID id,Hero hero, Handler handler) {
		super(x, y, z,id);
		this.handler = handler;
		this.health = z;
		this.hero = hero;
	
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}

	
	public void tick() {
		x+= velX;
		y+= velY;
		x = Game.clamp(x,0,Game.WIDTH -37);
		y = Game.clamp(y,0,Game.HEIGHT - 60);
		collision();
	}
	private void collision() {
		for (int i= 0; i <handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.BasicEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					
					rpg.createGameScreen();
					
					tempObject.setVelX(0);
					tempObject.setVelY(0);
					tempObject.setX(-6000);
					tempObject.setY(-6000);
					
					//HUD.HEALTH --;
					BasicEnemy.setHealth(0); 
					
				}
				
			}
		}
	}
	
	public void render(Graphics g) {
		if (id == ID.Player) g.setColor(Color.white);
		
		
		g.fillRect(x, y, 32, 32);
		// TODO Auto-generated method stub
		
	}
	

}
