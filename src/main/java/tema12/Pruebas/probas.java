package tema12.Pruebas;

import java.io.File;

public class probas {
    public static void main(String[] args) {
        File dir = new File("src/main/java/tema12");
        File[] lista = dir.listFiles();

        System.out.println("Contenido de "+dir.getAbsolutePath()+":");

        for (int i = 0; i < lista.length; i++) {
            if (lista[i].isDirectory()) {
                System.out.println("[DIR] "+lista[i].getName());
            }else{
                System.out.println("[FIC] "+lista[i].getName());
            }
        }





    }
}
