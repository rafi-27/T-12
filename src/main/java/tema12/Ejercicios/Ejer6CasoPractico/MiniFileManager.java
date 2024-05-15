package tema12.Ejercicios.Ejer6CasoPractico;

import java.io.File;
import java.sql.Date;

public class MiniFileManager {
    void getpwd(File f){
        System.out.println(f.getAbsolutePath());
    }

    // void cd(File f,String ruta){
    //     File nuevaRuta = new File(f,ruta);
    //     if (nuevaRuta.isDirectory()) {
    //         f=nuevaRuta;
    //     }else{
    //         System.err.println("Ruta no valida pa");
    //     }
    // }
    
    File cd(File currentDirectory, String ruta) {
        File nuevaRuta = new File(currentDirectory, ruta);
        
        if (nuevaRuta.isDirectory()) {
            // Si la nueva ruta es un directorio válido, devuelve la nueva ruta
            System.out.println("Directorio cambiado a: " + nuevaRuta.getAbsolutePath());
            return nuevaRuta;
        } else {
            System.err.println("Ruta no válida");
            return currentDirectory; // Devuelve el directorio actual si la ruta no es válida
        }
    }
    
    

    void ls(File f){
        File[] listaP = f.listFiles();
        for (int i = 0; i < listaP.length; i++) {
            if (listaP[i].isDirectory()) {
                System.out.println("[*]"+listaP[i].getName());
            }else{
                System.out.println("[A]"+listaP[i].getName());
            }
        }
    }

    void ll(File f){
        File[] listaP = f.listFiles();
        for (int i = 0; i < listaP.length; i++) {
            if (listaP[i].isDirectory()) {
                System.out.println("[*]"+listaP[i].getName());
            }else{
                long temp = listaP[i].lastModified();
                Date fecha = new Date(temp);
                System.out.println("[A]"+listaP[i].getName()+" peso en bytes: "+temp+" fecha ultima modi: "+fecha);
            }
        }
    }

    void mkdir(File f){
        if (f.exists() && f.isFile()) {
            System.out.println("El archivo ya existe.");
        }else if (f.exists() && f.isDirectory()) {
            System.out.println("Ya existe el directorio.");
        }else{
            f.mkdir();
        }
    }

    void rm(File f){
        if (f.isFile()) {
            f.delete();
        }else{
            File[] lispaFiles = f.listFiles();
            for (int i = 0; i < lispaFiles.length; i++) {
                lispaFiles[i].delete();
            }
        }
    }

    void mv(File f){

    }

    void help(){
        System.out.println("pwd: muestra la ruta actual.");
        System.out.println("cd <DIR>: te mueves a la ruta que le especificas.");
        System.out.println("ls: lista los directorios y archivos que tenga la ruta actual.");
        System.out.println("ll: lo mismo que ls pero añadiendo el peso y fecha de la ultima modificacion.");
        System.out.println("mkdir <name>: crea una carpeta.");
        System.out.println("rm <name>: borra la carpeta o archivo que se le pasa.");
        System.out.println("mv <ruta1> <ruta2>: mueve ruta1 a ruta2.");
        System.out.println("exit: salir");
    }

    void exit(){
        System.exit(0);
    }
}
