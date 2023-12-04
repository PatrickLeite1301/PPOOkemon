/**
 * Essa classe guarda informacoes sobre um comando que foi digitado pelo
 * usuario. Um comando atualmente consiste em duas strings: uma palavra
 * de comando e uma segunda palavra (por exemplo, se o campo for "pegar
 * mapa", entao as duas strings obviamente serao "pegar" e "mapa").
 *
 * Isso eh usado assim: comandos ja estao validados como comandos validos
 * Se o usuario entrou um comando invalido (uma palavra que nao eh
 * conhecida) entao o a palavra de comando eh <null>.
 *
 * Se o comando tem so uma palavra, a segunda palavra eh <null>
 *
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores
 *
 * Essa classe guarda uma enumeracao de todos os comandos conhecidos do
 * jogo. Ela eh usada no reconhecimento de comandos como eles sao digitados.
 *
 * @author Gustavo Pinto
 * @version 2023.12.03
 */

public class Comando {
    private String palavraDeComando; // guarda a primeira palavra do comando
    private String segundaPalavra; // guarda a segunda palavra do comando

    /**
     * Cria um objeto comando. Primeira e segunda palavra devem ser
     * fornecidas, mas qualquer uma (ou ambas) podem ser null.
     * 
     * @param primeiraPalavra A primeira palavra do comando. Null se
     *                        o comando nao foi reconhecido
     * @param segundaPalavra  A segunda palavra do comando.
     */
    public Comando(String primeiraPalavra, String segundaPalavra) {
        palavraDeComando = primeiraPalavra;
        this.segundaPalavra = segundaPalavra;
    }

    /**
     * Retorna a palavra de comando (a primeira palavra) deste comando.
     * Se o comando nao foi entendido, o resultado eh null.
     * 
     * @return A palavra de comando.
     */
    public String getPalavraDeComando() {
        return palavraDeComando;
    }

    /**
     * @return A segunda palavra deste comando. Retorna null se
     *         nao existe segunda palavra.
     */
    public String getSegundaPalavra() {
        return segundaPalavra;
    }

    /**
     * @return true se o comando nao foi entendido.
     */
    public boolean ehDesconhecido() {
        return (palavraDeComando == null);
    }

    /**
     * @return true se o comando tem uma segunda palavra.
     */
    public boolean temSegundaPalavra() {
        return (segundaPalavra != null);
    }
}
