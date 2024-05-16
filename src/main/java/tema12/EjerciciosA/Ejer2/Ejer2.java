package tema12.EjerciciosA.Ejer2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ejer2 {
    // En true te muestra el peso y la fecha de la ultima modificacion.

    // Metodo para mostrar info.
    public void muestraInfoRuta(File ruta,boolean info) throws FileNotFoundException {
        File[] todo = ruta.listFiles();
        if (info) {
            System.out.println("Directorio: [*] :: Archivo[A]");
            Arrays.sort(todo, new Comparator<File>() {

                @Override
                public int compare(File arg0, File arg1) {
                    return arg0.getName().compareTo(arg1.getName());
                }
            });

            for (int i = 0; i < todo.length; i++) {
                if (todo[i].isDirectory()) {
                    System.out.println("[*]" + todo[i].getName() + " Peso: ");
                    muestraInfoRuta(todo[i],info);
                }
                System.out.println();
            }
            System.out.println("-----------------------------------------Ficheros----------------------------------------");

            for (int i = 0; i < todo.length; i++) {
                System.out.println();
                long milisegundosYpeso = todo[i].lastModified();
                Date fecha = new Date(milisegundosYpeso);
                if (todo[i].isFile()) {
                    System.out.println("[A]" + todo[i].getName() + " Peso: " + todo[i].length() + " ulima modi-> " + fecha);
                }
            }
        } else {

            System.out.println("Directorio: [*] :: Archivo[A]");
            Arrays.sort(todo, new Comparator<File>() {

                @Override
                public int compare(File arg0, File arg1) {
                    return arg0.getName().compareTo(arg1.getName());
                }
            });

            for (int i = 0; i < todo.length; i++) {

                if (todo[i].isDirectory()) {
                    // int tamaño = (int)todo[i].length();
                    System.out.println("[*]" + todo[i].getName());
                    muestraInfoRuta(todo[i],info);
                }
            }
            System.out.println("-----------------------------------------Ficheros----------------------------------------");
            for (int i = 0; i < todo.length; i++) {
                System.out.println();
                if (todo[i].isFile()) {
                    System.out.println("[A]" + todo[i].getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        // Ruta para realziar las pruebas: src/main/java/tema12/Ejercicios/Documentos
        Scanner sc = new Scanner(System.in);
        Ejer2 ejercicio = new Ejer2();

        try {
            System.out.println("Inserta ruta: ");
            String ruta = sc.nextLine();

            File rutaCompleya = new File(ruta);

            if (!rutaCompleya.exists()) {
                throw new FileNotFoundException();
            }

            ejercicio.muestraInfoRuta(rutaCompleya,false);

        } catch (FileNotFoundException ex) {
            System.out.println("La ruta no existe.");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Ha dado otro tipo de excepcion.");
        }
    }
}