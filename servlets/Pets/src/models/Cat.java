package models;

public class Cat extends Animal {
	
	// constructor
	public Cat() {	
	}
	public Cat(String name, String breed, String weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	
	public String showAffection() {
		return "Your " + this.breed + " cat, " + this.name + " looked at you with some affection. You think";
	}
}
