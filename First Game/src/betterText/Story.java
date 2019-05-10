package betterText;

public class Story {
	
	Game game;
	UI ui;
	VisibilityManager vManager;
	Player player = new Player();
	SuperMonster monster = new SuperMonster();
	
	int silverRing;

	public Story(Game game, UI ui, VisibilityManager vManager) {
		
		this.game = game;
		this.ui = ui;
		this.vManager = vManager;
		
	}
	
	public void defaultSetup() {
		
		player.hp = 10;
		ui.hpLabelNumber.setText("" + player.hp);
		
		player.currentWeapon = new Weapon_Knife();
		ui.weaponLabelName.setText(player.currentWeapon.name);
		
		silverRing = 0;
	}
	
	
	
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
		case "townGate": townGate(); break;
		case "talkGuard": talkGuard(); break;
		case "attackGuard": attackGuard(); break;
		case "crossRoad": crossRoad(); break;
		case "north": north(); break;
		case "east": east(); break;
		case "west": west(); break;
		case "fight": fight(); break;
		case "playerAttack": playerAttack(); break;
		case "monsterAttack": monsterAttack(); break;
		case "win": win(); break;
		case "lose": lose(); break;
		case "ending": ending(); break;
		case "toTitle": toTitle(); break;
		}
	}
	
	public void townGate() {
		ui.mainTextArea.setText("You are at the gate of the town.\n A guard is standing in front of you. \n\n What do you do?");
		ui.choice1.setText("Talk to the guard"); 
		ui.choice2.setText("Attack the guard");
		ui.choice3.setText("Leave");
		ui.choice4.setText("");
		
		game.nextPosition1 = "talkGuard";
		game.nextPosition2 = "attackGuard";
		game.nextPosition3 = "crossRoad";
		game.nextPosition4 = "";
	}
	
	public void talkGuard() {
		if(silverRing == 0) {
			ui.mainTextArea.setText("Guard: Hello Strander. I have never seen your face here before. \n I'm sorry but i cannot let a stranger enter our town.");
		} else {
			ending();
		}
		
		ui.choice1.setText(">"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "townGate";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void attackGuard() {
		ui.mainTextArea.setText("Guard: Hey dont't be stupid! \n\n The guard hit you so hard you give up. \n(You recive 3 damage)");
		player.hp -= 3;
		ui.hpLabelNumber.setText("" + player.hp);
		
		ui.choice1.setText(">"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if(player.hp > 0 ) {
			game.nextPosition1 = "townGate";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		} else if(player.hp < 1) {
			game.nextPosition1 = "lose";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
	}
	
	public void crossRoad() {
		ui.mainTextArea.setText("You are at a crossroad. \n If you go south, you will go back to town.");
		ui.choice1.setText("Go North"); 
		ui.choice2.setText("Go East");
		ui.choice3.setText("Go West");
		ui.choice4.setText("Go South");
		
		game.nextPosition1 = "north";
		game.nextPosition2 = "east";
		game.nextPosition3 = "west";
		game.nextPosition4 = "townGate";
	}
	
	public void north() {
		ui.mainTextArea.setText("You arrive at a river. \n You drink the water and rest at the riverside. \n\n (Your HP goes up by two)");
		player.hp += 2;
		ui.hpLabelNumber.setText("" + player.hp);
		
		ui.choice1.setText("Go South"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void east() {
		ui.mainTextArea.setText("You walked into a forest and for a Long Sword. \n\n (You obtained a Long Sword)");
		player.currentWeapon = new Weapon_LongSword();
		ui.weaponLabelName.setText(player.currentWeapon.name);
		
		ui.choice1.setText("Go West"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void west() {
		
		int i = new java.util.Random().nextInt(100) + 1;
		
		if(i < 90) {
			monster = new Monster_Goblin();
		} else {
			monster = new Monster_Gandalf();
		}
		
		ui.mainTextArea.setText("You encounter " + monster.name + "!");
		
		ui.choice1.setText("Figth"); 
		ui.choice2.setText("Run");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "crossRoad";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void fight() {
				
		ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n What do you do?");
		
		ui.choice1.setText("Attack"); 
		ui.choice2.setText("Run");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "playerAttack";
		game.nextPosition2 = "crossRoad";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void playerAttack() {
		int playerDamage =  new java.util.Random().nextInt(player.currentWeapon.damage);
		
		ui.mainTextArea.setText("You attacked " + monster.name + " and did " + playerDamage + " damage!");
		
		monster.hp -= playerDamage;
		
		ui.choice1.setText(">"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if(monster.hp > 0) {
			game.nextPosition1 = "monsterAttack";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		} else if (monster.hp < 1) {
			game.nextPosition1 = "win";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void monsterAttack() {
		
		int monsterDamage = new java.util.Random().nextInt(monster.attack);
		
		ui.mainTextArea.setText(monster.attackMessage + "\n You recived " + monsterDamage + " damage!");
		
		player.hp -= monsterDamage;
		ui.hpLabelNumber.setText("" + player.hp);
		
		ui.choice1.setText(">"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if(player.hp > 0 ) {
			game.nextPosition1 = "fight";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		} else if(player.hp < 1) {
			game.nextPosition1 = "lose";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void win() {
		
		ui.mainTextArea.setText("You've defeated the " + monster.name + " !\n The monster dropped a ring! \n\n (You obtained a Silver Ring)");
		
		silverRing = 1;
		
		ui.choice1.setText("Go East"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void lose() {
		
		ui.mainTextArea.setText("You are defeated! \n\n <GAME OVER>");

		
		ui.choice1.setText("Go back to title screen"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "toTitle";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void ending() {
		
		ui.mainTextArea.setText("Guard: Oh you killed the goblin? \n Thank you so much. You are a true hero! \n Welcome to our town! \n\n <THE END>");
		
		ui.choice1.setVisible(false);
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
	}
	
	public void toTitle() {
		defaultSetup();
		vManager.showTitleScreen();
	}
	
}
