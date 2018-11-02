package simulation;

import creer_date.*;
import donnees.Robot;
import donnees.Carte;
import donnees.Case;
import donnees.DonneesSimulation;
import donnees.Incendie;

public class EvenementIntervention extends Evenement {

  private Robot robot;
  private Incendie[] incendies;
  private Simulateur simul;


  public EvenementIntervention(long date, Incendie[] incendies, Robot robot, Simulateur simul){
    super(date);
    this.robot = robot;
    this.incendies = incendies;
    this.simul = simul;
  }

  @Override
  public void execute(){

        // if (this.robot.getReservoirEau() - incend.getEauNecessaire() >= 0) {
        //   this.robot.deverserEau(incend.getEauNecessaire());
        //   incend.setEauNecessaire(0);
        // }
        // else {
        //   System.out.println(this.robot.getReservoirEau());
        //   incend.setEauNecessaire(incend.getEauNecessaire() - this.robot.getReservoirEau());
        //   this.robot.deverserEau(this.robot.getReservoirEau());
        // }
      //}

      
      for (Incendie incend : this.incendies) {
        if (this.robot.getPosition().equals(incend.getPosition())) {
          int volume = 0;
          if (this.robot.getReservoirEau() <= incend.getEauNecessaire()){
            volume = this.robot.getReservoirEau();
          }
          else {
            volume = incend.getEauNecessaire();
          }
          while (volume != 0){
            System.out.println("a");
            EvenementInterventionUnitaire interventionUnitaire = new EvenementInterventionUnitaire(new CreerDateIntervention(this.robot
            , this.simul.getEvenements().get(5).getDate()).retourneDate(), this.incendies, this.robot);
            interventionUnitaire.execute();
            switch (this.robot.getType()){
              case "Drone":
                volume = 0; // Vide la totalité du réservoir
                break;
              case "Roues":
              case "Chenilles":
                volume -= 100;  // Vide 100 litres
                break;
              case "Pattes:" :
                volume -= 10; // Vide 10 litres
                break;
              default :
                break;
            }
          }
        }
      }

  //  }
  }

}
