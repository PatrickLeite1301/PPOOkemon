package personagem;

public class Jogador extends Treinador{

    private int qtdDeRevives;

    public Jogador(String nome){
        super(nome);
        this.getPokemon().setVida(calculaVida());
        qtdDeRevives = 0;
    }

    @Override
    public int calculaVida() {
        return super.getVidaBasePokemon();
    }
}
