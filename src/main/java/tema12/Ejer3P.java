package tema12;

import java.io.File;
import java.io.IOException;

public class Ejer3P {
    public static void main(String[] args) {
        /**
        * Ejercicio 3
        * Realiza un programa que cree un nuevo directorio en nuestro directorio de trabajo. 
        * El directorio se llamará “archivos”, 
        * dentro de este directorio crea un nuevo fichero con nombre “prueba.txt”.
        */

        File archivos = new File("C:/Users/rafik/Desktop/Clases/Programacion/UD--12/iesthiar/src/main/java/tema12/archivos");
        File prueba = new File("C:/Users/rafik/Desktop/Clases/Programacion/UD--12/iesthiar/src/main/java/tema12/archivos/prueba.txt");




        try {
            if (prueba.createNewFile()) {
                System.out.println("Se ha creado: "+archivos.getPath());
            }else{
                System.out.println("Fallo");
            }
        } catch (IOException e) {
            System.out.println("No se ha podido crear correctamente.");
        }




    }
}
