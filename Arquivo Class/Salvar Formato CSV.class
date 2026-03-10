java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoCSV {

    public static void lerCSV(String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                System.out.println("UF: " + dados[0]);
                System.out.println("Estado: " + dados[1]);
                System.out.println("Descrição: " + dados[2]);
                System.out.println("-------------------");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler CSV.");
        }
    }
}