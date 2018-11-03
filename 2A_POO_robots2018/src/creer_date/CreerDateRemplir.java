package creer_date;
import donnees.*;

public class CreerDateRemplir extends CreerDate {

  public CreerDateRemplir(Robot robot){
    super(robot);
  }

  public long retourneDate(){
    switch (this.getRobot().getType()){
      case "Drone":
        return this.getDate() +  1800; // Remplissage complet en 30 mins
      case "Roues":
        return this.getDate() + 600; // Remplissage complet en 10 mins
      case "Chenilles":
        return this.getDate() + 300; // Remplissage complet en 5 mins
      case "Pattes" :
      default :
        return this.getDate(); // Ne se remplit jamais
    }
  }

}
