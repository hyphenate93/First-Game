package betterText;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import betterText.GameTest.ChoiceHandler;

public class UI {

	public JFrame window;
	public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	public JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, nameLabel, nameLabelName;
	public JButton startButton, choice1, choice2, choice3, choice4;
	public JTextArea mainTextArea;

	// default font is to small, make two new ones, one for title and one for
	// whatever text we are to use
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 55);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);

	public void createUI(ChoiceHandler cHandler) {

		// WINDOW
		// window creation. set the size, decide on how to exit the program, set the
		// background color and layout
		window = new JFrame();
		window.setSize(640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);

		
		// TITEL SCREEN
		// add the panel where the label with text will end up, give it its location and
		// size as well as background color
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(50, 50, 530, 100);
		titleNamePanel.setBackground(Color.black);

		// make the label and add text in it, make the text white, set font size and add
		// the label to the panel above
		titleNameLabel = new JLabel("Character Creation");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);

		// make a panel for the start button and give it its bounds, just as previously
		// done with other panels
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(220, 300, 200, 50);
		startButtonPanel.setBackground(Color.black);

		// create the start button, fix background, text color, font and add it to the
		// panel
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false); // removes an ugly white line (remove and run to see what i mean)
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		startButtonPanel.add(startButton);

		// add the layers to the window
		window.add(titleNamePanel);
		window.add(startButtonPanel);

		
		// GAME SCREEN
		// make a panel for the text to appear in, same as other panels above
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(10, 10, 450, 300);
		mainTextPanel.setBackground(Color.black);
		window.add(mainTextPanel);

		// adjust everything related to the text. background color, text color,
		// text-wrap when it reaches the end of the bounds and make it non-editable
		mainTextArea = new JTextArea("This is the main text area");
		mainTextArea.setBounds(10, 10, 440, 300);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);

		// button panel, same as other panels except that we fix the layout of how the
		// buttons will appear with the grid layout
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(15, 380, 600, 50);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(1, 4));
		window.add(choiceButtonPanel);

		// create four buttons that all work the same way
		choice1 = new JButton();
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);

		choice2 = new JButton();
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);

		choice3 = new JButton();
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);

		choice4 = new JButton();
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);

		//player panel, same as above
		playerPanel = new JPanel();
		playerPanel.setBounds(470, 15, 150, 150);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(6, 1));
		window.add(playerPanel);
		
		// label for name, same as above
		nameLabel = new JLabel("Name: ");
		nameLabel.setFont(normalFont);
		nameLabel.setForeground(Color.white);
		playerPanel.add(nameLabel);
		
		// label where name will show
		nameLabelName = new JLabel();
		nameLabelName.setFont(normalFont);
		nameLabelName.setForeground(Color.white);
		playerPanel.add(nameLabelName);
		
		// make a label for the HP, same adjustments as above
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);

		// make a label for the HP number
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);

		// make a label for the weapon, same adjustments as above
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);

		// make a label for the weapon name
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);

		// set everything to visible, else we cannot see the window or anything in it
		window.setVisible(true);
	}

}
