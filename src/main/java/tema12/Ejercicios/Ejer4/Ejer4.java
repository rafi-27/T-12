package tema12.Ejercicios.Ejer4;

import java.io.File;
import java.io.IOException;

public class Ejer4 {
    public static void main(String[] args) throws IOException {
        File misCosas = new File("src/main/java/tema12/Ejercicios/DOCS/MisCosas");
        File alfabeto = new File("src/main/java/tema12/Ejercicios/DOCS/Alfabeto");

        if (misCosas.mkdir()) {
            System.out.println("Se ha creado Mis cosas en Documentos");
        }
        if (alfabeto.mkdir()) {
            System.out.println("Se ha creado alfabeto en Documentos");
        }


        /**
         * Mover fotos y lectura a miscosas
         */

        File fotos = new File("src/main/java/tema12/Ejercicios/DOCS/FOTOS");
        File libros = new File("src/main/java/tema12/Ejercicios/DOCS/LECTURAS");

        //Nuevas rutas=
        File fotosMisCosas = new File("src/main/java/tema12/Ejercicios/DOCS/MisCosas/FOTOS");
        File librosMisCosas = new File("src/main/java/tema12/Ejercicios/DOCS/MisCosas/LECTURAS");

        //Movemos
        if (fotos.renameTo(fotosMisCosas)) {
            System.out.println("Movido");
        }else{
            System.err.println("No puc");
        }

        if (libros.renameTo(librosMisCosas)) {
            System.out.println("Movido");
        }else{
            System.err.println("No puc");
        }
        char letra='A';

        String[] alfa = new String[26];
        for (int i = 0; i < alfa.length; i++) {
            alfa[i]=String.valueOf(letra);
            letra++;
        }

        for (int i = 0; i < alfa.length; i++) {
            File archivoRuta = new File("src/main/java/tema12/Ejercicios/DOCS/Alfabeto/"+alfa[i]);
            if (archivoRuta.createNewFile()) {
                System.out.println("Creado el archivo: "+archivoRuta.getName());
            }
        }
    }
}