package textPart;

import java.util.ArrayList;
import java.util.List;

/*
 * somewhere to create any number of classes to be put in an list to be got at
 * any point later
 */
public class ClassGreenRoom {

	private List<Class> greenRoom = new ArrayList<Class>();
	WeaponRack wpnRack = new WeaponRack();

	public ClassGreenRoom() {

		Class warrior = new Class("Warrior", wpnRack.getWeapon("Sword"), 20, 20, 15, 0.0);
		Class thief = new Class("Thief", wpnRack.getWeapon("Dagger"), 15, 10, 20, 0.0);
		Class lancer = new Class("Lancer", wpnRack.getWeapon("Lance"), 10, 30, 10, 0.0);

		greenRoom.add(warrior);
		greenRoom.add(thief);
		greenRoom.add(lancer);

	}

	public Class getClass(String name) {

		for (int i = 0; i < greenRoom.size(); i++) {
			if (name.equals(greenRoom.get(i).getClassName())) {
				return greenRoom.get(i);
			}
		}
		return null;
	}
}
