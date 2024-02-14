package Logica;
import java.util.Scanner;



        public class Mandioca {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int porcoes[] = {300, 1500, 600, 1000, 150,};
                int total = 225;
                int n = 0;
                for (int i=0; i< porcoes.length; i++){
                     n = sc.nextInt();

                    total += porcoes[i] * n;
                }
                System.out.println(total);

    }
}
