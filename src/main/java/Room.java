import java.util.Random;

public class Room {
    private final int id;
    private double currentT;
    private boolean heatingEnabled;
    private boolean coolingEnabled;
    public double defaultRequestedTemperature = 20.0;


    public Room(int id) {
        this.id = id;
        this.currentT = generateRandomT(10, 40);;
        this.heatingEnabled = false;
        this.coolingEnabled = false;
    }

    /**
     * @return room id
     */
    public int getId() {
        return id;
    }

    /**
     * @return current temperature of the room
     */
    public double getCurrentT() {
        return currentT;
    }

    /**
     * @return heating status
     */
    public boolean isHeatingEnabled() {
        return heatingEnabled;
    }

    /**
     * @return cooling status
     */
    public boolean isCoolingEnabled() {
        return coolingEnabled;
    }


    /**
     * Generates a random temperature between the specified minimum and maximum values.
     *
     * @param min the minimum temperature value
     * @param max the maximum temperature value
     * @return a random temperature within the specified range
     */

    public double generateRandomT(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

    /*
     * Simulate temperature changes based on the heating and cooling status of the room.    
     * 
     * @param check if heating is enabled, false otherwise
     * @param check if cooling is enabled, false otherwise
     * if heating is enabled, increase the current temperature by 0.5
     * if cooling is enabled, decrease the current temperature by 0.5
     */
    public void updateTemperature(boolean heating, boolean cooling) {
        if (heating) {
            currentT += 0.5; // Simulate heating effect
        } else if (cooling) {
            currentT -= 0.5; // Simulate cooling effect
        }
    }

    /*
     * Set the temperature control for the room based on the requested temperature and tolerance.
     * 
     * @param requestedTemperature the desired temperature for the room
     * @param tolerance the tolerance range for temperature control
     * if the current temperature is less than the requested temperature minus the tolerance, enable heating
     * if the current temperature is greater than the requested temperature plus the tolerance, enable cooling
     * otherwise, disable both heating and cooling
     */
    public void setTemperatureControl(double requestedTemperature, double tolerance) {
        if (currentT < requestedTemperature - tolerance) {
            heatingEnabled = true;
            coolingEnabled = false;
        } else if (currentT > requestedTemperature + tolerance) {
            coolingEnabled = true;
            heatingEnabled = false;
        } else {
            heatingEnabled = false;
            coolingEnabled = false;
        }
    }
    

    // toString method
    @Override
    public String toString() {
        return "Room: id=" + id + ", currentT=" + currentT + ", heatingEnabled=" + heatingEnabled + ", coolingEnabled="
                + coolingEnabled;
    }

}