package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SpeedelecTest {
  private Speedelec speedelec;
  private final TypeOfBike typeOfBike = TypeOfBike.SPEEDELEC;
  private final String brand = "Benetti";
  private final int maximumSpeed = 16;
  private final int weight = 11400;
  private final boolean availabilityLights = false;
  private final int batteryCapacity = 245643;
  private final String color = "silver";
  private final int price = 1195;

  @BeforeEach
  void beforeEach() {
      speedelec = new Speedelec(brand,
              maximumSpeed,
              weight,
              availabilityLights,
              batteryCapacity,
              color,
              price);
  }

  @Test
  void getTypeOfBike() {
    assertEquals(typeOfBike, speedelec.getTypeOfBike());
  }

  @Test
  void getBrand() {
    assertEquals(brand, speedelec.getBrand());
  }

  @Test
  void getBatteryCapacity() {
    assertEquals(batteryCapacity, speedelec.getBatteryCapacity());
  }

  @Test
  void setMaximumSpeed() {
    assertEquals(maximumSpeed, speedelec.getMaximumSpeed());
  }

  @Test
  void getWeight() {
    assertEquals(weight, speedelec.getWeight());
  }

  @Test
  void isAvailabilityLights() {
    assertEquals(availabilityLights, speedelec.isAvailabilityLights());
  }

  @Test
  void getColor() {
    assertEquals(color, speedelec.getColor());
  }

  @Test
  void getPrice() {
    assertEquals(price, speedelec.getPrice());
  }

  @Test
  void setBrand() {
    String newBrand = "Ferrari";
    speedelec.setBrand(newBrand);
    assertEquals(newBrand, speedelec.getBrand());
  }

  @Test
  void setWeight() {
    int newWeight = 12000;
    speedelec.setWeight(newWeight);
    assertEquals(newWeight, speedelec.getWeight());
  }

  @Test
  void setAvailabilityLights() {
    speedelec.setAvailabilityLights(true);
    assertEquals(true, speedelec.isAvailabilityLights());
  }

  @Test
  void setColor() {
    String newColor = "red";
    speedelec.setColor(newColor);
    assertEquals(newColor, speedelec.getColor());
  }

  @Test
  void setPrice() {
    int newPrice = 12999;
    speedelec.setPrice(newPrice);
    assertEquals(newPrice, speedelec.getPrice());
  }

  @Test
  void equals() {
    Speedelec newSpeedelec = new Speedelec("Intertool",
            21,
            16345,
            false,
            15675,
            "black",
            21999);
    Speedelec copySpeedelec = speedelec;
    Speedelec fullCopySpeedelec = new Speedelec(brand,
            maximumSpeed,
            weight,
            availabilityLights,
            batteryCapacity,
            color,
            price);
    assertEquals(copySpeedelec, speedelec);
    assertNotEquals(speedelec, newSpeedelec);
    assertNotEquals(null, speedelec);
    assertEquals(fullCopySpeedelec, speedelec);
  }
}
