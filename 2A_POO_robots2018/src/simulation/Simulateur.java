package simulation;
import java.util.ArrayList;

/**
  * Classe permettant la simulation du probleme
  */
public class Simulateur{
  private long dateSimulation;
  private ArrayList<Evenement> evenements;

  /**
    * @param e Ajoute l'Evenement a la liste d'Evenement
    */
  public void ajouteEvenement(Evenement e){
    try {
      this.evenements.add(e);
    }catch (NullPointerException excep) {
      evenements = new ArrayList<Evenement>();
      this.evenements.add(e);
    }
  }

  /**
    * @return Renvoie la liste contenant tous les evenements
    */
  public ArrayList<Evenement> getEvenements(){
    return this.evenements;
  }

  /**
    * @return Renvoie la date actuelle
    */
  public long getDate(){
    return this.dateSimulation;
  }

  /**
    * Increment la date
    */
  public void incrementeDate(){
    this.dateSimulation ++;
  }

  /**
    * @return Indique si la simulation est terminee
    */
  public boolean simulationTerminee(){
    try {
      for (Evenement event : this.evenements) {
        if (event.getDate() >= this.getDate()) {
          return false;
        }
      }
      return true;
    }catch (NullPointerException e){
      System.out.println("C'est terminé");
      return true;
    }
  }

}
