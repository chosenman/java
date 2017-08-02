
public class Keeper {
	public static void main(String[] arg) {
		
		// Zoo Keeper 1
		Mammal testMammal = new Mammal();
		testMammal.displayEnergy();
		
		Gorilla testGorilla = new Gorilla();
		testGorilla.displayEnergy();
		
		testGorilla.Gthrow();
		testGorilla.Gthrow();
		testGorilla.Gthrow();
			testGorilla.displayEnergy();
		testGorilla.eatBananas();
		testGorilla.eatBananas();
			testGorilla.displayEnergy();
		testGorilla.climb();
			testGorilla.displayEnergy();
	}
}
