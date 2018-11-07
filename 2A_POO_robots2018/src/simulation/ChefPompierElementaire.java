package simulation;

import donnees.*;
import creer_date.*;
import java.util.*;

public class ChefPompierElementaire{
  Simulateur simul;
  DonneesSimulation donnees;

  public ChefPompierElementaire(Simulateur simul, DonneesSimulation donnees){
    this.simul = simul;
    this.donnees = donnees;
  }

  public void ordres(){
    for (Incendie incend : this.donnees.getIncendies()) {
      if (incend.getAffecte()) {
        System.out.println("L Incendie EST AFFECTE ");
        continue;
      }
      else{
        System.out.println(incend);
        for (Robot robot : this.donnees.getRobots()) {
          if (incend.getAffecte() || (this.simul.getDate() < robot.getDate()) || (robot.getReservoirEau() == 0 && !(robot.getType().equals("Pattes")) )) {
            continue;
          }
          else{
            robot.setDate(this.simul.getDate());
            System.out.println(incend.getAffecte());
            incend.setAffecte(true);
            ArrayList<Case> chemin = new ArrayList<Case>();
            chemin = robot.goTo(incend.getPosition());
            Case futurCase = robot.getPosition();
            int j = 0;
            for (Case caz : chemin) {
              System.out.println("La prochaine case est la " + caz);
              for (int i = 0; i < 4; i = i + 1) {
                if (j < chemin.size() && robot.getCarte().voisinExiste(futurCase, Direction.values()[i]) && robot.getCarte().getVoisin(futurCase, Direction.values()[i]).equals(chemin.get(j))) {
                  simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(robot, Direction.values()[i])).retourneDate()
                    , Direction.values()[i], robot.getCarte(), robot));
                    System.out.println(robot.getDate());
                    futurCase = chemin.get(j);
                    j++;
                    System.out.println("Le robot " + robot.getType() + " va se deplacer vers " + Direction.values()[i] + " pour eteindre l'incendie " + incend);

                }
              }
            }
            int eauIncend = incend.getEauNecessaire();
            int eauRobot = robot.getReservoirEau();
            int decrementation = 0;

            switch(robot.getType()){
              case "Drone" :
                decrementation = 10000;
                break;
              case "Roues" :
              case "Chenilles" :
                decrementation = 100;
                break;
              case "Pattes" :
                decrementation = 10;
                break;
            }

            while (eauIncend > 0 && (eauRobot > 0 || robot.getType().equals("Pattes"))) {
              simul.ajouteEvenement(new EvenementInterventionUnitaire(new CreerDateIntervention(robot
              ).retourneDate(), this.donnees.getIncendies(), robot));
              eauRobot -= decrementation;
              eauIncend -= decrementation;

            }
            System.out.println();
            System.out.println();
          }
        }
      }
    }
  }

}
