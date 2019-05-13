package betterText;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CombatClass {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, inventoryPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, nameLabelName, nameLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 55);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
	JButton startButton, choice1, choice2, choice3, inventoryButton, inventoryButton1, inventoryButton2,
			inventoryButton3, inventoryButton4, inventoryButton5, inventoryButton6, inventoryButton7, inventoryButton8, inventoryButton9;
	JTextArea mainTextArea;

	static int playerHP, monsterHP;

	Random random;
	static String position, inventoryStatus;
	Weapon weapon;

	ChoiceHandler choiceHandler = new ChoiceHandler();
	InventoryHandler iHandler = new InventoryHandler();

	ClassGreenRoom grnRoom = new ClassGreenRoom();
	Hero hero;

	static Monster monster;
	MonsterCage monsterCage = new MonsterCage();

	public CombatClass() {

		window = new JFrame();
		window.setSize(640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setLayout(null);
		con = window.getContentPane();

		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(15, 230, 600, 150);
		inventoryPanel.setBackground(Color.blue);
		inventoryPanel.setForeground(Color.white);
		inventoryPanel.setLayout(new GridLayout(3, 6));
		con.add(inventoryPanel);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(10, 10, 450, 300);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);

		mainTextArea = new JTextArea("This is the main text area. This game is going to be great im sure of it!!!");
		mainTextArea.setBounds(10, 10, 440, 300);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);

		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(15, 380, 600, 50);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(1, 4));
		con.add(choiceButtonPanel);

		choice1 = new JButton("One");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);

		choice2 = new JButton("Two");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);

		choice3 = new JButton("Tree");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);

		inventoryButton = new JButton("Inventory");
		inventoryButton.setBackground(Color.black);
		inventoryButton.setForeground(Color.white);
		inventoryButton.setFont(normalFont);
		inventoryButton.setFocusPainted(false);
		inventoryButton.addActionListener(iHandler);
		inventoryButton.setActionCommand("inventoryButton");
		choiceButtonPanel.add(inventoryButton);

		inventoryButton1 = new JButton();
		inventoryButton1.setBackground(Color.black);
		inventoryButton1.setForeground(Color.white);
		inventoryButton1.setFont(normalFont);
		inventoryButton1.setFocusPainted(false);
		inventoryButton1.addActionListener(iHandler);
		inventoryButton1.setActionCommand("Item1");
		inventoryPanel.add(inventoryButton1);

		inventoryButton2 = new JButton();
		inventoryButton2.setBackground(Color.black);
		inventoryButton2.setForeground(Color.white);
		inventoryButton2.setFont(normalFont);
		inventoryButton2.setFocusPainted(false);
		inventoryButton2.addActionListener(iHandler);
		inventoryButton2.setActionCommand("Item2");
		inventoryPanel.add(inventoryButton2);
		
		inventoryButton3 = new JButton();
		inventoryButton3.setBackground(Color.black);
		inventoryButton3.setForeground(Color.white);
		inventoryButton3.setFont(normalFont);
		inventoryButton3.setFocusPainted(false);
		inventoryButton3.addActionListener(iHandler);
		inventoryButton3.setActionCommand("Item3");
		inventoryPanel.add(inventoryButton3);
		
		inventoryButton4 = new JButton();
		inventoryButton4.setBackground(Color.black);
		inventoryButton4.setForeground(Color.white);
		inventoryButton4.setFont(normalFont);
		inventoryButton4.setFocusPainted(false);
		inventoryButton4.addActionListener(iHandler);
		inventoryButton4.setActionCommand("Item4");
		inventoryPanel.add(inventoryButton4);
		
		inventoryButton5 = new JButton();
		inventoryButton5.setBackground(Color.black);
		inventoryButton5.setForeground(Color.white);
		inventoryButton5.setFont(normalFont);
		inventoryButton5.setFocusPainted(false);
		inventoryButton5.addActionListener(iHandler);
		inventoryButton5.setActionCommand("Item5");
		inventoryPanel.add(inventoryButton5);
		
		inventoryButton6 = new JButton();
		inventoryButton6.setBackground(Color.black);
		inventoryButton6.setForeground(Color.white);
		inventoryButton6.setFont(normalFont);
		inventoryButton6.setFocusPainted(false);
		inventoryButton6.addActionListener(iHandler);
		inventoryButton6.setActionCommand("Item2");
		inventoryPanel.add(inventoryButton6);
		
		inventoryButton7 = new JButton();
		inventoryButton7.setBackground(Color.black);
		inventoryButton7.setForeground(Color.white);
		inventoryButton7.setFont(normalFont);
		inventoryButton7.setFocusPainted(false);
		inventoryButton7.addActionListener(iHandler);
		inventoryButton7.setActionCommand("Item7");
		inventoryPanel.add(inventoryButton7);
		
		inventoryButton8 = new JButton();
		inventoryButton8.setBackground(Color.black);
		inventoryButton8.setForeground(Color.white);
		inventoryButton8.setFont(normalFont);
		inventoryButton8.setFocusPainted(false);
		inventoryButton8.addActionListener(iHandler);
		inventoryButton8.setActionCommand("Item8");
		inventoryPanel.add(inventoryButton8);
		
		inventoryButton9 = new JButton();
		inventoryButton9.setBackground(Color.black);
		inventoryButton9.setForeground(Color.white);
		inventoryButton9.setFont(normalFont);
		inventoryButton9.setFocusPainted(false);
		inventoryButton9.addActionListener(iHandler);
		inventoryButton9.setActionCommand("Item9");
		inventoryPanel.add(inventoryButton9);
		
		inventoryPanel.setVisible(false);		
		

		playerPanel = new JPanel();
		playerPanel.setBounds(470, 15, 150, 150);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(6, 1));
		con.add(playerPanel);

		nameLabel = new JLabel("Name: ");
		nameLabel.setFont(normalFont);
		nameLabel.setForeground(Color.white);
		playerPanel.add(nameLabel);

		nameLabelName = new JLabel();
		nameLabelName.setFont(normalFont);
		nameLabelName.setForeground(Color.white);
		playerPanel.add(nameLabelName);

		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);

		hpLabelNumber = new JLabel("" + playerHP);
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);

		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);

		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);

		playerSetup();

		window.setVisible(true);

	}

	public void playerSetup() {

		hero = new Hero("Andreas", grnRoom.getClass("Warrior"));
		monster = monsterCage.getMonster("Rat Monster");

		playerHP = hero.getClassType().getHp();
		weapon = hero.getClassType().getWpn();
		nameLabelName.setText(hero.getName());
		hpLabelNumber.setText("" + playerHP);
		weaponLabelName.setText(hero.getClassType().getWpn().wpnName);
		inventoryStatus = "close";

		if (monster.getName() == "Rat") {
			rat();
		} else if (monster.getName() == "Rat-man") {
			ratMan();
		} else if (monster.getName() == "Rat Monster") {
			ratMonster();
		}

	}

	public void rat() {
		position = "rat";

		mainTextArea.setText("You see an unusally large rat. \nIt charges at you, trying to bite at your leggs!");

		choice1.setText("Fight");
		choice2.setText("Block");
		choice3.setText("Run");
		inventoryButton.setText("Inventory");
	}

	public void ratMan() {
		position = "ratMan";

		mainTextArea.setText("You see a rat-man. \nIt charges at you, trying to bite at your chest!");

		choice1.setText("Fight");
		choice2.setText("Block");
		choice3.setText("Run");
		inventoryButton.setText("Inventory");
	}

	public void ratMonster() {
		position = "ratMonster";

		mainTextArea.setText("You see a rat monster. \nIt charges at you, trying to bite at your head!");

		choice1.setText("Fight");
		choice2.setText("Block");
		choice3.setText("Run");
		inventoryButton.setText("Inventory");
	}

	public void fight() {
		position = "fight";

		mainTextArea.setText("Monster HP: " + monster.getHealth() + "\n\nWhat do you do?");

		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		inventoryButton.setText("");

	}

	public void playerAttack() {
		position = "playerAttack";

		int playerDamage = 0;

		if (hero.getClassType().getWpn().getWpnName() == "Sword") {
			playerDamage = new java.util.Random()
					.nextInt(hero.getClassType().getWpn().getDmg() + hero.getClassType().getAtkPwr());
		} else if (hero.getClassType().getWpn().getWpnName() == "Long Sword") {
			playerDamage = new java.util.Random()
					.nextInt(hero.getClassType().getWpn().getDmg() + hero.getClassType().getAtkPwr());
		}

		mainTextArea.setText("You attacked the monster and did " + playerDamage + " damage!");

		monster.health -= playerDamage;

		choice1.setText("Continue");
		choice2.setText("");
		choice3.setText("");
		inventoryButton.setText("");
	}

	public void monsterAttack() {
		position = "monsterAttack";

		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(monster.getAttackPower());

		mainTextArea.setText("The monster attacked you and you take " + monsterDamage + " damage!");

		hero.getClassType().hp -= monsterDamage;
		hpLabelNumber.setText("" + hero.getClassType().hp);

		choice1.setText("Fight");
		choice2.setText("");
		choice3.setText("");
		inventoryButton.setText("");
	}

	public void win() {
		position = "win";

		mainTextArea.setText("You defeated the monster!");

		choice1.setText("");
		choice1.setVisible(false);
		choice2.setText("Continue");
		choice3.setText("");
		choice3.setVisible(false);
		inventoryButton.setText("");
		inventoryButton.setVisible(false);

	}

	public void lose() {
		position = "lose";

		mainTextArea.setText("You are dead! \n\n<GAME OVER>");

		choice1.setText("");
		choice2.setText("Ok");
		choice3.setText("");
		inventoryButton.setText("");

		choice1.setVisible(false);
		choice3.setVisible(false);
		inventoryButton.setVisible(false);
	}

	public void cont() {
		window.dispose();
	}

	public void run() {
		position = "run";

		mainTextArea.setText("You run from the monster");

		choice1.setText("");
		choice2.setText("Ok");
		choice3.setText("");
		inventoryButton.setText("");

		choice1.setVisible(false);
		choice3.setVisible(false);
		inventoryButton.setVisible(false);

	}

	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String yourChoice = event.getActionCommand();

			switch (position) {
			case "rat":
				switch (yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					// block();
					break;
				case "c3":
					run();
					break;
				case "c4":
					// inventory();
					break;
				}
				break;
			case "ratMan":
				switch (yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					// block();
					break;
				case "c3":
					run();
					break;
				case "c4":
					// inventory();
					break;
				}
				break;
			case "ratMonster":
				switch (yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					// block();
					break;
				case "c3":
					run();
					break;
				case "c4":
					// inventory();
					break;
				}
				break;

			case "playerAttack":
				switch (yourChoice) {
				case "c1":
					if (monster.getHealth() < 1) {
						win();
					} else {
						monsterAttack();
					}
					break;
				}
				break;
			case "fight":
				switch (yourChoice) {
				case "c1":
					playerAttack();
					break;
				}
				break;
			case "monsterAttack":
				switch (yourChoice) {
				case "c1":
					if (playerHP < 1) {
						lose();
					} else {
						fight();
					}
					break;
				}
				break;
			case "win":
				switch (yourChoice) {
				case "c2":
					cont();
					break;
				}
				break;
			case "lose":
				switch (yourChoice) {
				case "c2":
					cont();
					break;
				}
				break;
			case "run":
				switch (yourChoice) {
				case "c2":
					cont();
					break;
				}
			}
		}
	}

	public static int getMonsterHealth() {
		return monsterHP;
	}

	public static int getHealth() {
		return playerHP;
	}

	public static String getPosition() {
		return position;
	}

	public static void main(String[] args) {
		new CombatClass();
	}

	public class InventoryHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String yourChoice = event.getActionCommand();
			
			switch(yourChoice) {
			case "inventoryButton":
				if(inventoryStatus.equals("close")) {
					inventoryPanel.setVisible(true);
					inventoryStatus = "open";
				} else if(inventoryStatus.equals("open")){
					inventoryPanel.setVisible(false);
					inventoryStatus = "close";
				}
				break;
			}
		}
	}

}
