package personagem;

public class InimigoChefe extends Treinador{

    public InimigoChefe(String nome){
        super(nome);
        this.getPokemon().setVida(calculaVida());
    }

    @Override
    public int calculaVida() {
        return super.getVidaBasePokemon() + 200;
    }

}
