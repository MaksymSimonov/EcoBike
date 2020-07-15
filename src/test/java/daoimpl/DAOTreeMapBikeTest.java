package daoimpl;

import dao.Identifiable;
import entities.EBike;
import entities.FoldingBike;
import entities.Speedelec;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOTreeMapBikeTest {
  private DAOTreeMapBike dao;
  private static FoldingBike foldingBike;
  private static Speedelec speedelec;
  private static EBike eBike;
  private static File file;

  @BeforeAll
  static void beforeAll() {
    foldingBike = new FoldingBike(1,
            "Benetti",
            16,
            24,
            11400,
            false,
            "silver",
            1195);
    speedelec = new Speedelec(2,
            "Dualtron",
            30,
            14400,
            true,
            6500,
            "dark gray",
            1019);
    eBike = new EBike(3,
            "E-Motion",
            50,
            26600,
            false,
            8000,
            "dark gray",
            1195);

    file = new File("./src/test/data", "ecobikeTest.txt");
  }

  @BeforeEach
  void beforeEach() {
    try {
      PrintWriter writer = new PrintWriter(file);
      writer.print("");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    dao = new DAOTreeMapBike(file);
    dao.insert(foldingBike);
    dao.insert(speedelec);
  }

  @Test
  void getAll() {
    List<Identifiable> allBikes = dao.getAll();
    assertEquals(2, allBikes.size());
    assertTrue(allBikes.contains(foldingBike));
    assertTrue(allBikes.contains(speedelec));
  }

  @Test
  void get() {
    Identifiable bike = dao.get(1);
    assertEquals(bike, foldingBike);
  }

  @Test
  void insert() {
    dao.insert(eBike);
    List<Identifiable> result = dao.getAll();
    assertEquals(3, result.size());
    assertTrue(result.contains(foldingBike));
    assertTrue(result.contains(speedelec));
    assertTrue(result.contains(eBike));
    assertThrows(IllegalArgumentException.class, () -> dao.insert(null));
  }

  @Test
  void update() {
    EBike newEBike = new EBike(3,
            "Lankeleisi",
            44,
            15400,
            true,
            18000,
            "black",
            2500);
    dao.insert(newEBike);
    assertEquals(newEBike, dao.get(newEBike.getId()));
    newEBike.setColor("red");
    newEBike.setMaximumSpeed(65);
    dao.update(newEBike);
    assertEquals(newEBike, dao.get(newEBike.getId()));
    assertTrue(dao.getAll().contains(foldingBike));
    assertTrue(dao.getAll().contains(speedelec));
    assertTrue(dao.getAll().contains(newEBike));
    assertThrows(IllegalArgumentException.class, () -> dao.insert(null));
  }

  @Test
  void remove_by_object() {
    dao.remove(foldingBike);
    List<Identifiable> allBikes = dao.getAll();
    assertEquals(1, allBikes.size());
    assertFalse(allBikes.contains(foldingBike));
    assertTrue(allBikes.contains(speedelec));
    assertThrows(IllegalArgumentException.class, () -> dao.remove(null));
  }

  @Test
  void remove_by_id() {
    dao.remove(foldingBike.getId());
    List<Identifiable> allBikes = dao.getAll();
    assertEquals(1, allBikes.size());
    assertFalse(allBikes.contains(foldingBike));
    assertTrue(allBikes.contains(speedelec));
  }

  @Test
  void save() {
    dao.save();
    List<Identifiable> allBikes = dao.getAll();
    assertEquals(2, allBikes.size());
    assertTrue(allBikes.contains(foldingBike));
    assertTrue(allBikes.contains(speedelec));
  }
}
