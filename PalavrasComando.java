/**
 * Essa eh a classe que administra as palavras de comando da aplicacao.
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores
 *
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 * "jogar".
 *
 * Essa classe guarda uma enumeracao de todos os comandos conhecidos do
 * jogo. Ela eh usada no reconhecimento de comandos como eles sao digitados.
 *
 * @author Danilo Chagas, Gustavo Pinto e Patrick Leite
 * @version 2023.12.03
 */

public class PalavrasComando {
    // um vetor constante que guarda todas as palavras de comandos validas
    private static final String[] comandosValidos = {
            "ir", "sair", "ajuda"
    };

    /**
     * Construtor - inicializa as palavras de comando.
     */
    public PalavrasComando() {
        // nada a fazer no momento...
    }

    /**
     * Verifica se uma dada String eh uma palavra de comando valida.
     * 
     * @return true se a string dada eh um comando valido,
     *         false se nao eh.
     */
    public boolean ehComando(String umaString) {
        for (int i = 0; i < comandosValidos.length; i++) {
            if (comandosValidos[i].equals(umaString))
                return true;
        }
        // se chegamos aqui, a string nao foi encontrada nos comandos.
        return false;
    }

    /**
     * Imprime todos os comandos validos na tela.
     */
    public String mostrarTodos() {
        String comandos = "";
        for (String comando : comandosValidos) {
            comandos += comando + "   ";
        }
        return comandos;
    }
}
