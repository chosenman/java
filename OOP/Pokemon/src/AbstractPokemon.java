
public abstract class AbstractPokemon implements pokemonInterface {
	static int count = 0;
	String name;
	int health;
	String type;
	
	public void createPokemon(String name, String type, int health) {
		this.name = name;
		this.type = type;
		this.health = health;
		count++;
	}
	
	 public void attackPokemon(Pokemon pokemon) {
		 pokemon.health -= 10;
	 }
	
}
