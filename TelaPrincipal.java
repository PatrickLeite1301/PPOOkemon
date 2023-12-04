/**
 * Classe TelaPrincipal - a tela principal do jogo.
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores
 *
 * @author Gustavo Pinto
 * @version 2023.12.03
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {

    private JFrame janela;
    private JButton botaoConfirmar;
    private JButton ataque1;
    private JButton ataque2;
    private JButton ataque3;
    private JButton ataque4;
    private JTextArea pokemonJogador;
    private JTextArea pokemonOponente;
    private JTextArea saidaTela;
    private JTextArea ataques;
    private JTextField campoComando;
    private JPanel painelInferior;
    private JLabel mapa;

    /**
     * Cria uma tela principal para o jogo
     * inicializando todos os componentes
     */
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

    /**
     * Exibe a tela principal do jogo
     * @param jogo Jogo que sera exibido na tela
     */
    public void exibir(Jogo jogo) {
        janela.setVisible(true);
        botaoConfirmar.addActionListener(new BotaoConfirmarOuvinte(jogo));
        ataque1.addActionListener(new BotaoAtaqueOuvinte(jogo));
        ataque2.addActionListener(new BotaoAtaqueOuvinte(jogo));
        ataque3.addActionListener(new BotaoAtaqueOuvinte(jogo));
        ataque4.addActionListener(new BotaoAtaqueOuvinte(jogo));
    }

    /**
     * Fecha a tela principal do jogo
     */
    private void montarJanela() {
        // Configurações da janela total
        janela.setSize(1200, 800);
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
        painelCentral.setSize(800, 610);
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

        janela.setResizable(false);
    }

    /**
     * Configura a janela para exibir o campo
     * de entrada de comandos
     */
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

    /**
     * Configura a janela para exibir os botões de ataques
     * durante uma batalha
     */
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

    /**
     * Configura a janela para exibir os ataques do pokemon
     * durante uma batalha
     * @param ata String com os ataques do pokemon
     */
    public void definirAtaques(String ata) {
        ataques.setText(ata);
    }

    /**
     * Configura a janela para exibir o nome do pokemon
     * @param poke String com o nome do pokemon
     */
    public void definirPokemon(String poke) {
        pokemonJogador.setText(poke);
    }

    /**
     * Configura a janela para exibir o nome do pokemon oponente
     * @param poke String com o nome do pokemon oponente
     */
    public void definirPokemonOponente(String poke) {
        pokemonOponente.setText(poke);
    }

    /**
     * Configura a janela para exibir o texto de saida
     * @param texto String com o texto de saida
     */
    public void definirTexto(String texto) {
        saidaTela.setText(texto);
    }

    /**
     * Adiciona texto ao texto de saida
     * @param texto String com o texto de saida
     */
    public void adicionarTexto(String texto) {
        saidaTela.append("\n" + texto);
    }

    private class BotaoConfirmarOuvinte implements ActionListener {
        private Jogo jogo;

        public BotaoConfirmarOuvinte(Jogo jogo) {
            this.jogo = jogo;
        }

        /**
         * Trata os comandos do jogador
         * @param act Ação do jogador
         * que no caso é pressionar o botão de confirmar
         * para enviar o comando
         */
        @Override
        public void actionPerformed(ActionEvent act) {
            if (act.getSource() == botaoConfirmar) {
                String comandoDoUsuario = campoComando.getText();
                jogo.tratarComando(comandoDoUsuario);
                campoComando.setText("");
            }
        }
    }

    private class BotaoAtaqueOuvinte implements ActionListener {
        private Jogo jogo;

        public BotaoAtaqueOuvinte(Jogo jogo) {
            this.jogo = jogo;
        }

        /**
         * Trata os ataques do jogador
         * @param act Ação do jogador
         * que no caso é pressionar um botão de ataque
         */
        @Override
        public void actionPerformed(ActionEvent act) {
            int resultado = 0;
            if (act.getSource() == ataque1) {
                resultado = Batalha.batalhar(jogo.getPokemonJogador(), jogo.getPokemonOponente(), 1);
                definirTexto("Você usou o ataque: " + jogo.getPokemonJogador().dadoAtaqueEspecifico(1) + "\n");
            } else if (act.getSource() == ataque2) {
                resultado = Batalha.batalhar(jogo.getPokemonJogador(), jogo.getPokemonOponente(), 2);
                definirTexto("Você usou o ataque: " + jogo.getPokemonJogador().dadoAtaqueEspecifico(2) + "\n");
            } else if (act.getSource() == ataque3) {
                resultado = Batalha.batalhar(jogo.getPokemonJogador(), jogo.getPokemonOponente(), 3);
                definirTexto("Você usou o ataque: " + jogo.getPokemonJogador().dadoAtaqueEspecifico(3) + "\n");
            } else if (act.getSource() == ataque4) {
                resultado = Batalha.batalhar(jogo.getPokemonJogador(), jogo.getPokemonOponente(), 4);
                definirTexto("Você usou o ataque: " + jogo.getPokemonJogador().dadoAtaqueEspecifico(4) + "\n");
            }

            definirPokemon(jogo.getPokemonJogador().dadosPokemon());
            definirPokemonOponente(jogo.getPokemonOponente().dadosPokemon());

            if (resultado == 1 || resultado == 3) {
                if (jogo.getOponente().getNome() == "Luiz Henrique Mershmann") {
                    JOptionPane.showMessageDialog(janela,
                            "Você derrotou o Líder do ginásio!!" + "\n Você adquiriu a insígnia de PPOO!!");
                    System.exit(0);
                }
                janelaComandos();
                JOptionPane.showMessageDialog(janela, "Você ganhou o duelo!");
                jogo.apresentarAmbiente();
                pokemonOponente.setText("");
            } else if (resultado == 2) {
                JOptionPane.showMessageDialog(janela, "Você perdeu!");
                System.exit(0);
            }
            
            if (resultado == 3) {
                adicionarTexto("\n Você deu sorte nesta batalha e ganhou uma poção no fim da luta!"
                        + "\n Você recuperou 200 de vida do seu Pokemon!");
            }
        }
    }
}
