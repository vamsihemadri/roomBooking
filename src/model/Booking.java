package model;

import java.util.List;

public class Booking {

    Room room;
    User createdByUser;
    List<User> participants;
    Interval interval;

    public Booking(Room room, Interval interval, List<User> participants, User creatingUser) {
        this.room = room;
        this.createdByUser = creatingUser;
        this.participants = participants;
        this.interval = interval;
    }
}
