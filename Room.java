import java.util.Random;

public class Room {
    private final String id;
    private double currentT;
    private boolean heatingEnabled;
    private boolean coolingEnabled;


    // Constructor for the Room class
    public Room(String id) {
        this.id = id;
        this.currentT = generateRandomTemperature(10, 40);;
        this.heatingEnabled = false;
        this.coolingEnabled = false;
    }

     /**
     * @return room id
     */
    public String getId() {
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

    public double generateRandomTemperature(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

    // toString method
    @Override
    public String toString() {
        return "Room [id=" + id + ", currentT=" + currentT + ", heatingEnabled=" + heatingEnabled + ", coolingEnabled="
                + coolingEnabled + "]";
    }

}