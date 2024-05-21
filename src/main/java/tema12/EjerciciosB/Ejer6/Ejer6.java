package tema12.EjerciciosB.Ejer6;

import java.io.File;
import java.util.Scanner;

public class Ejer6 {
    public static void main(String[] args) {
        File archivito = new File("src/main/java/tema12/EjerciciosB/Documentos/pi-million.txt");
        boolean existe=false;
        try (Scanner lectoriPI = new Scanner(archivito)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce la cadena y comprobamos que existe.");
            String numeroABuscar = sc.nextLine();
            String cadena="";

            while (lectoriPI.hasNext()) {
                cadena = lectoriPI.nextLine();
            }

            cadena = cadena.substring(2,cadena.length());

            for (int i = 0; i < cadena.length(); i++) {
                String cadenaAcomparar=cadena.substring(i,i+numeroABuscar.length());
                if (cadenaAcomparar.equals(numeroABuscar)) {
                    existe=true;
                    break;
                }
            }
            System.out.println((existe)?"El numero "+numeroABuscar+" existe.":"El numero "+numeroABuscar+" no existe.");



        } catch (Exception e) {
            System.out.println("Ha ocurrido un error."+e.getCause());
            System.out.println("El numero no puede tener una longitud mayor a 1000000.");
            e.printStackTrace();
        }
    }
}
