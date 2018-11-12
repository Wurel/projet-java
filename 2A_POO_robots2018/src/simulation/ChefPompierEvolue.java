package simulation;

import donnees.*;
import creer_date.*;
import java.util.*;

public class ChefPompierEvolue{
  Simulateur simul;
  DonneesSimulation donnees;

  public ChefPompierEvolue(Simulateur simul, DonneesSimulation donnees){
    this.simul = simul;
    this.donnees = donnees;
  }

  public void ordres(){
    ArrayList<Incendie> incendiesRestantsList = new ArrayList<Incendie>();
    for(Incendie incend : this.donnees.getIncendies()){
      if (incend.getEauNecessaire() != 0){
        incendiesRestantsList.add(incend); // On itère seulement sur les incendies allumés
      }
    }
    Incendie incendiesRestants[] = new Incendie[incendiesRestantsList.size()];
    incendiesRestants = incendiesRestantsList.toArray(incendiesRestants);
    if (this.donnees.getRobots().length > incendiesRestants.length){
      for (Incendie incend : incendiesRestants){ // Permet des affectations multiples
        incend.setAffecte(false); // quand il y a plus de robots que d'incendies
      }
    }
    for (Incendie incend : this.donnees.getIncendies()){
      ArrayList<Robot> robotsAffectes = new ArrayList<Robot>();
      for (Robot robot : this.donnees.getRobots()){
        if (robot.getPosition().equals(incend.getPosition())){
          robotsAffectes.add(robot);
        }
      }
      if (robotsAffectes.size() > 1 && incend.getEauNecessaire() == 0){
        for(Robot robot : robotsAffectes){ // Permet de faire repartir le robot
          robot.setDate(this.simul.getDate()); // S'il reste des événements intervention
        } // Alors que l'eau nécessaire de l'incendie est à 0
      }
    }
    if (incendiesRestantsList.size() == 0){
      long dateMax = this.simul.getDate();
      for (Evenement event : this.simul.getEvenements()){
        if (event.getDate() > dateMax){
          dateMax = event.getDate();
        }
      }
      while(this.simul.getDate() != dateMax + 1){ // Permet de sauter les événements inutiles
        this.simul.incrementeDate(); // dûs aux affectations multiples
      }
    }
    for (Robot robot : this.donnees.getRobots()) {
      if (!(robot.getOccupe()) && (robot.getVitesse(robot.getPosition().getNature()) != 0) && (robot.getReservoirEau() == 0) && !(robot.getType().equals("Pattes"))){
        robot.setDate(this.simul.getDate());
        ArrayList<Case> casesEau = new ArrayList<Case>();
        casesEau = robot.getCarte().getCasesEau();
        if (casesEau.size() == 0){
          break;
        }
        Case caseEau = casesEau.get(0);
        boolean acces = false;
        long temps = Long.MAX_VALUE;
        ArrayList<Case> cheminEau = new ArrayList<Case>();
        switch(robot.getType()){
            case "Drone" : // Un robot drone se remplit sur une case d'eau
            for (Case caseTestee : casesEau){
              if (robot.peutAller(caseTestee)){
                ArrayList<Case> chemin = new ArrayList<Case>();
                chemin = robot.goTo(caseTestee);
                long nvTemps = robot.timeToDo(chemin);
                if (nvTemps < temps) {
                  temps = nvTemps;
                  caseEau = caseTestee;
                }
              }
            }
            break;
          case "Roues" : // Un robot à roues se remplit sur une case voisine
          case "Chenilles" : // d'une case d'eau de même que le robot à chenilles
            for (Case caseTestee : casesEau){
              for (int i = 0; i < 4; i++){
                if (robot.peutAller(robot.getCarte().getVoisin(caseTestee, Direction.values()[i]))){
                  acces = true;
                  ArrayList<Case> chemin = new ArrayList<Case>();
                  chemin = robot.goTo(robot.getCarte().getVoisin(caseTestee, Direction.values()[i]));
                  long nvTemps = 0;
                  if (chemin.size() != 0){
                    nvTemps = robot.timeToDo(chemin);
                  }
                  if (nvTemps < temps) {
                    temps = nvTemps;
                    caseEau = robot.getCarte().getVoisin(caseTestee, Direction.values()[i]);
                  }
                }
              }
            }
            break;
          case "Pattes" : // Un robot à pattes ne se remplit jamais
            break;
        }
        if ((!acces) && (robot.getType() == "Roues" || robot.getType() == "Chenilles")){
          continue;
        }
        else {
          cheminEau = robot.goTo(caseEau);
          Case futurCase = robot.getPosition();
          for(int j = 0; j < cheminEau.size(); j++){
            simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(robot, futurCase.getDirectionVoisin(cheminEau.get(j)))).retourneDate()
              , futurCase.getDirectionVoisin(cheminEau.get(j)), robot.getCarte(), robot));
            System.out.println(futurCase.getDirectionVoisin(cheminEau.get(j)));
            futurCase = cheminEau.get(j);
          }
          simul.ajouteEvenement(new EvenementRemplir(new CreerDateRemplir(robot).retourneDate(), robot.getCarte(), robot));

          robot.setOccupe(true);
        }
      }
    }
    boolean incendieLePlusEloigneExiste = false;
    if (this.donnees.getCarte().getCasesEau().size() != 0) {
      for (Incendie incend : incendiesRestants) {
        boolean incendieLePlusEloigne = true;
        for (Robot robot : this.donnees.getRobots()) {
          if (robot.getType() != "Pattes"){
            if (!(incend.equals(robot.getIncendiesProchesEau(incendiesRestantsList).get(0)))){
              incendieLePlusEloigne = false;
            }
          }
        }
        if (incendieLePlusEloigne){
          incendieLePlusEloigneExiste = true;
        }
      }
    }

    for (Incendie incend : incendiesRestants) {
      boolean incendieLePlusEloigne = true;
      for (Robot robot : this.donnees.getRobots()) {
        if (robot.getType() != "Pattes"){
          if (!(incend.equals(robot.getIncendiesProchesEau(incendiesRestantsList).get(0)))){
            incendieLePlusEloigne = false;
          }
        }
      }
      boolean allRobotsOccupied = true;
      for (Robot robot : this.donnees.getRobots()) {
        if (!robot.getOccupe()){
          allRobotsOccupied = false;
        }
      }
      if (incend.getAffecte()) {
        if (incend.getEauNecessaire() == 0){
          System.out.println("L'incendie est éteint");
        }
        else {
        System.out.println("L'incendie est affecté");
        }
        continue;
      } else if(allRobotsOccupied) {
        System.out.println("Tous les robots sont occupés");
        continue;
      }
      else{
        System.out.println(incend);
        ArrayList<Case> chemin = new ArrayList<Case>();
        long temps = Long.MAX_VALUE;
        Robot currentRobot = this.donnees.getRobots()[0];
        for (Robot robot : this.donnees.getRobots()) {
          if (incendieLePlusEloigneExiste && (incendiesRestants.length > 1) && robot.getType() == "Pattes" && (!(robot.getOccupe()))){
            if (incendieLePlusEloigne){
              incend.setAffecte(true);
              currentRobot = robot;
              chemin = robot.goTo(incend.getPosition());
              break;
            }
            continue;
          }
          if (robot.getOccupe() || (robot.getVitesse(robot.getPosition().getNature()) == 0) || (!(robot.peutAller(incend.getPosition()))) || (this.simul.getDate() < robot.getDate()) || (robot.getReservoirEau() == 0 && !(robot.getType().equals("Pattes")) )) {
            continue;
          }
          else{
            incend.setAffecte(true);
            ArrayList<Case> nvChemin = new ArrayList<Case>();
            nvChemin = robot.goTo(incend.getPosition());
            long nvTemps = 0;
            if (nvChemin.size() != 0){
              nvTemps = robot.timeToDo(nvChemin);
            }
            if (nvTemps < temps) {
              temps = nvTemps;
              currentRobot = robot;
              chemin = nvChemin;
            }
          }
        }
        if(currentRobot.getVitesse(currentRobot.getPosition().getNature()) == 0){
          continue;
        }
        else {
          currentRobot.setDate(this.simul.getDate());
          currentRobot.setOccupe(true);
          Case futurCase = currentRobot.getPosition();
          for(int j = 0; j < chemin.size(); j++){
            simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(currentRobot, futurCase.getDirectionVoisin(chemin.get(j)))).retourneDate()
              , futurCase.getDirectionVoisin(chemin.get(j)), currentRobot.getCarte(), currentRobot));
            System.out.println(futurCase.getDirectionVoisin(chemin.get(j)));
            futurCase = chemin.get(j);
          }

          int eauIncend = incend.getEauNecessaire();
          int eauRobot = currentRobot.getReservoirEau();

          while (eauIncend > 0 && (eauRobot > 0 || currentRobot.getType().equals("Pattes"))) {
            simul.ajouteEvenement(new EvenementInterventionUnitaire(new CreerDateIntervention(currentRobot
            ).retourneDate(), incend, currentRobot));
            switch(currentRobot.getType()){
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
