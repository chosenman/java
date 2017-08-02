
public class Wizard extends Human {
	
	
	Wizard(){
		this.health = 50;
		this.intelligence = 8;
	}
	
	void heal(Human target) {
		target.health += this.intelligence;
	}
	
	void fireball(Human target) {
		target.health -= this.intelligence*3;
	}
}
