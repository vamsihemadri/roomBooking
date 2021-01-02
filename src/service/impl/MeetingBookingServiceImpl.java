package service.impl;

import model.Booking;
import model.Interval;
import model.Room;
import model.User;
import service.MeetingBookingService;

import java.util.List;
import java.util.stream.Collectors;

public class MeetingBookingServiceImpl implements MeetingBookingService {

    private final RoomInventoryImpl roomInventory;

    public MeetingBookingServiceImpl(RoomInventoryImpl roomInventory){
        this.roomInventory = roomInventory;
    }

    @Override
    public List<Room> searchBasedOnCriteria(int capacity, List<String> features, Interval interval) {
        return roomInventory.getRoomsInInventory()
                .stream()
                .filter(v->v.getCapacity() >= capacity)
                .filter(v-> eachFeaturePresent(features,v.getFeatures()))
                .filter(v-> roomAvailableInInterval(interval, v.getBookedIntervals()))
                .collect(Collectors.toList());
    }

    // helper method
    private boolean roomAvailableInInterval(Interval interval, List<Interval>roomBookedIntervals){
        return noIntersectingIntervalsPresent(roomBookedIntervals,interval);
    }

    private boolean noIntersectingIntervalsPresent(List<Interval> intervals, Interval interval){
        for(Interval i: intervals){
            if(areIntervalsIntersecting(i,interval))
                return false;
        }
        return true;
    }

    private boolean areIntervalsIntersecting(Interval a, Interval b){

        if(b.getToMinute() > a.getFromMinute() && b.getToMinute() < a.getToMinute())
            return true;
        return b.getFromMinute() > a.getFromMinute() && b.getFromMinute() < a.getToMinute();
    }

    private boolean eachFeaturePresent(List<String> featuresRequested, List<String>featuresAvailable){
        for(String feature : featuresRequested){
            if(!featuresAvailable.contains(feature)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Booking createBooking(Room room, Interval interval, List<User> participants, User creatingUser) {
        if(noIntersectingIntervalsPresent(room.getBookedIntervals(),interval)){
            room.getBookedIntervals().add(interval);
            return new Booking(room,interval,participants, creatingUser);
        }
        return null;
    }

    @Override
    public Booking reschedule(Booking booking, Interval newInterval) {
        return null;
    }

    @Override
    public Booking cancelBooking(Booking booking) {
        return null;
    }
}
