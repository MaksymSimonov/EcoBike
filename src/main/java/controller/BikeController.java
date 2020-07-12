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

  public boolean addFoldingBike(FoldingBike foldingBike) {
    return service.addFoldingBike(foldingBike);
  }

  public boolean addSpeedelec(Speedelec speedelec) {
    return service.addSpeedelec(speedelec);
  }

  public boolean addEBike(EBike eBike) {
    return service.addEBike(eBike);
  }

  public List<Identifiable> searchBikes(Identifiable identifiable) {
    return service.searchBikes(identifiable);
  }

  public void saveData() {
    service.saveData();
  }
}
