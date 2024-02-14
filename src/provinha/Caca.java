package provinha;
import java.util.Scanner;

public class Caca {
    public static void main(String[] args) {
        char[][] wh = {
                {'E','P','E','R','P','D','P','A','S','S','E','I'},
                {'V','H','A','Y','T','M','R','S','S','T','D','U'},
                {'E','T','E','A','C','R','O','J','H','N','E','Y'},
                {'I','A','T','E','T','E','G','A','P','G','A','S'},
                {'U','C','H','Y','F','P','R','V','R','C','F','A'},
                {'T','T','O','L','F','R','A','A','D','T','R','S'},
                {'E','O','N','E','L','O','M','W','E','O','A','A'},
                {'C','I','E','L','Y','V','A','N','N','A','W','E'},
                {'E','P','L','A','M','E','I','O','D','I','O','P'},
                {'R','D','H','O','B','I','I','D','S','D','E','T'},
                {'F','W','T','S','I','L','S','E','R','K','E','L'},
                {'E','C','T','R','T','D','T','E','C','E','P','O'}
        };

        Scanner scanner = new Scanner(System.in);
        String encontrar = scanner.nextLine();

        for (int i = 0; i < wh.length; i++) {
            for (int j = 0; j < wh[i].length; j++) {
                if (wh[i][j] == encontrar.charAt(0)) {
                    if (encontrarWh(wh, encontrar, i, j)) {
                        System.out.println("Econtrada em " + i + "," + j);
                        return;
                    }
                }
            }
        }
        System.out.println("Não encontrada");
    }

    public static boolean encontrarWh(char[][] wh, String encontrar, int x, int y) {
        int[] veri = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] veri2 = {-1, 0, 1, -1, 1, -1, 0, 1};

        if (wh[x][y] != encontrar.charAt(0))
            return false;

        for (int dir = 0; dir < 8; dir++) {
            int k, rd = x + veri[dir], cd = y + veri2[dir];

            for (k = 1; k < encontrar.length(); k++) {
                if (rd >= wh.length || rd < 0 || cd >= wh[0].length || cd < 0)
                    break;

                if (wh[rd][cd] != encontrar.charAt(k))
                    break;

                rd += veri[dir];
                cd += veri2[dir];
            }

            if (k == encontrar.length())
                return true;
        }
        return false;
    }
}
