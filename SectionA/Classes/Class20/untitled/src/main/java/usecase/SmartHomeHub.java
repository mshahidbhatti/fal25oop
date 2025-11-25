package usecase;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeHub {

    private final List<SmartDevice> devices = new ArrayList<>();

    public void registerDevice(SmartDevice device) {
        devices.add(device);
    }

    public void turnEverythingOn() {
        System.out.println("\nTurning all devices ON:");
        for (SmartDevice d : devices) {
            d.turnOn();
        }
    }

    public void turnEverythingOff() {
        System.out.println("\nTurning all devices OFF:");
        for (SmartDevice d : devices) {
            d.turnOff();
        }
    }

    // Uses functional interface DeviceCommand
    public void applyToAll(DeviceCommand command) {
        System.out.println("\nApplying command to all devices:");
        for (SmartDevice d : devices) {
            command.execute(d);
        }
    }

    // Uses marker interface CriticalDevice
    public void shutdownCriticalDevicesFirst() {
        System.out.println("\nShutting down CRITICAL devices first:");
        for (SmartDevice d : devices) {
            if (d instanceof CriticalDevice) {
                d.turnOff();
            }
        }

        System.out.println("\nNow shutting down non-critical devices:");
        for (SmartDevice d : devices) {
            if (!(d instanceof CriticalDevice)) {
                d.turnOff();
            }
        }
    }
}

