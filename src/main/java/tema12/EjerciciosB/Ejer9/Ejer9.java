package tema12.EjerciciosB.Ejer9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import utilidades.Persona;

public class Ejer9 {
    public static void main(String[] args) throws ClassNotFoundException {
        ArrayList<Persona>listaPersonas = new ArrayList<>();
        File fichero = new File("src/main/java/tema12/EjerciciosB/Documentos/datos_personas.bin");
        //BufferedReader leer = new BufferedReader(new InputStreamReader(new FileInputStream(fichero),"UTF-8"))
        try (ObjectInputStream objet = new ObjectInputStream(new FileInputStream(fichero))) {
            ArrayList<Persona>personas = (ArrayList<Persona>) objet.readObject();

            for (Persona persona : personas) {
                persona.imprime();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        // try (FileInputStream fis = new FileInputStream(fichero);
        //         BufferedInputStream bufis = new BufferedInputStream(fis);
        //         ObjectInputStream ois = new ObjectInputStream(bufis)) {
                    
        //     listaPersonas = (ArrayList<Persona>) ois.readObject(); 
      
        //     ArrayList<Persona> nuevaVeinteAños = new ArrayList<>();
        //     for (Persona persona : listaPersonas) {
        //         if (persona.getEdad()>=20&&persona.getEdad()<=29) {
        //             nuevaVeinteAños.add(persona);
        //         }
        //     }
            
        //     for (Persona element : listaPersonas) {
        //         element.imprime();
        //     }

        //     try (FileOutputStream fos = new FileOutputStream("src/main/java/tema12/EjerciciosB/Documentos/datos_veintes.ser", false);
        //     BufferedOutputStream bos = new BufferedOutputStream(fos);
        //     ObjectOutputStream oos = new ObjectOutputStream(bos)){
        //         for (int i = 0; i < nuevaVeinteAños.size(); i++) {
        //             oos.writeObject(nuevaVeinteAños.get(i)+"\n");
        //         }
                
        //     } catch (IOException  e) {
        //         System.out.println("Algo ha fallado");
        //     }
        //     //System.out.println(nuevaVeinteAños.size());
        // } catch (Exception ex) {
        //     ex.printStackTrace();
        // }
    }
}