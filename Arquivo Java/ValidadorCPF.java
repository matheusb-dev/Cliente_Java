public class ValidadorCPF {

    public static void main(String[] args) {
        String teste = "123.456.789-09"; 
        System.out.println("CPF: " + teste + " | Valido? " + validar(teste));
    }

    public static boolean validar(String cpf) {
        // 1. Limpeza: Mantem apenas os numeros
        cpf = cpf.replaceAll("\\D", "");

        // 2. Bloqueio: Tamanho errado ou numeros todos iguais
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

        try {
            // 3. Primeiro Digito: Multiplica os 9 primeiros por pesos de 10 a 2
            int soma = 0;
            for (int i = 0; i < 9; i++) soma += (cpf.charAt(i) - '0') * (10 - i);
            int d1 = 11 - (soma % 11);
            if (d1 > 9) d1 = 0;

            // 4. Segundo Digito: Multiplica os 10 primeiros por pesos de 11 a 2
            soma = 0;
            for (int i = 0; i < 10; i++) soma += (cpf.charAt(i) - '0') * (11 - i);
            int d2 = 11 - (soma % 11);
            if (d2 > 9) d2 = 0;

            // 5. Verificacao: Compara os calculados com os digitos reais
            return (d1 == (cpf.charAt(9) - '0') && d2 == (cpf.charAt(10) - '0'));
        } catch (Exception e) { return false; }
    }
}