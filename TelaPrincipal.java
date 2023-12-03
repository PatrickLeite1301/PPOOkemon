
import javax.swing.*;

import batalha.Batalha;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {

    JFrame janela;
    JTextField campoComando;
    JButton botaoConfirmar;
    JButton ataque1;
    JButton ataque2;
    JButton ataque3;
    JButton ataque4;
    JTextArea saidaTela;
    JTextArea pokemonJogador;
    JTextArea pokemonOponente;
    JPanel painelInferior;

    JTextArea ataques;
    JLabel mapa;

    public TelaPrincipal() {
        janela = new JFrame("PPOOkemon");
        campoComando = new JTextField();
        saidaTela = new JTextArea("");
        ataques = new JTextArea("");
        painelInferior = new JPanel();
        pokemonJogador = new JTextArea("");
        pokemonOponente = new JTextArea("");
        botaoConfirmar = new JButton("Confirmar");
        mapa = new JLabel(new ImageIcon("./mapa.jpg"), SwingConstants.CENTER);
        montarJanela();
    }

    public void exibir(Jogo jogo) {
        janela.setVisible(true);
        botaoConfirmar.addActionListener(new BotaoConfirmarOuvinte(jogo));
        ataque1.addActionListener(new BotaoAtaque(jogo));
        ataque2.addActionListener(new BotaoAtaque(jogo));
        ataque3.addActionListener(new BotaoAtaque(jogo));
        ataque4.addActionListener(new BotaoAtaque(jogo));
    }

    private void montarJanela() {
        // Configurações da janela total
        janela.setSize(1200, 700);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout());

        // Configurações do painel Esquerdo
        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setLayout(new BoxLayout(painelEsquerdo, BoxLayout.Y_AXIS));
        pokemonJogador.setEditable(false);
        pokemonOponente.setEditable(false);
        painelEsquerdo.add(pokemonJogador);
        painelEsquerdo.add(pokemonOponente);
        janela.add(painelEsquerdo, BorderLayout.WEST);

        // Configurações do painel Central
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new FlowLayout());
        painelCentral.add(mapa);
        janela.add(painelCentral, BorderLayout.CENTER);

        // Configurações do painel Direito
        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new BoxLayout(painelDireito, BoxLayout.Y_AXIS));

        // criando label de ataques
        JLabel labelAtaques = new JLabel("Ataques: ");
        labelAtaques.setAlignmentX(Component.RIGHT_ALIGNMENT);
        painelDireito.add(labelAtaques);
        painelDireito.add(ataques);
        ataques.setEditable(false);
        janela.add(painelDireito, BorderLayout.EAST);

        // Configurações do painel Inferior
        painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.Y_AXIS));
        janelaComandos();
        janela.add(painelInferior, BorderLayout.SOUTH);

        // Configurando os botões de ataques
        ataque1 = new JButton("Ataque 1");
        ataque2 = new JButton("Ataque 2");
        ataque3 = new JButton("Ataque 3");
        ataque4 = new JButton("Ataque 4");
    }

    public void janelaComandos() {
        // Painel de entrada de comandos
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new BoxLayout(painelEntrada, BoxLayout.X_AXIS));
        painelEntrada.add(campoComando);
        painelEntrada.add(botaoConfirmar);

        // Configurações do painel Inferior
        saidaTela.setEditable(false); // Fazendo que a area de texto nao seja editavel
        painelInferior.removeAll();
        painelInferior.add(saidaTela);
        painelInferior.add(painelEntrada); // Painel inferior recebe o painel de entrada de comandos
    }

    // Ideia de painel para batalha
    public void janelaDeBatalha() {

        JPanel painelAtaques = new JPanel();
        painelAtaques.setLayout(new BoxLayout(painelAtaques, BoxLayout.X_AXIS));
        painelAtaques.add(ataque1);
        painelAtaques.add(ataque2);
        painelAtaques.add(ataque3);
        painelAtaques.add(ataque4);

        // Configurações do painel de batalha
        JPanel painelBatalha = new JPanel();
        painelBatalha.setLayout(new BoxLayout(painelBatalha, BoxLayout.Y_AXIS));
        painelBatalha.add(saidaTela);
        painelBatalha.add(painelAtaques);
        painelInferior.removeAll();
        painelInferior.add(painelBatalha);
    }

    public void definirAtaques(String ata) {
        ataques.setText(ata);
    }

    public void definirPokemon(String poke) {
        pokemonJogador.setText(poke);
    }

    public void definirPokemonOponente(String poke) {
        pokemonOponente.setText(poke);
    }

    public void definirTexto(String texto) {
        saidaTela.setText(texto);
    }

    public void adicionarTexto(String texto) {
        saidaTela.append("\n" + texto);
    }

    public void fechar() {
        janela.setVisible(false);
    }

    private class BotaoConfirmarOuvinte implements ActionListener {
        Jogo jogo;

        public BotaoConfirmarOuvinte(Jogo jogo) {
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

    private class BotaoAtaque implements ActionListener {
        Jogo jogo;

        public BotaoAtaque(Jogo jogo) {
            this.jogo = jogo;
        }

        @Override
        public void actionPerformed(ActionEvent act) {
            int resultado = 0;
            if (act.getSource() == ataque1) {
                resultado = Batalha.batalhar(jogo.getPokemonJogador(), jogo.getPokemonOponente(), 1);
            } else if (act.getSource() == ataque2) {
                resultado = Batalha.batalhar(jogo.getPokemonJogador(), jogo.getPokemonOponente(), 2);
            } else if (act.getSource() == ataque3) {
                resultado = Batalha.batalhar(jogo.getPokemonJogador(), jogo.getPokemonOponente(), 3);
            } else if (act.getSource() == ataque4) {
                resultado = Batalha.batalhar(jogo.getPokemonJogador(), jogo.getPokemonOponente(), 4);
            }

            definirPokemon(jogo.getPokemonJogador().dadosPokemon());
            definirPokemonOponente(jogo.getPokemonOponente().dadosPokemon());
            if (resultado == 1) {
                janelaComandos();
                JOptionPane.showMessageDialog(janela, "Você ganhou o duelo!");
                jogo.apresentarAmbiente();
                pokemonOponente.setText("");
            } else if (resultado == 2) {
                JOptionPane.showMessageDialog(janela, "Você perdeu!");
                System.exit(0);
            }
        }
    }
}
