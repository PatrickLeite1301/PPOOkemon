/**
 * Essa eh a classe principal da aplicacao "PPOOkemon".
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 * "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os
 * ambientes, cria o analisador e comeca o jogo. Ela tambeme avalia e
 * executa os comandos que o analisador retorna.
 * 
 * @author Danilo Chagas, Gustavo Pinto e Patrick Leite
 * @version 2023.12.03
 */

public class Jogo {
    private Analisador analisador; // analisa os comandos
    private Ambiente ambienteAtual; // guarda o ambiente atual
    private TelaPrincipal telaPrincipal; // tela principal do jogo
    private Personagem jogador; // jogador do jogo

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() {
        criarAmbientes();
        analisador = new Analisador();
        telaPrincipal = new TelaPrincipal();
        jogador = new Jogador("Você");
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
        entrada = new Ambiente("Entrada do ginásio");
        corredorEntrada = new Ambiente("Corredor longo perto da entrada");
        salaTreinador1 = new Ambiente("Primeira sala que você encontra no ginásio", new InimigoComum("Paula"));
        corredorEsquerda = new Ambiente(
                "Um corredor que parece se aproximar de uma parte não muito utilizada do ginásio");
        salaSulCorredorEsquerdo = new Ambiente("Uma sala que você encontra no meio do corredor",
                new InimigoComum("Renato"));
        salaOesteCorredorEsquerdo = new Ambiente("Uma sala não muito utilizada do ginásio");
        salaEasterEgg = new Ambiente(
                "Você percebe uma aura esquisita nesta sala, há a presença de alguem mais forte aqui",
                new InimigoChefe("Joaquim"));
        corredorDireita = new Ambiente("Um corredor que parece se aproximar das profundezas do ginásio");
        salaTreinador2 = new Ambiente("Uma sala mão muito larga com marcas de caixas no chão",
                new InimigoComum("Denilson"));
        salaTreinador3 = new Ambiente("Uma sala limpa e espaçosa", new InimigoComum("Mayron"));
        salaVazia = new Ambiente("Uma sala completamente vazia");
        salaPocao = new Ambiente("Uma sala repleta de caixas");
        salaTreinador4 = new Ambiente("Uma sala grande mas sem muita graça", new InimigoComum("Ricardo Terra"));
        salaTreinador5 = new Ambiente("Uma sala pequena e com bastante poeira", new InimigoComum("Ana Paula"));
        corredorFinal = new Ambiente("Uma escadaria que sobe até uma sala iluminada");
        salaLider = new Ambiente("Esta é claramente a sala do lider do ginasio",
                new InimigoChefe("Luiz Henrique Mershmann"));

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

    /**
     * Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() {
        imprimirBoasVindas();
        telaPrincipal.definirAtaques(jogador.getPokemon().dadosAtaques());
        telaPrincipal.definirPokemon(jogador.getPokemon().dadosPokemon());
        telaPrincipal.exibir(this);
    }

    /**
     * Mostra a mensagem de abertura na tela
     */
    private void imprimirBoasVindas() {
        telaPrincipal.definirTexto("Bem-vindo ao PPOOkémon!\n"
                + "PPOOkémon eh um novo jogo de acao e aventura, baseado em jogos da franquia original.\n"
                + "Explore o ginásio, encontre o líder e seja um aluno vitorioso de PPOO!\n"
                + ambienteAtual.getDescricaoCompleta());
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o).
     * @param comando o Comando a ser processado.
     * @return true se o comando finaliza o jogo, false caso contrario.
     */
    private boolean processarComando(Comando comando) {
        boolean querSair = false;

        if (comando.ehDesconhecido()) {
            telaPrincipal
                    .definirTexto("Eu nao entendi o que voce disse..." + "\n" + ambienteAtual.getDescricaoCompleta());
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

    /**
     * Printa informacoes de ajuda.
     * Aqui nos imprimimos a descricao do local
     *  e a lista de palavras de comando
     */
    private void imprimirAjuda() {
        telaPrincipal.definirTexto("Voce esta perdido. Voce caminha pelo ginásio.\n" + "Suas palavras de comando sao: "
                + analisador.imprimirComandosValidos() + "\n" + ambienteAtual.getDescricaoCurta());
    }

    /**
     * Tenta ir em uma direcao. Se existe uma saida entra no
     * novo ambiente, caso contrario imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos pra onde ir...
            telaPrincipal.definirTexto("Ir pra onde?" + "\n" + ambienteAtual.getDescricaoCompleta());
            return;
        }

        String direcao = comando.getSegundaPalavra();
        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getSaida(direcao);
        if (proximoAmbiente == null) {
            telaPrincipal.adicionarTexto("Nao ha uma porta!");
        } else {
            ambienteAtual = proximoAmbiente;
            if (ambienteAtual.temTreinador()) {
                iniciarBatalha();
            } else {
                apresentarAmbiente();
            }
        }
    }

    /**
     * Apresenta o ambiente atual na tela
     */
    public void apresentarAmbiente() {
        telaPrincipal.definirTexto(ambienteAtual.getDescricaoCompleta());
    }

    /**
     * Inicia uma batalha com o treinador do ambiente atual
     */
    private void iniciarBatalha() {
        Personagem oponente = ambienteAtual.getPersonagem();
        telaPrincipal.definirTexto("\n" + oponente.getNome() + " te desafia para uma batalha! \n"
                + oponente.getNome() + " tem um " + oponente.getPokemon().getNome());

        telaPrincipal.definirPokemonOponente(oponente.getPokemon().dadosPokemon());
        telaPrincipal.janelaDeBatalha();
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

    /**
     * Trata o comando digitado pelo usuario
     * @param comandoTratado o comando digitado pelo usuario
     */
    public void tratarComando(String comandoTratado) {
        boolean terminado = false;
        Comando comando = analisador.pegarComando(comandoTratado);
        terminado = processarComando(comando);
        if (terminado) {
            System.exit(0);
        }
    }

    /**
     * Retorna o oponente do jogador
     * @return o oponente do jogador
     */
    public Personagem getOponente(){
        return ambienteAtual.getPersonagem();
    }

    /**
     * Retorna o pokemon do jogador
     * @return o pokemon do jogador
     */
    public Pokemon getPokemonJogador() {
        return jogador.getPokemon();
    }

    /**
     * Retorna o pokemon do oponente
     * @return o pokemon do oponente
     */
    public Pokemon getPokemonOponente() {
        return ambienteAtual.getPersonagem().getPokemon();
    }
}
