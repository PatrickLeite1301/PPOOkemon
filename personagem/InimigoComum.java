package personagem;

public class InimigoComum extends Treinador {

    public InimigoComum(String nome) {
        super(nome);
        this.getPokemon().setVida(calculaVida());
    }

    @Override
    public int calculaVida() {
        return super.getVidaBasePokemon() - 300;
    }

}
