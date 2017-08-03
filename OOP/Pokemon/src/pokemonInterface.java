
public interface pokemonInterface {
	// New in Java 8, default methods allow developers to create default methods that do not need implementation.
	
	// Abstract methods are methods that are declared without implementation. We saw an example of that in the OperateBicycle example above. 
	// Abstract is the implicit method type; without declaration of either Static or default the method will be Abstract
	 void createPokemon(String name, String type, int health);
	 
	 void attackPokemon(Pokemon pokemon);
	 
	 // Static methods are interface member methods. Also new to Java 8, they are implemented on the interface level and are called on the interface, not the class. Therefore, you cannot override static interface methods. You can only call them directly on the interface that they were declared.
	 static String pokemonInfo(Pokemon pokemon) {
		 return "Pokemon's name: " + pokemon.name + ", Health: " 
				 + Integer.toString(pokemon.health) + 
				 ", type: " + pokemon.type;
	 }
}
