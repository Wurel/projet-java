package donnees;

public enum Direction{
  NORD ("NORD"),
  SUD ("SUD"),
  EST ("EST"),
  OUEST ("OUEST");

  private String dir = "";

  Direction(String name){
    this.dir = name;
  }

  public String toString(){
    return this.dir;
  }

}
