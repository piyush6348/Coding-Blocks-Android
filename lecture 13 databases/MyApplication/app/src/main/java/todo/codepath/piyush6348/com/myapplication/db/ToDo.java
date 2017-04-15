package todo.codepath.piyush6348.com.myapplication.db;

/**
 * Created by dell on 4/15/2017.
 */

public class ToDo {
    private String task;
    private Boolean done;
    private int id;
    
    public ToDo(String task, Boolean done, int id) {
        this.task = task;
        this.done = done;
        this.id = id;
    }
    public ToDo(String task, Boolean done) {
        this.task = task;
        this.done = done;
    }

    public String getTask() {
        return task;
    }

    public Boolean getDone() {
        return done;
    }

    public int getId() {
        return id;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
