package service;

import model.Booking;
import model.Interval;
import model.Room;
import model.User;

import java.util.List;

public interface MeetingBookingService {

    List<Room> searchBasedOnCriteria(int capacity, List<String> features, Interval interval);

    Booking createBooking(Room room, Interval interval, List<User> participants, User creatingUser);

    Booking reschedule(Booking booking, Interval newInterval);

    Booking cancelBooking(Booking booking);
}
