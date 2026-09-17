import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerBuilderTest {
    @Test
    void shouldCreateValidGamingComputer() {

        Computer computer = new Computer.Builder(
                "Gaming PC",
                "Intel Core i7",
                32,
                1000
        )
                .gpu("RTX 4070")
                .enableWifi()
                .enableBluetooth()
                .enableRgb()
                .coolingType("Liquid Cooling")
                .build();

        assertEquals("Gaming PC", computer.getName());
        assertEquals("Intel Core i7", computer.getCpu());
        assertEquals(32, computer.getRam());
        assertEquals(1000, computer.getStorage());
        assertEquals("RTX 4070", computer.getGpu());
        assertTrue(computer.isWifiEnable());
        assertTrue(computer.isBluetoothEnable());
        assertTrue(computer.isRgbEnable());
    }

    @Test
    void shouldCreateValidBasicComputer() {

        Computer computer = new Computer.Builder(
                "Basic PC",
                "Intel Core i5",
                8,
                512
        )
                .enableWifi()
                .operatingSystem("Windows 11")
                .build();


        assertEquals("Basic PC", computer.getName());
        assertEquals("Intel Core i5", computer.getCpu());
        assertEquals(8, computer.getRam());
        assertEquals(512, computer.getStorage());


        assertTrue(computer.isWifiEnable());
        assertFalse(computer.isBluetoothEnable());

        assertEquals("Windows 11", computer.getOperatingSystem());
        assertEquals("Air Cooling", computer.getCoolingType());
        assertFalse(computer.isRgbEnable());
    }

    @Test
    void shouldCreateValidWorkstationComputer() {
        Computer computer = new Computer.Builder(
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
                .powerSupply(new PowerSupply(850, "80 Plus Gold"))
                .build();

        assertEquals("Workstation PC", computer.getName());
        assertEquals("Intel Core i9", computer.getCpu());
        assertEquals(64, computer.getRam());
        assertEquals(2000, computer.getStorage());
        assertEquals("RTX 4080", computer.getGpu());
        assertEquals("Windows 11 Pro", computer.getOperatingSystem());
        assertEquals("Liquid Cooling", computer.getCoolingType());

        assertTrue(computer.isWifiEnable());
        assertTrue(computer.isBluetoothEnable());
        assertFalse(computer.isRgbEnable());
    }

    @Test
    void shouldRejectEmptyComputerName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Computer.Builder(
                        "",
                        "Intel Core i5",
                        8,
                        512
                ).build()
        );
    }

    @Test
    void shouldRejectZeroRam() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Computer.Builder(
                        "Test PC",
                        "Intel Core i5",
                        0,
                        512
                ).build()
        );
    }

    @Test
    void shouldRejectRgbWithoutGpu() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Computer.Builder(
                        "RGB PC",
                        "Intel Core i5",
                        16,
                        512
                )
                        .enableRgb()
                        .build()
        );
    }

    @Test
    void shouldAllowLiquidCoolingWithExactly16GbRam() {

        Computer computer = new Computer.Builder(
                "Boundary PC",
                "Intel Core i5",
                16,
                512
        )
                .coolingType("Liquid Cooling")
                .build();

        assertEquals(16, computer.getRam());
        assertEquals("Liquid Cooling", computer.getCoolingType());
    }

    @Test
    void shouldRejectLiquidCoolingWith15GbRam() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Computer.Builder(
                        "Boundary PC",
                        "Intel Core i5",
                        15,
                        512
                )
                        .coolingType("Liquid Cooling")
                        .build()
        );
    }
 @Test
 void shouldAllowRgbWhenGpuIsProvided() {

        Computer computer = new Computer.Builder(
                "RGB Gaming PC",
                "Intel Core i5",
                16,
                512
        )
                .gpu("RTX 4060")
                .enableRgb()
                .build();

        assertEquals("RTX 4060", computer.getGpu());
        assertTrue(computer.isRgbEnable());
    }

    @Test
    void shouldKeepProductsIndependentWhenBuilderIsReused() {
        Computer.Builder builder = new Computer.Builder(
                "First PC",
                "Intel Core i5",
                16,
                512
        );

        Computer firstComputer = builder
                .gpu("RTX 4060")
                .build();

        Computer secondComputer = builder
                .gpu("RTX 4070")
                .enableRgb()
                .build();

        assertEquals("RTX 4060", firstComputer.getGpu());
        assertFalse(firstComputer.isRgbEnable());

        assertEquals("RTX 4070", secondComputer.getGpu());
        assertTrue(secondComputer.isRgbEnable());
    }

}


