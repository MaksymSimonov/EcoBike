package model;

public class Speedelec extends Bike {
  private final int maximumSpeed;
  private final int batteryCapacity;

  public Speedelec(int bikeId,
                   String brand,
                   int maximumSpeed,
                   int weight,
                   boolean availabilityLights,
                   int batteryCapacity,
                   String color,
                   String price) {
    super(bikeId, brand, weight, availabilityLights, color, price);
    this.maximumSpeed = maximumSpeed;
    this.batteryCapacity = batteryCapacity;
  }
}
