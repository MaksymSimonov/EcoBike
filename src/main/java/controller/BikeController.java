package controller;

import dao.Identifiable;
import model.EBike;
import model.FoldingBike;
import model.Speedelec;
import service.BikeService;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class BikeController {
  private final BikeService service;

  public BikeController() {
    this(new File("./data", "ecobike.txt"));
  }

  public BikeController(File file) {
    service = new BikeService(file);
  }

  public List<Identifiable> getAllBikes() {
    return service.getAllBikes();
  }

  public void addFoldingBike(FoldingBike foldingBike) {
    service.addFoldingBike(foldingBike);
  }

  public void addSpeedelec(Speedelec speedelec) {
    service.addSpeedelec(speedelec);
  }

  public void addEBike(EBike eBike) {
    service.addEBike(eBike);
  }

  public List<Identifiable> searchBike() {
    return service.searchBike();
  }

  public void saveData() {
    service.saveData();
  }
}
