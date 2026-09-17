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
        this.storage = storage;
        this.gpu = gpu;
        this.wifiEnable = wifiEnable;
        this.bluetoothEnable = bluetoothEnable;
        this.operatingSystem = operatingSystem;
        this.coolingType = coolingType;
        this.rgbEnable = rgbEnable;
        this.powerSupply = powerSupply;
    }

    public static class Builder {


        private String name;
        private String cpu;
        private int ram;
        private int storage;

        private String gpu;
        private boolean wifiEnable = false;
        private boolean bluetoothEnable = false;
        private String operatingSystem = "Windows 11";
        private String coolingType = "Air Cooling";
        private boolean rgbEnable = false;

        private PowerSupply powerSupply;

        public Builder(String name, String cpu, int ram, int storage) {
            this.name = name;
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder enableWifi() {
            this.wifiEnable = true;
            return this;
        }

        public Builder enableBluetooth() {
            this.bluetoothEnable = true;
            return this;
        }

        public Builder operatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Builder coolingType(String coolingType) {
            this.coolingType = coolingType;
            return this;
        }

        public Builder enableRgb() {
            this.rgbEnable = true;
            return this;
        }

        public Builder powerSupply(PowerSupply powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Computer build() {
            validate();

            return new Computer(
                    name,
                    cpu,
                    ram,
                    storage,
                    gpu,
                    wifiEnable,
                    bluetoothEnable,
                    operatingSystem,
                    coolingType,
                    rgbEnable,
                    powerSupply
            );
        }



        private void validate() {
            validateRequiredFields();
            validatePositiveValues();
            validateDependencies();
        }

        private void validateRequiredFields() {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException(
                        "Computer name cannot be empty"
                );
            }
        }

        private void validatePositiveValues() {
            if (ram <= 0) {
                throw new IllegalArgumentException(
                        "RAM must be greater than 0"
                );
            }

            if (storage <= 0)
                throw new IllegalArgumentException(
                        "Storage must be greater than 0");

        }


        private void validateDependencies() {
            if (rgbEnable && (gpu == null || gpu.isBlank())) {
                throw new IllegalArgumentException(
                        "GPU is required when RGB is enabled");
            }

            if ("Liquid Cooling".equals(coolingType) && ram < 16) {
                throw new IllegalArgumentException(
                        "Liquid Cooling requires at least 16 GB of RAM");
            }
        }
    }
    public String getName(){
        return name;
    }
    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public boolean isWifiEnable() {
        return wifiEnable;
    }

    public boolean isBluetoothEnable() {
        return bluetoothEnable;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getCoolingType() {
        return coolingType;
    }

    public boolean isRgbEnable() {
        return rgbEnable;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

}

