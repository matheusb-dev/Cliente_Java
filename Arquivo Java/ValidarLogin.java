import java.util.Scanner;

public class ValidarLogin {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String usuario = "";
        String senha = "";
        boolean usuarioValido = false;
        boolean senhaValida = false;

	System.out.println("                              ");
        System.out.println("----- VALIDAÇÃO DE LOGIN -----");
	System.out.println("                              ");

        while (!usuarioValido) {
            System.out.print("Digite o usuário (deve conter @ e sem sequencias longas): ");
            usuario = leitor.nextLine();

            if (validarUsuario(usuario)) {
                usuarioValido = true;
                System.out.println("[status 201] -> Usuario Criado");
            } else {
                System.out.println("ERRO! O usuario deve conter '@' e os numeros nao podem ser sequencias longas (ex: 123)");
                System.out.println("                                                                                                   ");
            }
        }

        while (!senhaValida) {
            System.out.print("\nDigite a senha (8+ digitos, @, Maiuscula e Minuscula): ");
            senha = leitor.nextLine();

            if (validarSenha(senha)) {
                senhaValida = true;
                System.out.println("-> Senha aceita!");
            } else {
                System.out.println("[ERRO] Senha fraca!");
            }
        }

        System.out.println("\n----- VALIDAÇÃO DE LOGIN REALIZADA COM SUCESSO! -----");
        leitor.close();
    }

    public static boolean validarUsuario(String user) {
        if (!user.contains("@")) return false;

        String nums = user.replaceAll("[^0-9]", "");
        
        // Se tiver 3 ou mais números, verificamos se há sequências proibidas
        if (nums.length() >= 3) {
            for (int i = 0; i < nums.length() - 2; i++) {
                int n1 = Character.getNumericValue(nums.charAt(i));
                int n2 = Character.getNumericValue(nums.charAt(i + 1));
                int n3 = Character.getNumericValue(nums.charAt(i + 2));

                // Bloqueia 3 iguais (111) ou 3 em sequência (123)
                if ((n1 == n2 && n2 == n3) || (n2 == n1 + 1 && n3 == n2 + 1)) {
                    return false;
                }
            }
        }
        return true; 
    }

    public static boolean validarSenha(String s) {
        if (s.length() < 8 || !s.contains("@")) return false;
        boolean temMasc = false, temMin = false;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) temMasc = true;
            if (Character.isLowerCase(c)) temMin = true;
        }
        return temMasc && temMin;
    }
}