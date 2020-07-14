package entities;

import java.util.Objects;

public class FoldingBike extends Bike {
  private final TypeOfBike typeOfBike = TypeOfBike.FOLDINGBIKE;
  private int sizeOfWheels;
  private int numberOfGears;

  public FoldingBike(){

  }

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

  @Override
  public TypeOfBike getTypeOfBike() {
    return typeOfBike;
  }

  public int getSizeOfWheels() {
    return sizeOfWheels;
  }

  public int getNumberOfGears() {
    return numberOfGears;
  }

  public void setSizeOfWheels(int sizeOfWheels) {
    this.sizeOfWheels = sizeOfWheels;
  }

  public void setNumberOfGears(int numberOfGears) {
    this.numberOfGears = numberOfGears;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    FoldingBike foldingBike = (FoldingBike) o;
    return sizeOfWheels == foldingBike.getSizeOfWheels() &&
            numberOfGears == foldingBike.getNumberOfGears() &&
            typeOfBike == foldingBike.getTypeOfBike();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), typeOfBike, sizeOfWheels, numberOfGears);
  }

  @Override
  public String toString() {
    return "FoldingBike{" +
            "typeOfBike=" + typeOfBike +
            ", sizeOfWheels=" + sizeOfWheels +
            ", numberOfGears=" + numberOfGears +
            ", availabilityLights=" + super.isAvailabilityLights() +
            ", getBrand=" + super.getBrand() +
            ", getColor=" + super.getColor() +
            ", getId=" + super.getId() +
            ", getPrice=" + super.getPrice() +
            ", getWeight=" + super. getWeight()+
            '}';
  }
}
