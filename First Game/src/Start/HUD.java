package Start;

import java.awt.Color;

import java.awt.Graphics;

import textPart.CharGUI;
import textPart.Hero;

public class HUD {
	
	public static int HEALTH = Game.hero.getClassType().getHp();
	private int greenValue = 255;
	
	private static int score = 0;
	private int level = 1;

	public void tick () {
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		greenValue = HEALTH*2;
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15, 15, HEALTH *2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, HEALTH *2, 32);
		
		g.drawString("Class " + Game.hero.getClassType().getClassName(), 15, 64);
		
		g.drawString("Score: " + score, 15, 80);
		g.drawString("Level: " + level, 15, 96);
	}
	
	public static void setScore(int score) {
		HUD.score = score;
	}
	public static int getScore() {
		return score;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	public static void combatWin(int x) {
		setScore(getScore()+x);
	}
}
