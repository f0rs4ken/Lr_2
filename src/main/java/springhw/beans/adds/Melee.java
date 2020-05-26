package springhw.beans.adds;

public class Melee implements Characters{
	
	private int skill;
	private int weight = 65;
	private String name;
	private String type = "melee";

	public Melee(String name) {
		super();
		this.name = name;
	}

	public String returnType(){
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
		System.out.println("Anti-Mage burns your mana");
	}

	@Override
	public String toString() {
		return "Melee{" +
				"name='" + name + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
