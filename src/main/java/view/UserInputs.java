package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputs {
  private Scanner scan = new Scanner(System.in);

  public int getMenuItem() throws InvalidUserInput {
    int input = 0;
    try {
      input = scan.nextInt();
    } catch (InputMismatchException e) {
      scan.nextLine();
      throw new InvalidUserInput("Wrong input", input, e);
    }
    return input;
  }

  public String getBrand() {
    System.out.println("Enter brand name:");
    String brand = scan.nextLine();
    return brand;
  }

  public int getWeight() {
    System.out.println("Enter weight(in grams):");
    String weight;
    while (!isNumeric(weight = scan.nextLine())) {
      this.getWeight();
    }
    return Integer.parseInt(weight);
  }

  public boolean getAvailabilityLights() {
    System.out.println("Enter availability lights(TRUE/FALSE):");
    String availabilityLights;
    while (!isBooleanType(availabilityLights = scan.nextLine())) {
      this.getAvailabilityLights();
    }
    return Boolean.parseBoolean(availabilityLights);
  }

  public String getColor() {
    System.out.println("Enter color:");
    String color = scan.nextLine();
    return color;
  }

  public int getPrice() {
    System.out.println("Enter price:");
    String price;
    while (!isNumeric(price = scan.nextLine())) {
      this.getPrice();
    }
    return Integer.parseInt(price);
  }

  public int getSizeOfWheels() {
    System.out.println("Enter the size of wheels(in inch):");
    String sizeOfWheels;
    while (!isNumeric(sizeOfWheels = scan.nextLine())) {
      this.getSizeOfWheels();
    }
    return Integer.parseInt(sizeOfWheels);
  }

  public int getNumberOfGears() {
    System.out.println("Enter the number of  gears:");
    String numberOfGears;
    while (!isNumeric(numberOfGears = scan.nextLine())) {
      this.getNumberOfGears();
    }
    return Integer.parseInt(numberOfGears);
  }

  public int getMaximumSpeed() {
    System.out.println("Enter maximum speed(in km/h):");
    String maximumSpeed;
    while (!isNumeric(maximumSpeed = scan.nextLine())) {
      this.getMaximumSpeed();
    }
    return Integer.parseInt(maximumSpeed);
  }

  public int getBatteryCapacity() {
    System.out.println("Enter battery capacity(in mAh):");
    String batteryCapacity;
    while (!isNumeric(batteryCapacity = scan.nextLine())) {
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

  private boolean isNumeric(String str) {
    if (str.matches("([0-9]+)")) {
      return true;
    } else {
      System.out.println("Not valid data. Enter the number");
      return false;
    }
  }
}
