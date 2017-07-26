package VirtualPetAMOK;

public class OrgCat extends Cat implements Org {
	protected int hunger;
	protected int thirst;

	public OrgCat(String nameParam, String descriptionParam) {
		super(nameParam, descriptionParam);
		hunger = 50;
		thirst = 50;
	}

	@Override
	public void feed() {
		hunger -= 10;
		mood += 5;
	}

	@Override
	public void water() {
		thirst -= 20;
		mood += 5;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getMood() {
		return mood;
	}

	@Override
	public void play() {
		mood += 10;
		hunger += 5;
		thirst += 5;
	}

	@Override
	public int tick() {
		hunger += (5 + generateRandom());
		thirst += (5 + generateRandom());
		mood -= (5 + generateRandom());
		health += (5 + generateRandom());
		return 5;
	}

	@Override
	public int generateRandom() {
		return generator.nextInt(10);
	}

	@Override
	public int getHunger() {
		return hunger;
	}

	@Override
	public int getThirst() {
		return thirst;
	}

	public void decreaseHealth() {
		health -= 5;
	}

}