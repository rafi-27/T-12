package tema12.EjerciciosB.Ejer2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejer2Ejem {
    public static void main(String[] args) {
        File file = new File("src/main/java/tema12/EjerciciosB/Documentos/alumnos_notas.txt");

        

        try (Scanner lector = new Scanner(file)) {
            String nombre;
            String linea;

            while (lector.hasNextLine()) {
                ArrayList<Integer>notas=new ArrayList<>();
                double media=0;
                linea=lector.nextLine();
                String partes[] = linea.split(" ");

                for (int i = 2; i < partes.length; i++) {
                    media+=Double.parseDouble(partes[i]);
                    notas.add(i);
                }
                media = media/partes.length;
                nombre=partes[0]+" "+partes[1];
                Collections.sort(notas,(n1,n2)->n1.compareTo(n2));
                System.out.println(nombre+" notas ordenadas: "+notas+" media de: "+media);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }





    }
}
