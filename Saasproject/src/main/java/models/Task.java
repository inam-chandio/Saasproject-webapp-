package models;
import java.util.Date;
public class Task {
    private int id;
    private String description;
    private Date dueDate;
    private boolean completed;
    private int points;

    // Getters and setters for Task
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
}
