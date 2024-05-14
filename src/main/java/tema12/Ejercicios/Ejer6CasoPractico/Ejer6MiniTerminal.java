package tema12.Ejercicios.Ejer6CasoPractico;

import java.util.Scanner;

public class Ejer6MiniTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[Comando]-[Sentencia]");
            String entrada=sc.nextLine();

            if (entrada.equalsIgnoreCase("pwd")) {
                MiniFileManager mn = new MiniFileManager();
                mn.getpwd();
            }else if (entrada.equalsIgnoreCase("ls")) {
                
            }else if (entrada.equalsIgnoreCase("ll")) {
                
            }else if (entrada.equalsIgnoreCase("help")) {
                
            }else if (entrada.equalsIgnoreCase("exit")) {
                
            }

            //Comando la palabra mas larga de los comandos es de 5 caracteres.
            int primerEspacio = entrada.indexOf(" ");
            String comando = entrada.substring(0,primerEspacio);

            System.out.println(comando);


        }
    }
}
