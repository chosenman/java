
public interface pokemonInterface {
	
	 void createPokemon(String name, String type, int health);
	 
	 void attackPokemon(Pokemon pokemon);
	 
	 static String pokemonInfo(Pokemon pokemon) {
		 return "Pokemon's name: " + pokemon.name + ", Health: " 
				 + Integer.toString(pokemon.health) + 
				 ", type: " + pokemon.type;
	 }
}
