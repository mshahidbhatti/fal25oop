package usecase;

@FunctionalInterface
public interface DeviceCommand {
    void execute(SmartDevice device);

    // Optional: default method to chain commands
    default DeviceCommand andThen(DeviceCommand after) {
        return d -> {
            this.execute(d);
            after.execute(d);
        };
    }
}
