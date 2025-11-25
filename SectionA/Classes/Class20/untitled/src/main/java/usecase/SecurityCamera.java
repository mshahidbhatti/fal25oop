package usecase;

public class SecurityCamera implements SmartDevice, CriticalDevice {
    private final String id;
    private boolean on;

    public SecurityCamera(String id) {
        this.id = id;
        this.on = false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void turnOn() {
        on = true;
        System.out.println("SecurityCamera " + id + " is now ON");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("SecurityCamera " + id + " is now OFF");
    }

    @Override
    public boolean isOn() {
        return on;
    }
}

