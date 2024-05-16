package tema12.Ejercicios.Ejer3;

import java.io.File;

public class Ejer3 {
    public static void main(String[] args) {
        File files = new File("src/main/java/tema12/Ejercicios/Documentos");
        File rDOCS = new File("src/main/java/tema12/Ejercicios/DOCS");

        File fotografias = new File("src/main/java/tema12/Ejercicios/DOCS/Fotografias");
        File fFotos = new File("src/main/java/tema12/Ejercicios/DOCS/FOTOS");

        File libros = new File("src/main/java/tema12/Ejercicios/DOCS/Libros");
        File lecturas = new File("src/main/java/tema12/Ejercicios/DOCS/LECTURAS");


        //Cambiamos el nombre de documentos:
        if (files.renameTo(rDOCS)) {
            System.out.println("Renombracion correcta DOCS.");
        }else{
            System.out.println("ERROR");
        }

        // //Cambiamos el nombre de fotografias:
        if (fotografias.renameTo(fFotos)) {
            System.out.println("Renombracion correcta FOTOS.");
        }else{
            System.out.println("ERROR");
        }

        // //Cambiamos el nombre de libros:
        if (libros.renameTo(lecturas)) {
            System.out.println("Renombracion correcta LECTURAS.");
        }else{
            System.out.println("ERROR");
        }

        File[] cambiarNombres = fFotos.listFiles();
        for (int i = 0; i < cambiarNombres.length; i++) {
            File momentaneo = cambiarNombres[i];
            String nombre = momentaneo.getName();

            String nuevoNombre = nombre.substring(0,nombre.length()-4);

            File nuevoArchivo = new File(cambiarNombres[i].getParent(), nuevoNombre);

            cambiarNombres[i].renameTo(nuevoArchivo);
        }

        File[] cambiarNombresLibros = lecturas.listFiles();
        for (int i = 0; i < cambiarNombresLibros.length; i++) {
            File momentaneo = cambiarNombresLibros[i];
            String nombre = momentaneo.getName();

            String nuevoNombre = nombre.substring(0,nombre.length()-4);

            File nuevoArchivo = new File(cambiarNombresLibros[i].getParent(), nuevoNombre);

            cambiarNombresLibros[i].renameTo(nuevoArchivo);
        }
    }
}