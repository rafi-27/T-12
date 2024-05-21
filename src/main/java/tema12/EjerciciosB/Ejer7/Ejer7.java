package tema12.EjerciciosB.Ejer7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejer7 {
    public static void main(String[] args) {
        File libro = new File("src/main/java/tema12/EjerciciosB/Documentos/Libros/lazarillo.txt");
        
        try (BufferedReader lector = new BufferedReader(new FileReader(libro))) {
            Scanner si = new Scanner(libro);
            String todo="";
            String linea;
            while ((linea=lector.readLine())!=null) {
                todo+=linea;
            }
            String[] palabrasTotales = todo.split(" ");

            for (int i = 0; i < palabrasTotales.length; i++) {
                if (palabrasTotales[i].endsWith(".")) {
                    palabrasTotales[i].replace(".","");
                }else if (palabrasTotales[i].endsWith(",")) {
                    palabrasTotales[i].replace(",","");
                }else if (palabrasTotales[i].endsWith("!")) {
                    palabrasTotales[i].replace("!","");
                }else if (palabrasTotales[i].endsWith(";")) {
                    palabrasTotales[i].replace(";","");
                }else if (palabrasTotales[i].endsWith(".")) {
                    palabrasTotales[i].replace(".","");
                }else if (palabrasTotales[i].endsWith(":")) {
                    palabrasTotales[i].replace(":","");
                }else if (palabrasTotales[i].contains("-")) {
                    palabrasTotales[i].replace("-","");
                }else if (palabrasTotales[i].contains("/")) {
                    palabrasTotales[i].replace("/","");
                }else if (palabrasTotales[i].contains("¿")) {
                    palabrasTotales[i].replace("¿","");
                }else if (palabrasTotales[i].endsWith("?")) {
                    palabrasTotales[i].replace("?","");
                }else if (palabrasTotales[i].contains("¡")) {
                    palabrasTotales[i].replace("¡","");
                }
            }

            ArrayList<String> cadena=new ArrayList<>();
            while (si.hasNext()) {
                cadena.add(si.nextLine());
            }

            // System.out.println("Numero de lineas en el archivo "+libro.getName()+":"+cadena.size());
            // System.out.println("Cantidad de palabras en el archivo "+libro.getName()+":"+palabrasTotales.length);
            // System.out.println("Cantidad de caracteres en el archivo "+libro.getName()+":"+todo.length());
            
            Hashtable<String,Integer> contenedor = new Hashtable<>();

            for (String palabra : palabrasTotales) {
                if (contenedor.containsKey(palabra)) {
                    contenedor.put(palabra, contenedor.get(palabra)+1);
                }else{
                    contenedor.put(palabra, 1);
                }
            }
            for (String palabra : contenedor.keySet()) {
                System.out.println("Palabra: " + palabra + ", Conteo: " + contenedor.get(palabra));
            }

        } catch (Exception e) {
            System.err.println("Algo ha fallado.");
        }
        /**
         * 
            for (int i = 0; i < palabrasTotales.length; i++) {
                if (palabrasTotales[i].contains(".")) {
                    palabrasTotales[i].replace(".","");
                }
                if (palabrasTotales[i].contains(",")) {
                    palabrasTotales[i].replace(",","");
                }
                if (palabrasTotales[i].contains("!")) {
                    palabrasTotales[i].replace("!","");
                }
                if (palabrasTotales[i].contains(";")) {
                    palabrasTotales[i].replace(";","");
                }
                if (palabrasTotales[i].contains(".")) {
                    palabrasTotales[i].replace(".","");
                }
                if (palabrasTotales[i].contains(":")) {
                    palabrasTotales[i].replace(":","");
                }
                if (palabrasTotales[i].contains("-")) {
                    palabrasTotales[i].replace("-","");
                }
                if (palabrasTotales[i].contains("/")) {
                    palabrasTotales[i].replace("/","");
                }
                if (palabrasTotales[i].contains("¿")) {
                    palabrasTotales[i].replace("¿","");
                }
                if (palabrasTotales[i].contains("?")) {
                    palabrasTotales[i].replace("?","");
                }
                if (palabrasTotales[i].contains("¡")) {
                    palabrasTotales[i].replace("¡","");
                }
            }
         */
    }
}