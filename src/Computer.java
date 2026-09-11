public class Computer {
    // Required
    private String name;
    private String cpu;
    private int ram;
    private int storage;

    // optional
    private String gpu;
    private boolean wifiEnable;
    private boolean bluetoothEnable;
    private String operatingSystem;
    private String coolingType;
    private boolean rgbEnable;

    // Nested object
    private PowerSupply powerSupply;

    public Computer(
            String name,
            String cpu,
            int ram,
            int storage,
            String gpu,
            boolean wifiEnable,
            boolean bluetoothEnable,
            String operatingSystem,
            String coolingType,
            boolean rgbEnable,
            PowerSupply powerSupply
    ) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
        this.wifiEnable = wifiEnable;
        this.bluetoothEnable = bluetoothEnable;
        this.operatingSystem = operatingSystem;
        this.coolingType = coolingType;
        this.rgbEnable = rgbEnable;
        this.powerSupply = powerSupply;
    }


}
