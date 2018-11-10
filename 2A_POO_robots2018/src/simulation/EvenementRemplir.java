package simulation;
import donnees.Robot;
import donnees.NatureTerrain;
import donnees.Carte;


public class EvenementRemplir extends Evenement{
  private Carte carte;
  private Robot robot;

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
