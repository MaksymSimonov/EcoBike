package view;

import model.TypeOfBike;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static model.TypeOfBike.EBIKE;
import static model.TypeOfBike.FOLDINGBIKE;
import static model.TypeOfBike.SPEEDELEC;

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

  public TypeOfBike getTypeOfBikeForSearch() throws IOException {
    String consoleTitle = "Enter type of bike for search:\n" +
            "1 - Folding bike\n" +
            "2 - Speedelec\n" +
            "3 - E-bike";
    while (true){
      switch (getPositiveNumber(consoleTitle)){
        case 1: return FOLDINGBIKE;
        case 2: return SPEEDELEC;
        case 3: return EBIKE;
        default: System.out.println("Please select from the list");
      }
    }
  }

  public String getBrand() throws IOException {
    System.out.println("Enter brand name:");
    return reader.readLine();
  }

  public int getWeight() throws IOException {
    String consoleTitle = "Enter weight(in grams):";
    return getPositiveNumber(consoleTitle);
  }

  public boolean getAvailabilityLights() throws IOException {
    String consoleTitle = "Enter availability lights(TRUE/FALSE):";
    return getBooleanType(consoleTitle);
  }

  public String getColor() throws IOException {
    System.out.println("Enter color:");
    return reader.readLine();
  }

  public int getPrice() throws IOException {
    String consoleTitle = "Enter price:";
    return getPositiveNumber(consoleTitle);
  }

  public int getSizeOfWheels() throws IOException {
    String consoleTitle = "Enter the size of wheels(in inch):";
    return getPositiveNumber(consoleTitle);
  }

  public int getNumberOfGears() throws IOException {
    String consoleTitle = "Enter the number of  gears:";
    return getPositiveNumber(consoleTitle);
  }

  public int getMaximumSpeed() throws IOException {
    String consoleTitle = "Enter maximum speed(in km/h):";
    return getPositiveNumber(consoleTitle);
  }

  public int getBatteryCapacity() throws IOException {
    String consoleTitle = "Enter battery capacity(in mAh):";
    return getPositiveNumber(consoleTitle);
  }

  private boolean getBooleanType(String consoleTitle) throws IOException {
    String input;
    while (true){
      System.out.println(consoleTitle);
      input = reader.readLine();
      if (input.toLowerCase().equals("true") || input.toLowerCase().equals("false")){
        return Boolean.parseBoolean(input);
      } else {
        System.out.printf("Not valid data: %s. Enter TRUE or FALSE\n", input);
      }
    }
  }

  private int getPositiveNumber(String consoleTitle) throws IOException {
    String input;
    while (true){
      System.out.println(consoleTitle);
      input = reader.readLine();
      if(input.matches("([0-9]+)")){
        return Integer.parseInt(input);
      } else {
        System.out.printf("Not valid data: %s. Enter the correct data\n", input);
      }
    }
  }
}
