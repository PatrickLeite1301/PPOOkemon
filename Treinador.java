/**
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores.
 * 
 * Essa eh a classe responsável por definir a criacao do tipo de treinadores,
 * treinador se refere a qualquer participante do jogo, tanto usuario quanto
 * npcs que estarao pelo mapa.
 * 
 * @author Patrick Leite
 * @version 2023/12/03
 */

public abstract class Treinador implements Personagem {

    private static final int vidaBasePokemon = 500;

    private String nome;

    private Pokemon pokemon;

    /**
     * @param nome define o nome de qualquer treinador instanciado
     */
    public Treinador(String nome) {
        this.nome = nome;
        this.pokemon = new Pokemon(vidaBasePokemon);
    }

    /**
     * Estabelece um meio de acessar o pokemon de um treinador
     * 
     * @return pokemon com todos seus atributos
     */
    @Override
    public Pokemon getPokemon() {
        return pokemon;
    }

    /**
     * Estabelece um meio de acessar o status de vida do pokemon de um treinador
     * 
     * @return quantidade de vida padrao de qualquer pokemon criado
     */
    public int getVidaBasePokemon() {
        return vidaBasePokemon;
    }

    /**
     * Estabelece um meio de acessar o nome do pokemon de um treinador
     * 
     * @return nome do pokemon
     */
    @Override
    public String getNome() {
        return nome;
    }
}
