java
import java.io.FileWriter;
import java.io.IOException;

public class CadastroCliente {

    public static void salvarCliente(String nome, String cpf, String email) {

        if (!ValidacaoCPF.validarCPF(cpf)) {
            System.out.println("CPF inválido!");
            return;
        }

        if (!ValidacaoEmail.validarEmail(email)) {
            System.out.println("E-mail inválido!");
            return;
        }

        try (FileWriter writer = new FileWriter("clientes.txt", true)) {
            writer.write(nome + ";" + cpf + ";" + email + "\n");
            System.out.println("Cliente salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar cliente.");
        }
    }
}