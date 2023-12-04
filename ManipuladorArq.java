import java.io.*;
import java.util.Random;

/**
 * "PPOOkemon" eh um jogo de aventura muito simples, baseado em texto e botoes.
 * Usuarios podem caminhar em um cenario e travar batalhas com os treinadores.
 * 
 * Essa classe é a responsavel por pegar os pokemons e os ataques que podem aparecer
 * e serem utilizados durante o jogo. Ela faz isso manipulando um arquivo que contem 
 * as possibilidades, dessa forma fica mais facil adicionar e modificar os pokemons 
 * que podem aparecer no jogo
 * 
 * @author Danilo Chagas
 * @version 2023.12.03
 */
public class ManipuladorArq {

    /**
     * Abre o arquivo e faz a leitura para armazenar 1 pokemon aleatorio aos treinadores
     * 
     * @param nomeArquivo nome do arquivo que sera aberto
     * @return retorna os campos do pokemon completo, seu nome e seus ataques
     */
    public static String[] readTxtArq(String nomeArquivo) {

        String[] campos = null;
        try (BufferedReader arq = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = arq.readLine();
            Random random = new Random();
            int linhaSorteada = random.nextInt(50);

            for (int i = 0; i < linhaSorteada; i++) {
                linha = arq.readLine();
            }
            campos = linha.split(";");

            return campos;

        } catch (FileNotFoundException e) {
            System.out.printf("Erro ao encontrar o arquivo: %s. \n", e.getMessage());
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        return campos;
    }
}