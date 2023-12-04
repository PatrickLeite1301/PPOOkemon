package batalha;

import java.util.HashMap;

/**
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores.
 * 
 * Essa classe é a responsavel por definir os pokemons que sao utilizados pelos treinadores
 * Nela sao armazenados diversos ataques distintos em um Hash
 * Assim como a vida que cada pokemon esta no momento
 * Sera daqui que os pokemons serao usados para a batalha
 * 
 * @author Danilo Chagas
 * @version 2023.12.03
 */
public class Pokemon {

    private String nome;
    private int vida;
    private HashMap<Integer, Ataque> ataques;

    /**
     * @param vida De um pokemon para ser inicializada
     */
    public Pokemon(int vida) {
        String[] campos = ManipuladorArq.readTxtArq("Pokedex.txt");
        this.nome = campos[0];
        this.ataques = iniciaAtaques(campos);
        this.vida = vida;
    }

    /**
     * @return A vida de um pokemon
     */
    public int getVida() {
        return this.vida;
    }

    /**
     * @param vida Altera a vida de um pokemon para essa vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return O nome do pokemon
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Iniciara os ataques para um pokemon para que ele possua diversos deles
     * 
     * @param campos Passa os ataques que serao colocados no pokemon
     */
    private HashMap<Integer, Ataque> iniciaAtaques(String[] campos) {
        HashMap<Integer, Ataque> hm = new HashMap<>();

        for (int i = 1; i <= 4; i++) {
            hm.put(i, new Ataque(campos[i * 2 - 1], Integer.parseInt(campos[i * 2])));
        }

        return hm;
    }

    /**
     * @return Os dados do pokemon (Nome e vida)
     */
    public String dadosPokemon() {
        return "Pokemon: " + this.nome + "\n" +
                "Vida: " + this.vida + "\n";
    }

    /**
     * Constroi uma string com todos os dados dos ataques
     * 
     * @return Os dados dos ataques do pokemon
     */
    public String dadosAtaques() {
        StringBuilder dados = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            dados.append(i).append(" - ").append(ataques.get(i).toString()).append("\n");
        }
        return dados.toString();
    }

    /**
     * Retorna o nome do ataque especificado
     * 
     * @param pos Posicao do ataque que sera usado
     * @return O nome do ataque especifico
     */
    public String dadoAtaqueEspecifico(int pos){
        return ataques.get(pos).getNome();
    }

    /**
     * Essa e a funcao que fara o ataque ao pokemon adversario
     * 
     * @param ataque Qual ataque sera usado (1 - 4)
     * @param pokemon Qual o pokemon que ele atacara
     */
    public void atacar(int ataque, Pokemon pokemon) {
        if (ataque >= 1 && ataque <= 4) {
            pokemon.setVida(pokemon.getVida() - this.ataques.get(ataque).tentarAtacar());
        }
    }

}
