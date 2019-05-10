package textPart;

public class Weapon {

	String wpnName;
	int range;
	int dmg;

	public Weapon(String wpnName, int range, int dmg) {
		this.wpnName = wpnName;
		this.range = range;
		this.dmg = dmg;
	}

	public String getWpnName() {
		return wpnName;
	}

	public int getRange() {
		return range;
	}

	public int getDmg() {
		return dmg;
	}

	public String toString() {
		return "|" + wpnName + "|" + range + "|" + dmg + "|";
	}
}