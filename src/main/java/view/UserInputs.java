package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputs {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public int getMenuItem() throws InvalidUserInput {
    String input = null;
    int number;
    try {
      input = reader.readLine();
      number = Integer.parseInt(input);
    } catch (Exception e) {
      throw new InvalidUserInput("Wrong input", input, e);
    }
    return number;
  }

  public String getBrand() throws IOException {
    System.out.println("Enter brand name:");
    return reader.readLine();
  }

  public int getWeight() throws IOException {
    System.out.println("Enter weight(in grams):");
    String weight;
    if (!isPositiveNumber(weight = reader.readLine())) {
      this.getWeight();
    }
    return Integer.parseInt(weight);
  }

  public boolean getAvailabilityLights() throws IOException {
    System.out.println("Enter availability lights(TRUE/FALSE):");
    String availabilityLights = reader.readLine();
    if (!isBooleanType(availabilityLights)) {
      this.getAvailabilityLights();
    }
    return Boolean.parseBoolean(availabilityLights);
  }

  public String getColor() throws IOException {
    System.out.println("Enter color:");
    return reader.readLine();
  }

  public int getPrice() throws IOException {
    System.out.println("Enter price:");
    String price;
    if (!isPositiveNumber(price = reader.readLine())) {
      this.getPrice();
    }
    return Integer.parseInt(price);
  }

  public int getSizeOfWheels() throws IOException {
    System.out.println("Enter the size of wheels(in inch):");
    String sizeOfWheels;
    if (!isPositiveNumber(sizeOfWheels = reader.readLine())) {
      this.getSizeOfWheels();
    }
    return Integer.parseInt(sizeOfWheels);
  }

  public int getNumberOfGears() throws IOException {
    System.out.println("Enter the number of  gears:");
    String numberOfGears;
    if (!isPositiveNumber(numberOfGears = reader.readLine())) {
      this.getNumberOfGears();
    }
    return Integer.parseInt(numberOfGears);
  }

  public int getMaximumSpeed() throws IOException {
    System.out.println("Enter maximum speed(in km/h):");
    String maximumSpeed;
    if (!isPositiveNumber(maximumSpeed = reader.readLine())) {
      this.getMaximumSpeed();
    }
    return Integer.parseInt(maximumSpeed);
  }

  public int getBatteryCapacity() throws IOException {
    System.out.println("Enter battery capacity(in mAh):");
    String batteryCapacity;
    if (!isPositiveNumber(batteryCapacity = reader.readLine())) {
      this.getBatteryCapacity();
    }
    return Integer.parseInt(batteryCapacity);
  }

  // validators
  private boolean isBooleanType(String str) {
    if (str.toLowerCase().equals("true") || str.toLowerCase().equals("false")) {
      return true;
    } else {
      System.out.println("Not valid data. Enter TRUE or FALSE");
      return false;
    }
  }

//  private int getNumber() throws InvalidUserInput {
//    String input = null;
//    int number;
//    try {
//      input = reader.readLine();
//      number = Integer.parseInt(input);
//    } catch (Exception e) {
//      throw new InvalidUserInput("Wrong input", input, e);
//    }
//    return number;
//  }

  private boolean isPositiveNumber(String str) {
    if (str.matches("([0-9]+)")) {
      return true;
    } else {
      System.out.println("Not valid data. Enter the positive number");
      return false;
    }
  }
}
