public class ComputerDirector {
    public Computer createBasicPC() {
        PowerSupply powerSupply =
                new PowerSupply(500, "80 Plus Bronze");

        return new Computer.Builder(
                "Basic PC",
                "Intel core i5",
                8,
                512
        )
                .enableWifi()
                .operatingSystem("Windows 11")
                .powerSupply(powerSupply)
                .build();

    }
    public Computer createGamingPC() {
        PowerSupply powerSupply =
                new PowerSupply(750, "80 Plus Gold");

        return new Computer.Builder(
                "Gaming PC",
                "intel core i7",
                32,
                1000
        )
                .gpu("RTX 4070")
                .enableWifi()
                .enableBluetooth()
                .operatingSystem("Windows 11")
                .coolingType("Liquid Cooling")
                .enableRgb()
                .powerSupply(powerSupply)
                .build();
    }
    public Computer createWorkstationPC() {
        PowerSupply powerSupply =
                new PowerSupply(850, "80 Plus Gold");

        return new Computer.Builder(
                "Workstation PC",
                "Intel Core i9",
                64,
                2000
        )
                .gpu("RTX 4080")
                .enableWifi()
                .enableBluetooth()
                .operatingSystem("Windows 11 Pro")
                .coolingType("Liquid Cooling")
                .powerSupply(powerSupply)
                .build();
    }
}





