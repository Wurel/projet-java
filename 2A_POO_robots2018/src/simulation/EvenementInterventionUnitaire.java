package simulation;

import donnees.Robot;
import donnees.Carte;
import donnees.Case;
import donnees.DonneesSimulation;
import donnees.Incendie;

/**
  * Classe representant un Evenement ou le robot intervient sur un incendie
  */
public class EvenementInterventionUnitaire extends Evenement {

  private Robot robot;
  private Incendie incendie;

  /**
    * @param date Date de la fin du deplacement
    * @param incend Incendie sur lequel le robot intervient
    * @param robot C'est le robot qui intervient
    */

  public EvenementInterventionUnitaire(long date, Incendie incend, Robot robot){
    super(date);
    this.robot = robot;
    this.incendie = incend;
    this.robot.setDate(date);
  }

  @Override
  public void execute(){
    if (this.robot.getPosition().equals(this.incendie.getPosition())) {
      switch(this.robot.getType()){
        case "Drone" :
          if (this.robot.getReservoirEau() - this.incendie.getEauNecessaire() >= 0) {
            this.robot.deverserEau(this.incendie.getEauNecessaire());
            this.incendie.setEauNecessaire(0);
            this.robot.setOccupe(false);
          }
          else {
            this.incendie.setEauNecessaire(this.incendie.getEauNecessaire() - this.robot.getReservoirEau());
            this.robot.deverserEau(this.robot.getReservoirEau());
          }
          break;
        case "Roues" :
        case "Chenilles" :
          if (this.robot.getReservoirEau() >= 100 && this.incendie.getEauNecessaire() >= 100) {
            this.robot.deverserEau(100);
            this.incendie.setEauNecessaire(this.incendie.getEauNecessaire()-100);
            if(this.incendie.getEauNecessaire() == 0){
              this.robot.setOccupe(false);
            }
          }
          else if (this.robot.getReservoirEau() >= 100 && this.incendie.getEauNecessaire() < 100){
            this.robot.deverserEau(100 - this.incendie.getEauNecessaire());
            this.incendie.setEauNecessaire(0);
            this.robot.setOccupe(false);
          }
          break;
        case "Pattes" :
          if (this.incendie.getEauNecessaire() > 10) {
            this.incendie.setEauNecessaire(this.incendie.getEauNecessaire()-10);
          }
          else if (this.incendie.getEauNecessaire() <= 10){
            this.incendie.setEauNecessaire(0);
            this.robot.setOccupe(false);
          }
          break;
      }
      if((this.robot.getReservoirEau() == 0) && !(robot.getType().equals("Pattes"))){
        this.robot.setOccupe(false);
        if (this.incendie.getEauNecessaire() != 0){
          this.incendie.setAffecte(false);
        }
      }
    }
  }

}
