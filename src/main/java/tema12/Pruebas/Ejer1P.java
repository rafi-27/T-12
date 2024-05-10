package tema12.Pruebas;
import java.io.File;

public class Ejer1P {

    public static void main(String[] args) {
        // Dos rutas absolutas
        File carpetaAbs = new File("C://Users/rafik/Desktop/Clases/Programacion");
        File archivoAbs = new File("C://Users/rafik/Desktop/Clases/Programacion/si.psc");
        // Dos rutas relativas
        File carpetaRel = new File("tema12");
        File archivoRel = new File("tema12/actividad.txt");
        // Mostrem sus rutas
        mostrarRutas(carpetaAbs);
        mostrarRutas(archivoAbs);
        mostrarRutas(carpetaRel);
        mostrarRutas(archivoRel);
    }
    public static void mostrarRutas(File f) {
        System.out.println("getParent()      : " + f.getParent());
        System.out.println("getName()        : " + f.getName());
        System.out.println("getAbsolutePath(): " + f.getAbsolutePath() + "\n");
    }

    //Relativa
    //src\main\java\tema12\UD12_Ficheros_v02.pdf

    //Acceso
    //C:\Users\rafik\Desktop\Clases\Programacion\UD--12\iesthiar\src\main\java\tema12\UD12_Ficheros_v02.pdf


}
