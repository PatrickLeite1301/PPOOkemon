package personagem;

public class Jogador extends Treinador {

    public Jogador(String nome) {
        super(nome);
        this.getPokemon().setVida(calculaVida());
    }

    @Override
    public int calculaVida() {
        return super.getVidaBasePokemon();
    }
}
