package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FoldingBikeTest {
  private FoldingBike foldingBike;
  private final int bikeId = 1;
  private final TypeOfBike typeOfBike = TypeOfBike.FOLDINGBIKE;
  private final String brand = "Benetti";
  private final int sizeOfWheels = 16;
  private final int numberOfGears = 24;
  private final int weight = 11400;
  private final boolean availabilityLights = false;
  private final String color = "silver";
  private final int price = 1195;

  @BeforeEach
  void beforeEach() {
    foldingBike = new FoldingBike(bikeId,
            brand,
            sizeOfWheels,
            numberOfGears,
            weight,
            availabilityLights,
            color,
            price);
  }

  @Test
  void getId() {
    assertEquals(bikeId, foldingBike.getId());
  }

  @Test
  void getTypeOfBike() {
    assertEquals(typeOfBike, foldingBike.getTypeOfBike());
  }

  @Test
  void getBrand() {
    assertEquals(brand, foldingBike.getBrand());
  }

  @Test
  void getSizeOfWheels() {
    assertEquals(sizeOfWheels, foldingBike.getSizeOfWheels());
  }

  @Test
  void getNumberOfGears() {
    assertEquals(numberOfGears, foldingBike.getNumberOfGears());
  }

  @Test
  void getWeight() {
    assertEquals(weight, foldingBike.getWeight());
  }

  @Test
  void isAvailabilityLights() {
    assertEquals(availabilityLights, foldingBike.isAvailabilityLights());
  }

  @Test
  void getColor() {
    assertEquals(color, foldingBike.getColor());
  }

  @Test
  void getPrice() {
    assertEquals(price, foldingBike.getPrice());
  }

  @Test
  void setBrand() {
    String newBrand = "Ferrari";
    foldingBike.setBrand(newBrand);
    assertEquals(newBrand, foldingBike.getBrand());
  }

  @Test
  void setWeight() {
    int newWeight = 12000;
    foldingBike.setWeight(newWeight);
    assertEquals(newWeight, foldingBike.getWeight());
  }

  @Test
  void setAvailabilityLights() {
    foldingBike.setAvailabilityLights(true);
    assertEquals(true, foldingBike.isAvailabilityLights());
  }

  @Test
  void setColor() {
    String newColor = "red";
    foldingBike.setColor(newColor);
    assertEquals(newColor, foldingBike.getColor());
  }

  @Test
  void setPrice() {
      int newPrice = 12999;
      foldingBike.setPrice(newPrice);
      assertEquals(newPrice, foldingBike.getPrice());
  }

  @Test
  void equals() {
    FoldingBike newFoldingBike = new FoldingBike(2,
           "Intertool",
           21,
           16,
           15300,
           false,
           "black",
           21999);
    FoldingBike copyFoldingBike = foldingBike;
    FoldingBike fullCopyFoldingBike = new FoldingBike(bikeId,
            brand,
            sizeOfWheels,
            numberOfGears,
            weight,
            availabilityLights,
            color,
            price);
    assertEquals(copyFoldingBike, foldingBike);
    assertNotEquals(foldingBike, newFoldingBike);
    assertNotEquals(null, foldingBike);
    assertEquals(fullCopyFoldingBike, foldingBike);
  }
}
