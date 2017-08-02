
public class Dragon extends Mammal {
	
	Dragon(){
		this.energyLevel = 300;
	}
	
	void fly(){
		System.out.println("woooff... ima flying");
		this.energyLevel -= 50;
	}
	void eatHumans(){
		System.out.println("one more human, tasty");
		this.energyLevel += 25;
	}
	void attackTown(){
		System.out.println("aaaa... dragon came to town!");
		this.energyLevel -= 100;
	}
}
