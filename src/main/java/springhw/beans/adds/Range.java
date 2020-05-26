package springhw.beans.adds;

public class Range implements Characters{

	private int skill;
	private int weight = 90;
	private String name;
	private String type = "range";

	public Range(String name) {
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
		System.out.println("Techies set mines");
	}

	@Override
	public String toString() {
		return "Range{" +
				"name='" + name + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
