import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RelatorioClientes {
    public static void imprimirRelatorio() {
        try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {
            String linha;
            System.out.println("===== RELATÓRIO DE CLIENTES =====");
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                System.out.println("Nome: "  + dados[0]);
                System.out.println("CPF: "   + dados[1]);
                System.out.println("Email: " + dados[2]);
                System.out.println("-----------------------");
            }
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório.");
        }
    }
}