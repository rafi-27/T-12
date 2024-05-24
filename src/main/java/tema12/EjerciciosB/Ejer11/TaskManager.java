package tema12.EjerciciosB.Ejer11;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
            }
        };
    }


    //: devuelve todas las tareas en forma de lista.
    void getTasks(){
        for (Task iterable_element : listaTareas) {
            System.out.println(iterable_element.toString()+" ");
        }
    }

    //guarda la lista de tareas en un archivo JSON con el nombre especificado.
    //Hay que usar Gson, Jackson
    void saveTasksToFile(String fileName){
        Gson gson = new Gson();

        JsonObject objeto1 = new JsonObject();
        JSONObject oJsonObject = new JSONObject();

        for (int i = 0; i < listaTareas.size(); i++) {
            oJsonObject.append("ID: ", listaTareas.get(i).getId());
            oJsonObject.append("Descripcion: ", listaTareas.get(i).getDescription());
            oJsonObject.append("Prioridad(1-3): ", listaTareas.get(i).getPriority());
            oJsonObject.append("Esta completa: ",listaTareas.get(i).isCompleted());
        }

        //Dos formas de reazliar esta tarea.
        for (int i = 0; i < listaTareas.size(); i++) {
            objeto1.addProperty("ID: ", listaTareas.get(i).getId());
            objeto1.addProperty("Descripcion: ", listaTareas.get(i).getDescription());
            objeto1.addProperty("Prioridad(1-3): ", listaTareas.get(i).getPriority());
            objeto1.addProperty("Esta completa: ",listaTareas.get(i).isCompleted());
        }


        String json = new Gson().toJson(objeto1);
        String json2 = new Gson().toJson(oJsonObject);
        String j = gson.toJson(oJsonObject);


        try {
            FileWriter writer = new FileWriter(fileName+".json");
            FileWriter writer2 = new FileWriter(fileName+"2.json");
            writer.write(j);
            writer2.write(json2);

            writer.close();
            writer2.close();
        } catch (IOException e) {
            System.out.println("Algo fallo en el metodo saveTasksFile");
        }
    }

    //carga la lista de tareas desde un archivo JSON con el nombre especificado.
    void loadTasksFromFile(String fileName){
        String json="";
        try (FileReader reader = new FileReader(fileName)) {
            int character;
            while ((character=reader.read())!=-1) {
                json+=(char)character;
            }
            System.out.println(json);

        } catch (IOException e) {
            System.out.println("No encontrado");
        }
    }
}