package batalha;

import java.util.Random;

public class Batalha {


    public static void executarTurnoJogador(Pokemon pokemon1, Pokemon pokemon2, int ataque){
        pokemon1.atacar(ataque, pokemon2);
    }

    public static void executarTurnoOponente(Pokemon pokemon1, Pokemon pokemon2){
        Random random = new Random();
        pokemon1.atacar(random.nextInt(1,5), pokemon2);
    }
}
