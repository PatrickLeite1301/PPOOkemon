import personagem.Jogador;
import personagem.Personagem;

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
    private TelaPrincipal telaPrincipal;

    private Personagem jogador;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() {
        criarAmbientes();
        analisador = new Analisador();
        telaPrincipal = new TelaPrincipal();
        jogador = new Jogador();
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente entrada, corredorEntrada, salaTreinador1, corredorEsquerda, salaSulCorredorEsquerdo,
                salaOesteCorredorEsquerdo, salaEasterEgg,
                corredorDireita, salaTreinador2, salaTreinador3, salaVazia, salaPocao, salaTreinador4, salaTreinador5,
                corredorFinal, salaLider;

        // cria os ambientes
        entrada = new Ambiente("entrada do ginásio");
        corredorEntrada = new Ambiente("corredor longo perto da entrada");
        salaTreinador1 = new Ambiente("primeira sala que você encontra no ginásio");
        corredorEsquerda = new Ambiente("um corredor que parece se aproximar de uma parte não muito utilizada do ginásio");
        salaSulCorredorEsquerdo = new Ambiente("uma sala que você encontra no meio do corredor");
        salaOesteCorredorEsquerdo = new Ambiente("uma sala não muito utilizada do ginásio");
        salaEasterEgg = new Ambiente("você percebe uma aura esquisita nesta sala, há a presença de alguem mais forte aqui");
        corredorDireita = new Ambiente("um corredor que parece se aproximar das profundezas do ginásio");
        salaTreinador2 = new Ambiente("uma sala mão muito larga com marcas de caixas no chão");
        salaTreinador3 = new Ambiente("uma sala limpa e espaçosa");
        salaVazia = new Ambiente("uma sala completamente vazia");
        salaPocao = new Ambiente("uma sala repleta de caixas");
        salaTreinador4 = new Ambiente("uma sala grande mas sem muita graça");
        salaTreinador5 = new Ambiente("uma sala pequena e com bastante poeira");
        corredorFinal = new Ambiente("uma escadaria que sobe até uma sala iluminada");
        salaLider = new Ambiente("esta é claramente a sala do lider do ginasio");

        // inicializa as saidas dos ambientes
        entrada.ajustarSaidas("norte", corredorEntrada);

        corredorEntrada.ajustarSaidas("norte", salaTreinador1);
        corredorEntrada.ajustarSaidas("sul", entrada);

        salaTreinador1.ajustarSaidas("oeste", corredorEsquerda);
        salaTreinador1.ajustarSaidas("leste", corredorDireita);
        salaTreinador1.ajustarSaidas("sul", corredorEntrada);

        corredorEsquerda.ajustarSaidas("oeste", salaOesteCorredorEsquerdo);
        corredorEsquerda.ajustarSaidas("sul", salaSulCorredorEsquerdo);
        corredorEsquerda.ajustarSaidas("leste", salaTreinador1);

        salaOesteCorredorEsquerdo.ajustarSaidas("norte", salaEasterEgg);
        salaOesteCorredorEsquerdo.ajustarSaidas("leste", corredorEsquerda);

        salaSulCorredorEsquerdo.ajustarSaidas("norte", corredorEsquerda);

        salaEasterEgg.ajustarSaidas("sul", salaOesteCorredorEsquerdo);

        corredorDireita.ajustarSaidas("oeste", salaTreinador1);
        corredorDireita.ajustarSaidas("sul", salaTreinador2);
        corredorDireita.ajustarSaidas("norte", salaTreinador3);
        corredorDireita.ajustarSaidas("leste", salaVazia);

        salaTreinador2.ajustarSaidas("norte", corredorDireita);
        salaTreinador2.ajustarSaidas("sul", salaPocao);

        salaPocao.ajustarSaidas("norte", salaTreinador2);

        salaTreinador3.ajustarSaidas("leste", corredorFinal);
        salaTreinador3.ajustarSaidas("oeste", salaTreinador4);
        salaTreinador3.ajustarSaidas("sul", corredorDireita);

        salaVazia.ajustarSaidas("oeste", corredorDireita);
        salaVazia.ajustarSaidas("norte", corredorFinal);

        salaTreinador4.ajustarSaidas("leste", salaTreinador3);

        corredorFinal.ajustarSaidas("leste", salaTreinador5);
        corredorFinal.ajustarSaidas("sul", salaVazia);
        corredorFinal.ajustarSaidas("oeste", salaTreinador3);
        corredorFinal.ajustarSaidas("norte", salaLider);

        salaTreinador5.ajustarSaidas("oeste", corredorFinal);

        salaLider.ajustarSaidas("sul", corredorFinal);

        ambienteAtual = entrada; // O jogo comeca do lado na entrada
    }

    // Rotina principal do jogo. Fica em loop ate terminar o jogo.
    public void jogar() {
        imprimirBoasVindas();
        //telaPrincipal.definirAtaques(jogador); // Ainda não implementado
        telaPrincipal.exibir(this);
    }

    // Mostra a mensagem de abertura na tela
    private void imprimirBoasVindas() {
        telaPrincipal.definirTexto("Bem-vindo ao PPOOkémon!\n"
                + "PPOOkémon eh um novo jogo de acao e aventura, baseado em jogos da franquia original.\n"
                + "Digite 'ajuda' se voce precisar de ajuda.\n" 
                + ambienteAtual.getDescricaoCompleta());
    }

    // Dado um comando, processa-o (ou seja, executa-o). @param comando é o Comando a ser processado. @return true se o comando finaliza o jogo.
    // Precisa ajustar
    private boolean processarComando(Comando comando) {
        boolean querSair = false;

        if (comando.ehDesconhecido()) {
            telaPrincipal.definirTexto("Eu nao entendi o que voce disse...");
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
    /**
     * Printe informacoes de ajuda.
     * Aqui nos imprimimos algo bobo e enigmatico e a lista de
     * palavras de comando
     */
    private void imprimirAjuda() {
        telaPrincipal.definirTexto("Voce esta perdido. Voce esta sozinho. Voce caminha pela universidade.\n" + "Suas palavras de comando sao: " + analisador.imprimirComandosValidos());
    }

    /**
     * Tenta ir em uma direcao. Se existe uma saida entra no
     * novo ambiente, caso contrario imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos pra onde ir...
            telaPrincipal.adicionarTexto("Ir pra onde?");
            return;
        }
        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getSaida(direcao);
        if (proximoAmbiente == null) {
            telaPrincipal.adicionarTexto("Nao ha uma porta!");
        } else {
            ambienteAtual = proximoAmbiente;
            telaPrincipal.definirTexto(ambienteAtual.getDescricaoCompleta());
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
            telaPrincipal.adicionarTexto("Sair o que?");
            return false;
        } else {
            return true; // sinaliza que nos queremos sair
        }
    }

    public void tratarComando(String comandoTratado){
        boolean terminado = false;
        Comando comando = analisador.pegarComando(comandoTratado);
        terminado = processarComando(comando);
        if(terminado){
            System.exit(0);
        }
    }
}
