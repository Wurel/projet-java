package simulation;
import donnees.Robot;
import donnees.NatureTerrain;


class EvenementRemplir extends Evenement{
  Carte carte;
  Robot robot;

  public EvenementDeplacement(int date, Carte carte, Robot robot){
    super(date);
    this.carte = carte;
    this.robot = robot;
  }

  @Override
  public void execute(){
    this.robot.remplirReservoir()
   }

}
