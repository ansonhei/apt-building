package main.java;
import java.util.ArrayList;
import java.util.List;


public class Building {
    private final List<Room> rooms;
    private double requestedTemperature = 20.0;

    // tolerance for temperature control
    private double tolerance;

    public Building(double requestedTemperature, double tolerance) {
        this.rooms = new ArrayList<>();
        this.requestedTemperature = requestedTemperature;
        this.tolerance = tolerance;
    }

    // Add a room to the building
    public void addRoom(Room room) {
        rooms.add(room);
    }

    //Update the temperature control for each room
    public void updateRoomControls() {
        for (Room room : rooms) {
            room.setTemperatureControl(requestedTemperature, tolerance);
        }
    }

    // Simulate temperature changes based on the heating and cooling status of each room
    public void simulateTemperatureChanges() {
        for (Room room : rooms) {
            room.updateTemperature(room.isHeatingEnabled(), room.isCoolingEnabled());
        }
    }

    // set the requested temperature
    public void setRequestedTemperature(double requestedTemperature) {
        this.requestedTemperature = requestedTemperature;
        updateRoomControls();
    }

    // set temperature tolerance of the building
    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
        updateRoomControls();
    }

    // get the list of rooms
    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return "Building: " +
                "requestedTemperature=" + requestedTemperature +
                ", rooms=" + rooms;
    }
}