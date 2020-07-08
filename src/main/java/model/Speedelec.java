package model;

public class Speedelec extends Bike {
  private final int maximumSpeed;
  private final int batteryCapacity;

  public Speedelec(int bikeId,
                   TypeOfBike typeOfBike,
                   String brand,
                   int maximumSpeed,
                   int weight,
                   boolean availabilityLights,
                   int batteryCapacity,
                   String color,
                   int price) {
    super(bikeId, typeOfBike, brand, weight, availabilityLights, color, price);
    this.maximumSpeed = maximumSpeed;
    this.batteryCapacity = batteryCapacity;
  }

  public int getMaximumSpeed() {
    return maximumSpeed;
  }

  public int getBatteryCapacity() {
    return batteryCapacity;
  }
}
