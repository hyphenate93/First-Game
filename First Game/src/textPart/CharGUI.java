package textPart;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Start.Game;

public class CharGUI {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 55);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;

	int playerHP, monsterHP;

	String position;
	Weapon weapon;

	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	ClassGreenRoom grnRoom = new ClassGreenRoom();
	Hero hero = null;
	boolean skip = false;
	
	public CharGUI() {
		
		window = new JFrame();
		window.setSize(640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setLayout(null);
		con = window.getContentPane();

		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(50, 50, 530, 100);
		titleNamePanel.setBackground(Color.black);

		titleNameLabel = new JLabel("Character Creation");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(220, 300, 200, 50);
		startButtonPanel.setBackground(Color.black);

		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false); // remove line around button

		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);

		con.add(titleNamePanel);
		con.add(startButtonPanel);

		window.setVisible(true);
		skip  = true;
		
	}

	public void createGameScreen() {

		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);

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
		playerPanel.setLayout(new GridLayout(3, 1));
		con.add(playerPanel);

		hpLabel = new JLabel("HP: " + playerHP);
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);

		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);

		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);

		preChoice();

	}

	public void preChoice() {
		position = "preChoice";

		mainTextArea.setText("\n\n\nWhat class would you like to be?");

		hpLabel.setText("HP:");
		weaponLabelName.setText("");

		choice1.setText("Warrior");
		choice2.setText("Thief");
		choice3.setText("Lancer");
		choice4.setText("W.I.P");

	}

	public void warrior() {
		position = "warrior";

		hero = new Hero("Andreas", grnRoom.getClass("Warrior"));
		mainTextArea.setText("You are the great Hero " + hero.getName() + "! \nA " + hero.getClassType().getClassName()
				+ " of legend! \nYour health is " + hero.getClassType().getHp()
				+ " and with your current weapon you will be doing "
				+ (hero.getClassType().getAtkPwr() + hero.getClassType().getWpn().getDmg()) + " damage per hit!");

		playerHP = hero.getClassType().getHp();
		weapon = hero.getClassType().getWpn();

		hpLabel.setText("HP:" + playerHP);
		weaponLabelName.setText(hero.getClassType().getWpn().wpnName);

		choice1.setText("Ok");
		choice2.setText("Nah dude");
		choice3.setText("");
		choice4.setText("");
	}

	public void thief() {
		position = "thief";

		hero = new Hero("Niklas", grnRoom.getClass("Thief"));
		mainTextArea.setText("You are the great Hero " + hero.getName() + "! \nA " + hero.getClassType().getClassName()
				+ " of legend! \nYour health is " + hero.getClassType().getHp()
				+ " and with your current weapon you will be doing "
				+ (hero.getClassType().getAtkPwr() + hero.getClassType().getWpn().getDmg()) + " damage per hit!");

		playerHP = hero.getClassType().getHp();
		weapon = hero.getClassType().getWpn();

		hpLabel.setText("HP:" + playerHP);
		weaponLabelName.setText(hero.getClassType().getWpn().wpnName);

		choice1.setText("Ok");
		choice2.setText("Nah dude");
		choice3.setText("");
		choice4.setText("");
	}

	public void lancer() {
		position = "lancer";

		hero = new Hero("Oscar", grnRoom.getClass("Lancer"));
		mainTextArea.setText("You are the great Hero " + hero.getName() + "! \nA " + hero.getClassType().getClassName()
				+ " of legend! \nYour health is " + hero.getClassType().getHp()
				+ " and with your current weapon you will be doing "
				+ (hero.getClassType().getAtkPwr() + hero.getClassType().getWpn().getDmg()) + " damage per hit!");

		playerHP = hero.getClassType().getHp();
		weapon = hero.getClassType().getWpn();

		hpLabel.setText("HP:" + playerHP);
		weaponLabelName.setText(hero.getClassType().getWpn().wpnName);

		choice1.setText("Ok");
		choice2.setText("Nah dude");
		choice3.setText("");
		choice4.setText("");
	}

	public void storyStart() {
		position = "storyStart";

		mainTextArea.setText("Your quest begins outside of town. \nThere is something going on. Investigate!");

		choice1.setText("");
		choice2.setText("Lets go!");
		choice3.setText("");
		choice4.setText("");

		choice1.setVisible(false);
		// choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void playerSetup() {

		playerHP = hero.getClassType().getHp();
		weapon = hero.getClassType().getWpn();
		hpLabel.setText("Health: " + playerHP);
		weaponLabelName.setText(hero.getClassType().getWpn().wpnName);

		/*
		 * if(monster is rat) { rat(); } else if(monster is ratMan) { ratMan(); } else
		 * if(monster is ratMonster) { ratMonster(); }
		 */

	}

	public void rat() {
		position = "rat";

		mainTextArea.setText("You see an unusally large rat. \nIt charges at you, trying to bite at your leggs!");

		choice1.setText("Attack");
		choice2.setText("Block");
		choice3.setText("Run");
		choice4.setText("Inventory");
	}

	public void ratMan() {
		position = "ratMan";

		mainTextArea.setText("You see a rat-man. \nIt charges at you, trying to bite at your chest!");

		choice1.setText("Attack");
		choice2.setText("Block");
		choice3.setText("Run");
		choice4.setText("Inventory");
	}

	public void ratMonster() {
		position = "ratMonster";

		mainTextArea.setText("You see a rat monster. \nIt charges at you, trying to bite at your head!");

		choice1.setText("Attack");
		choice2.setText("Block");
		choice3.setText("Run");
		choice4.setText("Inventory");
	}

	public class TitleScreenHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			createGameScreen();
		}
	}

	/*
	 * need a way to save the chosen hero to be used in other areas. shouldn't this
	 * work?
	 */
	public Hero getHero() {
		return hero;
	}

	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String yourChoice = event.getActionCommand();

			switch (position) {
			case "preChoice":
				switch (yourChoice) {
				case "c1":
					warrior();
					break;
				case "c2":
					thief();
					break;
				case "c3":
					lancer();
					break;
				case "c4":

					break;
				}
				break;
			case "warrior":
				switch (yourChoice) {
				case "c1":
					storyStart();
					break;
				case "c2":
					preChoice();
					break;
				}
				break;
			case "thief":
				switch (yourChoice) {
				case "c1":
					storyStart();
					break;
				case "c2":
					preChoice();
					break;
				}
				break;
			case "lancer":
				switch (yourChoice) {
				case "c1":
					storyStart();
					break;
				case "c2":
					preChoice();
					break;
				}
				break;
			case "storyStart":
				switch (yourChoice) {
				case "c2":
					new Game();
					window.dispose();
					break;
				}
				break;
			}
		}
	}

	public static void main(String[] args) {
		new CharGUI();
	}

}
