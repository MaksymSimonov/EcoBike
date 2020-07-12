package model;

import java.util.Objects;

public class Speedelec extends Bike {
  private final TypeOfBike typeOfBike = TypeOfBike.SPEEDELEC;
  private int maximumSpeed;
  private int batteryCapacity;

  public Speedelec() {

  }

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
    Speedelec speedelec = (Speedelec) o;
    return typeOfBike == speedelec.getTypeOfBike() &&
            maximumSpeed == speedelec.getMaximumSpeed() &&
            batteryCapacity == speedelec.getBatteryCapacity();
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), typeOfBike, maximumSpeed, batteryCapacity);
  }
}
