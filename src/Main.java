
public class Main {
    public static void main(String[] args) {

       /*  PowerSupply powerSupply = new PowerSupply(750, "80 Plus gold");

        Computer computer = new Computer(
                "Game PC",
                "Intel core i7",
                32,
                1000,
                "RTX 4070",
                true,
                true,
                "Windows 11",
                "Liquid Cooling",
                true,
                powerSupply
        );


        System.out.println("Computer is created!");
    }

    }

 */
        PowerSupply powerSupply =
                new PowerSupply(750, "80 Plus gold");

        Computer computer = new Computer.Builder(
                "Game PC",
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

        System.out.println("Computer is created!");
    }
}


