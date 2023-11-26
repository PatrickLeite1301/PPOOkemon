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

    private HashMap<Integer,Ataque> iniciaAtaques(String[] campos){
        HashMap<Integer, Ataque> hm = new HashMap<>();

        for(int i = 1; i <= 4; i++){
            hm.put(i, new Ataque(campos[i*2-1], Integer.parseInt(campos[i*2])));
        }

        return hm;
    }

    @Override
    public String toString(){
        return "Nome: "+ nome + "Vida: "+ vida + "Ataques : \n" + ataques.get(1).toString() + "\n" + ataques.get(2).toString() + "\n" + ataques.get(3).toString() + "\n" + ataques.get(4).toString() + "\n";
    }

    
}
