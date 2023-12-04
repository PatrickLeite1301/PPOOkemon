/**
 * Classe Ambiente - um ambiente em um jogo do estilo.
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores
 *
 * Um "Ambiente" representa uma localizacao no cenario do jogo. Ele eh
 * conectado aos outros ambientes atraves de saidas. Um ambiente pode ou
 * nao conter um treinador inimigo As saidas sao
 * nomeadas como norte, sul, leste e oeste. Para cada direcao, o ambiente
 * guarda uma referencia para o ambiente vizinho, ou null se nao ha
 * saida naquela direcao.
 *
 * @author Patrick Leite
 * @version 2023.12.03
 */

import personagem.Personagem;

import java.util.HashMap;
import java.util.Set;

public class Ambiente {
    private String descricao; // descricao curta deste ambiente
    private HashMap<String, Ambiente> saidas; // saidas deste ambiente
    private Personagem treinadorInimigo; // treinador inimigo que esta no ambiente

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele
     * nao tem saidas. "descricao" eh algo como "uma sala vazia" ou
     * algo assim.
     *
     * @param descricao A descricao do ambiente.
     */
    public Ambiente(String descricao) {
        this.descricao = descricao;
        saidas = new HashMap<>();
    }

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele
     * nao tem saidas. "descricao" eh algo como "uma sala vazia" ou
     * algo assim. O ambiente em questao possui um treinador inimigo
     *
     * @param descricao A descricao do ambiente.
     * @param treinadorInimigo O treinador inimigo que esta no ambiente
     */
    public Ambiente(String descricao, Personagem treinadorInimigo) {
        this.descricao = descricao;
        saidas = new HashMap<>();
        this.treinadorInimigo = treinadorInimigo;
    }

    /**
     * Define as saidas do ambiente. Cada direcao ou leva a um
     * outro ambiente.
     */
    public void ajustarSaidas(String direcao, Ambiente ambiente) {
        saidas.put(direcao, ambiente);
    }

    /**
     * @return A descricao do ambiente.
     */
    public String getDescricaoCurta() {
        return descricao + ".\n" + getExitsString();
    }

    /**
     * @return A descricao completa do ambiente e suas saidas.
     */
    public String getDescricaoCompleta() {
        return "Digite 'ajuda' se voce precisar de ajuda.\n" + descricao + ".\n" + getExitsString();
    }

    /**
     * @return A descricao das saidas do ambiente, por exemplo
     *         "Saidas: norte oeste".
     */
    private String getExitsString() {
        String stringResposta = "Saidas:";
        Set<String> chaves = saidas.keySet();
        for (String saida : chaves) {
            stringResposta += " " + saida;
        }

        return stringResposta;
    }

    /**
     * Retorna o ambiente que eh alcancavel a partir desta direcao.
     * Se nao ha saida, retorna null.
     * 
     * @param direcao A direcao da saida.
     * @return O ambiente naquela direcao.
     */

    public Ambiente getSaida(String direcao) {
        return saidas.get(direcao);
    }

    /**
     * @return true se o ambiente possui um treinador inimigo
     */
    public boolean temTreinador() {
        return treinadorInimigo != null;
    }

    /**
     * @return O treinador inimigo que esta no ambiente
     */
    public Personagem getPersonagem() {
        return treinadorInimigo;
    }

}
