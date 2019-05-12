package betterText;

public class Monster {
	
	String name;
	int health;
	int attackPower;
	double expreiencePoints;
	
	public Monster(String name, int health, int attackPower, double expreiencePoints) {
		this.name 			  = name;
		this.health 		  = health;
		this.attackPower 	  = attackPower;
		this.expreiencePoints = expreiencePoints;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getAttackPower() {
		return attackPower;
	}
	
	public double getExpreiencePoints() {
		return expreiencePoints;
	}
	
	public String toString() {
		return "This monster is called " + name + ", has " + health + " health, " + attackPower + " attack power and will give " + expreiencePoints + " experience points\n";
	}
}
