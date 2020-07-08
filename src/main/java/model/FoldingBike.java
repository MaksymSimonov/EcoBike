package model;

public class FoldingBike extends Bike {
  private final int sizeOfWheels;
  private final int numberOfGears;

  public FoldingBike(int bikeId,
                     TypeOfBike typeOfBike,
                     String brand,
                     int sizeOfWheels,
                     int numberOfGears,
                     int weight,
                     boolean availabilityLights,
                     String color,
                     int price) {
    super(bikeId, typeOfBike,  brand, weight, availabilityLights, color, price);
    this.sizeOfWheels = sizeOfWheels;
    this.numberOfGears = numberOfGears;
  }

  public int getSizeOfWheels() {
    return sizeOfWheels;
  }

  public int getNumberOfGears() {
    return numberOfGears;
  }
}
