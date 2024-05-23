package tema12.EjerciciosB.Ejer2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejer2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/tema12/EjerciciosB/Documentos/alumnos_notas.txt");
        String linea = " ";

        try (Scanner lector = new Scanner(file)) {
            while (lector.hasNextLine()) {
                ArrayList<Integer> listaNumeros = new ArrayList<>();
                linea = lector.nextLine();
                String[] partes = linea.split(" ");
                
                String nombreApellidos = partes[0]+" "+partes[1];
                
                double media = 0;
                for (int i = 2; i < partes.length; i++) {
                    int numero = Integer.parseInt(partes[i]);
                    listaNumeros.add(numero);
                    media += Double.parseDouble(partes[i]);
                }
                System.out.println("Partes:"+partes.length);
                Collections.sort(listaNumeros,(n1,n2)->n2-n1);
                media /= partes.length - 2;
                //listaNumeros.stream().forEach(System.out::println);
                //System.out.println("Nombre: "+nombreApellidos+" Noas: "+numeros+" Media: "+media);
                System.out.println("Nombres y apellidos: "+nombreApellidos+" Media: "+media+" Notas ordenadas: "+listaNumeros);
                System.out.println();
            }
        }
    }
}