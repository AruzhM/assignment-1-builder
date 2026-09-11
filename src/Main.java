public class Main {
    public static void main(String[] args) {

        PowerSupply powerSupply = new PowerSupply(750, "80 Plus gold");

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
