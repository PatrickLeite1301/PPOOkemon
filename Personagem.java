/**
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores.
 * 
 * Cria metodos em interface que serao atendidos em cada tipo de treinador para
 * definir funcoes referentes aos pokemons.
 * 
 * @author Patrick Leite
 * @version 2023/12/03
 */

public interface Personagem {

    int calculaVida();

    Pokemon getPokemon();

    String getNome();
}
