package service;

import dao.Identifiable;
import daoimpl.DAOTreeMapBike;
import entities.*;

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

    List<Identifiable> result = getAllBikes().stream()
            .map(identifiable -> (Bike) identifiable)
            .filter(bike -> brand == null || bike.getBrand().toLowerCase().equals(brand.toLowerCase()))
            .filter(bike -> weight == null || bike.getWeight() == weight)
            .filter(bike -> availabilityLights == null || bike.isAvailabilityLights() == availabilityLights)
            .filter(bike -> color == null || bike.getColor().toLowerCase().equals(color.toLowerCase()))
            .filter(bike -> price == null || bike.getPrice() == price)
            .filter(bike -> typeOfBike == null || bike.getTypeOfBike() == typeOfBike)
            .filter(bike -> {
                switch (bike.getTypeOfBike()) {
                  case FOLDINGBIKE: {
                    FoldingBike foldingBike = (FoldingBike) bike;
                    return sizeOfWheels == null || foldingBike.getSizeOfWheels() == price;
                  }
                  case SPEEDELEC: {
                    Speedelec speedelec = (Speedelec) bike;
                    return maximumSpeed == null || speedelec.getMaximumSpeed() == maximumSpeed;
                  }
                  case EBIKE: {
                    EBike eBike = (EBike) bike;
                    return maximumSpeed == null || eBike.getMaximumSpeed() == maximumSpeed;
                  }
                }
                return true;
            })
            .filter(bike -> {
                switch (bike.getTypeOfBike()) {
                  case FOLDINGBIKE: {
                    FoldingBike foldingBike = (FoldingBike) bike;
                    return numberOfGears == null || foldingBike.getNumberOfGears() == numberOfGears;
                  }
                  case SPEEDELEC: {
                    Speedelec speedelec = (Speedelec) bike;
                    return batteryCapacity == null || speedelec.getBatteryCapacity() == batteryCapacity;
                  }
                  case EBIKE: {
                    EBike eBike = (EBike) bike;
                    return batteryCapacity == null || eBike.getBatteryCapacity() == batteryCapacity;
                  }
                }
                return true;
            })
            .collect(Collectors.toList());

    return result;
  }

  public void saveData() {
    data.saveData();
  }
}
