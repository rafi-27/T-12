package tema12.EjerciciosB.Ejer11;

public class Ejer11 {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask(new Task(0, "Primera",2, false));
        manager.addTask(new Task(1, "Segunda",3, false));
        manager.addTask(new Task(2, "Tercera",1, true));
        manager.addTask(new Task(3, "Cuarta",0, true));

        //manager.getTask(1);
        //manager.getTasks();

        //manager.saveTasksToFile("datos");

        manager.loadTasksFromFile("datos2.json");






        
    }
}
