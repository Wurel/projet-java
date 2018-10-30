package simulation;


import donnees.Robot;
import donnees.Carte;
import donnees.Case;
import donnees.DonneesSimulation;
import donnees.Incendie;

public class EvenementIntervention extends Evenement {

  Robot robot;
  Incendie[] incendies;


  public EvenementIntervention(int date, Incendie[] incendies, Robot robot){
    super(date);
    this.robot = robot;
    this.incendies = incendies;
  }

  @Override
  public void execute(){
    for (Incendie incend : incendies) {
      if (robot.getPosition().equals(incend.getPosition())) {
        System.out.println("il est sur la bonne case");
        if (robot.getReservoirEau() - incend.getEauNecessaire() >= 0) {
          robot.setReservoirEau(robot.getReservoirEau() - incend.getEauNecessaire());
          incend.setEauNecessaire(0);
        }
        else {
          System.out.println(robot.getReservoirEau());
          incend.setEauNecessaire(incend.getEauNecessaire() - robot.getReservoirEau());
          robot.setReservoirEau(0);
        }
      }

    }
  }

}
