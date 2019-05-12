package Start;

import java.awt.Color;

import java.awt.Graphics;

import textPart.CharGUI;
import textPart.Hero;

public class HUD {
	
	public static int HEALTH = Game.hero.getClassType().getHp();

	public void tick () {
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, HEALTH *2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, HEALTH *2, 32);
		
		g.drawString("Class " + Game.hero.getClassType().getClassName(), 15, 64);
	}
	
}
