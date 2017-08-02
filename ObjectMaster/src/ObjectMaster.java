
public class ObjectMaster {
	public static void main(String[] arg) {
		Human man = new Human();
		Human man2 = new Human();
		
		man.attack(man2);
		
		man2.showHealth();
	}
}
