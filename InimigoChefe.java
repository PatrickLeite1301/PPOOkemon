/**
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores.
 * 
 * Essa eh a classe responsavel por definir a criacao do tipo de personagem Chefe,
 * sua implementação tem como funcionalidade possibilitar a diferenca no status vida
 * uma vez que eh um tipo de npc do jogo que possuira um pokemon com vida especial 
 * para suas batalhas.
 * 
 * @author Patrick Leite
 * @version 2023/12/03
 */
package personagem;

public class InimigoChefe extends Treinador {
    /**
     * @param nome dita o nome dos npcs chefes que habitam o mapa
     */
    public InimigoChefe(String nome) {
        super(nome);
        this.getPokemon().setVida(calculaVida());
    }

    /**
     * Estabelece o aumento de vida do pokemon do chefe baseado na vida base de todo
     * pokemon.
     * 
     * @return A vida final do pokemon do Chefe
     */
    @Override
    public int calculaVida() {
        return super.getVidaBasePokemon() + 200;
    }

}
