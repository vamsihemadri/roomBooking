package service.impl;

import model.Room;
import model.User;
import service.RoomInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomInventoryImpl implements RoomInventory {

    public static RoomInventoryImpl getRoomInventory(){
        return roomInventory;
    }

    public List<Room> getRoomsInInventory() {
        return roomsInInventory;
    }

    private List<Room> roomsInInventory;

    public static RoomInventoryImpl roomInventory = new RoomInventoryImpl();

    private RoomInventoryImpl(){
        this.roomsInInventory = new ArrayList<>();
    }


    @Override
    public Room addRoom(Room room,List<String> features, User user) {
        if(user == null || !user.getIsAdmin() || room == null){
            return null;
        }
        room.setFeatures(features);
        roomsInInventory.add(room);
        return room;
    }

    @Override
    public Room updateRoom(int roomId,int cap, List<String> features,User user) {
        if(user == null || !user.getIsAdmin()){
            return null;
        }
        Optional<Room> roomOptional = roomsInInventory.stream()
                .filter(v-> v.getId() == roomId)
                .findFirst();
        if(!roomOptional.isPresent()){
            return null;
        }
        Room room = roomOptional.get();
        room.setCapacity(cap);
        room.setFeatures(features);
        return room;
    }
}
