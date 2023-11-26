package batalha;

public class Ataque {

    private String nome;
    private int dano;
    private int chanceDeAcerto;

    public Ataque(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
        this.chanceDeAcerto = calcularAcerto();
    }

    private int calcularAcerto(){
        if(dano == 20){
            return 80;
        }else if(dano == 50){
            return 50;
        }else{
            return 30;
        }
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "Dano: " + dano;
    }
    
}
