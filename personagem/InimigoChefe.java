package personagem;

import batalha.Pokemon;

public class InimigoChefe extends Treinador{

    public InimigoChefe(){
        this.getPokemon().setVida(calculaVida());
    }
    @Override
    public int calculaVida() {
        return super.getVidaBasePokemon() + 200;
    }

}
