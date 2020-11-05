import model.Interval;
import model.Room;
import model.User;
import service.MeetingBookingService;
import service.RoomInventory;
import service.impl.MeetingBookingServiceImpl;
import service.impl.RoomInventoryImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application{

    public static void main(String[] args) throws Exception {
        //BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hi there");

        Room room1 = new Room(1,10);
        Room room2 = new Room(2, 20);

        User adminUser = new User("ea","na",true);
        RoomInventoryImpl roomInventory= RoomInventoryImpl.getRoomInventory();

        roomInventory.addRoom(room1, Arrays.asList("conference","white board"),adminUser);
        roomInventory.addRoom(room2, Arrays.asList("conference"),adminUser);

        MeetingBookingService meetingBookingService = new MeetingBookingServiceImpl(roomInventory);

        Interval interval = new Interval("today",50,"today",500);
        meetingBookingService.searchBasedOnCriteria(5,Arrays.asList("conference"),interval);

        User p = new User("pe","pa",false);
        Interval interval1 = new Interval("today",100,"today",600);


        meetingBookingService.createBooking(room1,interval1,Arrays.asList(p),adminUser);

        meetingBookingService.searchBasedOnCriteria(5,Arrays.asList("conference"),interval);
    }
}