package batalha;

import java.util.Random;

public class Batalha {

    public static int batalhar(Pokemon jogador, Pokemon oponente, int ataque){
        if(checaVencedor(jogador, oponente) == 0){
            executarTurnoJogador(jogador, oponente, ataque);
        } else {
            return checaVencedor(jogador, oponente);
        }
        if(checaVencedor(jogador, oponente) == 0){
            executarTurnoOponente(jogador, oponente);
        } else {
            return checaVencedor(jogador, oponente);
        }
        return 0;
    }

    public static void executarTurnoJogador(Pokemon pokemon1, Pokemon pokemon2, int ataque){
        pokemon1.atacar(ataque, pokemon2);
    }

    public static void executarTurnoOponente(Pokemon pokemon1, Pokemon pokemon2){
        Random random = new Random();
        pokemon1.atacar(random.nextInt(1,5), pokemon2);
    }

    private static int checaVencedor(Pokemon jogador, Pokemon oponente){
        if(jogador.getVida() <= 0){
            return 1;
        } else if(oponente.getVida() <= 0){
            return 2;
        }
        return 0;
    }
}
