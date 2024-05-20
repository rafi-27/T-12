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
            String[] partes = entrada.split(" ");

            if (partes[0].equalsIgnoreCase("pwd")) {
                mn.getpwd(acrhivoP);
            } else if (partes[0].equalsIgnoreCase("cd")) {
                if (partes.length<=1) {
                    System.out.println("Ruta no completa");
                }else{
                acrhivoP = mn.cd(acrhivoP, partes[1]);
                }
            } else if (partes[0].equalsIgnoreCase("ls")) {
                mn.ls(acrhivoP);
            } else if (partes[0].equalsIgnoreCase("ll")) {
                mn.ll(acrhivoP);
            } else if (partes[0].equalsIgnoreCase("mkdir")) {
                if (partes.length==2) {
                    if (mn.mkdir(acrhivoP,partes[1])) {
                        System.out.println("Carpeta creada con exito.");
                    }else{
                        System.out.println("Fallo al crear la carpeta.");
                    }
                }else{
                    System.out.println("Comando invalido");
                }
            } else if (partes[0].equalsIgnoreCase("rm")) {
                mn.rm(acrhivoP);
            } else if (partes[0].equalsIgnoreCase("mv")) {
                if (partes.length==3) {
                    mn.mv(partes[1],partes[2]);
                }else{
                    System.err.println("Comando invalido");
                }
                //----------------------------//
                System.out.println("O: "+partes[1]);
                System.out.println("D: "+partes[2]);
            } else if (partes[0].equalsIgnoreCase("exit")) {
                sigue = false;
                mn.exit();
            } else if (partes[0].equalsIgnoreCase("help")) {
                mn.help();
            } else {
                System.err.println("Comando no encontrado.");
            }
        } while (sigue);
    }
}