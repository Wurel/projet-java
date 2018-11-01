package simulation;
import donnees.Robot;
import donnees.NatureTerrain;
import donnees.Carte;


public class EvenementRemplir extends Evenement{
  Carte carte;
  Robot robot;

  public EvenementRemplir(long date, Carte carte, Robot robot){
    super(date);
    this.carte = carte;
    this.robot = robot;
  }

  @Override
  public void execute(){
    this.robot.remplirReservoir();
   }

}
