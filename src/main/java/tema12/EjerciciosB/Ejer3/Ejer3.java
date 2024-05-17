package tema12.EjerciciosB.Ejer3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejer3 {
    public static void main(String[] args) {
        
        //System.out.println("Primer archivo de lectura: ");

        File paLee = new File("src/main/java/tema12/EjerciciosB/Documentos/usa_personas.txt");
        try(Scanner lectura = new Scanner(paLee);){
            File paEscribi = new File("src/main/java/tema12/EjerciciosB/Documentos/usa_personas_sorted.txt");
            FileWriter archivoADevolver = new FileWriter(paEscribi);
            ArrayList<String> listaNombres = new ArrayList<>();
            while (lectura.hasNext()) {
                String line=lectura.nextLine();
                listaNombres.add(line);
            }
            Collections.sort(listaNombres,(n1,n2)->n1.compareToIgnoreCase(n2));
            for (int i = 0; i < listaNombres.size(); i++) {
                archivoADevolver.write(listaNombres.get(i));
                archivoADevolver.write("\n");
            }
            archivoADevolver.close();
        }catch(FileNotFoundException ex){
            System.out.println("No encontrao.");
        } catch(IOException ex){
            System.out.println("Genio");
        }
    }
}
