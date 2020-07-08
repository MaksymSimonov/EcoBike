package controller;

import dao.Identifiable;
import view.UserInputs;

import java.util.List;

public class ConsoleController {
  private BikeController bikeController = new BikeController();
  private UserInputs userInputs = new UserInputs();

  public List<Identifiable> getAllBikes() {
    return bikeController.getAllBikes();
  }

  public void addFoldingBike() {

  }

  public void addSpeedelec() {

  }

  public void addEBike() {

  }

  public void searchBike() {

  }

  public void saveData() {
    bikeController.saveData();
  }
}
