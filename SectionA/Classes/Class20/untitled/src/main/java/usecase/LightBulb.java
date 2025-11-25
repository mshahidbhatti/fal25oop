package usecase;

public class LightBulb implements SmartDevice {
    private final String id;
    private boolean on;

    public LightBulb(String id) {
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
        System.out.println("LightBulb " + id + " is now ON");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("LightBulb " + id + " is now OFF");
    }

    @Override
    public boolean isOn() {
        return on;
    }
}

