package tema12;
import java.io.File;

public class Application {

    public static void main(String[] args) {
        File fotos = new File("C:/Temp/Fotos");
        File doc = new File("C:/Temp/Documentos.txt");

        boolean mkdirFot = fotos.mkdir();

        if (mkdirFot) {
            System.out.println("Creada carpeta "+fotos.getName()+"? "+mkdirFot);
        }
        else{
            boolean delCa = fotos.delete();
            System.out.println("Borrada carpeta "+fotos.getName()+"? "+delCa);
            boolean delAr = doc.delete();
            System.out.println("Borrada carpeta "+doc.getName()+"? "+delAr);
        }

    }
}
