package controller;

import dao.Identifiable;
import entities.EBike;
import entities.FoldingBike;
import entities.Speedelec;
import entities.TypeOfBike;

import java.util.List;

public class ConsoleController {
  private BikeController bikeController = new BikeController();

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

  public List<Identifiable> searchBikes(TypeOfBike typeOfBike,
                                        String brand,
                                        Integer weight,
                                        Boolean availabilityLights,
                                        String color,
                                        Integer price,
                                        Integer sizeOfWheels,
                                        Integer numberOfGears,
                                        Integer maximumSpeed,
                                        Integer batteryCapacity) {
    return bikeController
            .searchBikes(typeOfBike,
                    brand,
                    weight,
                    availabilityLights,
                    color,
                    price,
                    sizeOfWheels,
                    numberOfGears,
                    maximumSpeed,
                    batteryCapacity);
  }

  public void saveData() {
    bikeController.saveData();
  }
}
