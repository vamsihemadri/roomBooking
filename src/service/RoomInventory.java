package service;

import model.Room;
import model.User;

import java.util.List;

public interface RoomInventory {

    Room addRoom(Room room, List<String> features, User user);

    Room updateRoom(int roomId,int capacity, List<String> features,User user);
}
