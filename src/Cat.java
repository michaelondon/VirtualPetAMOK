
public class Cat extends VirtualPet{
	
	import java.util.Scanner;
	 
	public class cat {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);	
			Cat cat = new cat();
	do{
	// Start Status of my pet	
		System.out.println("This is my pet tiger cat #TWD");
		System.out.println("Currently cat's hunger level is at "+ cat.hungry); 		
		System.out.println("Currently cat's thirst level is at "+ cat.thirst);
		System.out.println("Currently cat's boredom level is at "+ cat.boredom);
			
	 
	// What do you want to do
			System.out.println("\nHow would you like to interact with cat?");
			System.out.println("Enter 1 To feed cat ");
			System.out.println("Enter 2 To water cat");
			System.out.println("Enter 3 To play with cat");
			String interact=input.nextLine();
			System.out.println();
			
				  switch (interact){
			  case"1":
				  cat.feed();
				  writeline("You just feed cat.");
				  break;
						  
			  case"2":
				  cat.water();
				  writeline("You just gave cat water.");
				  break;
			  case"3":
				  cat.played();
				  writeline("cat loves playtime.");
				  break;
			  case"4":
				  cat.nothing();
				  writeline("Sometime she just likes being alone.");
				  break;
			  }
					
				cat.tick();	 
	}
	while (cat.hungry>0 && cat.thirst>0 && cat.boredom>0);
	 
	// Dead message
		if (cat.hungry>0){
			System.out.println("cat died of hunger");}
		
		else if (cat.thirst>0){
			System.out.println("cat died of thirst");
		
		}else if (cat.hungry>0){
			System.out.println("cat died of pure boredom");}
		
	}
		private static void writeline(String string) {
		
			
		}
		}


