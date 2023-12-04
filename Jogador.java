/**
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores.
 * 
 * Essa eh a classe responsavel por definir a criacao do personagem do usuario,
 * sua implementação tem como funcionalidade possibilitar a manipulacao do jogo, pokemons
 * e como serao explorados os ambientes.
 * 
 * @author Patrick Leite
 * @version 2023/12/03
 */

public class Jogador extends Treinador {
    /**
     * @param nome se refere a voce no jogo
     */
    public Jogador(String nome) {
        super(nome);
        this.getPokemon().setVida(calculaVida());
    }

    /**
     * Estabelece a vida base do pokemon recebido pelo usuario.
     * 
     * @return A vida padrao do pokemon
     */
    @Override
    public int calculaVida() {
        return super.getVidaBasePokemon();
    }
}
