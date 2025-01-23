public class CommonRoom extends Room {

    private final String type;

    public CommonRoom(int id, String type) {
        super(id);
        this.type = type;

    }

    /**
     * @return room type
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "CommonRoom{" +
                "id='" + getId() + '\'' +
                ", type='" + type + '\'' +
                ", currentTemperature=" + getCurrentT() +
                ", heatingEnabled=" + isHeatingEnabled() +
                ", coolingEnabled=" + isCoolingEnabled() +
                '}';
    }
}