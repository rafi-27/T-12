package tema12.EjerciciosB.Ejer1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Ejer1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        try(BufferedReader bufferReader = new BufferedReader(new FileReader("src/main/java/tema12/EjerciciosB/Documentos/numeros.txt"))){
            ArrayList<Integer> listaNums = new ArrayList<>();

            String linea;

            while ((linea=bufferReader.readLine()) != null) {
                //System.out.println(linea);
                listaNums.add(Integer.parseInt(linea));
            }

            int maximo = Collections.max(listaNums);
            int minimo = Collections.min(listaNums);

            System.out.println("El maximo: "+maximo);
            System.out.println("El minimo: "+minimo);

            Collections.sort(listaNums,(n1,n2)->n2-n1);

            System.out.println("-------------------------------");

            for (int i = 0; i < listaNums.size(); i++) {
                System.out.println(listaNums.get(i));
            }

            System.out.println("-------------------------------");

        }catch (IOException ex){
            System.err.println("Error");
        }
    }
}