package tema12.Ejercicios.Ejer1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejer1 {
    
    // Metodo para mostrar info.
    public void muestraInfoRuta(File ruta) throws FileNotFoundException {
        File[] todo = ruta.listFiles();
        System.out.println("Directorio: [*] :: Archivo[A]");
        for (int i = 0; i < todo.length; i++) {
            if (todo[i].isDirectory()) {
                System.out.println("[*]"+todo[i].getName());
            } 
            //else if (todo[i].isFile()) {
            //     System.out.println("[A]"+todo[i].getName());
            // }
            if (todo[i].isFile()) {
                System.out.println("[A]"+todo[i].getName());
            }
        }
    }
    
    public static void main(String[] args) {
        //Ruta para realziar las pruebas: //src/main/java/tema12/Ejercicios/Documentos
        Scanner sc = new Scanner(System.in);
        Ejer1 ejercicio = new Ejer1();

        try {
            System.out.println("Inserta ruta: ");
            String ruta = sc.nextLine();

            File rutaCompleya = new File(ruta);

            if (!rutaCompleya.exists()) {
                throw new FileNotFoundException();
            }

            ejercicio.muestraInfoRuta(rutaCompleya);

        } catch (FileNotFoundException ex) {
            System.out.println("La ruta no existe.");
        } catch(Exception ex){
            System.out.println("Ha dado otro tipo de excepcion.");
        }

        //sc.close();
    }
}
