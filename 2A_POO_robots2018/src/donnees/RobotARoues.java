package donnees;
/**
  * Classe representant les robots a roues.
  */

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

  public void remplirReservoir(){
    boolean empty = true;
    for(Direction dir : Direction.values()){
      if (this.getCarte().voisinExiste(this.getPosition(), dir)){
        switch(this.getCarte().getVoisin(this.getPosition(), dir).getNature()){
          case EAU:
          empty = false;
          this.setReservoirEau(5000);
          break;
        }
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
