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
import textPart.TextAdventure.ChoiceHandler;
import textPart.TextAdventure.TitleScreenHandler;

public class RPGScreen {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 55);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;

	int playerHP, monsterHP, silverRing;
	String weapon, position;

	ChoiceHandler choiceHandler = new ChoiceHandler();
	ClassGreenRoom grnRoom = new ClassGreenRoom();
	Hero hero = null;
	
	CharGUI test = new CharGUI();
	

	public RPGScreen() {

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

		window.setVisible(true);

		playerSetup();
	}
	
	public void playerSetup() {
		
		//hero = new Hero("Andreas", grnRoom.getClass("Warrior"));
		
		hero = test.getHero();
		
		playerHP = hero.getClassType().getHp();
		weapon = hero.getClassType().getWpn().getWpnName();
		hpLabel.setText("Health: " + playerHP);
		weaponLabelName.setText(weapon);
		
		/*
		if(monster is rat) {
			rat();
		} else if(monster is ratMan) {
			ratMan();
		} else if(monster is ratMonster) {
			ratMonster();
		}
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
	
	
	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
		}
	}
	
	public static void main(String[] args) {
		new RPGScreen();
	}
	
	
}
