package personagem;

import batalha.Pokemon;

public abstract class Treinador implements Personagem{

    private Pokemon pokemon;

    @Override
    public abstract int calculaVida();
}
