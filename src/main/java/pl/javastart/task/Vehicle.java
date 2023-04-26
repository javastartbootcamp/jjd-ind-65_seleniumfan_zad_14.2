package pl.javastart.task;

public class Vehicle {
    private final VehicleType type;
    private final String producer;
    private final String model;
    private final int yearOfProduction;
    private final double mileage;
    private final String vin;

    public Vehicle(VehicleType type, String producer, String model, int yearOfProduction, double mileage, String vin) {
        this.type = type;
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.mileage = mileage;
        this.vin = vin;
    }

    public VehicleType getType() {
        return type;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public double getMileage() {
        return mileage;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", mileage=" + mileage +
                ", vin='" + vin + '\'' +
                '}';
    }
}
