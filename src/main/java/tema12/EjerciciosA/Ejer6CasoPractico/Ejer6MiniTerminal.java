package tema12.Ejercicios.Ejer6CasoPractico;

import java.io.File;
import java.util.Scanner;

public class Ejer6MiniTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            MiniFileManager mn = new MiniFileManager();
            File acrhivoP = new File(".");

            System.out.println("[Comando]-[Sentencia]");
            String entrada = sc.nextLine();

            if (entrada.startsWith("pwd")) {
                mn.getpwd(acrhivoP);
            } else if (entrada.startsWith("cd")) {
                int primerEspacio = entrada.indexOf(" ");
                String ruta = entrada.substring(primerEspacio, entrada.length());
                acrhivoP = new File(acrhivoP.getParent(), ruta);

                mn.cd(acrhivoP, ruta);
                
            } else if (entrada.startsWith("ls")) {
                mn.ls(acrhivoP);
            } else if (entrada.startsWith("ll")) {
                mn.ll(acrhivoP);
            } else if (entrada.equalsIgnoreCase("mkdir")) {
                mn.mkdir(acrhivoP);
            } else if (entrada.startsWith("rm")) {
                mn.rm(acrhivoP);
            } else if (entrada.startsWith("mv")) {

            } else if (entrada.startsWith("exit")) {
                mn.exit();
            } else if (entrada.startsWith("help")) {
                mn.help();
            } else {
                System.err.println("Comando no encontrado.");
            }
        }
    }
}
