package tema12.EjerciciosA.Ejer6CasoPractico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejer6MiniTerminal {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        MiniFileManager mn = new MiniFileManager();
        File acrhivoP = new File(".");
        boolean sigue = true;

        do {
            System.out.println("[Comando]-[Sentencia]");
            String entrada = sc.nextLine();

            if (entrada.startsWith("pwd")) {
                mn.getpwd(acrhivoP);
            } else if (entrada.startsWith("cd")) {
                String[] ruta = entrada.split(" ");
                if (ruta.length<=1) {
                    System.out.println("Ruta no completa");
                }else{
                acrhivoP = mn.cd(acrhivoP, ruta[1]);
                }
            } else if (entrada.startsWith("ls")) {
                mn.ls(acrhivoP);
            } else if (entrada.startsWith("ll")) {
                mn.ll(acrhivoP);
            } else if (entrada.startsWith("mkdir")) {
                String[] ruta = entrada.split(" ");
                if (ruta.length==2) {
                    if (mn.mkdir(acrhivoP,ruta[1])) {
                        System.out.println("Carpeta creada con exito.");
                    }else{
                        System.out.println("Fallo al crear la carpeta.");
                    }
                }else{
                    System.out.println("Comando invalido");
                }
            } else if (entrada.startsWith("rm")) {
                mn.rm(acrhivoP);
            } else if (entrada.startsWith("mv")) {
                String[] partes = entrada.split(" ");
                if (partes.length==3) {
                    mn.mv(partes[1],partes[2]);
                }else{
                    System.err.println("Comando invalido");
                }
                //----------------------------//
                System.out.println("O: "+partes[1]);
                System.out.println("D: "+partes[2]);
            } else if (entrada.startsWith("exit")) {
                sigue = false;
                mn.exit();
            } else if (entrada.startsWith("help")) {
                mn.help();
            } else {
                System.err.println("Comando no encontrado.");
            }
        } while (sigue);
    }
}