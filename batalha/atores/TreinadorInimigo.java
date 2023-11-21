package batalha.atores;

import batalha.Pokemon;

public class TreinadorInimigo extends Treinador{

    boolean possuiPocao;
    boolean possuiReviver;

    public TreinadorInimigo(String nome, Pokemon pokemon, boolean possuiPocao) {
        super(nome, pokemon);
        this.possuiPocao = possuiPocao;
    }
}
