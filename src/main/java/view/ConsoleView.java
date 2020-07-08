package view;

import controller.ConsoleController;
import dao.Identifiable;
import logger.Logger;
import model.Bike;
import model.EBike;
import model.FoldingBike;
import model.Speedelec;

import java.util.List;


public class ConsoleView {
  private ConsoleController consoleController = new ConsoleController();
  private UserInputs userInputs = new UserInputs();
  private Logger logger = new Logger();

  public void startApp() {
    try {
      this.showMenu();
    } catch (InvalidUserInput e) {
      System.out.println(e.getMessage());
      if (e.getCause() != null) {
        System.out.println("Original exception " + e.getCause().getMessage());
      }
      System.out.print("\n\n");
      this.startApp();
    }
  }

  private void showMenu() throws InvalidUserInput {
    System.out.println("-----------Please make your choice:-----------");
    System.out.println("1 - Show the entire EcoBike catalog");
    System.out.println("2 – Add a new folding bike");
    System.out.println("3 – Add a new speedelec");
    System.out.println("4 – Add a new e-bike");
    System.out.println("5 – Find the first item of a particular brand");
    System.out.println("6 – Write to file");
    System.out.println("7 – Stop the program");
    System.out.println("----------------------------------------------");
    this.menuItemReader();
  }

  private void menuItemReader() throws InvalidUserInput {
    try {
      switch (userInputs.getMenuItem()) {
        case 1:
          showBikes(consoleController.getAllBikes());
          //logger.add("Show the entire EcoBike catalog");
          break;
        case 2:
          consoleController.addFoldingBike();
          //logger.add("Add a new folding bike");
          break;
        case 3:
          consoleController.addSpeedelec();
          //logger.add("Add a new speedelec");
          break;
        case 4:
          consoleController.addEBike();
          //logger.add("Add a new e-bike");
          break;
        case 5:
          consoleController.searchBike();
          //logger.add("Find the first item of a particular brand");
          break;
        case 6:
          consoleController.saveData();
          System.out.println("Save completed");
          //logger.add("Write to file");
          break;
        case 7:
          consoleController.saveData();
          System.out.println("Save completed");
          System.out.println("Goodbye!");
          System.exit(1);
          break;
        default:
          System.out.println("Try to enter menu item again");
      }
    } catch (InvalidUserInput e) {
      System.out.println(e.getMessage());
      if (e.getCause() != null) {
        System.out.println("Original exception " + e.getCause().getMessage());
      }
    } finally {
      this.showMenu();
    }
  }

  private void showBikes(List<Identifiable> bikes) {
    bikes.forEach(item -> {
      Bike bike = (Bike) item;
      switch (bike.getTypeOfBike()) {
        case FOLDINGBIKE: {
          FoldingBike foldingBike = (FoldingBike) bike;
          showFoldingBike(foldingBike);
          break;
        }
        case SPEEDELEC: {
          Speedelec speedelec = (Speedelec) bike;
          showSpeedelec(speedelec);
          break;
        }
        case EBIKE: {
          EBike eBike = (EBike) bike;
          showEBike(eBike);
          break;
        }
        default: {

        }
      }
    });
  }

  private void showFoldingBike(FoldingBike foldingBike) {
    System.out.printf("%s %s with %d gear(s) and%s head/tail light.\n",
            foldingBike.getTypeOfBike().getFullNameOfType(),
            foldingBike.getBrand(),
            foldingBike.getNumberOfGears(),
            foldingBike.isAvailabilityLights()?"":" no");
    System.out.printf("Price: %d euros.\n", foldingBike.getPrice());
  }

  private void showSpeedelec(Speedelec speedelec) {
    System.out.printf("%s %s with %d mAh battery and%s head/tail light.\n",
            speedelec.getTypeOfBike().getFullNameOfType(),
            speedelec.getBrand(),
            speedelec.getBatteryCapacity(),
            speedelec.isAvailabilityLights()?"":" no");
    System.out.printf("Price: %d euros.\n", speedelec.getPrice());
  }

  private void showEBike(EBike eBike) {
    System.out.printf("%s %s with %d mAh battery and%s head/tail light.\n",
            eBike.getTypeOfBike().getFullNameOfType(),
            eBike.getBrand(),
            eBike.getBatteryCapacity(),
            eBike.isAvailabilityLights()?"":" no");
    System.out.printf("Price: %d euros.\n", eBike.getPrice());
  }
}
