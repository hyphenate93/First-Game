package betterText;

import java.util.ArrayList;
import java.util.List;

/*
 * somewhere to create any number of monsters to be put in an list to be got at any point later
 */
public class MonsterCage {
	
	private List<Monster> monsterCage = new ArrayList<Monster>();
	
	public MonsterCage() {		
		
		Monster mon1 = new Monster("Rat", 10, 1, 7.0);
		Monster mon2 = new Monster("Rat-man", 15, 5, 10.0);
		Monster mon3 = new Monster("Rat Monster", 20, 10, 20.0);
		
		monsterCage.add(mon1);
		monsterCage.add(mon2);
		monsterCage.add(mon3);
		
	}
	
	public Monster getMonster(String name) {
		
		for(int i = 0; i < monsterCage.size(); i++) {
			if(name.equals(monsterCage.get(i).getName())) {
				return monsterCage.get(i);
			}
		}
		return null;
	}
	
}