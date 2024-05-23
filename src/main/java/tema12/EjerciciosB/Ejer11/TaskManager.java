package tema12.EjerciciosB.Ejer11;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> listaTareas = new ArrayList<>();

    //Añadir task a una lista que tenemos aqui:
    void addTask(Task task){
        listaTareas.add(task);
    }
    //Eliminar el task
    void removeTask(int id){
        for (Task task : listaTareas) {
            if (task.getId()==id) {
                listaTareas.remove(task);
                System.out.println("Eliminacion correcta.");
            }else{
                System.out.println("Tarea no encontrada.");
            }
        }
    }

    //: devuelve la tarea con el identificador especificado.
    void getTask(int id){
        for (Task task : listaTareas) {
            if (task.getId()==id) {
                System.out.println(task.toString());
            }else{
                System.out.println("Tarea no encontrada.");
            }
        }
    }

    //: devuelve todas las tareas en forma de lista.
    void getTasks(){
        for (Task iterable_element : listaTareas) {
            System.out.println(iterable_element.toString()+" ");
        }
    }

    //: guarda la lista de tareas en un archivo JSON con el nombre especificado.
    void saveTasksToFile(String fileName){
        





    }

    //: carga  la lista  de tareas desde  un archivo JSON con el nombre especificado.
    void loadTasksFromFile(String   fileName){





    }
}