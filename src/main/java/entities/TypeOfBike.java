package entities;

public enum TypeOfBike {
  FOLDINGBIKE("FOLDING BIKE"),
  SPEEDELEC("SPEEDELEC"),
  EBIKE("E-BIKE");

  private final String fullTittle;

  TypeOfBike(String fullTittle){
    this.fullTittle = fullTittle;
  }

  public String getFullNameOfType(){
    return this.fullTittle;
  }
}
