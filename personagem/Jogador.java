package personagem;

import batalha.Pokemon;

public class Jogador extends Treinador{

    private int qtdDeRevives;

    public Jogador(){
        this.getPokemon().setVida(calculaVida());
        qtdDeRevives = 0;
    }

    @Override
    public int calculaVida() {
        return super.getVidaBasePokemon();
    }
}
