package tema12.Ejercicios.Ejer6CasoPractico;

import java.io.File;

public class MiniFileManager {
    public String[] listaComandos = {"pwd","cd","ls","ll","mkdir","rm","mv","help","exit"};

    void getpwd(){
        File pwd = new File("./");
        System.out.println(pwd);
    }

    void cd(){

    }

    void ls(){

    }

    void ll(){

    }

    void mkdir(){

    }

    void rm(){

    }

    void mv(){

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

    }


}
