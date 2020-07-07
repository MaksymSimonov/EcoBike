package logger;

import java.io.*;
import java.util.ArrayList;

public class Logger {
  private final File file;
  private final ArrayList<String> passengersLogHistory;

  public Logger() {
    this(new File("./data", "logs.txt"));
  }

  private Logger(File file) {
    this.file = file;
    this.passengersLogHistory = new ArrayList<>();
  }

  public void add(String action) {
    passengersLogHistory.add(action);
  }

  public void save() {
    try {
      FileOutputStream f = new FileOutputStream(file);
      ObjectOutputStream o = new ObjectOutputStream(f);
      o.writeObject(passengersLogHistory);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}