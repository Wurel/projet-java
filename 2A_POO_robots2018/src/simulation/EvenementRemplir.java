package simulation;
import donnees.Robot;
import donnees.NatureTerrain;
import donnees.Carte;

/**
  * Classe representant un Evenement ou le robot remplit son reservoir
  */
public class EvenementRemplir extends Evenement{
  private Carte carte;
  private Robot robot;

  /**
    * @param date Date de la fin du deplacement
    * @param carte Carte sur laquelle le robot se situe 
    * @param robot C'est le robot qui se remplit
    */
  public EvenementRemplir(long date, Carte carte, Robot robot){
    super(date);
    this.carte = carte;
    this.robot = robot;
    this.robot.setDate(date);
  }

  @Override
  public void execute(){
    this.robot.remplirReservoir();
    this.robot.setOccupe(false);
   }

}
