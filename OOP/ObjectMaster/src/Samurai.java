
public class Samurai extends Human {
	private static int samuraiHealth = 200;
	 static int count = 0;
	Samurai(){
		this.health = this.samuraiHealth;
		this.count ++;
	}
	
	void deathBlow(Human target) {
		target.health = 0;
		this.health = this.health/2;
	}
	
	void meditate() {
		this.health += (samuraiHealth - this.health)/2;
	}
	
	void howMany() {
		System.out.println(this.count);
	}
}
