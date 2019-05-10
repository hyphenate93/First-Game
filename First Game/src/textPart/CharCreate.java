package textPart;

import java.util.Scanner;

public class CharCreate {

	public Hero getCharacterTest() {

		Scanner input = new Scanner(System.in);
		
		ClassGreenRoom grnRoom = new ClassGreenRoom(); // initialize the "green room"
		Hero hero = null; // initialize the hero object that will be filled by the outcome of the switch
							// bellow
		System.out.println("What class are you?");
		System.out.println("1: Warrior, 2: Thief, 3: Lancer");
		do {
			switch (input.next()) {
			case "Warrior":
				System.out.println("Your choice is " + grnRoom.getClass("Warrior").getClassName());
				System.out.println("Are you sure?");
				if (input.nextInt() == 0) {
					System.out.println("Please pick a class");
					break;
				} else {
					System.out.println("What is your name?");
					hero = new Hero(input.next(), grnRoom.getClass("Warrior"));
				}
				break;
			case "Thief":
				System.out.println("Your choice is " + grnRoom.getClass("Thief").getClassName());
				System.out.println("Are you sure?");
				if (input.nextInt() == 0) {
					System.out.println("Please pick a class");
					break;
				} else {
					System.out.println("What is your name?");
					hero = new Hero(input.next(), grnRoom.getClass("Thief"));
				}
				break;
			case "Lancer":
				System.out.println("Your choice is " + grnRoom.getClass("Lancer").getClassName());
				System.out.println("Are you sure?");
				if (input.nextInt() == 0) {
					System.out.println("Please pick a class");
					break;
				} else {
					System.out.println("What is your name?");
					hero = new Hero(input.next(), grnRoom.getClass("Lancer"));
				}
				break;
			default:
				System.out.println("Invalid choice, try again");
				break;
			}
		} while (hero == null);

		System.out.println("You are the great Hero " + hero.getName() + "! A " + hero.getClassType().getClassName()
				+ " of legend!");
		System.out.println("Your health is " + hero.getClassType().getHp());
		System.out.println("Your armor is " + hero.getClassType().getArmor());
		System.out.println("Your attack power is " + hero.getClassType().getAtkPwr());
		System.out.println("You're wielding a " + hero.getClassType().getWpn().getWpnName() + ". Your range is "
				+ hero.getClassType().getWpn().getRange() + " and you will be doing "
				+ ((hero.getClassType().getAtkPwr()) + (hero.getClassType().getWpn().getDmg())) + " damage on a hit.");
		System.out.println("You have " + hero.getClassType().getExp() + " exp");
		System.out.println("*--------------------------------*");

		return hero;
	}
}
