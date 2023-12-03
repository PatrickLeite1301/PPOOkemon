package batalha;

import java.io.*;
import java.util.Random;

public class ManipuladorArq{

    public static String[] readTxtArq(String nomeArquivo) {

        String[] campos = null;
        try (BufferedReader arq = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = arq.readLine();

            Random random = new Random();

            int linhaSorteada = random.nextInt(50);

            for(int i = 0; i < linhaSorteada; i++){
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