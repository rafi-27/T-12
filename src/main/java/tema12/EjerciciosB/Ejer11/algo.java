package tema12.EjerciciosB.Ejer11;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class algo {
/**
 * Buscamos la última versión de la libreria gson en maven repository y la incorporamos al proyecto 
 */
    public static void main(String[] args) {
        TaskManager listaTareas=new TaskManager();

        // Cambiamos el valos de esta variable para leer o escribir
        boolean escribir=false;
        if (escribir) {
            listaTareas.addTask(new Task(3, "Aprender Java", 2));
            listaTareas.addTask(new Task(5, "Aprender JSON", 3));
            listaTareas.addTask(new Task(6, "Aprender GSON", 3));
            listaTareas.addTask(new Task(10, "Desaprender lo aprendido", 1));

            listaTareas.saveTasksToFile("tareas.json");
            System.out.println("Fichero guardado correctamente");
        } else {
            // Segunda parte, recuperamos el fichero
            listaTareas.loadTasksFromFile("tareas.json");

            listaTareas.mostrarTareas();
        }
        
    }
}

class Task{
    private int id;
    private String description;
    private int priority;
    private boolean completed;

    public Task(int id, String description, int priority) {
        this.id = id;
        this.description = description;
        setPriority(priority);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if (priority>=1 && priority<=3)
            this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", completed=" + completed +
                '}';
    }
}

class TaskManager{
    private List<Task> lista=new ArrayList<>();

    public void addTask(Task task){
        lista.add(task);
    }

    public void removeTask(int id){
        lista.removeIf(task -> task.getId()==id);
    }

    public Task getTask(int id){
        return lista.stream().filter(task -> task.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public void saveTasksToFile(String fileName){
        Gson gson=new Gson();
        try (FileWriter writer=new FileWriter(fileName)){
            writer.write(gson.toJson(lista));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadTasksFromFile(String fileName){
        Gson gson=new Gson();
        Type tipoListaPersonas = new TypeToken<ArrayList<Task>>(){}.getType();
        try (FileReader reader=new FileReader(fileName)){
            lista=gson.fromJson(reader,tipoListaPersonas);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarTareas(){
        for (Task task : lista) {
            System.out.println(task);
        }
    }
}