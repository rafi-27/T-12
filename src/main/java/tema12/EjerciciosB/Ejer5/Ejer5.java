package tema12.EjerciciosB.Ejer5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Ejer5 {
    public static void main(String[] args) throws IOException {
        /**
         * Ejercicio B5 - Diccionario
         * Implementa un programa que cree la carpeta ‘Diccionario’ con tantos archivos
         * como
         * letras del abecedario (A.txt, B.txt... Z.txt). Introducirá en cada archivo
         * las palabras de
         * 'diccionario.txt’ que comiencen por dicha letra.
         */

        // Crear la carpeta diccionario:
        // ---------------------------------------Hecho---------------------------------//
        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

        File mkdirdicionario = new File("src/main/java/tema12/EjerciciosB/Diccionario");

        if (mkdirdicionario.mkdir()) {
            System.out.println("Creada.");
        }
        for (int i = 0; i < letras.length(); i++) {
            File nuevoLetra = new File("src/main/java/tema12/EjerciciosB/Diccionario/" +
                    letras.charAt(i) + ".txt");
            nuevoLetra.createNewFile();
        }

        // ---------------------------------------Hecho---------------------------------//
        // String cadena;
        // File dicion = new File("src/main/java/tema12/EjerciciosB/Documentos/diccionario.txt");

        // for (int i = 0; i < letras.length(); i++) {
        //     File f = new File("src/main/java/tema12/EjerciciosB/Diccionario/" + letras.charAt(i) + ".txt");
        //     try (BufferedReader bfr = new BufferedReader(new FileReader(dicion));
        //          BufferedWriter bfw = new BufferedWriter(new FileWriter(f, true))) {

        //         while ((cadena = bfr.readLine()) != null) {
        //             if (cadena.startsWith(String.valueOf(letras.charAt(i)))) {
        //                 bfw.write(cadena + "\n");
        //             }
        //         }
        //     } catch (IOException e) {
        //         System.err.println("Error procesando el archivo " + f.getName() + ": " + e.getMessage());
        //     }
        // }

        String cadena;
        File dicion = new
        File("src/main/java/tema12/EjerciciosB/Documentos/diccionario.txt");
        try (BufferedReader bfr = new BufferedReader(new FileReader(dicion))) {

        while ((cadena = bfr.readLine()) != null) {
        Character letra = Character.toLowerCase(cadena.charAt(0));
        File n = new File("src/main/java/tema12/EjerciciosB/Diccionario/" + letra +
        ".txt");
        FileWriter fescribe = new FileWriter(n, true);
        fescribe.write(cadena + "\n");
        fescribe.close();
        }
        } catch (Exception ex) {
        System.out.println("Algo fallo.");
        }
    }
}