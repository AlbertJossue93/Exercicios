package provinha;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Diagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leitura da entrada
        String[] inicial = sc.nextLine().split(" ");
        int words = Integer.parseInt(inicial[0]);
        int linhas = Integer.parseInt(inicial[1]);
        int colunas = Integer.parseInt(inicial[2]);

        // Lista para armazenar as palavras
        List<String> u_word = new ArrayList<>();

        // Leitura das palavras
        for (int i = 0; i < words; i++) {
            String temp = sc.nextLine().trim().toLowerCase();
            u_word.add(temp);
        }

        // Lista para armazenar a matriz
        List<String> matriz = new ArrayList<>();

        // Mapa para armazenar as palavras encontradas e suas posições
        Map<String, Integer> encontradas = new LinkedHashMap<>();

        // Leitura da matriz e reversão das linhas
        for (int i = 0; i < linhas; i++) {
            String temp = sc.nextLine().toLowerCase();
            if (temp.length() < colunas) {
                matriz.add(temp);
            } else {
                temp = temp.substring(0, colunas);
                matriz.add(temp);
            }
        }

        for (int i = 0; i < linhas; i++) {
            matriz.set(i, new StringBuilder(matriz.get(i)).reverse().toString());
        }

        // Lista para armazenar as diagonais secundárias
        List<String> res = new ArrayList<>();

        // Preenchimento das diagonais secundárias
        for (int d = 0; d < linhas + colunas - 1; d++) {
            StringBuilder cur = new StringBuilder();
            for (int x = Math.max(0, d - colunas + 1); x < Math.min(linhas, d + 1); x++) {
                if (matriz.get(x).length() > d - x) {
                    cur.append(matriz.get(x).charAt(d - x));
                }
            }
            res.add(cur.toString());
        }

        // Lista para armazenar palavras não encontradas
        List<String> notfound = new ArrayList<>();

        // Verificação de palavras e saída
        for (String word : u_word) {
            boolean found = false;
            for (int i = 0; i < res.size(); i++) {
                String diagonal = res.get(i);
                if (diagonal.contains(word) || new StringBuilder(diagonal).reverse().toString().contains(word)) {
                    found = true;
                    if (i == linhas - 1) {
                        encontradas.put(word, 1);
                    } else if (i < linhas - 1) {
                        encontradas.put(word, 2);
                    } else {
                        encontradas.put(word, 3);
                    }
                }
            }

            if (!found) {
                notfound.add(word);
            }
        }

        // Exibição dos resultados
        for (String word : u_word) {
            if (encontradas.containsKey(word)) {
                int value = encontradas.get(word);
                if (value == 1) {
                    System.out.println("1 Palavra \"" + word + "\" na diagonal secundaria");
                } else if (value == 2) {
                    System.out.println("2 Palavra \"" + word + "\" acima da diagonal secundaria");
                } else {
                    System.out.println("3 Palavra \"" + word + "\" abaixo da diagonal secundaria");
                }
            } else if (notfound.contains(word)) {
                System.out.println("4 Palavra \"" + word + "\" inexistente");
            }
        }

        // Fechamento do Scanner
        sc.close();

    }
}
