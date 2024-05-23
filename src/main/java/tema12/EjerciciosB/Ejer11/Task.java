package tema12.EjerciciosB.Ejer11;

public class Task {
    private final int id;
    private String description;
    private int priority;//(1 para alta, 2 para media, 3 para baja)
    boolean completed;
    
    public Task(int id, String description, int priority, boolean completed) {
        this.id = id;
        this.description = description;
        setPriority(priority);
        this.completed = completed;
    }

    public int getId() {
        return id;
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
        if (priority>=1&&priority<=3) {
            this.priority=priority;
        }else{
            this.priority=3;
        }
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + ", priority=" + priority + ", completed=" + completed
                + "]";
    }
}