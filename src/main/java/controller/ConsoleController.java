package controller;

import dao.Identifiable;
import view.UserInputs;

import java.util.List;

public class ConsoleController {
  private BikeController bikeController = new BikeController();
  private UserInputs userInputs = new UserInputs();

  public void getAllBikes() {
    List<Identifiable> allBikes = bikeController.getAllBikes();
    allBikes.forEach(System.out::println);
  }

  public void addFoldingBike() {

  }

  public void addSpeedelec() {

  }

  public void addEBike() {

  }

  public void searchBike() {

  }

  public void saveChanges() {

  }
}
