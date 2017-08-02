
public class Ninja extends Human {
	
	Ninja(){
		this.stealth = 10;
	}
	
	Human steal(Human target) {
		target.health -= this.stealth;
		this.health += this.stealth;
		return target;
	}
	void runAway(){
		this.health -=10;
	}
}
