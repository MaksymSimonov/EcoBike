package controller;

import dao.Identifiable;
import model.EBike;
import model.FoldingBike;
import model.Speedelec;
import view.UserInputs;

import java.util.List;

public class ConsoleController {
  private BikeController bikeController = new BikeController();
  private UserInputs userInputs = new UserInputs();

  public List<Identifiable> getAllBikes() {
    return bikeController.getAllBikes();
  }

  public void addFoldingBike(FoldingBike foldingBike) {
    bikeController.addFoldingBike(foldingBike);
  }

  public void addSpeedelec(Speedelec speedelec) {
    bikeController.addSpeedelec(speedelec);
  }

  public void addEBike(EBike eBike) {
    bikeController.addEBike(eBike);
  }

  public void searchBike() {

  }

  public void saveData() {
    bikeController.saveData();
  }
}
