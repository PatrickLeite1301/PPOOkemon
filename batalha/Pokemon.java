package batalha;

import java.util.List;

public class Pokemon {

    private String nome;
    private int pontosDeVida;
    private List<Ataque> ataques;

    public Pokemon(String nome, int pontosDeVida, List<Ataque> ataques) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.ataques = ataques;
    }
    
}
