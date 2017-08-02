
public class Human {
	int strength;
	int stealth;
	int intelligence;
	
	int health;
	
	Human(){
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 3;
		this.health = 100;
	}
	
	void attack(Human enemy){
		enemy.health -= this.strength;
	}
	
	void showHealth() {
		System.out.println(this.health);
	}
	
}
