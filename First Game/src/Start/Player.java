package Start;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import betterText.ClassGreenRoom;
import betterText.CombatClass;
import textPart.CharGUI;
import betterText.Hero;
import textPart.RPGScreen;

public class Player extends GameObject {
	Random r = new Random();
	Handler handler;
//	CharGUI rpg = new CharGUI();
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
		String position = "";
		for (int i= 0; i <handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.BasicEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					
				//	rpg.createGameScreen();
					
					new CombatClass();
					while(position != "win" && position != "lose") {
						// loop while we are in battle
						position = CombatClass.getPosition();
						System.out.println(position);
					}
					//HUD.HEALTH --;
					
					if(CombatClass.getPosition() == "win") {
						handler.removeObject(tempObject);
					}
					else {
						BasicEnemy.setHealth(CombatClass.getHealth());
					}
					
				}
				
			}
		}
	}
	
	public void render(Graphics g) {
		if (id == ID.Player) {
			
			if(hero.getClassType().getClassName() == "Warrior") {
				g.setColor(new Color(102, 51, 0));
				// Brown
			}else if(hero.getClassType().getClassName() == "Thief") {
				g.setColor(Color.YELLOW);
			}else if(hero.getClassType().getClassName() == "Lancer") {
				g.setColor(Color.GREEN);
			}
		}
		
		
		g.fillRect(x, y, 32, 32);
		// TODO Auto-generated method stub
		
	}
	

}
