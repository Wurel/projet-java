package creer_date;
import donnees.*;

public class CreerDateRemplir {
  long date;
  Robot robot;
  Direction dir;

  public CreerDateRemplir(Robot robot, long date){
    this.robot = robot;
    this.date = date;
  }

  public long retourneDate(){
    switch this.robot.getType{
      case "Drone":
        return this.date +  1800;
      case "Roues":
        return this.date + 600
      case "Chenilles":
        return this.date + 300;
      case "Pattes":
        return this.date;
  }

}
