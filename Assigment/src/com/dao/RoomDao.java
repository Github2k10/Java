package com.dao;

import java.util.List;

import com.dto.Room;
import com.exception.RoomException;

public interface RoomDao {
	public boolean addRoom(Room room) throws RoomException;
	public Room getRoomByRoomType(String name) throws RoomException;
	public List<Room> getEmptyRoom() throws RoomException;	
	public List<Room> getAllRoomDetails();
}
