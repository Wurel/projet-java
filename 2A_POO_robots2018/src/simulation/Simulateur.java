package simulation;
import java.util.ArrayList;

public class Simulateur{
  private long dateSimulation;
  private ArrayList<Evenement> evenements;

  public void ajouteEvenement(Evenement e){
    try {
      this.evenements.add(e);
    }catch (NullPointerException excep) {
      evenements = new ArrayList<Evenement>();
      this.evenements.add(e);
    }
  }

  public ArrayList<Evenement> getEvenements(){
    return this.evenements;
  }

  public long getDate(){
    return this.dateSimulation;
  }

  public void incrementeDate(){
    this.dateSimulation ++;
  }

  public boolean simulationTerminee(){
    try {
      for (Evenement event : this.evenements) {
        if (event.getDate() >= this.getDate()) {
          return false;
        }
      }
      return true;
    }catch (NullPointerException e){
      System.out.println("C est termine");
      return true;
    }
  }

}
