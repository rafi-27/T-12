package tema12.EjerciciosA.Ejer6CasoPractico;

import java.io.File;
import java.sql.Date;

public class MiniFileManager {
    
    void getpwd(File f){
        System.out.println(f.getAbsolutePath());
    }

    File cd(File f,String ruta){
        File nuevaRuta;
        if (ruta.equals("..")) {
            nuevaRuta=f.getParentFile();
        }else{
            nuevaRuta = new File(f,ruta);
        }

        if (nuevaRuta.isDirectory()) {
            return nuevaRuta;
        }else{
            return f;
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

    boolean mkdir(File f,String nombreCarpeta){
        return new File(f,nombreCarpeta).mkdir();
    }

    void rm(File f){
        if (f.isFile()) {
            f.delete();
        }else{
            File[] lispaFiles = f.listFiles();
            for (int i = 0; i < lispaFiles.length; i++) {
                lispaFiles[i].delete();
            }
            f.delete();
        }
    }

    void mv(String rutaUno,String rutaDos){
        File origen=new File(rutaUno);
        File destino=new File(rutaDos);
        if (destino.exists() && destino.isDirectory()) {
            destino = new File(destino, origen.getName());
        }
        if (origen.renameTo(destino)) {
            System.out.println("Movido con exito.");
        }else{
            System.out.println("No se ha podido mover.");
        }
    }

    void help(){
        System.out.println("pwd: muestra la ruta actual.");
        System.out.println("cd <DIR>: te mueves a la ruta que le especificas.");
        System.out.println("ls: lista los directorios y archivos que tenga la ruta actual.");
        System.out.println("ll: lo mismo que ls pero añadiendo el peso y fecha de la ultima modificacion.");
        System.out.println("mkdir <name>: crea una carpeta.");
        System.out.println("rm <name>: borra la carpeta o archivo que se le pasa.");
        System.out.println("mv <ruta1> <ruta2>: mueve ruta1 a ruta2 o cambia el nombre.");
        System.out.println("exit: salir");
    }

    void exit(){
        System.exit(0);
    }
}
