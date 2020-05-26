package springhw.beans.adds;

public class Tank implements Characters{
	
private int skill;
private int weight = 220;
private String name;
private String type = "tank";

public Tank(String name) {
	super();
	this.name = name;
	}

	public String returnType() {
		return type;
	}

	public int getName() {
		return skill;
	}

	public void setName(int skill) {
		this.skill = skill;
	}

	public void useSkill() {
		if(skill == 1)
		System.out.println("Pudge throws a hook");
	}

	@Override
	public String toString() {
		return "Tank{" +
				"name='" + name + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
