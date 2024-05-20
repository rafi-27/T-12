package tema12.EjerciciosB.Ejer5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

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

        File mkdirdicionario = new
        File("src/main/java/tema12/EjerciciosB/Diccionario");
        
        if (mkdirdicionario.mkdir()) {
        System.out.println("Creada.");
        }
        for (int i = 0; i < letras.length(); i++) {
        File nuevoLetra = new
        File("src/main/java/tema12/EjerciciosB/Diccionario/"+letras.charAt(i)+".txt");
        nuevoLetra.createNewFile();
        }

        // ---------------------------------------Hecho---------------------------------//

        // ArrayList<String> lista = new ArrayList<>();
        // String cadena;
        // try {
        //     BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/tema12/EjerciciosB/Documentos/diccionario.txt"), "UTF-8"));
        //     File dicionario = new File("src/main/java/tema12/EjerciciosB/Documentos/diccionario.txt");
        //     FileInputStream fis = new FileInputStream(dicionario);
        //     InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        //     BufferedReader bfr = new BufferedReader(isr);

        //     while ((cadena = bfr.readLine()) != null){
        //         lista.add(cadena);
                
        //     PrintWriter fescribe = new PrintWriter("src/main/java/tema12/EjerciciosB/Diccionario/"+cadena.toLowerCase().charAt(0)+".txt");
        //     fescribe.write(cadena);
        //     fescribe.close();
        //     }

        // } catch (Exception ex) {
        //     System.out.println("Algo fallo.");
        // }
    }
}