package view;

import controller.ConsoleController;
import logger.Logger;


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
          consoleController.getAllBikes();
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
          consoleController.saveChanges();
          //logger.add("Write to file");
          break;
        case 7:
          consoleController.saveChanges();
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
}
