package donnees;

import java.util.*;

public class RobotDrone extends Robot {

  public RobotDrone(Carte carte, int ligne, int colonne){
    super(carte, ligne, colonne);
    this.setVitesse(100);
    this.setReservoirEau(10000);
  }

  public RobotDrone(Carte carte, int ligne, int colonne, double vitesse){
    super(carte, ligne, colonne);
    if (vitesse > 150){
      throw new IllegalArgumentException("La vitesse d'un robot à chenilles ne peut excéder 150 km/h.");
    }
    this.setVitesse(vitesse);
    this.setReservoirEau(10000);
  }

  @Override
  public String getType(){
    return "Drone";
  }

  @Override
  public boolean peutSeDeplacer(Case nvCase){
    return true;
  }

  public ArrayList<Incendie> getIncendiesProchesEau(ArrayList<Incendie> incendies){
    ArrayList<Incendie> incendiesProximiteEau = new ArrayList<Incendie>();
    ArrayList<Long> tempsIncendiesEau = new ArrayList<Long>();
    for (Incendie incend : incendies){
      RobotDrone robot = new RobotDrone(this.getCarte(), incend.getPosition().getLigne(), incend.getPosition().getColonne(), this.getVitesse(incend.getPosition().getNature()));
      long temps = Long.MAX_VALUE;
      for (Case caseEau : this.getCarte().getCasesEau()){
        if (this.peutAller(caseEau)){
          ArrayList<Case> chemin = new ArrayList<Case>();
          chemin = robot.goTo(caseEau);
          long nvTemps = robot.timeToDo(chemin);
          if (nvTemps < temps) {
            temps = nvTemps;
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

  @Override
  public double getVitesse(NatureTerrain naturePosition){
    return super.getVitesse(naturePosition);
  }

  public void setPosition(Case nvCase){
    boolean still = true;
    for ( Direction dir : Direction.values()){
      if (this.getCarte().getVoisin(this.getPosition(), dir).equals(nvCase)){
        super.setPosition(nvCase);
        still = false;
      }
    }
    if (still) {
      throw new IllegalArgumentException("Le robot n'est pas à côté de cette position.");
    }
  }

  public void remplirReservoir(){
    boolean empty = true;
    switch(this.getPosition().getNature()){
        case EAU:
        empty = false;
        this.setReservoirEau(10000);
        break;
      }
    if(empty ) {
      throw new IllegalArgumentException("Le robot ne peut remplir son réservoir qu'à côté d'une case contenant de l'eau.");
    }
  }

  @Override
  public String toString(){
    return "Robot : [" + this.getPosition().getLigne() + ", " + this.getPosition().getColonne() + "]" + " type :  Drones, reservoirEau : " + this.getReservoirEau() + " , date : " + this.getDate() + "\n";
  }
}
