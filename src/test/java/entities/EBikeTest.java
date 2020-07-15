package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EBikeTest {
  private EBike eBike;
  private final TypeOfBike typeOfBike = TypeOfBike.EBIKE;
  private final String brand = "Benetti";
  private final int maximumSpeed = 16;
  private final int weight = 11400;
  private final boolean availabilityLights = false;
  private final int batteryCapacity = 245643;
  private final String color = "silver";
  private final int price = 1195;

  @BeforeEach
  void beforeEach() {
    eBike = new EBike(brand,
            maximumSpeed,
            weight,
            availabilityLights,
            batteryCapacity,
            color,
            price);
  }

  @Test
  void getTypeOfBike() {
    assertEquals(typeOfBike, eBike.getTypeOfBike());
  }

  @Test
  void getBrand() {
    assertEquals(brand, eBike.getBrand());
  }

  @Test
  void getBatteryCapacity() {
    assertEquals(batteryCapacity, eBike.getBatteryCapacity());
  }

  @Test
  void setMaximumSpeed() {
    assertEquals(maximumSpeed, eBike.getMaximumSpeed());
  }

  @Test
  void getWeight() {
    assertEquals(weight, eBike.getWeight());
  }

  @Test
  void isAvailabilityLights() {
    assertEquals(availabilityLights, eBike.isAvailabilityLights());
  }

  @Test
  void getColor() {
    assertEquals(color, eBike.getColor());
  }

  @Test
  void getPrice() {
    assertEquals(price, eBike.getPrice());
  }

  @Test
  void setBrand() {
    String newBrand = "Ferrari";
    eBike.setBrand(newBrand);
    assertEquals(newBrand, eBike.getBrand());
  }

  @Test
  void setWeight() {
    int newWeight = 12000;
    eBike.setWeight(newWeight);
    assertEquals(newWeight, eBike.getWeight());
  }

  @Test
  void setAvailabilityLights() {
    eBike.setAvailabilityLights(true);
    assertEquals(true, eBike.isAvailabilityLights());
  }

  @Test
  void setColor() {
    String newColor = "red";
    eBike.setColor(newColor);
    assertEquals(newColor, eBike.getColor());
  }

  @Test
  void setPrice() {
    int newPrice = 12999;
    eBike.setPrice(newPrice);
    assertEquals(newPrice, eBike.getPrice());
  }

  @Test
  void equals() {
    EBike newEBike = new EBike("Intertool",
            21,
            16345,
            false,
            15675,
            "black",
            21999);
    EBike copyEBike = eBike;
    EBike fullCopyEBike = new EBike(brand,
            maximumSpeed,
            weight,
            availabilityLights,
            batteryCapacity,
            color,
            price);
    assertEquals(copyEBike, eBike);
    assertNotEquals(eBike, newEBike);
    assertNotEquals(null, eBike);
    assertEquals(fullCopyEBike, eBike);
  }
}
