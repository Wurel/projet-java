package simulation;


import donnees.Robot;
import donnees.Carte;
import donnees.DonneesSimulation;

class EvenementIntervention extends Evenement {

  Robot robot;
  DonneesSimulation donnees;

  public EvenementIntervention(int date, DonneesSimulation donnees, Robot robot){
    super(date);
    this.robot = robot;
    this.carte = carte;
  }

  @Override
  public void execute{
    for (Incendie incend : donnees.Incendies) {
      if (robot.getPosition() == incend.getPosition()) {
        robot.setReservoirEau(robot.getReservoirEau() - incend.getEauNecessaire());
      }
    }
  }

}
