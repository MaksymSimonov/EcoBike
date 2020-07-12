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

  public boolean addFoldingBike(FoldingBike foldingBike) {
    return bikeController.addFoldingBike(foldingBike);
  }

  public boolean addSpeedelec(Speedelec speedelec) {
    return bikeController.addSpeedelec(speedelec);
  }

  public boolean addEBike(EBike eBike) {
    return bikeController.addEBike(eBike);
  }

  public List<Identifiable> searchBikes(Identifiable identifiable) {
    return bikeController.searchBikes(identifiable);
  }

  public void saveData() {
    bikeController.saveData();
  }
}
