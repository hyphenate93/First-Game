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
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, nameLabelName, nameLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 55);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;

	static int playerHP, monsterHP;

	Random random;
	static String position;
	Weapon weapon;

	ChoiceHandler choiceHandler = new ChoiceHandler();

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

		choice4 = new JButton("Four");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);

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
		monster = monsterCage.getMonster("Rat");

		playerHP = hero.getClassType().getHp();
		weapon = hero.getClassType().getWpn();
		nameLabelName.setText(hero.getName());
		hpLabelNumber.setText("" + playerHP);
		weaponLabelName.setText(hero.getClassType().getWpn().wpnName);

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
		choice4.setText("Inventory");
	}

	public void ratMan() {
		position = "ratMan";

		mainTextArea.setText("You see a rat-man. \nIt charges at you, trying to bite at your chest!");

		choice1.setText("Fight");
		choice2.setText("Block");
		choice3.setText("Run");
		choice4.setText("Inventory");
	}

	public void ratMonster() {
		position = "ratMonster";

		mainTextArea.setText("You see a rat monster. \nIt charges at you, trying to bite at your head!");

		choice1.setText("Fight");
		choice2.setText("Block");
		choice3.setText("Run");
		choice4.setText("Inventory");
	}

	public void fight() {
		position = "fight";

		mainTextArea.setText("Monster HP: " + monster.getHealth() + "\n\nWhat do you do?");

		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");

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
		choice4.setText("");
	}

	public void monsterAttack() {
		position = "monsterAttack";

		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(monster.getAttackPower());

		mainTextArea.setText("The monster attacked you and you take " + monsterDamage + " damage!");

		playerHP -= monsterDamage;
		hpLabelNumber.setText("" + playerHP);

		choice1.setText("Fight");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void win() {
		position = "win";

		mainTextArea.setText("You defeated the monster!");

		choice1.setText(""); choice1.setVisible(false);
		choice2.setText("Continue");
		choice3.setText(""); choice3.setVisible(false);
		choice4.setText(""); choice4.setVisible(false);

	}

	public void lose() {
		position = "lose";

		mainTextArea.setText("You are dead! \n\n<GAME OVER>");

		choice1.setText("");
		choice2.setText("Ok");
		choice3.setText("");
		choice4.setText("");

		choice1.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
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
		choice4.setText("");

		choice1.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		
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

}
