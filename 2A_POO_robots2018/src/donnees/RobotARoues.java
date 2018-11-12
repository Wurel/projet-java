package donnees;

import java.util.*;

public class RobotARoues extends Robot {

  public RobotARoues(Carte carte, int ligne, int colonne){
    super(carte, ligne, colonne);
    this.setVitesse(80);
    this.setReservoirEau(5000);
  }

  public RobotARoues(Carte carte, int ligne, int colonne, double vitesse){
    super(carte, ligne, colonne);
    this.setVitesse(vitesse);
    this.setReservoirEau(5000);
  }

  @Override
  public String getType(){
    return "Roues";
  }

  @Override
  public double getVitesse(NatureTerrain naturePosition){
    return super.getVitesse(naturePosition);
  }

  @Override
  public boolean peutSeDeplacer(Case nvCase){
    switch(nvCase.getNature()){
      case EAU :
      case FORET :
      case ROCHE:
        return false;
      default :
        return true;
    }
  }

  public ArrayList<Incendie> getIncendiesProchesEau(ArrayList<Incendie> incendies){
    ArrayList<Incendie> incendiesProximiteEau = new ArrayList<Incendie>();
    ArrayList<Long> tempsIncendiesEau = new ArrayList<Long>();
    for (Incendie incend : incendies){
      RobotDrone robot = new RobotDrone(this.getCarte(), incend.getPosition().getLigne(), incend.getPosition().getColonne(), this.getVitesse(incend.getPosition().getNature()));
      long temps = Long.MAX_VALUE;
      boolean acces = false;
      for (Case caseEau : this.getCarte().getCasesEau()){
        for (int i = 0; i < 4; i++){
          if (robot.peutAller(robot.getCarte().getVoisin(caseEau, Direction.values()[i]))){
            acces = true;
            ArrayList<Case> chemin = new ArrayList<Case>();
            chemin = robot.goTo(robot.getCarte().getVoisin(caseEau, Direction.values()[i]));
            long nvTemps = 0;
            if (chemin.size() != 0){
              nvTemps = robot.timeToDo(chemin);
            }
            if (nvTemps < temps) {
              temps = nvTemps;
              caseEau = robot.getCarte().getVoisin(caseEau, Direction.values()[i]);
            }
          }
        }
      }
      tempsIncendiesEau.add(temps);
    }
    Long tempsIncendiesEauTab[] = new Long[tempsIncendiesEau.size()];
    tempsIncendiesEauTab = tempsIncendiesEau.toArray(tempsIncendiesEauTab);
    Arrays.sort(tempsIncendiesEauTab);
    for (int i = 0; i < incendies.size(); i++){
      int index = tempsIncendiesEau.indexOf(tempsIncendiesEauTab[i]);
      incendiesProximiteEau.add(0, incendies.get(index));
      tempsIncendiesEau.set(index, Long.MAX_VALUE);
    }
    return incendiesProximiteEau;
  }

  public void setPosition(Case nvCase){
    boolean still = true;
    boolean notAdapt = true;
    for ( Direction dir : Direction.values()){
      if (this.getCarte().getVoisin(this.getPosition(), dir).equals(nvCase)){
        still = false;
        if (this.peutSeDeplacer(nvCase)){
          super.setPosition(nvCase);
          notAdapt = false;
        }
      }
    }
    if (still) {
      throw new IllegalArgumentException("Le robot n'est pas à côté de cette position.");
    } else if (notAdapt){
      throw new IllegalArgumentException("Le robot ne peut se déplacer que sur du terrain libre ou habitat.");
    }
  }

  public void remplirReservoir(){
    boolean empty = true;
    for(Direction dir : Direction.values()){
      switch(this.getCarte().getVoisin(this.getPosition(), dir).getNature()){
        case EAU:
        empty = false;
        this.setReservoirEau(5000);
        break;
      }
    }
    if(empty ) {
      throw new IllegalArgumentException("Le robot ne peut remplir son réservoir qu'à côté d'une case contenant de l'eau.");
    }
  }

  @Override
  public String toString(){
    return "Robot : [" + this.getPosition().getLigne() + ", " + this.getPosition().getColonne() + "]" + " type :  Roues, reservoirEau : " + this.getReservoirEau() + " , date : " + this.getDate() + "\n";
  }
}
