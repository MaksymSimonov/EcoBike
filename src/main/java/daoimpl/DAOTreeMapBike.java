package daoimpl;
import dao.DAOFactory;
import dao.Identifiable;
import entities.*;

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
    int id = map.size() + 1;
    if (map.containsValue(bike)) {
      throw new IllegalArgumentException("Such bike already exists");
    } else {
      Bike newBike = (Bike)bike;
      newBike.setId(id);
      map.put(id, newBike);
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

  public Identifiable remove(int id) {
    try {
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

  private FoldingBike retrieveFoldingBikeData(String dataLine) {
    TypeOfBike typeOfBike = TypeOfBike.FOLDINGBIKE;
    String[] params = dataLine.split("; ");
    String brand = params[0].substring(typeOfBike.getFullNameOfType().length(), params[0].length()).trim();
    int sizeOfWheels = Integer.valueOf(params[1]);
    int numberOfGears = Integer.valueOf(params[2]);
    int weight = Integer.valueOf(params[3]);
    boolean availabilityLights = Boolean.valueOf(params[4]);
    String color = params[5];
    int price = Integer.valueOf(params[6]);
    return new FoldingBike(brand, sizeOfWheels, numberOfGears, weight, availabilityLights, color, price);
  }

  private Speedelec retrieveSpeedelecData(String dataLine) {
    TypeOfBike typeOfBike = TypeOfBike.SPEEDELEC;
    String[] params = dataLine.split("; ");
    String brand = params[0].substring(typeOfBike.getFullNameOfType().length(), params[0].length()).trim();
    int maximumSpeed = Integer.valueOf(params[1]);
    int weight = Integer.valueOf(params[2]);
    boolean availabilityLights = Boolean.valueOf(params[3]);
    int batteryCapacity = Integer.valueOf(params[4]);
    String color = params[5];
    int price = Integer.valueOf(params[6]);
    return new Speedelec(brand, maximumSpeed, weight, availabilityLights, batteryCapacity, color, price);
  }

  private EBike retrieveEBikeData(String dataLine) {
    TypeOfBike typeOfBike = TypeOfBike.EBIKE;
    String[] params = dataLine.split("; ");
    String brand = params[0].substring(typeOfBike.getFullNameOfType().length(), params[0].length()).trim();
    int maximumSpeed = Integer.valueOf(params[1]);
    int weight = Integer.valueOf(params[2]);
    boolean availabilityLights = Boolean.valueOf(params[3]);
    int batteryCapacity = Integer.valueOf(params[4]);
    String color = params[5];
    int price = Integer.valueOf(params[6]);
    return new EBike(brand, maximumSpeed, weight, availabilityLights, batteryCapacity, color, price);
  }

  public void retrieveInitialData() {
    try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                    new FileInputStream(file), StandardCharsets.UTF_8))){
      String line;
      while ((line = reader.readLine()) != null) {
        if(line.contains(TypeOfBike.FOLDINGBIKE.getFullNameOfType())){
          FoldingBike foldingBike = retrieveFoldingBikeData(line);
          insert(foldingBike);
        } else if(line.contains(TypeOfBike.SPEEDELEC.getFullNameOfType())) {
          Speedelec speedelec = retrieveSpeedelecData(line);
          insert(speedelec);
        } else if(line.contains(TypeOfBike.EBIKE.getFullNameOfType())) {
          EBike eBike = retrieveEBikeData(line);
          insert(eBike);
        }
      }
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("ecobike.txt file not found");
    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalArgumentException("Error while initializing stream");
    }
  }

  public void save() {
    try {
      OutputStream outputStream = new FileOutputStream(file);
      String line = null;
      for(Map.Entry<Integer, Identifiable> item : map.entrySet()){
        Bike bike = (Bike)item.getValue();
        switch (bike.getTypeOfBike()) {
          case FOLDINGBIKE: {
            FoldingBike foldingBike = (FoldingBike)bike;
            line = convertFoldingBikeToStr(foldingBike);
            break;
          }
          case SPEEDELEC: {
            Speedelec speedelec = (Speedelec)bike;
            line = convertSpeedelecToStr(speedelec);
            break;
          }
          case EBIKE: {
            EBike eBike = (EBike)bike;
            line = convertEBikeToStr(eBike);
            break;
          }
        }
        outputStream.write(line.getBytes(), 0, line.length());
      }
      outputStream.close();
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("ecobike.txt file not found");
    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalArgumentException("Error while initializing stream");
    }
  }

  private String convertFoldingBikeToStr(FoldingBike foldingBike) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(foldingBike.getTypeOfBike().getFullNameOfType()).append(' ')
            .append(foldingBike.getBrand()).append("; ")
            .append(foldingBike.getSizeOfWheels()).append("; ")
            .append(foldingBike.getNumberOfGears()).append("; ")
            .append(foldingBike.getWeight()).append("; ")
            .append(String.valueOf(foldingBike.isAvailabilityLights())
                    .toUpperCase()).append("; ")
            .append(foldingBike.getColor()).append("; ")
            .append(foldingBike.getPrice())
            .append('\n');
    return stringBuffer.toString();
  }

  private String convertSpeedelecToStr(Speedelec speedelec) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(speedelec.getTypeOfBike().getFullNameOfType()).append(' ')
            .append(speedelec.getBrand()).append("; ")
            .append(speedelec.getMaximumSpeed()).append("; ")
            .append(speedelec.getWeight()).append("; ")
            .append(String.valueOf(speedelec.isAvailabilityLights())
                    .toUpperCase()).append("; ")
            .append(speedelec.getBatteryCapacity()).append("; ")
            .append(speedelec.getColor()).append("; ")
            .append(speedelec.getPrice())
            .append('\n');
    return stringBuffer.toString();
  }

  private String convertEBikeToStr(EBike eBike) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(eBike.getTypeOfBike().getFullNameOfType()).append(' ')
            .append(eBike.getBrand()).append("; ")
            .append(eBike.getMaximumSpeed()).append("; ")
            .append(eBike.getWeight()).append("; ")
            .append(String.valueOf(eBike.isAvailabilityLights())
                    .toUpperCase()).append("; ")
            .append(eBike.getBatteryCapacity()).append("; ")
            .append(eBike.getColor()).append("; ")
            .append(eBike.getPrice())
            .append('\n');
    return stringBuffer.toString();
  }
}
