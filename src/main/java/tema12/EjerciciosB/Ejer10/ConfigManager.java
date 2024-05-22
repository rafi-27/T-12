package tema12.EjerciciosB.Ejer10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    Properties config = new Properties();

    public void loadConfig() {
        String empresa;
        int numIntents;
        int tiempoDeTimeOut;
        try {
            config.load(new FileInputStream("src/main/java/tema12/EjerciciosB/Ejer10/config.properties"));
            empresa = config.getProperty("empresa.nombre");
            numIntents = Integer.parseInt(config.getProperty("login.max_intentos"));
            tiempoDeTimeOut = Integer.parseInt(config.getProperty("sesion.timeout"));

            System.out.println("Nombre de la empresa: "+empresa);
            System.out.println("Numero de intentos de sesion: "+numIntents);
            System.out.println("Tiempo de conexion maximo: "+tiempoDeTimeOut);

        } catch (IOException e) {
            System.out.println("Hubo un error al leer el archivo de properties.");
        }
    }

    String getNombreEmpresa(){
        return config.getProperty("empresa.nombre");
    }

    int getMaxIntentos(){
        return Integer.parseInt(config.getProperty("login.max_intentos"));
    }

    int getSesionTimeOut(){
        return Integer.parseInt(config.getProperty("sesion.tiemout"));
    }
}
