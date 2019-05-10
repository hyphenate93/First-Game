package textPart;

public class Class {

	String className;
	Weapon wpn;
	int hp;
	int armor;
	int atkPwr;
	double exp;

	public Class(String className, Weapon wpn, int hp, int armor, int atkPwr, double exp) {
		this.className = className;
		this.wpn = wpn;
		this.hp = hp;
		this.armor = armor;
		this.atkPwr = atkPwr;
		this.exp = exp;
	}

	public String getClassName() {
		return className;
	}

	public Weapon getWpn() {
		return wpn;
	}

	public int getHp() {
		return hp;
	}

	public int getArmor() {
		return armor;
	}

	public int getAtkPwr() {
		return atkPwr;
	}

	public double getExp() {
		return exp;
	}

	public String toString() {
		return "|" + className + "|" + wpn.getWpnName() + "|" + hp + "|" + armor + "|" + atkPwr + "|" + exp + "|";
	}
}
