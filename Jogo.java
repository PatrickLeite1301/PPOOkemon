/**
 *  Essa eh a classe principal da aplicacao "World of Zull".
 *  "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.
 *  Usuarios podem caminhar em um cenario. E eh tudo! Ele realmente
 *  precisa ser estendido para fazer algo interessante!
 * 
 *  Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 *  "jogar".
 * 
 *  Essa classe principal cria e inicializa todas as outras: ela cria os
 *  ambientes, cria o analisador e comeca o jogo. Ela tambeme avalia e 
 *  executa os comandos que o analisador retorna.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido por Julio Cesar Alves)
 * @version 2011.07.31 (2016.02.01)
 */

public class Jogo 
{
    private Analisador analisador;
    private Ambiente ambienteAtual;
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() 
    {
        criarAmbientes();
        analisador = new Analisador();
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes()
    {
        Ambiente entrada, corredorEntrada, salaTreinador1, corredorEsquerda, salaSulCorredorEsquerdo, salaOesteCorredorEsquerdo, salaEasterEgg,
        corredorDireita, salaTreinador2, salaTreinador3, salaVazia, salaPocao, salaTreinador4, salaTreinador5, corredorFinal, salaLider;
      
        // cria os ambientes
        entrada = new Ambiente("entrada do ginásio");
        corredorEntrada = new Ambiente("corredor longo perto da entrada");
        salaTreinador1 = new Ambiente("primeira sala que você encontra no ginásio");
        corredorEsquerda = new Ambiente("um corredor que parece se aproximar de uma parte não muito utilizada do ginásio");
        salaSulCorredorEsquerdo = new Ambiente("primeira sala que você encontra no ginásio");
        salaOesteCorredorEsquerdo = new Ambiente("um corredor que parece se aproximar de uma parte não muito utilizada do ginásio");
        salaEasterEgg = new Ambiente("você percebe uma aura esquisita nesta sala, há a presença de alguem mais forte aqui");
        corredorDireita = new Ambiente("um corredor que parece se aproximar das profundezas do ginásio");
        salaTreinador2 = new Ambiente("uma sala mão muito larga com marcas de caixas no chão");
        salaTreinador3 = new Ambiente("uma sala limpa e espaçosa");
        salaVazia = new Ambiente("uma sala completamente vazia");
        salaPocao = new Ambiente("uma sala repleta de caixas");
        salaTreinador4 = new Ambiente("uma sala grande mas sem muita graça");
        salaTreinador5  = new Ambiente("uma sala pequena e com bastante poeira");
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

        ambienteAtual = entrada;  // o jogo comeca do lado na entrada
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() 
    {            
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os executamos ate o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas()
    {
        System.out.println();
        System.out.println("Bem-vindo ao PPOOkémon!");
        System.out.println("PPOOkémon eh um novo jogo de acao e aventura, baseado em jogos da franquia original.");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();
        System.out.println("Voce esta " + ambienteAtual.getDescricaoCompleta());
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) 
    {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("sair")) {
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
    private void imprimirAjuda() 
    {
        System.out.println("Voce esta perdido. Voce esta sozinho. Voce caminha");
        System.out.println("pela universidade.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        analisador.imprimirComandosValidos();
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saida entra no 
     * novo ambiente, caso contrario imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando) 
    {
        if(!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos pra onde ir...
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getSaida(direcao);

        if (proximoAmbiente == null) {
            System.out.println("Nao ha uma porta!");
        }
        else {
            ambienteAtual = proximoAmbiente;
            System.out.println(ambienteAtual.getDescricaoCompleta());
        }

    }

    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver
     * se nos queremos realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrario
     */
    private boolean sair(Comando comando) 
    {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nos queremos sair
        }
    }
}
