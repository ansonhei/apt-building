public class Apartment extends Room{

    private final String ownerName;

    public Apartment(int id, String ownerName) {
        super(id);
        this.ownerName = ownerName;
    
    }

    /**
     * @return owner name
     */
    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id='" + getId() + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", currentTemperature=" + getCurrentT() +
                ", heatingEnabled=" + isHeatingEnabled() +
                ", coolingEnabled=" + isCoolingEnabled() +
                '}';
    }

}
