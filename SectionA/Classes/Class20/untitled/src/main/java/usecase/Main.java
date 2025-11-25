package usecase;

public class Main {
    public static void main(String[] args) {

        SmartHomeHub hub = new SmartHomeHub();

        SmartDevice light1 = new LightBulb("Light-1");
        SmartDevice light2 = new LightBulb("Light-2");
        Thermometer thermometer = new Thermometer("Thermo-1", 25.0);
        SmartDevice camera = new SecurityCamera("Cam-1");

        hub.registerDevice(light1);
        hub.registerDevice(light2);
        hub.registerDevice(thermometer);
        hub.registerDevice(camera);

        hub.turnEverythingOn();

        // --- Functional interface: anonymous class vs lambda ---

        // Anonymous class (Java 7 style)
        DeviceCommand printStatusOldStyle = new DeviceCommand() {
            @Override
            public void execute(SmartDevice device) {
                System.out.println(device.getId() + " isOn = " + device.isOn());
            }
        };

        hub.applyToAll(printStatusOldStyle);

        // Lambda (Java 8+ style)
        DeviceCommand printStatus = device ->
                System.out.println("[Lambda] " + device.getId() + " isOn = " + device.isOn());

        hub.applyToAll(printStatus);

        // Another lambda: turn off only lights
        DeviceCommand turnOffLightsOnly = device -> {
            if (device instanceof LightBulb) {
                device.turnOff();
            }
        };

        hub.applyToAll(turnOffLightsOnly);

        // Using default method andThen
        DeviceCommand printThenOff =
                printStatus.andThen(device -> {
                    if (device.isOn()) {
                        device.turnOff();
                        System.out.println(" -> turned OFF by chained command");
                    }
                });

        hub.applyToAll(printThenOff);

        // --- Marker interface in action ---

        hub.turnEverythingOn(); // ensure all ON

        System.out.println("\nSimulating power cut: critical devices shut down first.");
        hub.shutdownCriticalDevicesFirst();
    }
}

