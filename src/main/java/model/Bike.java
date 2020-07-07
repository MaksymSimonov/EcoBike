package model;

import dao.Identifiable;

public class Bike implements Identifiable{
  private final String bikeId;
  private String brand;
  private int weight;
  private boolean availabilityLights;
  private String color;
  private String price;

  public Bike(String bikeId, String brand, int weight, boolean availabilityLights, String color, String price) {
    this.bikeId = bikeId;
    this.brand = brand;
    this.weight = weight;
    this.availabilityLights = availabilityLights;
    this.color = color;
    this.price = price;
  }

  @Override
  public String getId() {
    return bikeId;
  }

  @Override
  public String toString() {
    return "Bike{" +
            "bikeId='" + bikeId + '\'' +
            ", brand='" + brand + '\'' +
            ", weight=" + weight +
            ", availabilityLights=" + availabilityLights +
            ", color='" + color + '\'' +
            ", price='" + price + '\'' +
            '}';
  }
}
