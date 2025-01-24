public class CommonRoom extends Room {

    private final String type;

    // limiting the types of common rooms to 'Gym', 'Library', and 'Laundry'
    public CommonRoom(int id, String type) {
        super(id);
        switch (type.toUpperCase()) {
            case "GYM":
            case "LIBRARY":
            case "LAUNDRY":
                this.type = type;
                break;
            default:
                throw new IllegalArgumentException("Invalid common room type. Must be Gym, Library, or Laundry.");
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