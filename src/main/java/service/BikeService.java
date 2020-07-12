package service;

import dao.Identifiable;
import daoimpl.DAOTreeMapBike;
import model.Bike;
import model.EBike;
import model.FoldingBike;
import model.Speedelec;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class BikeService {
  private final DAOTreeMapBike data;

  public BikeService(File file) {
    data = new DAOTreeMapBike(file);
    data.retrieveInitialData();
  }

  public List<Identifiable> getAllBikes() {
    return data.getAll();
  }

  private Map<Integer, Identifiable> getAllBikesWithId() {
      return data.getAllWithId();
  }


  public boolean addFoldingBike(FoldingBike foldingBike) {
    int bikeId = getAllBikes().size() + 1;
    foldingBike.setBikeId(bikeId);
    return data.insert(foldingBike);
  }

  public boolean addSpeedelec(Speedelec speedelec) {
    int bikeId = getAllBikes().size() + 1;
    speedelec.setBikeId(bikeId);
    return data.insert(speedelec);
  }

  public boolean addEBike(EBike eBike) {
    int bikeId = getAllBikes().size() + 1;
    eBike.setBikeId(bikeId);
    return data.insert(eBike);
  }

  public List<Identifiable> searchBikes(Identifiable searchObj) {
    List<Identifiable> result = new ArrayList<>();
    List<Identifiable> allBikes = getAllBikes();
    allBikes.forEach(currentObj -> {
      if(compareBikes(searchObj, currentObj)){
        result.add(currentObj);
      }
    });
    return result;
  }

  private boolean compareBikes(Identifiable searchObj, Identifiable currentObj){
    Bike searchBike = (Bike)searchObj;
    Bike currentBike = (Bike)currentObj;
    boolean equal = false;
    if(searchBike.getTypeOfBike().equals(currentBike.getTypeOfBike())){
      switch (searchBike.getTypeOfBike()) {
        case FOLDINGBIKE: {
          FoldingBike searchFoldingBike = (FoldingBike)searchBike;
          FoldingBike currentFoldingBike = (FoldingBike)currentBike;
          equal = currentFoldingBike.equals(searchFoldingBike);
          break;
        }
        case SPEEDELEC: {
          Speedelec searchSpeedelec = (Speedelec)searchBike;
          Speedelec currentSpeedelec = (Speedelec)currentBike;
          equal = currentSpeedelec.equals(searchSpeedelec);
          break;
        }
        case EBIKE: {
          EBike searchEBike = (EBike)searchBike;
          EBike currentEBike = (EBike)currentBike;
          equal = currentEBike.equals(searchEBike);
          break;
        }
      }
    }
    return equal;
  }

  public void saveData() {
    data.saveData();
  }
}
