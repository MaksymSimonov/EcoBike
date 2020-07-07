package model;

import dao.Identifiable;

public class Bike implements Identifiable{
  private final int bikeId;
  private final String brand;
  private final int weight;
  private final boolean availabilityLights;
  private final String color;
  private final String price;

  public Bike(int bikeId, String brand, int weight, boolean availabilityLights, String color, String price) {
    this.bikeId = bikeId;
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
