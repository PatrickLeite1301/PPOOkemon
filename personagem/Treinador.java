package personagem;

import batalha.Pokemon;

public abstract class Treinador implements Personagem{

    private Pokemon pokemon;

    public Treinador(){
        this.pokemon = new Pokemon();
    }

    @Override
    public abstract int calculaVida();


}
