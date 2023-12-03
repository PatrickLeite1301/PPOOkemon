package personagem;

import batalha.Pokemon;

public interface Personagem {

    int calculaVida();
    Pokemon getPokemon();

    String getNome();
}
