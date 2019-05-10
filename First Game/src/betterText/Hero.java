package betterText;

public class Hero {

	String name;
	Class classType;

	public Hero(String name, Class classType) {
		this.name = name;
		this.classType = classType;
	}

	public String getName() {
		return name;
	}

	public Class getClassType() {
		return classType;
	}

}