

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {

    JFrame janela;
    JTextField campoComando;
    JButton botaoConfirmar;
    JTextArea saidaTela;

    String ataques;

    JLabel mapa;

    public TelaPrincipal() {
        janela = new JFrame("PPOOkemon");
        campoComando = new JTextField();
        saidaTela = new JTextArea("");
        botaoConfirmar = new JButton("Confirmar");
        mapa = new JLabel(new ImageIcon("./mapa.jpg"), SwingConstants.CENTER);
        montarJanela();
    }

    public void exibir(Jogo jogo) {
        janela.setVisible(true);
        botaoConfirmar.addActionListener(new BotaoConfirmarOuvinte(jogo));
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
        painelDireito.add(new JLabel(ataques)); // Mudar o JLabel usado aqui
        janela.add(painelDireito, BorderLayout.EAST);

        // Painel de entrada de comandos
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new BoxLayout(painelEntrada, BoxLayout.X_AXIS));
        saidaTela.setEditable(false); // Fazendo que a area de texto nao seja editavel
        painelEntrada.add(campoComando);
        painelEntrada.add(botaoConfirmar);

        // Configurações do painel Inferior
        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.Y_AXIS));
        painelInferior.add(saidaTela);
        painelInferior.add(painelEntrada); // Painel inferior recebe o painel de entrada de comandos
        janela.add(painelInferior, BorderLayout.SOUTH);
    }

    public void definirAtaques(String ataques) {
        this.ataques = ataques;
    }

    public void definirTexto(String texto) {
        saidaTela.setText(texto);
    }

    public void adicionarTexto(String texto) {
        saidaTela.append("\n" + texto);
    }

    public void fechar(){
        janela.setVisible(false);
    }

    private class BotaoConfirmarOuvinte implements ActionListener {
        Jogo jogo;
        public BotaoConfirmarOuvinte(Jogo jogo){
            this.jogo = jogo;
        }
        
        @Override
        public void actionPerformed(ActionEvent act) {
            if (act.getSource() == botaoConfirmar) {
                String comandoDoUsuario = campoComando.getText();
                jogo.tratarComando(comandoDoUsuario);
                campoComando.setText("");
            }
        }
    }
}
