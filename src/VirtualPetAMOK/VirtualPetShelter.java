package VirtualPetAMOK;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
	private int litterBox = 50;

	Map<String, VirtualPet> shelterPets = new HashMap<String, VirtualPet>();
	Map<String, Org> organicDogs = new HashMap<String, Org>();
	Map<String, Org> organicCats = new HashMap<String, Org>();
	Map<String, Robo> roboticDogs = new HashMap<String, Robo>();
	Map<String, Robo> roboticCats = new HashMap<String, Robo>();

	public int getLitterBox() {
		return litterBox;
	}

	public void cleanLitterBox() {
		litterBox = 0;
	}

	public void maintainAllRobo() {
		for (Robo d : roboticDogs.values()) {
			d.oilPet();
			d.recharge();
		}
		for (Robo c : roboticCats.values()) {
			c.oilPet();
			c.recharge();
		}
	}

	public void cleanDogCages() {
		for (Org d : organicDogs.values()) {
			((OrgDog) d).cleanCage();
		}
	}

	public void walkDogs() {
		for (Org d : organicDogs.values()) {
			((Dog) d).walk();
		}
		for (Robo d : roboticDogs.values()) {
			((Dog) d).walk();
		}

	}

	public void intake(Org pet) {
		shelterPets.put(pet.getName(), (VirtualPet) pet);
		if (pet instanceof OrgCat) {
			organicCats.put(pet.getName(), pet);
		}
		if (pet instanceof OrgDog) {
			organicDogs.put(pet.getName(), pet);
		}
	}

	public void intake(Robo pet) {
		shelterPets.put(pet.getName(), (VirtualPet) pet);
		if (pet instanceof RoboCat) {
			roboticCats.put(pet.getName(), pet);
		}
		if (pet instanceof RoboDog) {
			roboticDogs.put(pet.getName(), pet);
		}
	}

	public void feedAllOrganic() {
		for (Org p : organicDogs.values()) {
			p.feed();
		}
		for (Org p : organicCats.values()) {
			p.feed();
		}
		litterBox += 10;
	}

	public void waterAllOrganic() {
		for (Org p : organicDogs.values()) {
			p.water();
		}
		for (Org p : organicCats.values()) {
			p.water();
		}
		litterBox += 5;
	}

	// Tick method 
	void tickAllPets() {
		for (Org p : organicDogs.values()) {
			p.tick();
		}
		for (Org p : organicCats.values()) {
			litterBox += p.tick();
		}
		for (Robo d : roboticDogs.values()) {
			((RoboDog) d).tick();
		}
		for (Robo c : roboticCats.values()) {
			((RoboCat) c).tick();
		}
	}

	// Method returning collection of all pets in the shelter
	public Collection<VirtualPet> pets() {
		return shelterPets.values();
	}

	public Collection<Org> organicDogs() {
		return organicDogs.values();
	}

	public Collection<Org> organicCats() {
		return organicCats.values();
	}

	public Collection<Robo> roboticDogs() {
		return roboticDogs.values();
	}

	public Collection<Robo> roboticCats() {
		return roboticCats.values();
	}

	// Method to return a pet from the map by name
	public VirtualPet getPet(String name) {
		return shelterPets.get(name);

	}

	// Method to play with one pet
	public void playOne(VirtualPet player) {
		player.play();
	}

	// Method to adopt a pet
	public void adoptPet(VirtualPet pet) {
		shelterPets.remove(pet);

		if (pet instanceof RoboDog) {
			roboticDogs.remove(pet.name, pet);
		}
		if (pet instanceof RoboCat) {
			roboticCats.remove(pet.name, pet);
		}
		if (pet instanceof OrgDog) {
			organicDogs.remove(pet.name, pet);
		}
		if (pet instanceof OrgCat) {
			organicCats.remove(pet.name, pet);
		}
	}
}