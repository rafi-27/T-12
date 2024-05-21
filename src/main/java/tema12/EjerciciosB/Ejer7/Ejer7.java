package tema12.EjerciciosB.Ejer7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ejer7 {
    public static void main(String[] args) {
        File libro = new File("src/main/java/tema12/EjerciciosB/Documentos/Libros/vida_unamuno.txt");
        //File libro = new File("src/main/java/tema12/EjerciciosB/Documentos/Libros/lazarillo.txt");

        try (BufferedReader lector = new BufferedReader(new FileReader(libro))) {
            Scanner si = new Scanner(libro);
            String todo = "";
            String linea;
            while ((linea = lector.readLine()) != null) {
                todo += linea;
            }
            String[] palabrasTotales = todo.split(" ");

            for (int i = 0; i < palabrasTotales.length; i++) {
                if (palabrasTotales[i].endsWith(".")) {
                    palabrasTotales[i].replace(".", "");
                } else if (palabrasTotales[i].endsWith(",")) {
                    palabrasTotales[i].replace(",", "");
                } else if (palabrasTotales[i].endsWith("!")) {
                    palabrasTotales[i].replace("!", "");
                } else if (palabrasTotales[i].endsWith(";")) {
                    palabrasTotales[i].replace(";", "");
                } else if (palabrasTotales[i].endsWith(".")) {
                    palabrasTotales[i].replace(".", "");
                } else if (palabrasTotales[i].endsWith(":")) {
                    palabrasTotales[i].replace(":", "");
                } else if (palabrasTotales[i].contains("-")) {
                    palabrasTotales[i].replace("-", "");
                } else if (palabrasTotales[i].contains("/")) {
                    palabrasTotales[i].replace("/", "");
                } else if (palabrasTotales[i].contains("¿")) {
                    palabrasTotales[i].replace("¿", "");
                } else if (palabrasTotales[i].endsWith("?")) {
                    palabrasTotales[i].replace("?", "");
                } else if (palabrasTotales[i].contains("¡")) {
                    palabrasTotales[i].replace("¡", "");
                }
            }

            ArrayList<String> cadena = new ArrayList<>();
            while (si.hasNext()) {
                cadena.add(si.nextLine());
            }

            System.out.println("Numero de lineas en el archivo "+libro.getName()+": "+cadena.size());
            System.out.println("Cantidad de palabras en el archivo "+libro.getName()+": "+palabrasTotales.length);
            System.out.println("Cantidad de caracteres en el archivo "+libro.getName()+": "+todo.length());

            Hashtable<String, Integer> contenedor = new Hashtable<>();

            for (String palabra : palabrasTotales) {
                if (contenedor.containsKey(palabra)) {
                    contenedor.put(palabra, contenedor.get(palabra) + 1);
                } else {
                    contenedor.put(palabra, 1);
                }
            }

            // Obtener las entradas del Hashtable en una lista
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(contenedor.entrySet());

            // Ordenar la lista de entradas por valor (en orden ascendente)
            entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    return e2.getValue().compareTo(e1.getValue());
                }
            });
            System.out.print("Palabras mas repetidas: ");
            for (int j = 0; j < 10; j++) {
                System.out.print(entryList.get(j)+", ");
            }

        } catch (Exception e) {
            System.err.println("Algo ha fallado.");
        }
        /**
         * 
         * for (int i = 0; i < palabrasTotales.length; i++) {
         * if (palabrasTotales[i].contains(".")) {
         * palabrasTotales[i].replace(".","");
         * }
         * if (palabrasTotales[i].contains(",")) {
         * palabrasTotales[i].replace(",","");
         * }
         * if (palabrasTotales[i].contains("!")) {
         * palabrasTotales[i].replace("!","");
         * }
         * if (palabrasTotales[i].contains(";")) {
         * palabrasTotales[i].replace(";","");
         * }
         * if (palabrasTotales[i].contains(".")) {
         * palabrasTotales[i].replace(".","");
         * }
         * if (palabrasTotales[i].contains(":")) {
         * palabrasTotales[i].replace(":","");
         * }
         * if (palabrasTotales[i].contains("-")) {
         * palabrasTotales[i].replace("-","");
         * }
         * if (palabrasTotales[i].contains("/")) {
         * palabrasTotales[i].replace("/","");
         * }
         * if (palabrasTotales[i].contains("¿")) {
         * palabrasTotales[i].replace("¿","");
         * }
         * if (palabrasTotales[i].contains("?")) {
         * palabrasTotales[i].replace("?","");
         * }
         * if (palabrasTotales[i].contains("¡")) {
         * palabrasTotales[i].replace("¡","");
         * }
         * }
         */
    }
}