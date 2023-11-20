/**
 * Essa eh a classe principal da aplicacao "World of Zull".
 * "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.
 * Usuarios podem caminhar em um cenario. E eh tudo! Ele realmente
 * precisa ser estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 * "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os
 * ambientes, cria o analisador e comeca o jogo. Ela tambeme avalia e
 * executa os comandos que o analisador retorna.
 * 
 * @author Michael Kölling and David J. Barnes (traduzido por Julio Cesar Alves)
 * @version 2011.07.31 (2016.02.01)
 */

public class Jogo {
    private Analisador analisador;
    private Ambiente ambienteAtual;

    // Inicializador do jogo
    public Jogo() {
        criarAmbientes();
        analisador = new Analisador();
    }

    // Criando os ambientes
    private void criarAmbientes() {
        Ambiente entrada, fora, anfiteatro, cantina, laboratorio, escritorio;

        // cria os ambientes
        fora = new Ambiente("do lado de fora da entrada principal de uma universidade");
        entrada = new Ambiente("aqui é a entrada do ginásio");
        anfiteatro = new Ambiente("no anfiteatro");
        cantina = new Ambiente("na cantina do campus");
        laboratorio = new Ambiente("no laboratorio de computacao");
        escritorio = new Ambiente("na sala de administracao dos computadores");

        // inicializa as saidas dos ambientes
        // fora.ajustarSaidas(null, anfiteatro, laboratorio, cantina);
        // fora.ajustarSaida("norte", escritorio);
        // anfiteatro.ajustarSaidas(null, null, null, fora);
        // cantina.ajustarSaidas(null, fora, null, null);
        // laboratorio.ajustarSaidas(fora, escritorio, null, null);
        // escritorio.ajustarSaidas(null, null, null, laboratorio);

        ambienteAtual = entrada; // o jogo comeca pela entrada
    }

    // Looping inicial
    public void jogar() {
        imprimirBoasVindas();
        boolean terminado = false;
        while (!terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
    }

    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Este e PPOOkemon!");
        System.out.println("Um jogo completamente inovador e extremamente divertido.");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();
        imprimirSaidas();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * 
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) {
        boolean querSair = false;

        if (comando.ehDesconhecido()) {
            System.out.println("Nao foi possivel entender o que foi dito.");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        } else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        } else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }

        return querSair;
    }

    // Implementacoes dos comandos do usuario

    // Imprime as saidas disponiveis
    private void imprimirSaidas() {
        System.out.println("Voce esta " + ambienteAtual.getDescricao());

        System.out.print("Saidas: ");
        if (ambienteAtual.getSaida("norte") != null) {
            System.out.print("norte ");
        }
        if (ambienteAtual.getSaida("leste") != null) {
            System.out.print("leste ");
        }
        if (ambienteAtual.getSaida("sul") != null) {
            System.out.print("sul ");
        }
        if (ambienteAtual.getSaida("oeste") != null) {
            System.out.print("oeste ");
        }
        System.out.println();
    }

    // Ajuda o usuario
    private void imprimirAjuda() {
        System.out.println("Voce precisa de ajuda?");
        System.out.println("Suas palavras de comando sao:");
        System.out.println("ir - sair - ajuda");
    }

    // Vai até um proximo ambiente
    private void irParaAmbiente(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            // A segunda palavra indica o lugar
            System.out.println("Ir pra onde?");
            return;
        }
        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;
        if (direcao.equals("norte")) {
            proximoAmbiente = ambienteAtual.getSaida("norte");
        }
        if (direcao.equals("leste")) {
            proximoAmbiente = ambienteAtual.getSaida("leste");
        }
        if (direcao.equals("sul")) {
            proximoAmbiente = ambienteAtual.getSaida("sul");
        }
        if (direcao.equals("oeste")) {
            proximoAmbiente = ambienteAtual.getSaida("oeste");
        }

        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        } else {
            ambienteAtual = proximoAmbiente;

            imprimirSaidas();
        }
    }

    /**
     * "Sair" foi digitado. Verifica o resto do comando pra ver
     * se nos queremos realmente sair do jogo.
     * 
     * @return true, se este comando sai do jogo, false, caso contrario
     */
    private boolean sair(Comando comando) {
        if (comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        } else {
            return true; // Fim de jogo
        }
    }
}
