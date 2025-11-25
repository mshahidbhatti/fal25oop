package usecase;

public class Thermometer implements Sensor {
    private final String id;
    private boolean on;
    private double temperature;

    public Thermometer(String id, double initialTemperature) {
        this.id = id;
        this.temperature = initialTemperature;
        this.on = false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void turnOn() {
        on = true;
        System.out.println("Thermometer " + id + " is now ON");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("Thermometer " + id + " is now OFF");
    }

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public double readValue() {
        if (!on) {
            System.out.println("Thermometer " + id + " is OFF, returning last known value");
        }
        return temperature;
    }

    // To simulate change, let’s add:
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}

