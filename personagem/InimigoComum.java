package personagem;

public class InimigoComum extends Treinador{

    public InimigoComum(){
        this.getPokemon().setVida(calculaVida());
    }

    @Override
    public int calculaVida() {
        return super.getVidaBasePokemon() + 100;
    }

}
