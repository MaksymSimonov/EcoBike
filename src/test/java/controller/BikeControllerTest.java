package controller;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BikeControllerTest {
  private BikeController controller;
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
    controller = new BikeController(file);
    controller.addFoldingBike(foldingBike);
    controller.addSpeedelec(speedelec);
    controller.addEBike(eBike);
  }

  @Test
  void addFoldingBike() {
    FoldingBike newFoldingBike = new FoldingBike(4,
            "Formula",
            21,
            34,
            9000,
            true,
            "coral",
            855);
    assertTrue(controller.addFoldingBike(newFoldingBike));
    List<Identifiable> allBikes = controller.getAllBikes();
    assertTrue(allBikes.contains(newFoldingBike));
    assertThrows(IllegalArgumentException.class, () -> controller.addFoldingBike(null));
  }

  @Test
  void addSpeedelec() {
    Speedelec newSpeedelec = new Speedelec(4,
            "Freego",
            65,
            7600,
            false,
            11000,
            "brown",
            999);
    assertTrue(controller.addSpeedelec(newSpeedelec));
    List<Identifiable> allBikes = controller.getAllBikes();
    assertTrue(allBikes.contains(newSpeedelec));
    assertThrows(IllegalArgumentException.class, () -> controller.addSpeedelec(null));
  }

  @Test
  void addEBike() {
    EBike newEBike = new EBike(4,
            "Gazelle",
            65,
            7600,
            false,
            11000,
            "brown",
            999);
    assertTrue(controller.addEBike(newEBike));
    List<Identifiable> allBikes = controller.getAllBikes();
    assertTrue(allBikes.contains(newEBike));
    assertThrows(IllegalArgumentException.class, () -> controller.addEBike(null));
  }

  @Test
  void getAllBikes() {
    List<Identifiable> allBikes = controller.getAllBikes();
    assertEquals(3, allBikes.size());
    assertTrue(allBikes.contains(foldingBike));
    assertTrue(allBikes.contains(speedelec));
    assertTrue(allBikes.contains(eBike));
  }

  @Test
  void searchBikes() {
    int price = 1195;
    String color = "dark gray";
    List<Identifiable> resultForColor = controller.searchBikes(null,
            null,
            null,
            null,
            color,
            null,
            null,
            null,
            null,
            null);
    assertEquals(2, resultForColor.size());
    List<Identifiable> resultForPrice = controller.searchBikes(null,
            null,
            null,
            null,
            null,
            price,
            null,
            null,
            null,
            null);
    assertEquals(2, resultForPrice.size());
    List<Identifiable> resultForColorAndPrice = controller.searchBikes(null,
            null,
            null,
            null,
            color,
            price,
            null,
            null,
            null,
            null);
    assertEquals(1, resultForColorAndPrice.size());
  }

  @Test
  void saveData() {
    controller.saveData();
    List<Identifiable> allBikes = controller.getAllBikes();
    assertEquals(3, allBikes.size());
    assertTrue(allBikes.contains(foldingBike));
    assertTrue(allBikes.contains(speedelec));
    assertTrue(allBikes.contains(eBike));
  }
}
