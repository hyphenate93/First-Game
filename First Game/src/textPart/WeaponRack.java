package textPart;

import java.util.ArrayList;
import java.util.List;

/*
 * somewhere to create any number of weapons to be put in an list to be got at any point later
 */
public class WeaponRack {

	private List<Weapon> wpnRack = new ArrayList<Weapon>();

	public WeaponRack() {
		Weapon sword = new Weapon("Sword", 2, 5);
		Weapon dagger = new Weapon("Dagger", 1, 2);
		Weapon lance = new Weapon("Lance", 3, 3);

		wpnRack.add(sword);
		wpnRack.add(dagger);
		wpnRack.add(lance);
	}
	
	public Weapon getWeapon(String name) {
		for(int i = 0; i < wpnRack.size(); i++) {
			if(name.equals(wpnRack.get(i).getWpnName())) {
				return wpnRack.get(i);
			}
		}
		return null;
		
	}

}
