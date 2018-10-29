package donnees;

public class RobotARoues extends Robot {

  public RobotARoues(Carte carte, int ligne, int colonne){
    super(carte, ligne, colonne);
    this.setVitesse(80);
  }

  public RobotARoues(Carte carte, int ligne, int colonne, double vitesse){
    super(carte, ligne, colonne);
    this.setVitesse(vitesse);
  }

  public String getType(){
    return "Roues";
  }

  @Override
  public double getVitesse(NatureTerrain naturePosition){
    return super.getVitesse(naturePosition);
  }

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

  public void setPosition(Case nvCase){
    boolean still = true;
    boolean notAdapt = true;
    for ( Direction dir : Direction.values()){
      if (this.getCarte().getVoisin(this.getPosition(), dir).equals(nvCase)){
        still = false;
        if (this.peutSeDeplacer(nvCase)){
          this.setPosition(nvCase);
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
        break;// 10 mins pour le remplissage complet
        // 5000 litres max
        // comment gère t'on le temps ?
      }
    }
    if(empty ) {
      throw new IllegalArgumentException("Le robot ne peut remplir son réservoir qu'à côté d'une case contenant de l'eau.");
    }
  }

  public void deverserEau(int vol){
    this.setReservoirEau(this.getReservoirEau() - vol); // 5 sec pour vider 100 litres
    // comment gère t'on le temps ?
  }

  @Override
  public String toString(){
    return "Robot : [" + this.getPosition().getLigne() + ", " + this.getPosition().getColonne() + "]" + " type :  Roues, vitesse : " + this.getVitesse(this.getPosition().getNature()) + " , reservoirEau : " + this.getReservoirEau() + "\n";
  }
}