package personagem;

import batalha.Pokemon;

public abstract class Treinador implements Personagem{

    private static final int vidaBasePokemon = 500;
    private Pokemon pokemon;

    public Treinador(){
        this.pokemon = new Pokemon(0);
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public int getVidaBasePokemon() {
        return vidaBasePokemon;
    }

    @Override
    public abstract int calculaVida();

}
