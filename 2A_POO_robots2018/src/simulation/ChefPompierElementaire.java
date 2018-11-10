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
    for (Robot robot : this.donnees.getRobots()) {
      if (robot.getReservoirEau() == 0 && !(robot.getType().equals("Pattes"))){
        robot.setDate(this.simul.getDate());
        ArrayList<Case> caseEau = new ArrayList<Case>();
        caseEau = robot.getCarte().getCaseEau();
        ArrayList<Case> cheminEau = new ArrayList<Case>();
        cheminEau = robot.goTo(caseEau.get(0));
        Case futurCase = robot.getPosition();
        for(int j = 0; j < chemin.size(); j++){
          simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(robot, futurCase.getDirectionVoisin(chemin.get(j)))).retourneDate()
            , futurCase.getDirectionVoisin(chemin.get(j)), robot.getCarte(), robot));
          System.out.println(robot.getDate());
          System.out.println(futurCase.getDirectionVoisin(chemin.get(j)));
          futurCase = chemin.get(j);
        }
        simul.ajouteEvenement(new EvenementRemplir(new CreerDateRemplir(robot).retourneDate(), robot.getCarte(), robot));
      }
    }
    for (Incendie incend : this.donnees.getIncendies()) {
      if (incend.getAffecte()) {
        System.out.println("L Incendie EST AFFECTE ");
        continue;
      }
      else{
        System.out.println(incend);
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
              ).retourneDate(), this.donnees.getIncendies(), robot));
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
