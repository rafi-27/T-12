package tema12.EjerciciosB.Ejer8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import utilidades.Persona;

public class Ejer8 {
    public static void main(String[] args) {
        File f = new File("src/main/java/tema12/EjerciciosB/Documentos/datos_personas.csv");
        Scanner sc = new Scanner(System.in);
        try (Scanner lector = new Scanner(new File("src/main/java/tema12/EjerciciosB/Documentos/datos_personas.csv"),
                "UTF-8")) {
            Map<String, Persona> listaPersonas = new HashMap();
            // 22222222B;María;González Rodríguez;32

            while (lector.hasNext()) {
                String linea = lector.nextLine();
                String[] datosSeparados = linea.split(";");

                String dni = datosSeparados[0];
                String nombre = datosSeparados[1];
                String apellidos = datosSeparados[2];
                int edad = Integer.parseInt(datosSeparados[3]);

                listaPersonas.put(dni, new Persona(dni, nombre, apellidos, edad));
            }

            FileOutputStream fos = new FileOutputStream("src/main/java/tema12/EjerciciosB/Documentos/datos_junilados.csv",true);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter nuevoCSV = new BufferedWriter(osw);
            
            for (Map.Entry<String, Persona> persona: listaPersonas.entrySet()) {
                String dni = persona.getKey();
                Persona valor = persona.getValue();
                String nombre = valor.getNombre();
                String apellido = valor.getApellidos();
                int edad = valor.getEdad();
                
                if (valor.esJubilado()) {
                    nuevoCSV.write(dni+";"+nombre+";"+apellido+";"+edad+"\n");
                }
            }
            nuevoCSV.close();

            //Buscar usuarios con bucle infinito hasta que se introduzca 'fin';

            while (true) {
                System.out.println("Introduce el dni a buscar: ");
                String entradaDNI = sc.nextLine();

                if (entradaDNI.equalsIgnoreCase("fin")) {
                    break;
                }else{
                    Persona p = listaPersonas.get(entradaDNI);
                    if (p.validarDNI(entradaDNI)) {
                        p.imprime();
                    }else{
                        System.err.println("DNI no registrado.");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Algo a fallado.");
        }
    }
}