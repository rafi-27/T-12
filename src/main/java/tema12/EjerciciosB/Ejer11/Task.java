package tema12.EjerciciosB.Ejer11;

public class Task {
    private int id;
    private String description;
    private int priority;
    boolean completed;
    
    public Task(int id, String description, int priority, boolean completed) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.completed = completed;
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
        return "Task [id=" + id + ", description=" + description + ", priority=" + priority + ", completed=" + completed
                + "]";
    }
}