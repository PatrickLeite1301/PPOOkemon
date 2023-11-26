package personagem;

import batalha.Pokemon;

public class Jogador extends Treinador{

    private int qtdDeRevives;

    public Jogador(){
        qtdDeRevives = 0;
    }

    @Override
    public int calculaVida() {
        return 300;
    }
}
