package batalha;
import java.util.HashMap;

public class Pokemon {

    private String nome;
    private int vida;
    private HashMap<Integer, Ataque> ataques;

    public Pokemon(int vida) {
        String[] campos = ManipuladorArq.readTxtArq("Pokedex.txt");
        this.nome = campos[0];
        this.ataques = iniciaAtaques(campos);
        this.vida = vida;
    }

    public int getVida(){
        return vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    private HashMap<Integer,Ataque> iniciaAtaques(String[] campos){
        HashMap<Integer, Ataque> hm = new HashMap<>();

        for(int i = 1; i <= 4; i++){
            hm.put(i, new Ataque(campos[i*2-1], Integer.parseInt(campos[i*2])));
        }

        return hm;
    }


    public String dadosPokemon(){
        return "Pokemon: "+ nome + "\n" +
                "Vida: "+ vida + "\n";
    }

    public String dadosAtaques(){
        StringBuilder dados = new StringBuilder();
        for(int i = 1; i <= 4; i++){
            dados.append(i).append(" - ").append(ataques.get(i).toString()).append("\n");
        }
        return dados.toString();
    }

    
}
