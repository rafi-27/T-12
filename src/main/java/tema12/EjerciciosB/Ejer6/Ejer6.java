package tema12.EjerciciosB.Ejer6;

import java.io.File;
import java.util.Scanner;

public class Ejer6 {
    public static void main(String[] args) {
        File archivito = new File("src/main/java/tema12/EjerciciosB/Documentos/pi-million.txt");

        try (Scanner lectoriPI = new Scanner(archivito)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce la cadena y comprobamos que existe.");
            String numeroABuscar = sc.nextLine();

            



        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
        }















    }
}
