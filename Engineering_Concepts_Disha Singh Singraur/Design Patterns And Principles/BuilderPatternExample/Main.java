public class Main {
    public static void main(String[] args) {
        System.out.println("--- Builder Pattern Test ---");

        // Basic Office PC
        Computer officePC = new Computer.Builder("Intel i3", "8GB", "256GB SSD")
                                .build();
        System.out.println("Office PC: " + officePC);

        // Gaming PC with graphics card and bluetooth enabled
        Computer gamingPC = new Computer.Builder("AMD Ryzen 7", "16GB", "1TB NVMe SSD")
                                .setGraphicsCardEnabled(true)
                                .setBluetoothEnabled(true)
                                .build();
        System.out.println("Gaming PC: " + gamingPC);

        // Server build with only bluetooth optional component disabled but extra specs
        Computer serverPC = new Computer.Builder("Intel Xeon", "64GB", "4TB HDD")
                                .setGraphicsCardEnabled(false)
                                .setBluetoothEnabled(false)
                                .build();
        System.out.println("Server: " + serverPC);
    }
}
