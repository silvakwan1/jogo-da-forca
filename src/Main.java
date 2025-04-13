import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dica, palavra;
        char[] letra ;
        ArrayList<Character> letrasErradas = new ArrayList<>();
        char inputLetra;
        String palavraSecreta;
        char[] letraSecreta;
        int contador = 0;

        System.out.println("Digite uma palavra: ");
        palavra = sc.nextLine();
        palavra = palavra.toUpperCase();
        letra = palavra.toCharArray();

        System.out.println("Digite uma dica: ");
        dica = sc.nextLine();
        dica = dica.toUpperCase();

        palavraSecreta = secret(palavra);
        letraSecreta = palavraSecreta.toCharArray();


        prinJogoDaForca();
        do {

            System.out.println("A dica é: " + dica);
            System.out.println("\nA palavra: " + palavraSecreta + "         tentativas: " + contador++);
            System.out.println("\nletras já digitadas: " + letrasErradas);
            System.out.print("Digite uma letra: ");
            inputLetra = sc.next().charAt(0);
            inputLetra = Character.toUpperCase(inputLetra);

            boolean achouLetra = false;

            for (int i = 0; i < palavra.length(); i++) {
                if (letra[i] == inputLetra) {
                    letraSecreta[i] = inputLetra;
                    achouLetra = true;
                }
            }

            // Atualiza a palavra secreta
            palavraSecreta = new String(letraSecreta);

            // Se não achou, adiciona em letrasErradas
            if (!achouLetra) {
                System.out.println("Não tem essa letra...");
                if (!letrasErradas.contains(inputLetra)) {
                    letrasErradas.add(inputLetra);
                }
            }

        } while (!palavraSecreta.equals(palavra));


        System.out.println(
                """
                ------------------------
                Parabéns você acertou!!!
                ------------------------
                """);
    }


    public static  void prinJogoDaForca() {
        String mensegem =
                """
                -----------------
                Jogo da Forca
                -----------------
                """;
        System.out.println(mensegem);
    }

    public static String secret(String palavra){
        char[] novaPalavra = palavra.toCharArray();

        for(int i = 0; i < palavra.length(); i++){
            novaPalavra[i] = '_';
        }
        return new String(novaPalavra);
    }
}