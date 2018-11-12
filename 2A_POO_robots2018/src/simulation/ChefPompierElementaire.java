package simulation;

import donnees.*;
import creer_date.*;
import java.util.*;

/**
  * Classe modelisant un chef pompier qui donne des ordres aux differents robots suivant la strategie elementaire
  */
public class ChefPompierElementaire{
  Simulateur simul;
  DonneesSimulation donnees;

  /**
    * @param simul Simulateur dans lequel le chef pompier evolue
    * @param donnees Donnees de la simulation dont le chef a besoin pour donner ses ordres
    */
  public ChefPompierElementaire(Simulateur simul, DonneesSimulation donnees){
    this.simul = simul;
    this.donnees = donnees;
  }

  /**
    * Le chef pompier donne des ordres aux robots afin qu'ils se deplacent et eteignent les incendies
    */
  public void ordres(){
    for (Incendie incend : this.donnees.getIncendies()) {
      if (incend.getAffecte()) {
        System.out.println("L'incendie est affecté");
        continue;
      }
      else{
        for (Robot robot : this.donnees.getRobots()) {
          if (incend.getAffecte() || !(robot.peutAller(incend.getPosition())) || (this.simul.getDate() < robot.getDate()) || (robot.getReservoirEau() == 0 && !(robot.getType().equals("Pattes")))) {
            continue;
          }
          else{
            robot.setDate(this.simul.getDate());
            System.out.println(incend.getAffecte());
            incend.setAffecte(true);
            ArrayList<Case> chemin = new ArrayList<Case>();
            chemin = robot.goTo(incend.getPosition());
            Case futurCase = robot.getPosition();
            for(int j = 0; j < chemin.size(); j++){
              simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(robot, futurCase.getDirectionVoisin(chemin.get(j)))).retourneDate()
                , futurCase.getDirectionVoisin(chemin.get(j)), robot.getCarte(), robot));
              System.out.println(robot.getDate());
              System.out.println(futurCase.getDirectionVoisin(chemin.get(j)));
              futurCase = chemin.get(j);
            }

            int eauIncend = incend.getEauNecessaire();
            int eauRobot = robot.getReservoirEau();

            while (eauIncend > 0 && (eauRobot > 0 || robot.getType().equals("Pattes"))) {
              simul.ajouteEvenement(new EvenementInterventionUnitaire(new CreerDateIntervention(robot
              ).retourneDate(), incend, robot));
              switch(robot.getType()){
                case "Drone" :
                  eauRobot -= 10000;
                  eauIncend -= 10000;
                  break;
                case "Roues" :
                case "Chenilles" :
                  eauRobot -= 100;
                  eauIncend -= 100;
                  break;
                case "Pattes" :
                  eauRobot -= 10;
                  eauIncend -= 10;
                  break;
              }
            }
          }
        }
      }
    }
  }

}
