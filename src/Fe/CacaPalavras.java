package Fe;
import java.util.Scanner;

public class CacaPalavras {
    public static void main(String[] args) {
        char[][] wh = {
                {'E', 'P', 'E', 'R', 'P', 'D', 'P', 'A', 'S', 'S', 'E', 'I'},
                {'V', 'H', 'A', 'Y', 'T', 'M', 'R', 'S', 'S', 'T', 'D', 'U'},
                {'E', 'T', 'E', 'A', 'C', 'R', 'O', 'J', 'H', 'N', 'E', 'Y'},
                {'I', 'A', 'T', 'E', 'T', 'E', 'G', 'A', 'P', 'G', 'A', 'S'},
                {'U', 'C', 'H', 'Y', 'F', 'P', 'R', 'V', 'R', 'C', 'F', 'A'},
                {'T', 'T', 'O', 'L', 'F', 'R', 'A', 'A', 'D', 'T', 'R', 'S'},
                {'E', 'O', 'N', 'E', 'L', 'O', 'M', 'W', 'E', 'O', 'A', 'A'},
                {'C', 'I', 'E', 'L', 'Y', 'V', 'A', 'N', 'N', 'A', 'W', 'E'},
                {'E', 'P', 'L', 'A', 'M', 'E', 'I', 'O', 'D', 'I', 'O', 'P'},
                {'R', 'D', 'H', 'O', 'B', 'I', 'I', 'D', 'S', 'D', 'E', 'T'},
                {'F', 'W', 'T', 'S', 'I', 'L', 'S', 'E', 'R', 'K', 'E', 'L'},
                {'E', 'C', 'T', 'R', 'T', 'D', 'T', 'E', 'C', 'E', 'P', 'O'}
        };
        // EXIBIR E MOSTRAR A MATRIZ
        Scanner sc = new Scanner(System.in);
        String encontrar = sc.nextLine();
        for (int l = 0; l < wh.length; l++) {
            for (int c = 0; c < wh[l].length; c++) {
                if (encontrarwh(wh, encontrar, l, c)) {
                    System.out.println("Encontrada em " + l + "," + c);
                    return;

                }
            }
        }

        System.out.println("nao encontrada");
    }

    public static boolean encontrarwh(char[][] wh, String encontrar, int y, int x) {
        int[] veri1 = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] veri = {-1, 0, 1, -1, 1, -1, 0, 1};
        if (wh[y][x] != encontrar.charAt(0))
            return false;
        for (int direcao = 0; direcao < 8; direcao++) {
            int k, rd = y + veri1[direcao], cd = y + veri[direcao];

            for (k = 1; k < encontrar.length(); k++) {
                if (rd >= wh.length || rd < 0 || cd >= wh[0].length || cd < 0)
                    break;

                if (wh[rd][cd] != encontrar.charAt(k))
                    break;

                rd += veri1[direcao];
                cd += veri[direcao];
            }
            if (k == encontrar.length())
                return true;
        }
        return false;
    }
}


