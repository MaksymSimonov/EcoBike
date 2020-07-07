package model;

public class EBike extends Bike {
  private final int maximumSpeed;
  private final int batteryCapacity;

  public EBike(int bikeId,
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
