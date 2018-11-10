package simulation;

import donnees.Robot;
import donnees.Carte;
import donnees.Case;
import donnees.DonneesSimulation;
import donnees.Incendie;

public class EvenementInterventionUnitaire extends Evenement {

  private Robot robot;
  private Incendie[] incendies;


  public EvenementInterventionUnitaire(long date, Incendie[] incendies, Robot robot){
    super(date);
    this.robot = robot;
    this.incendies = incendies;
    this.robot.setDate(date);
  }

  @Override
  public void execute(){
    for (Incendie incend : incendies) {
      if (this.robot.getPosition().equals(incend.getPosition())) {
        System.out.println("il est sur la bonne case");
        System.out.println(this.robot.getType());
        switch(this.robot.getType()){
          case "Drone" :
            if (this.robot.getReservoirEau() - incend.getEauNecessaire() >= 0) {
              this.robot.deverserEau(incend.getEauNecessaire());
              incend.setEauNecessaire(0);
              //this.robot.setOccupe(false);
            }
            else {
              System.out.println(this.robot.getReservoirEau());
              incend.setEauNecessaire(incend.getEauNecessaire() - this.robot.getReservoirEau());
              this.robot.deverserEau(this.robot.getReservoirEau());
            }
            break;
          case "Roues" :
          case "Chenilles" :
            if (this.robot.getReservoirEau() >= 100 && incend.getEauNecessaire() >= 100) {
              this.robot.deverserEau(100);
              incend.setEauNecessaire(incend.getEauNecessaire()-100);
            }
            else if (this.robot.getReservoirEau() >= 100 && incend.getEauNecessaire() < 100){
              this.robot.deverserEau(100 - incend.getEauNecessaire());
              incend.setEauNecessaire(0);
              //this.robot.setOccupe(false);
            }
            break;
          case "Pattes" :
            if (incend.getEauNecessaire() >= 10) {
              incend.setEauNecessaire(incend.getEauNecessaire()-10);
            }
            else if (incend.getEauNecessaire() < 10){
              incend.setEauNecessaire(0);
            }
            break;
        }
        if(this.robot.getReservoirEau() == 0){
          this.robot.setOccupe(false);
        }
      }
    }
  }

}
