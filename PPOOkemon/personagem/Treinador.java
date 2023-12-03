package personagem;

import batalha.Pokemon;

public abstract class Treinador implements Personagem{

    private static final int vidaBasePokemon = 500;

    private String nome;

    private Pokemon pokemon;

    public Treinador(String nome){
        this.nome = nome;
        this.pokemon = new Pokemon(vidaBasePokemon);
    }

    @Override
    public Pokemon getPokemon() {
        return pokemon;
    }

    public int getVidaBasePokemon() {
        return vidaBasePokemon;
    }

    @Override
    public String getNome(){
        return nome;
    }
}