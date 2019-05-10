package betterText;

import Start.Game;

public class Story {
	
	GameTest game;
	UI ui;
	VisibilityManager vManager;
	Player player = new Player();
	SuperMonster monster = new SuperMonster();
	
	Hero hero = null;
	ClassGreenRoom grnRoom = new ClassGreenRoom();
	Weapon weapon;
	

	public Story(GameTest game, UI ui, VisibilityManager vManager) {
		
		this.game = game;
		this.ui = ui;
		this.vManager = vManager;
		
	}
	
	public void defaultSetup() {
	
		ui.hpLabelNumber.setText("");
		
		ui.weaponLabelName.setText("");
	}
	
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
		case "charCreate": charCreate(); break;
		case "warrior": warrior(); break;
		case "thief": thief(); break;
		case "lancer": lancer(); break;
		case "w.i.p": wip(); break;
		case "storyStart": storyStart(); break;
		case "gameStart": gameStart(); break;

		}
	}
	
	public void charCreate() {
		ui.mainTextArea.setText("What class would you like to be?");
		ui.choice1.setText("Warrior"); 
		ui.choice2.setText("Thief");
		ui.choice3.setText("Lancer");
		ui.choice4.setText("W.I.P");
		
		game.nextPosition1 = "warrior";
		game.nextPosition2 = "thief";
		game.nextPosition3 = "lancer";
		game.nextPosition4 = "w.i.p";
	}
	
	public void warrior() {
		hero = new Hero("Andreas", grnRoom.getClass("Warrior"));
		ui.mainTextArea.setText("You are the great Hero " + hero.getName() + "! \nA " + hero.getClassType().getClassName()
				+ " of legend! \nYour health is " + hero.getClassType().getHp()
				+ " and with your current weapon you will be doing "
				+ (hero.getClassType().getAtkPwr() + hero.getClassType().getWpn().getDmg()) + " damage per hit!");
		
		player.hp = hero.getClassType().getHp();
		weapon = hero.getClassType().getWpn();
		
		ui.choice1.setText("Ok"); 
		ui.choice2.setText("No");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "storyStart";
		game.nextPosition2 = "charCreate";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void thief() {
		hero = new Hero("Niklas", grnRoom.getClass("Thief"));
		ui.mainTextArea.setText("You are the great Hero " + hero.getName() + "! \nA " + hero.getClassType().getClassName()
				+ " of legend! \nYour health is " + hero.getClassType().getHp()
				+ " and with your current weapon you will be doing "
				+ (hero.getClassType().getAtkPwr() + hero.getClassType().getWpn().getDmg()) + " damage per hit!");
		
		player.hp = hero.getClassType().getHp();
		weapon = hero.getClassType().getWpn();
		
		ui.choice1.setText("Ok"); 
		ui.choice2.setText("No");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "storyStart";
		game.nextPosition2 = "charCreate";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void lancer() {
		hero = new Hero("Oscar", grnRoom.getClass("Lancer"));
		ui.mainTextArea.setText("You are the great Hero " + hero.getName() + "! \nA " + hero.getClassType().getClassName()
				+ " of legend! \nYour health is " + hero.getClassType().getHp()
				+ " and with your current weapon you will be doing "
				+ (hero.getClassType().getAtkPwr() + hero.getClassType().getWpn().getDmg()) + " damage per hit!");
		
		player.hp = hero.getClassType().getHp();
		weapon = hero.getClassType().getWpn();
		
		ui.choice1.setText("Ok"); 
		ui.choice2.setText("No");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "storyStart";
		game.nextPosition2 = "charCreate";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void wip() {
		
		ui.mainTextArea.setText("Wokring on it, go back!");
		
		ui.choice1.setText("Ok, sorry"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "charCreate";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void storyStart() {
		ui.mainTextArea.setText("Your quest begins outside of town. \nThere is something going on. Investigate!");
		
		ui.nameLabelName.setText(hero.getName());
		ui.hpLabelNumber.setText("" + hero.getClassType().getHp());
		ui.weaponLabelName.setText(hero.getClassType().getWpn().getWpnName());
		 
		ui.choice1.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
		ui.choice2.setText("Lets go!");
		game.nextPosition2 = "gameStart";

	}
	
	public void gameStart() {
		//new Game();
	}
	
}
