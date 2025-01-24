public class CommonRoom extends Room {

    private final String type;

    // Limiting the types of common rooms to 'Gym', 'Library', and 'Laundry'
public CommonRoom(int id, String type) {
    super(id);
    switch (type.toUpperCase()) {
        case "GYM" -> this.type = "gym";
        case "LIBRARY" -> this.type = "library";
        case "LAUNDRY" -> this.type = "laundry";
        default -> throw new IllegalArgumentException("Invalid common room type. Must be Gym, Library, or Laundry.");
    }
}


    /**
     * @return room type
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "\nCommonRoom:" +
                "\nid='" + getId() + '\'' +
                ", type='" + type + '\'' +
                ", currentTemperature=" + getCurrentT() +
                ", heatingEnabled=" + isHeatingEnabled() +
                ", coolingEnabled=" + isCoolingEnabled();
    }
}