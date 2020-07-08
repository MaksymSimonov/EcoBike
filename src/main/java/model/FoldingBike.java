package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoldingBike foldingBike = (FoldingBike) o;
        return this.getId() == foldingBike.getId() &&
                this.getWeight() == foldingBike.getWeight() &&
                this.isAvailabilityLights() == foldingBike.isAvailabilityLights() &&
                this.getPrice() == foldingBike.getPrice() &&
                Objects.equals(this.getTypeOfBike(), foldingBike.getTypeOfBike()) &&
                Objects.equals(this.getBrand(), foldingBike.getBrand()) &&
                Objects.equals(this.getColor(), foldingBike.getColor()) &&
                sizeOfWheels == foldingBike.sizeOfWheels &&
                numberOfGears == foldingBike.numberOfGears;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), sizeOfWheels, numberOfGears);
    }
}
