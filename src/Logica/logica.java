package Logica;
import java.util.Scanner;

public class logica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String equipo;
        System.out.println("A que Equipo le vas?: ");
            equipo = sc.nextLine();

            if (equipo.equals("real madrid")) {
                System.out.println("Ah te gusta robar ( que Plasta JAJAJAJAJ)");
            } else if (equipo.equals("barcelona")) {
                System.out.println("Visca el Barça y visca catalunha");

            } else {
                System.out.println("No tenemos ese equipo");
            }

        }

    }




