package donnees;
import io.LecteurDonnees;

/**
  * Classe representant l'ensemble des donnees du probleme
  */
public class DonneesSimulation{
  Carte carte;
  Incendie incendies[];
  Robot robots[];

  /**
    * @param car Carte du probleme
    */
  public void setCarte(Carte car){
    this.carte = car;
  }

  /**
    * @return Renvoie la carte du probleme
    */
  public Carte getCarte(){
    return this.carte;
  }

  /**
    * @param incend Liste contenant tous les incendies de la carte
    */
  public void setIncendies(Incendie[] incend){
    this.incendies = incend;
  }

  /**
    * @return Renvoie la liste des Incendies
    */
  public Incendie[] getIncendies(){
    return this.incendies;
  }

  /**
    * @param robot Liste contenant tous les robots
    */
  public void setRobots(Robot[] robot){
    this.robots = robot;
  }

  /**
    * @return Renvoie la liste des robots
    */
  public Robot[] getRobots(){
    return this.robots;
  }

  /**
    * @return Renvoie l'ensemble des donnees relatives au probleme
    */
  @Override
  public String toString(){
    String strDonnees = new String();
    strDonnees += carte.toString();
    strDonnees += "Incendies : \n";
    for (Incendie incend : incendies) {
      strDonnees += incend.toString();
    }
    strDonnees += "Robots : \n";
    for (Robot robot : robots) {
      strDonnees += robot.toString();
    }
    return strDonnees;
  }

}
