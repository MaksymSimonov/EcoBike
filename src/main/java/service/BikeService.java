package service;

import dao.Identifiable;
import daoimpl.DAOTreeMapBike;
import java.io.File;
import java.util.List;

public class BikeService {
  private final DAOTreeMapBike data;

  public BikeService(File file) {
    data = new DAOTreeMapBike(file);
    data.retrieveInitialData();
  }

  public List<Identifiable> getAllBikes() {
    return data.getAll();
  }

  public Identifiable addFoldingBike(Identifiable foldingBike) {
    return foldingBike;
  }

  public Identifiable addSpeedelec(Identifiable speedelec) {
    return speedelec;
  }

  public Identifiable addEBike(Identifiable eBike) {
    return eBike;
  }

  public List<Identifiable> searchBike() {
    return null;
  }

  public void save() {
    data.saveData();
  }
}
