package model;

import java.util.Objects;

public class EBike extends Bike {
  private final TypeOfBike typeOfBike = TypeOfBike.EBIKE;
  private int maximumSpeed;
  private int batteryCapacity;

  public EBike() {

  }

  public EBike(int bikeId,
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

  @Override
  public TypeOfBike getTypeOfBike() {
    return typeOfBike;
  }

  public int getMaximumSpeed() {
    return maximumSpeed;
  }

  public int getBatteryCapacity() {
    return batteryCapacity;
  }

  public void setMaximumSpeed(int maximumSpeed) {
    this.maximumSpeed = maximumSpeed;
  }

  public void setBatteryCapacity(int batteryCapacity) {
    this.batteryCapacity = batteryCapacity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    EBike eBike = (EBike) o;
    return this.getId() == eBike.getId() &&
            this.getWeight() == eBike.getWeight() &&
            this.isAvailabilityLights() == eBike.isAvailabilityLights() &&
            this.getPrice() == eBike.getPrice() &&
            Objects.equals(this.getTypeOfBike(), eBike.getTypeOfBike()) &&
            Objects.equals(this.getBrand(), eBike.getBrand()) &&
            Objects.equals(this.getColor(), eBike.getColor()) &&
            maximumSpeed == eBike.maximumSpeed &&
            batteryCapacity == eBike.batteryCapacity;
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), maximumSpeed, batteryCapacity);
  }


}
