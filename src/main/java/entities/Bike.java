package entities;

import dao.Identifiable;

import java.util.Objects;

public class Bike implements Identifiable{
  private int bikeId;
  private TypeOfBike typeOfBike;
  private String brand;
  private int weight;
  private boolean availabilityLights;
  private String color;
  private int price;

  public Bike(){

  }

  public Bike(String brand,
              int weight,
              boolean availabilityLights,
              String color,
              int price) {
    this.brand = brand;
    this.weight = weight;
    this.availabilityLights = availabilityLights;
    this.color = color;
    this.price = price;
  }

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

  public void setBikeId(int bikeId) {
    this.bikeId = bikeId;
  }

  public void setTypeOfBike(TypeOfBike typeOfBike) {
    this.typeOfBike = typeOfBike;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public void setAvailabilityLights(boolean availabilityLights) {
    this.availabilityLights = availabilityLights;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bike bike = (Bike) o;
    return weight == bike.getWeight() &&
            availabilityLights == bike.isAvailabilityLights() &&
            price == bike.getPrice() &&
            Objects.equals(brand, bike.getBrand()) &&
            Objects.equals(color, bike.getColor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(brand, weight, availabilityLights, color, price);
  }

  @Override
  public String toString() {
    return "Bike{" +
            "bikeId=" + bikeId +
            ", typeOfBike=" + typeOfBike +
            ", brand='" + brand + '\'' +
            ", weight=" + weight +
            ", availabilityLights=" + availabilityLights +
            ", color='" + color + '\'' +
            ", price=" + price +
            '}';
  }
}
