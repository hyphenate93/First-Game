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

	public Player(int x, int y, int z, ID id, Hero hero, Handler handler) {
		super(x, y, z, id);
		this.handler = handler;
		this.health = z;
		this.hero = hero;

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		collision();
	}

	private void collision() {
		String position = "";
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.BasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {

					// rpg.createGameScreen();

					new CombatClass();
					// turn off velocity when we enter battle
					handler.object.get(0).setVelX(0);
					handler.object.get(0).setVelY(0);
					while (position != "win" && position != "lose" && position != "run") {
						// loop while we are in battle
						position = CombatClass.getPosition();
						System.out.println();
					}
					// HUD.HEALTH --;

					if (position == "win") {
						// we won, remove the monster and set our health
						Player.setHealth(CombatClass.getHealth());
						handler.removeObject(tempObject);
					}
					else {
						// either lost or ran, set new hp values
						BasicEnemy.setHealth(CombatClass.getMonsterHealth());
						Player.setHealth(CombatClass.getHealth());
						// move player back to original location
						handler.object.get(0).setY(Game.WIDTH / 2 - 64);
						//WIDTH / 2 - 64, HEIGHT / 2 - 64
						handler.object.get(0).setX(Game.HEIGHT / 2 - 64);
						
					}

				}

			}
		}
	}

	public void render(Graphics g) {
		if (id == ID.Player) {

			if (hero.getClassType().getClassName() == "Warrior") {
				g.setColor(new Color(102, 51, 0));
				// Brown
			} else if (hero.getClassType().getClassName() == "Thief") {
				g.setColor(Color.YELLOW);
			} else if (hero.getClassType().getClassName() == "Lancer") {
				g.setColor(Color.GREEN);
			}
		}

		g.fillRect(x, y, 32, 32);
		// TODO Auto-generated method stub

	}

}
