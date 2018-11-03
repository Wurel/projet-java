package simulation;

import creer_date.*;
import donnees.*;

public class EvenementDeplacement extends Evenement{

  Direction dir;
  Carte carte;
  Robot robot;

  public EvenementDeplacement(long date, Direction dir, Carte carte, Robot robot){
    super(date);
    this.dir = dir;
    this.carte = carte;
    this.robot = robot;
    this.robot.setDate(date);
  }

  @Override
  public void execute(){
    if (carte.voisinExiste(this.robot.getPosition(), this.dir) &&
    this.robot.peutSeDeplacer(carte.getVoisin(this.robot.getPosition(), this.dir))) {
      this.robot.setPosition(carte.getVoisin(this.robot.getPosition(), this.dir));
    }
    else{
      throw new IllegalArgumentException("Le robot " + this.robot.getType() + " ne peut pas se deplacer dans cette direction : " + dir);
    }
  }

}
