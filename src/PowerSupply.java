public class PowerSupply {

    private int wattage;
    private String certification;

    public PowerSupply(int wattage, String certification) {
        this.wattage = wattage;
        this.certification = certification;

    }

    public int getWattage() {
        return wattage;
    }
    public String getCertification() {
        return certification;
    }
}
