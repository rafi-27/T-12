package tema12.EjerciciosB.Ejer8;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import utilidades.Persona;

public class Ejer8 {
    public static void main(String[] args) {
        File f = new File("src/main/java/tema12/EjerciciosB/Documentos/datos_personas.csv");
        try (Scanner lector = new Scanner(new File("src/main/java/tema12/EjerciciosB/Documentos/datos_personas.csv"), "UTF-8")) {
            Map<String,Persona> listaPersonas = new HashMap();
            //22222222B;María;González Rodríguez;32
            String datos="";
            while (lector.hasNext()) {
                datos+=lector.nextLine();
            }
            String[] datosSeparados = datos.split(";");

            while (lector.hasNext()) {
                listaPersonas.put(datosSeparados[0],new Persona(datosSeparados[0], datosSeparados[1],datosSeparados[2],Integer.parseInt(datosSeparados[3])));
            }

            // for (String dni : listaPersonas.keySet()) {
            //     System.out.println("DNI: " + dni);
            // }

            for (int i = 1; i < datosSeparados.length+1; i++) {
                System.out.print(datosSeparados[i]+" ");
                if (i%4==0) {
                    System.out.println();
                }
            }





        } catch (Exception e) {
            System.out.println("Algo a fallado.");
        }









    }
}
