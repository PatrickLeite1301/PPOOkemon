import batalha.Pokemon;

public class Programa {

	public static void main(String[] args) {
//		Jogo jogo = new Jogo();
//		jogo.jogar();

		Pokemon p = new Pokemon(100);
		System.out.println(p.dadosPokemon());
		System.out.println(p.dadosAtaques());
	}

}
