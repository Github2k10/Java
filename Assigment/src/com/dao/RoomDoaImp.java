package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Room;
import com.dto.RoomImp;
import com.exception.RoomException;

public class RoomDoaImp implements RoomDao {
	
	private boolean isResultRestEmpty(ResultSet set) throws SQLException {
		if(!set.isBeforeFirst() && set.getRow() == 0) {
			return false;
		}
		
		return true;
	}
	
	private List<Room> getList(ResultSet set) throws SQLException{
		List<Room> list = new ArrayList<>();
		
		while(set.next()) {
			Room room = new RoomImp();
			
			room.setRoomNumber(set.getInt(1));
			room.setRoomType(set.getString(2));
			room.setPricePerNight(set.getDouble(3));
			room.setMaxPerson(set.getInt(4));
			room.setEmpty(set.getBoolean(5));
			
			list.add(room);
		}
		
		return list;
	}

	@Override
	public boolean addRoom(Room room) throws RoomException {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "insert into room values ( ?, ?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, room.getRoomNumber());
			statement.setString(2, room.getRoomType());
			statement.setDouble(3, room.getPricePerNight());
			statement.setInt(4, room.getMaxPerson());
			statement.setBoolean(5, room.isEmpty());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new RoomException();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				throw new RoomException();
			}
		}
		
		return false;
	}

	@Override
	public Room getRoomByRoomType(String name) throws RoomException {
		Connection connection = null;
		Room room = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "select * from room where roomtype = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			
			ResultSet set = statement.executeQuery();
			
			if(isResultRestEmpty(set)) {
				throw new RoomException();
			}
			
			set.next();
			
			room = new RoomImp();
			
			room.setRoomNumber(set.getInt(1));
			room.setRoomType(set.getString(2));
			room.setPricePerNight(set.getDouble(3));
			room.setMaxPerson(set.getInt(4));
			room.setEmpty(set.getBoolean(5));
			
		} catch (SQLException e) {
			throw new RoomException();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				throw new RoomException();
			}
		}
		
		return room;
	}

	@Override
	public List<Room> getEmptyRoom() throws RoomException {
		Connection connection = null;
		List<Room> list = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "select * from room where roomtype = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setBoolean(1, false);
			
			ResultSet set = statement.executeQuery();
			
			if(isResultRestEmpty(set)) {
				throw new RoomException();
			}
			
			list = getList(set);
		} catch (SQLException e) {
			throw new RoomException();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				throw new RoomException();
			}
		}

		return list;
	}

	@Override
	public List<Room> getAllRoomDetails() {
		Connection connection = null;
		List<Room> list = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "select * from room";
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet set = statement.executeQuery();
			
			if(isResultRestEmpty(set)) {
				System.out.println("Empty table found");
				return null;
			}
			
			list = getList(set);
		} catch (SQLException e) {
			
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
			}
		}

		return list;
	}

}
