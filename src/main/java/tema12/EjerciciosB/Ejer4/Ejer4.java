package tema12.EjerciciosB.Ejer4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ejer4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        File nombresAleer = new File("src/main/java/tema12/EjerciciosB/Documentos/usa_nombres.txt");
        File apellidosAleer = new File("src/main/java/tema12/EjerciciosB/Documentos/usa_apellidos.txt");

        File anyadir = new File("src/main/java/tema12/EjerciciosB/Documentos/usa_personas.txt");
        
        try (BufferedWriter escBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(anyadir,true),"UTF-8"))) {
            System.out.println("Cantidad de nombres y apellidos a generar: ");
            int valor = sc.nextInt();

            ArrayList<String> listaNombres = new ArrayList<>();
            ArrayList<String> listaApellidos = new ArrayList<>();
            
            Scanner paNombres = new Scanner(nombresAleer);
            Scanner paApellidos = new Scanner(apellidosAleer);
            
            while (paNombres.hasNext()) {
                listaNombres.add(paNombres.nextLine());
            }

            while (paApellidos.hasNext()) {
                listaApellidos.add(paApellidos.nextLine());
            }

            for (int i = 0; i < valor; i++) {
                int aleN = ThreadLocalRandom.current().nextInt(0,listaNombres.size());
                int aleA = ThreadLocalRandom.current().nextInt(0,listaApellidos.size());
                System.out.println(listaNombres.get(aleN)+" "+listaApellidos.get(aleA));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
