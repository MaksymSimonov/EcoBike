package daoimpl;
import dao.DAOFactory;
import dao.Identifiable;
import model.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DAOTreeMapBike implements DAOFactory<Identifiable> {
  private final File file;
  private final TreeMap<Integer, Identifiable> map;

  public DAOTreeMapBike(){
    this(new File("./data", "ecobike.txt"));
  }

  public DAOTreeMapBike(File file){
    this.file = file;
    this.map = new TreeMap<>();
  }

  public Identifiable get(int id) {
    return map.get(id);
  }

  public List<Identifiable> getAll() {
    return new ArrayList<>(map.values());
  }

  public boolean insert(Identifiable bike) {
    if (bike == null) throw new IllegalArgumentException("Invalid insert arguments: null is not accepted");
    int id = bike.getId();
    if (map.containsKey(id)) {
      return false;
    } else {
      map.put(id, bike);
      return true;
    }
  }

  public boolean update(Identifiable bike) {
    if (bike == null) throw new IllegalArgumentException("Invalid insert arguments: null is not accepted");
    int id = bike.getId();
    if (map.containsKey(id)) {
      map.put(id, bike);
      return true;
    } else {
      return false;
    }
  }

  public Identifiable remove(String id) {
    if (id == null) throw new IllegalArgumentException("Invalid insert arguments: null is not accepted");
    try{
      Identifiable bike = null;
      if (map.containsKey(id)) {
        bike = map.get(id);
        map.remove(id);
      }
      return  bike;
    } catch (IllegalArgumentException e){
      e.printStackTrace();
      throw new IllegalArgumentException("Such bike is not found");
    }
  }

  public boolean remove(Identifiable bike) {
    if (bike == null) throw new IllegalArgumentException("Invalid insert arguments: null is not accepted");
    int id = bike.getId();
    if (map.containsKey(id)) {
      map.remove(id);
      return true;
    } else {
      return false;
    }
  }

  private FoldingBike retrieveFoldingBikeData(int countOfBikes, String dataLine){
    int bikeId = countOfBikes;
    String brand;
    TypeOfBike typeOfBike = TypeOfBike.FOLDINGBIKE;
    int sizeOfWheels;
    int numberOfGears;
    int weight;
    boolean availabilityLights;
    String color;
    int price;

    String[] params = dataLine.split("; ");
    brand = params[0].substring(typeOfBike.getFullNameOfType().length(), params[0].length()).trim();
    sizeOfWheels = Integer.valueOf(params[1]);
    numberOfGears = Integer.valueOf(params[2]);
    weight = Integer.valueOf(params[3]);
    availabilityLights = Boolean.valueOf(params[4]);
    color = params[5];
    price = Integer.valueOf(params[6]);

    return new FoldingBike(bikeId, TypeOfBike.FOLDINGBIKE, brand, sizeOfWheels, numberOfGears, weight, availabilityLights, color, price);
  }

  private Speedelec retrieveSpeedelecData(int countOfBikes, String dataLine){
    int bikeId = countOfBikes;
    TypeOfBike typeOfBike = TypeOfBike.SPEEDELEC;
    String brand;
    int maximumSpeed;
    int weight;
    boolean availabilityLights;
    int batteryCapacity;
    String color;
    int price;

    String[] params = dataLine.split("; ");
    brand = params[0].substring(typeOfBike.getFullNameOfType().length(), params[0].length()).trim();
    maximumSpeed = Integer.valueOf(params[1]);
    weight = Integer.valueOf(params[2]);
    availabilityLights = Boolean.valueOf(params[3]);
    batteryCapacity = Integer.valueOf(params[4]);
    color = params[5];
    price = Integer.valueOf(params[6]);
    return new Speedelec(bikeId, typeOfBike, brand, maximumSpeed, weight, availabilityLights, batteryCapacity, color, price);
  }

  private EBike retrieveEBikeData(int countOfBikes, String dataLine){
    int bikeId = countOfBikes;
    TypeOfBike typeOfBike = TypeOfBike.EBIKE;
    String brand;
    int maximumSpeed;
    int weight;
    boolean availabilityLights;
    int batteryCapacity;
    String color;
    int price;

    String[] params = dataLine.split("; ");
    brand = params[0].substring(typeOfBike.getFullNameOfType().length(), params[0].length()).trim();
    maximumSpeed = Integer.valueOf(params[1]);
    weight = Integer.valueOf(params[2]);
    availabilityLights = Boolean.valueOf(params[3]);
    batteryCapacity = Integer.valueOf(params[4]);
    color = params[5];
    price = Integer.valueOf(params[6]);
    return new EBike(bikeId, typeOfBike, brand, maximumSpeed, weight, availabilityLights, batteryCapacity, color, price);
  }

  public void retrieveInitialData() {
    try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                    new FileInputStream(file), StandardCharsets.UTF_8))){
      String line;
      int countOfBikes = 1;
      while ((line = reader.readLine()) != null) {
        if(line.contains(TypeOfBike.FOLDINGBIKE.getFullNameOfType())){
          FoldingBike foldingBike = retrieveFoldingBikeData(countOfBikes, line);
          insert(foldingBike);
        } else if(line.contains(TypeOfBike.SPEEDELEC.getFullNameOfType())) {
          Speedelec speedelec = retrieveSpeedelecData(countOfBikes, line);
          insert(speedelec);
        } else if(line.contains(TypeOfBike.EBIKE.getFullNameOfType())) {
          EBike eBike = retrieveEBikeData(countOfBikes, line);
          insert(eBike);
        }
        countOfBikes++;
      }
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("ecobike.txt file not found");
    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalArgumentException("Error while initializing stream");
    }
  }

  public void saveData() {
    try {
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(new ArrayList<>(map.values()));
      oos.close();
      fos.close();
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("ecobike.txt file not found");
    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalArgumentException("Error while initializing stream");
    }
  }
}