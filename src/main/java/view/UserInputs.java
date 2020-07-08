package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputs {
  private Scanner scan = new Scanner(System.in);

  public int getMenuItem() throws InvalidUserInput {
    int input = 0;
    try {
      input = scan.nextInt();
    } catch (InputMismatchException e) {
      scan.nextLine();
      throw new InvalidUserInput("Wrong input", input, e);
    }
    return input;
  }
}
