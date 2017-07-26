package VirtualPetAMOK;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		VirtualPetShelter shelter = new VirtualPetShelter();
		Scanner input = new Scanner(System.in);

		Org astro = new OrgDog("Astro", "Playful Great Dane");
		shelter.intake(astro);
		Robo tinman = new RoboDog("Tinman", "Model 5");
		shelter.intake(tinman);
		Org azrael = new OrgCat("Azrael", "Evil cat");
		shelter.intake(azrael);
		Robo doraemon = new RoboCat("Doraemon", "Robo Time Traveling cat");
		shelter.intake(doraemon);
		Org jack = new OrgDog("Jack", "Terrier with a trenchcoat");
		shelter.intake(jack);

		boolean quit = false;
		writeLine("Welcome my weird Pet Shop"
				+ "\nHere we specialize in both robotic and organic pets.");

		do {
			if (shelter.getLitterBox() >= 100) {
				writeLine("The litterbox is really smelly. You should really clean it.");
				for (VirtualPet pet : shelter.pets()) {
					if (pet instanceof OrgCat) {
						((OrgCat) pet).decreaseHealth();
					}
				}
			}
			for (VirtualPet pet : shelter.pets()) {
				if (pet instanceof OrgDog) {

					if (((OrgDog) pet).getCageMessiness() >= 100) {
						writeLine(pet.getName() + "'s cage is getting messy and you should probably clean it.");
						((OrgDog) pet).decreaseHealth();
					}
				}
			}

			writeLine("\nHere are the status of all the pets at my pet shop: ");
			writeLine("\nName\t|Mood\t|Health\t|Hunger\t|Thirst\t|OilLvl\t|CageMess");
			writeLine("--------|-------|-------|-------|-------|-------|-------");
			for (Org currentPet : shelter.organicCats()) {
				writeLine(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + currentPet.getHunger() + "\t|"
						+ currentPet.getThirst() + "\t|" + "n/a" + "\t|" + "n/a");
			}
			for (Org currentPet : shelter.organicDogs()) {
				writeLine(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + currentPet.getHunger() + "\t|"
						+ currentPet.getThirst() + "\t|" + "n/a" + "\t|" + ((OrgDog) currentPet).getCageMessiness());
			}
			for (Robo currentPet : shelter.roboticDogs()) {
				writeLine(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + "n/a" + "\t|" + "n/a" + "\t|"
						+ currentPet.getOilLevel() + "\t|" + "n/a");
			}
			for (Robo currentPet : shelter.roboticCats()) {
				writeLine(currentPet.getName() + "|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + "n/a" + "\t|" + "n/a" + "\t|"
						+ currentPet.getOilLevel() + "\t|" + "n/a");
			}

			writeLine("\nThe litterbox is: " + shelter.getLitterBox());
			writeLine("\nWhat would you like to do next?");
			writeLine("\n1.Feed the organic pets \n2.Water the organic pets "
					+ "\n3.Play with a pet \n4.Adopt a pet \n5.Admit a pet "
					+ "\n6.Clean Cages \n7.Clean Litterbox \n8.Walk Dogs "
					+ "\n9.Maintain all Robos \n10.Do nothing \n11.Quit");
			String response = input.nextLine();

			switch (response) {
			case "1":
				shelter.feedAllOrganic();
				writeLine("You fed all the pets!");
				break;
			case "2":
				shelter.waterAllOrganic();
				writeLine("You watered all the pets");
				break;
			case "3": // play
				writeLine("Which one would you like to play with:\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to play with?");
				String petName = input.nextLine();
				shelter.playOne(shelter.getPet(petName));
				writeLine("You played with " + shelter.getPet(petName) + "! ");
				break;
			case "4": // adopt
				writeLine("You want to adopt a pet? Allons-y!\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to adopt?");
				String petAdopt = input.nextLine();
				VirtualPet a = shelter.getPet(petAdopt);
				shelter.adoptPet(a);
				writeLine("You adopted " + petAdopt + ". Please take good care of them!");
				break;
			case "5":// intake
				writeLine("You want to give us a new pet?"
						+ "Is it organic or robotic?");
				String response2 = input.next();
				if (response2.equalsIgnoreCase("organic")) {
					writeLine("Is your organic pet a cat or a dog?");
					String response3 = input.next();
					input.nextLine();
					if (response3.equalsIgnoreCase("dog")) {
						writeLine("What is the dog's name?");
						String name = input.nextLine();
						writeLine("Tell us more about the dog!");
						String description = input.nextLine();
						Org pet = new OrgDog(name, description);
						shelter.intake(pet);
						writeLine(pet.getName() + "is in good hands.");
					} else if (response3.equalsIgnoreCase("cat")) {
						writeLine("What is the cat's name?");
						String name = input.nextLine();

						writeLine("Tell us more about the cat!");
						String description = input.nextLine();
						Org pet = new OrgCat(name, description);
						shelter.intake(pet);
						writeLine("We'll take good care of " + pet.getName() + ".");
					}

				} else if (response2.equalsIgnoreCase("robotic")) {
					writeLine("Is your robotic pet a cat or a dog?");
					String response3 = input.next();
					input.nextLine();

					if (response3.equalsIgnoreCase("dog")) {
						writeLine("What is the dog's name?");
						String name = input.nextLine();
						writeLine("How about a short description of the dog");
						String description = input.nextLine();
						Robo pet = new RoboDog(name, description);
						shelter.intake(pet);
						writeLine(pet.getName() + "is in good hands.");

					} else if (response3.equalsIgnoreCase("cat")) {
						writeLine("What is the cat's name?");
						String name = input.nextLine();
						writeLine("Pleae description the cat.");
						String description = input.nextLine();
						Robo pet = new RoboCat(name, description);
						shelter.intake(pet);
						writeLine(pet.getName() + "is in good hands.");
					}
				}
				break;
			case "6":
				shelter.cleanDogCages();
				writeLine("Cages are all clean!");
				break;
			case "7":
				shelter.cleanLitterBox();
				writeLine("Litterbox are all clean!");
				break;
			case "8":
				shelter.walkDogs();
				writeLine("The dogs enjoyed the walk.");
				break;
			case "9":
				shelter.maintainAllRobo();
				writeLine("You just oiled the Robo pets.");
				break;
			case "10":
				// tick
				break;
			case "11":
				writeLine("Please come again");
				System.exit(0);
			default:
				writeLine("Try again.");
				break;

			}
			shelter.tickAllPets();

		} while (!quit);
		input.close();

	}

	private static void displayPets(VirtualPetShelter shelter) {
		for (VirtualPet currentPet : shelter.pets()) {
			writeLine("" + currentPet);
		}
	}

	public static void writeLine(String message) {
		System.out.println(message);
	}

}