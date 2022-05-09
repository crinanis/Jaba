package Broadcasting;

import java.io.Serializable;
import java.util.ArrayList;

public class Broadcast extends Info implements IBroadcast, Serializable {

    public static ArrayList<Broadcast> collection = new ArrayList<Broadcast>();

    private String name;
    private String title;
    private int year;
    private int duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { this.title = title; }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getInfo() {
        return null;
    }


}
