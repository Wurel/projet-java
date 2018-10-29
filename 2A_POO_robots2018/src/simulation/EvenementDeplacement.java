package simulation;

import donnees.Carte;
import donnees.Robot;
import donnees.Direction;

class EvenementDeplacement extends Evenement{

  Direction dir;
  Carte carte;
  Robot robot;

  public EvenementDeplacement(int date, Direction dir, Carte carte, Robot robot){
    super(date);
    this.dir = dir;
    this.carte = carte;
    this.robot = robot;
  }

  @Override
  public void execute(){
    if (carte.voisinExiste(this.robot.getPosition(), this.dir) &&
    this.robot.peutSeDeplacer()) {
      this.robot.setPosition(carte.getVoisin(this.robot.getPosition, this.dir))

    }
  }

}
