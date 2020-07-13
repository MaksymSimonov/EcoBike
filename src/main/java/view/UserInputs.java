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

  public TypeOfBike getTypeOfBikeForSearch() throws IOException {
    String consoleTitle = "Enter type of bike for search: (Press Enter to skip this step)\n" +
            "1 - Folding bike\n" +
            "2 - Speedelec\n" +
            "3 - E-bike";
    while (true){
      Integer input = getPositiveNumberForSearch(consoleTitle);
      if (input != null){
        switch (input){
          case 1: return FOLDINGBIKE;
          case 2: return SPEEDELEC;
          case 3: return EBIKE;
          default: System.out.println("Please select from the list");
        }
      } else {
        return null;
      }
    }
  }

  public String getBrandForSearch() throws IOException {
    System.out.println("Enter brand name: (Press Enter to skip this step)");
    String input = reader.readLine();
    if (input.equals("")) return null;
    return input;
  }

  public Integer getWeightForSearch() throws IOException {
    String consoleTitle = "Enter weight(in grams): (Press Enter to skip this step)";
    return getPositiveNumberForSearch(consoleTitle);
  }

  public Boolean getAvailabilityLightsForSearch() throws IOException {
    String consoleTitle = "Enter availability lights(TRUE/FALSE): (Press Enter to skip this step)";
    return getBooleanTypeForSearch(consoleTitle);
  }

  public String getColorForSearch() throws IOException {
    System.out.println("Enter color: (Press Enter to skip this step)");
    String input = reader.readLine();
    if (input.equals("")) return null;
    return input;
  }

  public Integer getPriceForSearch() throws IOException {
    String consoleTitle = "Enter price: (Press Enter to skip this step)";
    return getPositiveNumberForSearch(consoleTitle);
  }

  public Integer getSizeOfWheelsForSearch() throws IOException {
    String consoleTitle = "Enter the size of wheels(in inch): (Press Enter to skip this step)";
    return getPositiveNumberForSearch(consoleTitle);
  }

  public Integer getNumberOfGearsForSearch() throws IOException {
    String consoleTitle = "Enter the number of  gears: (Press Enter to skip this step)";
    return getPositiveNumberForSearch(consoleTitle);
  }

  public Integer getMaximumSpeedForSearch() throws IOException {
    String consoleTitle = "Enter maximum speed(in km/h): (Press Enter to skip this step)";
    return getPositiveNumberForSearch(consoleTitle);
  }

  public Integer getBatteryCapacityForSearch() throws IOException {
    String consoleTitle = "Enter battery capacity(in mAh): (Press Enter to skip this step)";
    return getPositiveNumberForSearch(consoleTitle);
  }

  private Integer getPositiveNumberForSearch(String consoleTitle) throws IOException {
    String input;
    while (true){
      System.out.println(consoleTitle);
      input = reader.readLine();
      if(input.equals("")) return null;
      else {
        if(input.matches("([0-9]+)")){
          return Integer.parseInt(input);
        } else {
          System.out.printf("Not valid data: %s. Enter the correct data\n", input);
        }
      }
    }
  }

  private Boolean getBooleanTypeForSearch(String consoleTitle) throws IOException {
    String input;
    while (true){
      System.out.println(consoleTitle);
      input = reader.readLine();
      if(input.equals("")) return null;
      if (input.toLowerCase().equals("true") || input.toLowerCase().equals("false")){
        return Boolean.parseBoolean(input);
      } else {
        System.out.printf("Not valid data: %s. Enter TRUE or FALSE\n", input);
      }
    }
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
