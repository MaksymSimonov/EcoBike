package daoimpl;
import dao.DAOFactory;
import dao.Identifiable;
import model.Bike;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOHashMapBike implements DAOFactory<Identifiable> {
  private final File file;
  private final HashMap<String, Identifiable> map;

  public DAOHashMapBike(){
    this(new File("./data", "ecobike.txt"));
  }

  public DAOHashMapBike (File file){
    this.file = file;
    this.map = new HashMap<>();
  }

  public Identifiable get(int id) {
    return map.get(id);
  }

  public List<Identifiable> getAll() {
    return new ArrayList<>(map.values());
  }

  public boolean insert(Identifiable bike) {
    if (bike == null) throw new IllegalArgumentException("Invalid insert arguments: null is not accepted");
    String id = bike.getId();
    if (map.containsKey(id)) {
      return false;
    } else {
      map.put(id, bike);
      return true;
    }
  }

  public boolean update(Identifiable bike) {
    if (bike == null) throw new IllegalArgumentException("Invalid insert arguments: null is not accepted");
    String id = bike.getId();
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
    String id = bike.getId();
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
      int count = 0;
      while ((line = reader.readLine()) != null) {
        count++;
        map.put(String.valueOf(count), new Bike(String.valueOf(count), "brand", 999, true, "color", "price"));
        //System.out.println(line);
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
