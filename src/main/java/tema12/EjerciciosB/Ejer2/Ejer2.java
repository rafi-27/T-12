package tema12.EjerciciosB.Ejer2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejer2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/tema12/EjerciciosB/Documentos/alumnos_notas.txt");
        String linea=" ";
        try (Scanner lector = new Scanner(file)) {
        while (lector.hasNextLine()) {
            linea=lector.nextLine();
            String[] partes = linea.split(" ");
            
            //System.out.printf("%nNombre:%s, apellido:%s, notas: ", args);
        }
        }

    }
}
