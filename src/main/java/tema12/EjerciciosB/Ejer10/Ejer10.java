package tema12.EjerciciosB.Ejer10;


public class Ejer10 {
    public static void main(String[] args) {
        // empresa.nombre=Mi empresa
        // login.max_intentos=3
        // sesion.timeout=1800

        ConfigManager configurarion = new ConfigManager();
        configurarion.loadConfig();

        System.out.println(configurarion.getNombreEmpresa());
    }
}