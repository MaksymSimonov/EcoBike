package view;

public class InvalidUserInput extends Exception {
  InvalidUserInput(String wrong_input, String input, Throwable cause) {
    super(wrong_input + ": " + input, cause);
  }
}
