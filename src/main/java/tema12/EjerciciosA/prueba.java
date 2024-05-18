package tema12.EjerciciosA;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class prueba {
/**
 * Clase MiniTerminal: Clase principal (con función main) que se encargará de
 * interactuar con el usuario e interpretar los comandos (qué comando se pide,
 * argumentos, etc.). Utilizará la segunda clase para realizar las operaciones
 * de gestión de archivos. Manejará todas las posibles excepciones.
 */

    static File rutaActual = new File("src/main/java/tema12");
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        String[] splitCommand;
        do {
            MiniFileManager fileManager = new MiniFileManager(rutaActual);
            System.out.print("root@" + rutaActual.getParent() + "\\" + rutaActual.getName() + ": ");
            String command = lector.nextLine();
            splitCommand = command.split(" ");
            if (splitCommand.length > 3) {
                splitCommand[0] = "wiwi";
            }
            switch (splitCommand[0]) {
                case "pwd":
                    System.out.println(fileManager.getPWD(rutaActual));
                    break;
                case "cd":
                    fileManager.changeDir(splitCommand[1]);
                    rutaActual = fileManager.getRutaActual();
                    break;
                case "ls":
                    fileManager.printList(false);
                    break;
                case "ll":
                    fileManager.printList(true);
                    break;
                case "mkdir":
                    fileManager.makeDir(splitCommand[1]);
                    break;
                case "rm":
                    fileManager.rm(splitCommand[1]);
                    break;
                case "mv":
                    fileManager.moveDir(splitCommand[1], splitCommand[2]);
                    break;
                case "help":
                    fileManager.getHelp();
                    break;
                default:
                    System.err.println("Comando Inexistente");
                    break;
            }
        } while (!splitCommand[0].equals("exit"));
    }
}

class MiniFileManager {

    private File rutaActual;

    public MiniFileManager(File rutaActual) {
        this.rutaActual = rutaActual;
    }

    public File getRutaActual() {
        return rutaActual;
    }

    /*pwd: Muestra cual es la carpeta actual*/
    public String getPWD(File f) throws FileNotFoundException {
        return f.getAbsolutePath();
    }

    /*cd <DIR>: Cambia la carpeta actual a ‘DIR’. Con .. cambia a la carpeta superior*/
    public boolean changeDir(String dir) throws FileNotFoundException {
        File auxiliar = new File(rutaActual, dir);
        if (!auxiliar.isDirectory()) {
            return false;
        }
        if (dir.equals("..")) {
            File parentDirectory = rutaActual.getParentFile();
            rutaActual = parentDirectory;
            return true;
        } else if (dir.contains("/")) {
            return rutaActual.renameTo(new File(dir));
        }
        rutaActual = auxiliar;
        return true;
    }

    /*ls:   Muestra   la   lista   de   directorios   y   archivos   de   la   carpeta   actual   (primero directorios, luego archivos, ambos ordenados alfabéticamente).*/
    public void printList(boolean info) throws FileNotFoundException {
        if (rutaActual.isFile()) {
            System.out.println("[A] " + rutaActual.getName());
        }
        if (rutaActual.isDirectory()) {
            System.out.println("[*] " + rutaActual.getName());
            System.out.println("------------------------------------");
            File[] lista = rutaActual.listFiles();

            if (lista != null) {
                File[] listaDir = Arrays.stream(lista)
                        .filter(File::isDirectory)
                        .toArray(File[]::new);
                File[] listaFil = Arrays.stream(lista)
                        .filter(File::isFile)
                        .toArray(File[]::new);

                Arrays.sort(listaDir, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));
                Arrays.sort(listaFil, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));

                for (File dir : listaDir) {
                    System.out.println("[*] " + dir.getName());
                    if (info) {
                        System.out.println("Tamaño: " + dir.length());
                        System.out.println("Última modificación: " + dir.lastModified());
                        System.out.println("");
                    }
                }
                for (File dir : listaFil) {
                    System.out.println("[A] " + dir.getName());
                    if (info) {
                        System.out.println("Tamaño: " + dir.length());
                        System.out.println("Última modificación: " + dir.lastModified());
                        System.out.println("");
                    }
                }
            }
        }
    }


    /*ll: Como ls pero muestra también el tamaño y la fecha de última modificación.*/
    public void printLongList() throws FileNotFoundException {
        printList(true);
    }

    /*mkdir <DIR>: Crea el directorio ‘DIR’ en la carpeta actual.*/
    public boolean makeDir(String s) {
        return new File(this.rutaActual, s).mkdir();
    }

    /*mv <FILE1> <FILE2>: Mueve o renombra ‘FILE1’ a ‘FILE2’.*/
    public boolean moveDir(String archivo1, String archivo2) {
        File f1 = new File(rutaActual, archivo1);
        File f2 = new File(rutaActual, archivo2);
        if (f2.exists() && f2.getAbsolutePath().equals(f1.getParentFile().getAbsolutePath() + File.separator + archivo2)) {
            System.err.println("No se puede mover el archivo a la misma ubicación");
            return false;
        }
        if (f2.exists()) {
            System.err.println("Ya existe el directorio o archivo");
            return false;
        } else if (f1.renameTo(f2)) {
            System.err.println("Archivo creado correctamente");
            return true;
        }
        System.err.println("No existe la ruta");
        return false;
    }


    /*rm <FILE>: Borra ‘FILE’. Si es una carpeta, borrará primero sus archivos y luego la carpeta. Si tiene subcarpetas, las dejará intactas y mostrará un aviso al usuario.*/
    public boolean rm(String s) throws FileNotFoundException {
        File f = new File(rutaActual, s);
        if (!f.exists()) {
            throw new FileNotFoundException("No se encuentra el archivo o directorio: " + f.getAbsolutePath());
        }
        if (f.isFile()) {
            return f.delete();
        }
        if (f.isDirectory()) {
            for (File archivo : f.listFiles()) {
                if (archivo.isFile()) {
                    archivo.delete();
                } 
            }
        }
        return f.delete();
    }

    /*help: Muestra una breve ayuda con los comandos disponibles.*/
    public void getHelp() {
        System.out.println(
                "-pwd: Muestra cual es la carpeta actual.\n"
                + "-cd <DIR>: Cambia la carpeta actual a ‘DIR’. Con .. cambia a la carpeta superior.\n"
                + "-ls: Muestra la lista de directorios y archivos de la carpeta actual (primero directorios, luego archivos, ambos ordenados alfabéticamente).\n"
                + "-ll: Como ls pero muestra también el tamaño y la fecha de última modificación.\n"
                + "-mkdir <DIR>: Crea el directorio ‘DIR’ en la carpeta actual.\n"
                + "-rm <FILE>: Borra ‘FILE’. Si es una carpeta, borrará primero sus archivos y luego la carpeta. Si tiene subcarpetas, las dejará intactas y mostrará un aviso al usuario.\n"
                + "-mv <FILE1> <FILE2>: Mueve o renombra ‘FILE1’ a ‘FILE2’.\n"
                + "-help: Muestra una breve ayuda con los comandos disponibles.\n"
                + "-exit: Termina el programa."
        );
    }


}
