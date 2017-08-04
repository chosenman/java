package models;

public class Dog extends Animal {
	
	// constructor
	public Dog() {	
	}
	public Dog(String name, String breed, String weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	
	public String showAffection() {
		String answer;
		if (Integer.parseInt(this.weight) < 30) {
			 answer = this.name + " hopped into your lap and cuddled you!";
		} else {
			answer = this.name + " cuddled next to you!";
		}
		return answer;
	}
}
