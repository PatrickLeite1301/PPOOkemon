package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal implements ActionListener {

    JFrame janela;
    JTextField campoComando;
    JButton botaoConfirmar;
    JTextArea testando;

    JLabel mapa;

    public TelaPrincipal() {
        janela = new JFrame("PPOOkemon");
        campoComando = new JTextField();
        testando = new JTextArea("");
        botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(this);
        mapa = new JLabel(new ImageIcon("gui/mapa.jpg"), SwingConstants.CENTER);
        montarJanela();
    }

    @Override
    public void actionPerformed(ActionEvent act) {
        if(act.getSource() == botaoConfirmar){
            String comandoDoUsuario = campoComando.getText();
            JOptionPane.showMessageDialog(janela, "Comando do usuario: " + comandoDoUsuario);
            campoComando.setText("");
            testando.setText(comandoDoUsuario);
        }   
    }

    public void exibir() {
        janela.setVisible(true);
    }

    private void montarJanela() {
        // Configurações da janela total
        janela.setSize(1200, 700);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout());

        // Configurações do painel Esquerdo
        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setLayout(new FlowLayout());
        painelEsquerdo.add(new JLabel("Pikachu")); // Mudar o JLabel usado aqui
        janela.add(painelEsquerdo, BorderLayout.WEST);

        // Configurações do painel Central
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new FlowLayout());
        painelCentral.add(mapa);
        janela.add(painelCentral, BorderLayout.CENTER);

        // Configurações do painel Direito
        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new FlowLayout());
        painelDireito.add(new JLabel("Ataques")); // Mudar o JLabel usado aqui
        janela.add(painelDireito, BorderLayout.EAST);
        
        // Painel de entrada de comandos
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new BoxLayout(painelEntrada, BoxLayout.X_AXIS));
        painelEntrada.add(campoComando);
        painelEntrada.add(botaoConfirmar);
        
        // Configurações do painel Inferior
        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.Y_AXIS));
        painelInferior.add(testando);
        painelInferior.add(painelEntrada); // Painel inferior recebe o painel de entrada de comandos
        janela.add(painelInferior, BorderLayout.SOUTH);
    }

    public void setText(String texto){
        testando.setText(texto);
    }

    public void attachText(String texto){
        testando.append("\n" + texto);
    }
}
