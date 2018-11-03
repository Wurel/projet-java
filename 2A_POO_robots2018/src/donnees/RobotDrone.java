package donnees;

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
        this.setReservoirEau(2000);
        break;// 5 mins pour le remplissage complet
        // 2000 litres max
        // comment gère t'on le temps ?
      }
    if(empty ) {
      throw new IllegalArgumentException("Le robot ne peut remplir son réservoir qu'à côté d'une case contenant de l'eau.");
    }
  }

  public void deverserEau(int vol){
    this.setReservoirEau(this.getReservoirEau() - vol); // 30 sec pour vider la totalité
    // comment gère t'on le temps ?
  }

  @Override
  public String toString(){
    return "Robot : [" + this.getPosition().getLigne() + ", " + this.getPosition().getColonne() + "]" + " type :  Drones, vitesse : " + this.getVitesse(this.getPosition().getNature()) + " , reservoirEau : " + this.getReservoirEau() + "\n";
  }
}
