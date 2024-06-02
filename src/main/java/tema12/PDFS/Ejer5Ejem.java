package tema12.PDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ejer5Ejem {
    public static void main(String[] args) {
        //65-90
        File carpeta = new File("src/main/java/tema12/EjerciciosB/Ejer5/Carpeta");
        if (carpeta.mkdir()) {
            System.out.println("Exito");
        }
        for (int i = 65; i <= 90; i++) {
            File n = new File("src/main/java/tema12/EjerciciosB/Ejer5/Carpeta/"+(char)i+".txt");
            try {
                n.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader lector = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/tema12/EjerciciosB/Documentos/diccionario.txt"),"UTF-8"))) {
                String linea="";
                while ((linea=lector.readLine())!=null) {
                    char letra = Character.toUpperCase(linea.charAt(0));
                    File n = new File("src/main/java/tema12/EjerciciosB/Ejer5/Carpeta/"+letra+".txt");
                    try (BufferedWriter escribimos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(n,true),"UTF-8"))) {
                        escribimos.write(linea);
                        escribimos.newLine();                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}