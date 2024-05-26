package tema12.archivos;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ejer1 {
    public static void main(String[] args) throws FileNotFoundException {
        leer lee = new leer();
        // lee.lee();

        lee.escribe();


        
    }
}

class leer{
    public void lee() throws FileNotFoundException{
        File n = new File("src/main/java/tema12/archivos/prueba.txt");
        try (Scanner aLeer = new Scanner(n,"UTF-8")) {
            String c="";
            
            while (aLeer.hasNext()) {
                c=aLeer.nextLine();
                System.out.println(c);
            }
        }
    }
    public void escribe(){
        String linea="Ho-là ch@mos que tál.";
        File nuevo = new File("src/main/java/tema12/archivos/pruebaEscrito.txt");
        try (BufferedWriter si = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nuevo,false),"UTF-8"))) {
            si.write(linea);
            si.close();
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
}