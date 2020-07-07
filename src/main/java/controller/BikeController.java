package controller;

import dao.Identifiable;
import service.BikeService;
import java.io.File;
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

  public Identifiable addFoldingBike(Identifiable foldingBike) {
    return service.addFoldingBike(foldingBike);
  }

  public Identifiable addSpeedelec(Identifiable speedelec) {
    return service.addSpeedelec(speedelec);
  }

  public Identifiable addEBike(Identifiable eBike) {
    return service.addEBike(eBike);
  }

  public List<Identifiable> searchBike() {
    return service.searchBike();
  }

  public void save() {
    service.save();
  }
}
