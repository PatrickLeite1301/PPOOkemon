package batalha;

import java.util.Random;

/**
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores.
 * 
 * Essa classe é utilizada para armazenar os ataques que um pokemon tem
 * e também serve para fazer uma tentativa de ataque na hora da batalha
 * 
 * @author Danilo Chagas
 * @version 2023.12.03
 */

public class Ataque {

    private String nome;
    private int dano;
    private int chanceDeAcerto;

    /**
     * Calcula o acerto, usada para inicializar o ataque com o acerto que ele
     * deveria realmente ter
     * @param nome Nome do ataque
     * @param dano Dano do ataque
     */
    public Ataque(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
        this.chanceDeAcerto = calcularAcerto();
    }

    /**
     * Calcula o acerto, usada para inicializar o ataque com o acerto que ele
     * deveria realmente ter
     * 
     * @return Valor de acerto em %
     */
    private int calcularAcerto() {
        if (dano == 20) {
            return 80;
        } else if (dano == 50) {
            return 50;
        } else {
            return 30;
        }
    }

    /**
     * Faz uma tentativa de ataque
     * 
     * @return Dano que ele causa, se for 0 ele errou o ataque
     */
    public int tentarAtacar() {
        Random random = new Random();
        int acerto = random.nextInt(100);
        if (acerto <= chanceDeAcerto) {
            return dano;
        } else {
            return 0;
        }
    }

    /**
     * @return Nome do ataque
     */
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Dano: " + dano + "\n" +
                "Chance de acerto: " + chanceDeAcerto + "%" + "\n";
    }

}
