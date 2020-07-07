package model;

public class FoldingBike extends Bike {
  private final int sizeOfWheels;
  private final int numberOfGears;

  public FoldingBike(int bikeId,
                     String brand,
                     int sizeOfWheels,
                     int numberOfGears,
                     int weight,
                     boolean availabilityLights,
                     String color,
                     String price) {
    super(bikeId, brand, weight, availabilityLights, color, price);
    this.sizeOfWheels = sizeOfWheels;
    this.numberOfGears = numberOfGears;
  }
}
