package service;

import dao.Identifiable;
import daoimpl.DAOTreeMapBike;
import model.EBike;
import model.FoldingBike;
import model.Speedelec;

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

  public void addFoldingBike(FoldingBike foldingBike) {
    int bikeId = getAllBikes().size() + 1;
    foldingBike.setBikeId(bikeId);
    data.insert(foldingBike);
  }

  public void addSpeedelec(Speedelec speedelec) {
    int bikeId = getAllBikes().size() + 1;
    speedelec.setBikeId(bikeId);
    data.insert(speedelec);
  }

  public void addEBike(EBike eBike) {
    int bikeId = getAllBikes().size() + 1;
    eBike.setBikeId(bikeId);
    data.insert(eBike);
  }

  public List<Identifiable> searchBike() {
    return null;
  }

  public void saveData() {
    data.saveData();
  }
}
