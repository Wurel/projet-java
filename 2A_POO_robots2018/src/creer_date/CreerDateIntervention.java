package creer_date;
import donnees.*;

public class CreerDateIntervention extends CreerDate {

  public CreerDateIntervention(Robot robot){
    super(robot);
  }

  public long retourneDate(){
    switch (this.getRobot().getType()){
      case "Drone":
        return this.getDate() + 30; // Vide la totalité du réservoir en 30 sec
      case "Roues":
        return this.getDate() + 5;  // Vide 100 litres en 5 sec
      case "Chenilles":
        return this.getDate() + 8; // Vide 100 litres en 8 sec
      case "Pattes" :
        return this.getDate() + 1; // Vide 10 litres en 1 sec
      default :
        return this.getDate();
    }
  }

}
