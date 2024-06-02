package tema12.EjerciciosB.Ejer1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class EjerEjem1 {
    public static void main(String[] args) {
        ArrayList<Integer>listaNums = new ArrayList<>();
        File f = new File("src/main/java/tema12/EjerciciosB/Documentos/numeros.txt");
 
        try (Scanner lector = new Scanner(f)) {

            while (lector.hasNextInt()) {
                listaNums.add(lector.nextInt());
            }

            System.out.println(listaNums.stream().max((n1,n2)->n1.compareTo(n2)).get());
            System.out.println(listaNums.stream().min((n1,n2)->n1.compareTo(n2)).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
