package tema12.EjerciciosB.Ejer4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ejer4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        File nombresAleer = new File("src/main/java/tema12/EjerciciosB/Documentos/usa_nombres.txt");
        File apellidosAleer = new File("src/main/java/tema12/EjerciciosB/Documentos/usa_apellidos.txt");

        File anyadir = new File("src/main/java/tema12/EjerciciosB/Documentos/usa_personas.txt");
        
        try{
            
            System.out.println("Cuantos registros quieres: ");
            int numeroRegistros = sc.nextInt();

            FileWriter escritor = new FileWriter(anyadir,true);
            BufferedWriter buffer = new BufferedWriter(escritor);
            ArrayList<String> listaNombres = new ArrayList<>();
            ArrayList<String> listaApellidos = new ArrayList<>();
            
            Scanner uno = new Scanner(nombresAleer);
            Scanner dos = new Scanner(apellidosAleer);

            while (uno.hasNext()) {
                String lineaUno = uno.nextLine();
                listaNombres.add(lineaUno);
            }
            while (dos.hasNext()) {
                String lineaDos = dos.nextLine();
                listaApellidos.add(lineaDos);
            }

            for (int i = 0; i < numeroRegistros; i++) {        
                int unoRandom = ThreadLocalRandom.current().nextInt(0,listaNombres.size());
                int dosRandom = ThreadLocalRandom.current().nextInt(0,listaApellidos.size());
                buffer.write(listaNombres.get(unoRandom)+" "+listaApellidos.get(dosRandom));
                buffer.newLine();
            }
            buffer.close();
            escritor.close();
        }catch(Exception ex){
            System.out.println("Algo fallo."+ex.getCause());
        }
    }
}
