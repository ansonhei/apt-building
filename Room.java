import java.util.Random;

public class Room {
    private final int id;
    private double currentT;
    private boolean heatingEnabled;
    private boolean coolingEnabled;


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

    // toString method
    @Override
    public String toString() {
        return "Room [id=" + id + ", currentT=" + currentT + ", heatingEnabled=" + heatingEnabled + ", coolingEnabled="
                + coolingEnabled + "]";
    }

}