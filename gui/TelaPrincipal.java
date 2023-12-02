package gui;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal {

    JFrame janela;
    JTextField campoComando;
    JButton botaoConfirmar;

    JLabel mapa;


    public TelaPrincipal(){
        janela = new JFrame("PPOOkemon");
        campoComando = new JTextField();
        botaoConfirmar = new JButton("Confirmar");
        mapa = new JLabel(new ImageIcon("gui/mapa.jpg"), SwingConstants.CENTER);
        montarJanela();
    }

    public void exibir(){
        janela.setVisible(true);
    }

    private void montarJanela(){
        // Configurações da janela total
        janela.setSize(1200, 900);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout());

        //Configurações do painel Esquerdo
        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setLayout(new FlowLayout());
        painelEsquerdo.add(new JLabel("Pikachu"));
        janela.add(painelEsquerdo, BorderLayout.WEST);

        //Configurações do painel Central
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new FlowLayout());
        painelCentral.add(mapa);
        janela.add(painelCentral, BorderLayout.CENTER);

        //Configurações do painel Direito
        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new FlowLayout());
        painelDireito.add(new JLabel("Ataques"));
        janela.add(painelDireito, BorderLayout.EAST);

        //Configurações do painel Inferior
        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.Y_AXIS));
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new BoxLayout(painelEntrada, BoxLayout.X_AXIS));
        painelEntrada.add(campoComando);
        painelEntrada.add(botaoConfirmar);

        painelInferior.add(new JLabel("VOCE ESTA NO LUGAR PEIDOKKKKKKKKKKKKKKKK"));
        painelInferior.add(new JLabel("VOCE ESTA NO LUGAR PEIDOKKKKKKKKKKKKKKKK"));
        painelInferior.add(new JLabel("VOCE ESTA NO LUGAR PEIDOKKKKKKKKKKKKKKKK"));
        painelInferior.add(new JLabel("VOCE ESTA NO LUGAR PEIDOKKKKKKKKKKKKKKKK"));
        painelInferior.add(new JLabel("VOCE ESTA NO LUGAR PEIDOKKKKKKKKKKKKKKKK"));
        painelInferior.add(painelEntrada);
        janela.add(painelInferior, BorderLayout.SOUTH);


    }

}
