package tema12.EjerciciosB.Ejer7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;


public class Ejer7 {
    public static void main(String[] args) {
        File libro = new File("src/main/java/tema12/EjerciciosB/Documentos/Libros/vida_unamuno.txt");
        //File libro = new File("src/main/java/tema12/EjerciciosB/Documentos/Libros/lazarillo.txt");

        try (BufferedReader lector = new BufferedReader(new FileReader(libro))) {
            Scanner si = new Scanner(libro);
            String todo = "";
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.contains(".")) {
                    linea.replace(".", " ");
                } else if (linea.contains(",")) {
                    linea.replace(",", " ");
                } else if (linea.contains("!")) {
                    linea.replace("!", " ");
                } else if (linea.contains(";")) {
                    linea.replace(";", " ");
                } else if (linea.contains(".")) {
                    linea.replace(".", " ");
                } else if (linea.contains(":")) {
                    linea.replace(":", " ");
                } else if (linea.contains("-")) {
                    linea.replace("-", " ");
                } else if (linea.contains("/")) {
                    linea.replace("/", " ");
                } else if (linea.contains("¿")) {
                    linea.replace("¿", " ");
                } else if (linea.contains("?")) {
                    linea.replace("?", " ");
                } else if (linea.contains("¡")) {
                    linea.replace("¡", " ");
                }
                todo += linea;
            }
            String[] palabrasTotales = todo.split(" ");

            ArrayList<String> cadena = new ArrayList<>();
            while (si.hasNext()) {
                cadena.add(si.nextLine());
            }

            Hashtable<String, Integer> contenedor = new Hashtable<>();

            for (String palabra : palabrasTotales) {
                if (contenedor.containsKey(palabra)) {
                    contenedor.put(palabra, contenedor.get(palabra) + 1);
                } else {
                    contenedor.put(palabra, 1);
                }
            }

            List<Map.Entry<String,Integer>> nueva = new ArrayList<>(contenedor.entrySet());
            Collections.sort(nueva,(n1,n2)->n2.getValue()-n1.getValue());
            
            System.out.println("Numero de lineas en el archivo "+libro.getName()+": "+cadena.size());
            System.out.println("Cantidad de palabras en el archivo "+libro.getName()+": "+palabrasTotales.length);
            System.out.println("Cantidad de caracteres en el archivo "+libro.getName()+": "+todo.length());
            System.out.print("Palabras mas repetidas: ");
            for (int i = 0; i < 10; i++) {
                System.out.print("{"+nueva.get(i)+"} ");
            }
            

        } catch (Exception e) {
            System.err.println("Algo ha fallado.");
        }
    }
}