/**
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores.
 * 
 * Essa eh a classe responsável por definir a criacao do tipo de personagem Comum,
 * sua implementação tem como funcionalidade possibilitar a diferenca no status vida
 * e ter um objeto que possua pokemons que serão um meio de duelo.
 * 
 * @author Patrick Leite
 * @version 2023/12/03
 */
package personagem;

public class InimigoComum extends Treinador {
    /**
     * @param nome nome dado ao inimigo criado para um ambiente
     */
    public InimigoComum(String nome) {
        super(nome);
        this.getPokemon().setVida(calculaVida());
    }

    /**
     * Estabelece o decressimo de vida do pokemon do inimigo comum baseado na vida
     * base de todo
     * pokemon.
     * 
     * @return A vida final do pokemon dos inimigos comuns encontrados pelo mapa
     */
    @Override
    public int calculaVida() {
        return super.getVidaBasePokemon() - 300;
    }

}
