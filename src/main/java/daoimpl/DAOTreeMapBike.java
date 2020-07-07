package daoimpl;
import dao.DAOFactory;
import dao.Identifiable;
import model.Bike;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

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

  public void retrieveInitialData() {
    try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                    new FileInputStream(file), StandardCharsets.UTF_8))){
      String line;
      int countOfBikes = 1;
      while ((line = reader.readLine()) != null) {


        String[] params = line.split("; ");
        for (String param : params) {

        }
//        for (String param : params) {
//          String[] item = param.split(":");
//          switch (item[0]) {
//            case "flightID": {
//              flightId = Integer.parseInt(item[1]);
//              break;
//            }
//            case "passengerID": {
//              String[] passengersStr = item[1].split(",");
//
//              for (int j = 0; j < passengersStr.length; j++) {
//                passengers.add(Integer.parseInt(passengersStr[j]));
//              }
//              break;
//            }
//          }
//          insert(new Bike(flightId, passengers));
//          passengers = new ArrayList<>();
//        }

        //map.put(countOfBikes, new Bike(countOfBikes, "brand", 999, true, "color", "price"));
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
