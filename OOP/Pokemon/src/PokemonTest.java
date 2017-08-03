
public class PokemonTest {
	public static void main(String[] arg) {
		Pokemon one = new Pokemon("Shrek", "green guy", 1000);
		
		Pokemon two = new Pokemon("Butterfly", "bug", 700);
		
		one.attackPokemon(two);
		System.out.println(Pokedex.Info(one));
		System.out.println(Pokedex.Info(two));
	}
}
