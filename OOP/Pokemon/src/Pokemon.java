
public class Pokemon extends AbstractPokemon implements pokemonInterface {

	
	Pokemon(String name, String type, int health){
		createPokemon( name,  type,  health);
	}
	

	

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
