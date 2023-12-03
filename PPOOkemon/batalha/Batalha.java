package batalha;

import java.util.Random;

public class Batalha {

    public static int batalhar(Pokemon jogador, Pokemon oponente, int ataque) {

        executarTurnoJogador(jogador, oponente, ataque);

        if (checaVencedor(jogador, oponente) == 0) {
            executarTurnoOponente(oponente, jogador);
        } else {
            recebePocao(jogador);
            return checaVencedor(jogador, oponente);
        }
        return checaVencedor(jogador, oponente);
    }

    public static void executarTurnoJogador(Pokemon pokemon1, Pokemon pokemon2, int ataque) {
        pokemon1.atacar(ataque, pokemon2);
    }

    public static void executarTurnoOponente(Pokemon pokemon1, Pokemon pokemon2) {
        Random random = new Random();
        pokemon1.atacar(random.nextInt(1, 5), pokemon2);
    }

    private static int checaVencedor(Pokemon jogador, Pokemon oponente) {
        if (jogador.getVida() <= 0) {
            return 2;
        } else if (oponente.getVida() <= 0) {
            return 1;
        }
        return 0;
    }

    private static void recebePocao(Pokemon jogador) {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            jogador.setVida(jogador.getVida() + 200);
        }
    }
}
