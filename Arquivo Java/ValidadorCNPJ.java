public class ValidadorCNPJ {

    public static void main(String[] args) {
        String teste = "12.345.678/0001-95";
        System.out.println("CNPJ: " + teste + " | Valido? " + validar(teste));
    }

    public static boolean validar(String cnpj) {
        // 1. Limpeza: Remove pontos, barras e tracos
        cnpj = cnpj.replaceAll("\\D", "");

        if (cnpj.length() != 14 || cnpj.matches("(\\d)\\1{13}")) return false;

        try {
            // Pesos especificos da Receita Federal para CNPJ
            int[] p1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] p2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

            // 2. Calculo do Primeiro Digito (posicao 12)
            int soma = 0;
            for (int i = 0; i < 12; i++) soma += (cnpj.charAt(i) - '0') * p1[i];
            int d1 = 11 - (soma % 11);
            if (d1 > 9) d1 = 0;

            // 3. Calculo do Segundo Digito (posicao 13)
            soma = 0;
            for (int i = 0; i < 13; i++) soma += (cnpj.charAt(i) - '0') * p2[i];
            int d2 = 11 - (soma % 11);
            if (d2 > 9) d2 = 0;

            return (d1 == (cnpj.charAt(12) - '0') && d2 == (cnpj.charAt(13) - '0'));
        } catch (Exception e) { return false; }
    }
}