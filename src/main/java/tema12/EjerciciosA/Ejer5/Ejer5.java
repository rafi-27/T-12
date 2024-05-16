package tema12.EjerciciosA.Ejer5;

import java.io.File;
import java.io.FileNotFoundException;

public class Ejer5 {

    static boolean borrarTodo(File f) throws FileNotFoundException{
        if (!f.exists()) {
            throw new FileNotFoundException();
        }else{
            if (f.isFile()) {
                f.delete();
                return true;
            }else if (f.isDirectory()) {
                File[] lista = f.listFiles();
                for (int i = 0; i < lista.length; i++) {
                    lista[i].delete();
                }
                f.delete();
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        File archivoAborrar = new File("src/main/java/tema12/Ejercicios/DOCS/alumnos_notas.txt");
        File carpetaAborrarF = new File("src/main/java/tema12/Ejercicios/DOCS/FOTOS");
        File carpetaAborrarL = new File("src/main/java/tema12/Ejercicios/DOCS/MisCosas/LECTURAS");
        File carpetaAborrarD = new File("src/main/java/tema12/Ejercicios/DOCS");
        
        try {
            System.out.println((borrarTodo(carpetaAborrarF)?"Se ha borrado correctamente":"Hubo un error."));
            System.out.println((borrarTodo(carpetaAborrarL)?"Se ha borrado correctamente":"Hubo un error."));
            System.out.println((borrarTodo(carpetaAborrarD)?"Se ha borrado correctamente":"Hubo un error."));

        } catch (FileNotFoundException e) {
           System.out.println("Archivo no encontrado");
        }
    }
}
