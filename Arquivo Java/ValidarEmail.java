import java.util.Scanner;

public class ValidarEmail {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String email;
        boolean emailValido = false;

        while (!emailValido) {
            System.out.print("Digite seu email: ");
            email = leitor.nextLine().toLowerCase(); 

           
            if (email.endsWith("@gmail.com") || 
                email.endsWith("@icloud.com") || 
                email.endsWith("@yahoo.com")) {
                
                System.out.println("                                             ");
                System.out.println("Email cadastrado com sucesso!");
                System.out.println("                                             ");
                emailValido = true;
            } else {
                System.out.println("Email incorreto, tente novamente.");
                System.out.println("                                             ");
                System.out.println("Aceitamos apenas: @gmail, @icloud ou @yahoo.");
                System.out.println("                                             ");
            }
        }
        leitor.close();
    }
}