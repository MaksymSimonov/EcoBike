package model;

import java.util.Objects;

public class Speedelec extends Bike {
  private final int maximumSpeed;
  private final int batteryCapacity;

  public Speedelec(int bikeId,
                   TypeOfBike typeOfBike,
                   String brand,
                   int maximumSpeed,
                   int weight,
                   boolean availabilityLights,
                   int batteryCapacity,
                   String color,
                   int price) {
    super(bikeId, typeOfBike, brand, weight, availabilityLights, color, price);
    this.maximumSpeed = maximumSpeed;
    this.batteryCapacity = batteryCapacity;
  }

  public int getMaximumSpeed() {
    return maximumSpeed;
  }

  public int getBatteryCapacity() {
    return batteryCapacity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Speedelec speedelec = (Speedelec) o;
    return this.getId() == speedelec.getId() &&
            this.getWeight() == speedelec.getWeight() &&
            this.isAvailabilityLights() == speedelec.isAvailabilityLights() &&
            this.getPrice() == speedelec.getPrice() &&
            Objects.equals(this.getTypeOfBike(), speedelec.getTypeOfBike()) &&
            Objects.equals(this.getBrand(), speedelec.getBrand()) &&
            Objects.equals(this.getColor(), speedelec.getColor()) &&
            maximumSpeed == speedelec.maximumSpeed &&
            batteryCapacity == speedelec.batteryCapacity;
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), maximumSpeed, batteryCapacity);
  }
}
