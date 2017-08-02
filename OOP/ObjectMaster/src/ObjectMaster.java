
public class ObjectMaster {
	public static void main(String[] arg) {
		Human man = new Human();
		Human man2 = new Human();
		
		// Object master 1
//		man.attack(man2);
//		
//		man2.showHealth();
		
		// Object master 2
		Ninja ninja = new Ninja();
		Samurai samurai = new Samurai();
		Samurai samurai2 = new Samurai();
		Wizard wizard = new Wizard();
		
		ninja.steal(man).showHealth();
		ninja.showHealth();
		ninja.runAway();
		ninja.showHealth();
		
		samurai.howMany();
		samurai.deathBlow(man2);
		man2.showHealth();
		
		samurai.showHealth();
		samurai.meditate();
		samurai.showHealth();
		
		samurai2.deathBlow(wizard);
		wizard.showHealth();
		wizard.heal(wizard);
		wizard.showHealth();
		samurai2.showHealth();
		wizard.fireball(samurai2);
		samurai2.showHealth();
		
	}
}
