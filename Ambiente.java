import java.util.HashMap;
import java.util.Set;

/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe eh parte da aplicacao "World of Zuul".
 * "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localizacao no cenario do jogo. Ele eh
 * conectado aos outros ambientes atraves de saidas. As saidas sao
 * nomeadas como norte, sul, leste e oeste. Para cada direcao, o ambiente
 * guarda uma referencia para o ambiente vizinho, ou null se nao ha
 * saida naquela direcao.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido por Julio Cesar Alves)
 * @version 2011.07.31 (2016.02.01)
 */
public class Ambiente 
{
    private String descricao;
    private HashMap<String, Ambiente> saidas;

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele
     * nao tem saidas. "descricao" eh algo como "uma cozinha" ou
     * "
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "um jardim aberto".
     * @param descricao A descricao do ambiente.
     */
    public Ambiente(String descricao) 
    {
        this.descricao = descricao;
        saidas = new HashMap<>();
    }

    /**
     * Define as saidas do ambiente. Cada direcao ou leva a um
     * outro ambiente.
     */
    public void ajustarSaidas(String direcao, Ambiente ambiente)
    {
        saidas.put(direcao, ambiente);
    }

    /**
     * @return A descricao do ambiente.
     */
    public String getDescricaoCurta()
    {
        return descricao;
    }

    //pega uma descricao mais completa
    public String getDescricaoCompleta()
    {
        return descricao + ".\n" + getExitsString();
    }

    /**
     * @return A descricao das saidas do ambiente, por exemplo
     * "Saidas: norte oeste".
     */
    private String getExitsString()
    {
        String stringResposta = "Saidas:";
        Set<String> chaves = saidas.keySet();
        for(String saida : chaves) {
            stringResposta += " " + saida;
        }

        return stringResposta;
    }

    /**
     * Retorna o ambiente que eh alcancavel a partir desta direcao.
     * Se nao ha saida, retorna null.
     * @param direcao A direcao da saida.
     * @return O ambiente naquela direcao.
     */

    public Ambiente getSaida(String direcao)
    {
        return saidas.get(direcao);
    }

}
