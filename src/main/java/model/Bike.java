package model;

import dao.Identifiable;

import java.util.Objects;

public class Bike implements Identifiable{
  private final int bikeId;
  private final TypeOfBike typeOfBike;
  private final String brand;
  private final int weight;
  private final boolean availabilityLights;
  private final String color;
  private final int price;

  public Bike(int bikeId,
              TypeOfBike typeOfBike,
              String brand,
              int weight,
              boolean availabilityLights,
              String color,
              int price) {
    this.bikeId = bikeId;
    this.typeOfBike =  typeOfBike;
    this.brand = brand;
    this.weight = weight;
    this.availabilityLights = availabilityLights;
    this.color = color;
    this.price = price;
  }

  @Override
  public int getId() {
    return bikeId;
  }

  public TypeOfBike getTypeOfBike() {
    return typeOfBike;
  }

  public String getBrand() {
    return brand;
  }

  public int getWeight() {
    return weight;
  }

  public boolean isAvailabilityLights() {
    return availabilityLights;
  }

  public String getColor() {
    return color;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bike bike = (Bike) o;
    return bikeId == bike.bikeId &&
            weight == bike.weight &&
            availabilityLights == bike.availabilityLights &&
            price == bike.price &&
            typeOfBike == bike.typeOfBike &&
            Objects.equals(brand, bike.brand) &&
            Objects.equals(color, bike.color);
  }

  @Override
  public int hashCode() {

    return Objects.hash(bikeId, typeOfBike, brand, weight, availabilityLights, color, price);
  }
}
