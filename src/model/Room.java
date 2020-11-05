package model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private int capacity;
    private List<String> features;
    private List<Interval> bookedIntervals;

    public Room(int id,int capacity){
        this.id= id;
        this.capacity = capacity;
        this.features = new ArrayList<>();
        this.bookedIntervals = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<String> getFeatures() {
        return features;
    }

    public List<Interval> getBookedIntervals() {
        return bookedIntervals;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public void setBookedIntervals(List<Interval> bookedIntervals) {
        this.bookedIntervals = bookedIntervals;
    }

    public int getId() {
        return id;
    }
}
