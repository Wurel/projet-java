package simulation;

import creer_date.*;
import donnees.*;

/**
  * Classe representant un Evenement ou le robot se deplace
  */
public class EvenementDeplacement extends Evenement{

  private Direction dir;
  private Carte carte;
  private Robot robot;

  /**
    * @param date Date de la fin du deplacement
    * @param dir Direction du deplacement
    * @param carte Carte sur laquelle le robot se deplace
    * @param robot C'est le robot qui se deplace
    */
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
