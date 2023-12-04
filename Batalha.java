import java.util.Random;

/**
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores.
 * 
 * Essa classe é a classe para quando há uma batalha entre dois pokemons
 * aqui é visto quem será o ganhador e executa os turnos da batalha assim como
 * o resultado da pocao que pode ser aplicado ao fim da batalha
 * 
 * @author Gustavo Biaso
 * @version 2023.12.03
 */
public class Batalha {

    /**
     * É chamada a cada vez que um ataque for utilizado, a escolha de um ataque pelo
     * jogador inicia aquele "turno" do combate, a batalhar ira apenas trazer ambos os
     * turnos assim como trazer o resultado
     * 
     * @param jogador Pokemon do jogador que ira batalhar
     * @param oponente Pokemon do oponento do jogador que ira batalhar
     * @param ataque Inteiro representando qual o ataque que sera usado (1 - 4)
     * 
     * @return Valor que indica o resultado que o duelo teve (0 - ainda nao terminou o combate, 1 - Vencido, 2 - Derrota, 3 - Vitoria com cura da pocao)
     */
    public static int batalhar(Pokemon jogador, Pokemon oponente, int ataque) {

        executarTurnoJogador(jogador, oponente, ataque);
        if (checaVencedor(jogador, oponente) == 0) {
            executarTurnoOponente(oponente, jogador);
        } else {
            if (recebePocao(jogador)) {
                return 3;
            }
        }

        return checaVencedor(jogador, oponente);
    }

    /**
     * Executa o ataque do pokemon do jogador ao pokemon do oponente, tambem e
     * escolhido qual o ataque que sera usado
     * 
     * @param pokemon1 Pokemon que fara o ataque
     * @param pokemon2 Pokemon que sofre o ataque
     * @param ataque Inteiro representando o ataque escolhido pelo jogador
     */
    public static void executarTurnoJogador(Pokemon pokemon1, Pokemon pokemon2, int ataque) {
        pokemon1.atacar(ataque, pokemon2);
    }

    /**
     * Executa o ataque do oponete ao pokemon do jogador, o ataque do oponente e
     * escolhido aleatoriamente
     *
     * @param pokemon1 Pokemon que fara o ataque
     * @param pokemon2 Pokemon que sofre o ataque
     */
    public static void executarTurnoOponente(Pokemon pokemon1, Pokemon pokemon2) {
        Random random = new Random();
        pokemon1.atacar(random.nextInt(1, 5), pokemon2);
    }

    /**
     * Faz uma checagem e retorna um inteiro representando quem e o ganhador
     * usada na funcao de batalhar para ver se o proximo ataque deveria ser feito
     * 
     * @param jogador Pokemon do jogador
     * @param oponente Pokemon do oponente
     * 
     * @return Quem foi o vencedor da batalha
     */
    private static int checaVencedor(Pokemon jogador, Pokemon oponente) {
        if (jogador.getVida() <= 0) {
            return 2;
        } else if (oponente.getVida() <= 0) {
            return 1;
        }
        return 0;
    }

    /**
     * Funcao que checa se o jogador recebeu uma pocao ao finalizar a batalha
     * Se o jogador ganha a batalha a pocao e utilizada naquele mesmo instante
     * 
     * @param jogador Pokemon do jogador
     * 
     * @return Se o oponente deixou cair uma pocao ou nao
     */
    private static boolean recebePocao(Pokemon jogador) {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            jogador.setVida(jogador.getVida() + 200);
            return true;
        }
        return false;
    }
}
