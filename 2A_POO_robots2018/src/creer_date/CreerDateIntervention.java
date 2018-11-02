package creer_date;
import donnees.*;

public class CreerDateIntervention {
  long date;
  Robot robot;
  Direction dir;

  public CreerDateIntervention(Robot robot, long date){
    this.robot = robot;
    this.date = date;
  }

  public long retourneDate(){
    switch this.robot.getType{
      case "Drone":
        return this.date + 30;
      case "Roues":
        return this.date + 5;
      case "Chenilles":
        return this.date + 8;
      case "Pattes":
        return this.date + 1;
    }
  }

}
